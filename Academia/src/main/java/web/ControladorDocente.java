package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.DocenteLogic;
import logic.MateriaLogic;
import logic.PersonaLogic;
import logic.UnmatchException;
import entities.Docente;
import entities.Materia;
import entities.Persona;


@WebServlet("/ControladorDocente")
public class ControladorDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DocenteLogic dLogic = new DocenteLogic();
	private PersonaLogic pLogic = new PersonaLogic();
       

    public ControladorDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String accion = request.getParameter("accion");
    	
    	if(accion != null) {
    		
    		switch(accion) {
    		
    		case "editar":
    			this.editarDocente(request, response);
    			break;
    			
    		case "eliminar":
    			this.eliminarDocente(request, response);
    			break;
    			
    		default:
    			this.actualizarPagina(request, response);
    		}
    	}
    	
    	else {
    		this.actualizarPagina(request, response);
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
				this.insertarDocente(request, response);
				break;
				
			case "modificar":
				this.modificarDocente(request, response);
				break;
				
			default:
    			this.actualizarPagina(request, response);
			}
		}
		
		else {
			this.actualizarPagina(request, response);
		}
		
	}
	
	private void actualizarPagina(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		try {
			List<Docente> docentes = new DocenteLogic().getAll();
			List<Persona> docentesActuales = new PersonaLogic().getAllDocentes();
			List<Materia> materias = new MateriaLogic().getAll();
			HttpSession sesion = request.getSession();
			
			sesion.setAttribute("docentes", docentes);
			sesion.setAttribute("docentesActuales", docentesActuales);
			sesion.setAttribute("materiasAcademia", materias);
			
			
			response.sendRedirect("docentes.jsp");
		}catch(UnmatchException u) {
			String message = u.getMessage();
			String ruta = "principal.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	private void editarDocente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idDocente = Integer.parseInt(request.getParameter("idDocente"));
		
		try {
			Docente doc = dLogic.getOne(new Docente(idDocente));
			Materia mat = new MateriaLogic().getOne(new Materia(doc.getIdMateria()));
			Persona per = pLogic.getOne(new Persona(doc.getIdPersona()));
			HttpSession sesion = request.getSession();
			sesion.setAttribute("docente", doc);
			sesion.setAttribute("materia", mat);
			sesion.setAttribute("pr", per);
			String jspPathEditar = "/WEB-INF/paginas/docente/editarDocente.jsp";
			request.getRequestDispatcher(jspPathEditar).forward(request, response);
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "principal.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
	}
	
	private void insertarDocente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String cargo = request.getParameter("cargo");
		int legajo = Integer.parseInt(request.getParameter("legajo"));
		String materia = request.getParameter("descripcionMateria");
		Integer leg = legajo;
		
		
		
		try {
			
			//Busco a la materia para obtener su id
			Materia mat = new MateriaLogic().getOneByDescripcion(new Materia(materia));
			
			//Busco a la persona para obtener su id
			Persona per = new PersonaLogic().getByLegajo(new Persona(leg));
			
			//Creo el objeto docente
			Docente doc = new Docente(per.getIdPersona(), mat.getIdMateria(), cargo);
			
			dLogic.insert(doc);
			
			//Refresco la pagina
			this.actualizarPagina(request, response);
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "docentes.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
		
	}
	
	private void modificarDocente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//Recupero los valores del formulario editarDocente
		int idDocente = Integer.parseInt(request.getParameter("idDocente"));
		String cargo = request.getParameter("cargo");
		String descripcionMateria = request.getParameter("descripcionMateria");

		try {
			Materia mat = new MateriaLogic().getOneByDescripcion(new Materia(descripcionMateria)); 
			Persona per = (Persona)request.getSession().getAttribute("pr");
			Docente doc = new Docente(per.getIdPersona(), idDocente, mat.getIdMateria(), cargo);
			dLogic.update(doc);
			
			//Refresco la página
			this.actualizarPagina(request, response);
			
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "docentes.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}

	}
	
	private void eliminarDocente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int idDocente = Integer.parseInt(request.getParameter("idDocente"));
		Docente doc = new Docente(idDocente);
		
		try {
			dLogic.delete(doc);
			this.actualizarPagina(request, response);
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "docentes.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
		
		
	}
}