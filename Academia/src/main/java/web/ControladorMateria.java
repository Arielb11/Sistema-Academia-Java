package web;

import logic.MateriaLogic;
import logic.PlanLogic;
import logic.UnmatchException;
import entities.Materia;
import entities.Plan;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ControladorMateria")
public class ControladorMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MateriaLogic mLogic = new MateriaLogic();
	private PlanLogic pLogic = new PlanLogic();
	
    public ControladorMateria() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if(accion != null) {
			
			switch(accion) {
				
				case "editar":
					this.editarMateria(request, response);
					break;
					
				case "eliminar":
					this.eliminarMateria(request, response);
					break;
					
				default:
					//Si no hay ninguna acción, se actualiza el listado nuevamente
					this.actualizarPagina(request, response);
					break;
				}
		}
		
		else {
			this.actualizarPagina(request, response);
		}
	}

	
	
	//El metodo actualizar, sera llamado cuando se haya que exhibir el listado de materias.
	//Al realizar una insercion de una nueva materia, el mismo debe ser llamado para
	//actualizar el listado, y asi, incluir la nueva materia
	private void actualizarPagina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			//Recupero el listado de materias, compartir lo obtenido hacía otro jsp, 
			//el cual se llamará materias.jsp

			List<Materia> materias = mLogic.getAll();
			List<Plan> planes = pLogic.getAll();
			HttpSession sesion = request.getSession();
			
			//Seteo en el alcance de sesion, las materias obtenidas, las cuales serán
			//redirigidas hacia materias.jsp
			sesion.setAttribute("materias", materias);
			
			sesion.setAttribute("planes", planes);
			
			//Me redirijo a la materias.jsp
			
			response.sendRedirect("materias.jsp");
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "principal.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		String accion = request.getParameter("accion");
		
		if(accion != null) {
			
			switch(accion) {
				
			case "insertar":
				this.insertarMateria(request, response);
				break;
				
			case "modificar":
				this.modificarMateria(request, response);
				break;
				
			default:
				//Redirijo a la pagina de inicio
				this.actualizarPagina(request, response);
				break;
				
				
			}
		}
		
		
		else {
			this.actualizarPagina(request, response);
		}
		
	}
	
	private void insertarMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
		String descripcion = request.getParameter("descripcion");
		int hsSemanales = Integer.parseInt(request.getParameter("hsSemanales"));
		int hsTotales = Integer.parseInt(request.getParameter("hsTotales"));
		String nombrePlan = request.getParameter("nombrePlan");
		int cupo = Integer.parseInt(request.getParameter("cupo"));
		
		try {
			
			//Busco el plan mediante su descripción
			Plan pla = new PlanLogic().getPlanByDescripcion(new Plan(nombrePlan));
			
			//Creo una Materia
			Materia mat = new Materia(hsSemanales, hsTotales, pla.getIdPlan(), cupo, descripcion);
			
			//Almaceno en la dataBase
			mLogic.insert(mat);
			
			//Actualizo la pagina
			this.actualizarPagina(request, response);
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "materias.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	private void editarMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Del listado de las materias, quiero recuperar el id de la materia que yo quiero editar.
		int idMateria = Integer.parseInt(request.getParameter("idMateria"));
		
		try {
			//Busco la entidad en la base de datos
			Materia mat = mLogic.getOne(new Materia(idMateria));
			
			int idPlan = mat.getIdPlan();
			Plan pln = pLogic.getOne(new Plan(idPlan));
			
			mat.setDescPlan(pln.getDescripcion());
			request.setAttribute("materia", mat);
			request.setAttribute("esp", pln);
			
			
			
			//Indico el jsp correspondiente, donde voy a realizar la edición
			String pathJspEditar = "/WEB-INF/paginas/materia/editarMateria.jsp";
			
			request.getRequestDispatcher(pathJspEditar).forward(request, response);
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "materias.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	private void modificarMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recupero los valores del formulario editarMateria
		int idMateria = Integer.parseInt(request.getParameter("idMateria"));
		String descripcion = request.getParameter("descripcion");
		int hsSemanales = Integer.parseInt(request.getParameter("hsSemanales"));
		int hsTotales = Integer.parseInt(request.getParameter("hsTotales"));
		String nombrePlan = request.getParameter("nombrePlan");
		int cupo = Integer.parseInt(request.getParameter("cupo"));
		
		
		try {
			
			//Busco el plan mediante su descripción
			Plan pla = new PlanLogic().getPlanByDescripcion(new Plan(nombrePlan));
			
			Materia mat = new Materia(idMateria, hsSemanales, hsTotales, pla.getIdPlan(), cupo, descripcion);
			
			//Almaceno en la dataBase
			mLogic.update(mat);
			
			//Actualizo la pagina
			this.actualizarPagina(request, response);
			
		}catch(UnmatchException u) {
			String message = u.getMessage();
			String ruta = "materias.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	private void eliminarMateria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idMateria = Integer.parseInt(request.getParameter("idMateria"));
		Materia mat = new Materia(idMateria);
		
		try {
			mLogic.delete(mat);
			
			//Actualizo la pagina
			this.actualizarPagina(request, response);
			
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "materias.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
	
	}

}
