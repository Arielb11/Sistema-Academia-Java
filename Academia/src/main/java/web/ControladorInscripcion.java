package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import entities.Inscripcion;
import entities.Materia;
import entities.Persona;
import logic.InscripcionLogic;
import logic.MateriaLogic;
import logic.PersonaLogic;
import logic.UnmatchException;
import logic.Validaciones;

/**
 * Servlet implementation class ControladorInscripcion
 */
@WebServlet("/ControladorInscripcion")
public class ControladorInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InscripcionLogic insLogic = new InscripcionLogic();
       
    public ControladorInscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String accion = request.getParameter("accion");
    	
    	if(accion != null) {
    		
    		switch(accion) {
    		
    		case "editar":
    			this.editarInscripcion(request, response);
    			break;
    			
    		case "eliminar":
    			this.eliminarInscripcion(request, response);
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
		
		if (accion != null) {
			switch (accion) {
			case "insertar":
				this.insertarInscripcion(request, response);
				break;
				
			case "modificar":
				this.modificarInscripcion(request, response);
				break;
				
			
			default:
				this.actualizarPagina(request, response);
			}
		}
		else {
			this.actualizarPagina(request, response);
		}
	}

	protected void actualizarPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Inscripcion> inscripciones = insLogic.getAll();	
			List<Materia> materias = new MateriaLogic().getAll();
 			HttpSession sesion = request.getSession();
			sesion.setAttribute("inscripciones", inscripciones);	
			sesion.setAttribute("materiasAcademia", materias);
			response.sendRedirect("inscripciones.jsp");
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "principal.jsp";
			request.setAttribute("mensaje", message); 
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	private void editarInscripcion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idMateria = Integer.parseInt(request.getParameter("idMateria"));
		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		
		if(idMateria == 0) {
			
		}
		
		try {
			Inscripcion ins = insLogic.getOne(new Inscripcion(idMateria, idPersona));
			Persona per = new PersonaLogic().getOne(new Persona(idPersona));
			Materia mat = new MateriaLogic().getOne(new Materia(idMateria));
			HttpSession sesion = request.getSession();
			sesion.setAttribute("inscripcion", ins);
			sesion.setAttribute("aluData", per);
			sesion.setAttribute("materia", mat);
			String jspPathEditar = "/WEB-INF/paginas/inscripcion/editarInscripcion.jsp";
			request.getRequestDispatcher(jspPathEditar).forward(request, response);
			
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "inscripciones.jsp";
			request.setAttribute("mensaje", message); 
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	private void insertarInscripcion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean bandera = true;
		
		int legajo= Integer.parseInt(request.getParameter("legajo"));
		String descripcionMateria = request.getParameter("descripcionMateria");
		int nota = Integer.parseInt(request.getParameter("nota"));
		String condicion = request.getParameter("condicion");
		
		
		
		
		Integer leg = legajo;

		try {
			
			Materia mat = new MateriaLogic().getOneByDescripcion(new Materia(descripcionMateria));
			
			Persona per = new PersonaLogic().getByLegajo(new Persona(leg));
			
			Inscripcion ins = new Inscripcion(mat.getIdMateria(), per.getIdPersona(), nota, condicion);
			
			bandera = Validaciones.verificaCupo(ins.getIdMateria());
			
			bandera = Validaciones.verificaNota(nota);
			
			if(bandera) {
				insLogic.insert(ins);
				Validaciones.DisminuyeCupo(mat.getIdMateria());
				this.actualizarPagina(request, response);	
			}
			
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "inscripciones.jsp";
			request.setAttribute("mensaje", message); 
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
	}
	
	private void modificarInscripcion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		boolean bandera = true;
		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		int idMateriaVieja = Integer.parseInt(request.getParameter("idMateria"));
		String descripcionMateria = request.getParameter("descripcionMateria");
		int nota = Integer.parseInt(request.getParameter("nota"));
		String condicion = request.getParameter("condicion");
				
		try {
			
			Materia materiaNueva = new MateriaLogic().getOneByDescripcion(new Materia(descripcionMateria));
			Inscripcion ins = new Inscripcion(idMateriaVieja, materiaNueva.getIdMateria(), idPersona, nota, condicion);
			bandera = Validaciones.verificaNota(nota);
			
			if (bandera) {
				insLogic.update(ins);
				
				this.actualizarPagina(request, response);
			}

			
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "inscripciones.jsp";
			request.setAttribute("mensaje", message); 
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
	}
	
	private void eliminarInscripcion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int idMateria = Integer.parseInt(request.getParameter("idMateria"));
		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		
		Inscripcion ins = new Inscripcion(idMateria, idPersona);
		
		try {
			insLogic.delete(ins);
			Validaciones.AumentaCupo(idMateria);
			this.actualizarPagina(request, response);
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "inscripciones.jsp";
			request.setAttribute("mensaje", message); 
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
	}
	
	
}
