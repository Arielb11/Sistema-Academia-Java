package web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Inscripcion;
import entities.Persona;
import logic.InscripcionLogic;
import logic.PersonaLogic;
import logic.UnmatchException;



/**
 * Servlet implementation class ControladorPersona
 */
@WebServlet("/ControladorPersona")
public class ControladorPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonaLogic pLogic = new PersonaLogic();
	
	
    public ControladorPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");
		
		if(accion != null) {
			
			switch(accion) {
			
			case "editar":
				this.editarPersona(request, response);
				break;
				
			case "eliminar":
				this.eliminarPersona(request, response);
				break;
				
			default:
				this.actualizarPagina(request, response);
				break;
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
				this.insertarPersona(request, response);
				break;
				
			case "modificar":
				this.modificarPersona(request, response);
				break;
			
			case "buscarAlumno":
				this.buscarAlumno(request, response);
				break;
				
			default:
				this.actualizarPagina(request, response);
			}
			
		}
		
		else {
			this.actualizarPagina(request, response);
		}
		
	}
	
	private void actualizarPagina(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			List<Persona> personas = new PersonaLogic().getAll();
			List<Persona> alumnosActuales = new PersonaLogic().getAllAlumnos();
			HttpSession sesion = request.getSession();
			sesion.setAttribute("personas", personas);
			sesion.setAttribute("alumnosActuales", alumnosActuales);
			response.sendRedirect("personas.jsp");
			
		}catch(UnmatchException u) {
			String message = u.getMessage();
			String ruta = "principal.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
		

	}
	
	private void insertarPersona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String email = request.getParameter("email");
		LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
		String nombreUsuario = request.getParameter("nombreUsuario");
		String clave = request.getParameter("clave");
		String telefono = request.getParameter("telefono");
		String tipoPersona = request.getParameter("tipoPersona");
		int legajo = Integer.parseInt(request.getParameter("legajo"));
		
		//Creo un objeto Persona
		Persona per = new Persona(legajo, tipoPersona, nombre, apellido, direccion, email, telefono, fechaNacimiento, nombreUsuario, clave);
		
		try {
			//Guardo en la database
			this.pLogic.insert(per);
			
			//Refreso la página con la nueva persona insertada
			this.actualizarPagina(request, response);
			
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "personas.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	private void modificarPersona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recupero los valores del formulario de editarPersona
		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		int legajo = Integer.parseInt(request.getParameter("legajo"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String email = request.getParameter("email");
		LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
		String nombreUsuario = request.getParameter("nombreUsuario");
		String clave = request.getParameter("clave");
		String telefono = request.getParameter("telefono");
		String tipoPersona = request.getParameter("tipoPersona");
		
		Persona per = new Persona(idPersona, legajo, tipoPersona, nombre, apellido, direccion, email, telefono, fechaNacimiento, nombreUsuario, clave);
		
		try {
			//Envío la persona a la database
			this.pLogic.update(per);
			
			this.actualizarPagina(request, response);
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "personas.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	private void editarPersona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Del listado de personas, recupero la persona que quiero editar mediante su id
		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		
		try {
			Persona per = this.pLogic.getOne(new Persona(idPersona));
			
			request.setAttribute("persona", per);
			
			//Indico el jsp correspondiente, donde voy a realizar la edición
			String pathJspEditar = "/WEB-INF/paginas/persona/editarPersona.jsp";
			
			request.getRequestDispatcher(pathJspEditar).forward(request, response);
			
		}catch(UnmatchException u) {
			String message = u.getMessage();
			String ruta = "personas.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
	}

	private void eliminarPersona(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		Persona per = new Persona(idPersona);
		
		try {
			this.pLogic.delete(per);	
		}catch(UnmatchException u) {
			String message = u.getMessage();
			String ruta = "personas.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
		
		this.actualizarPagina(request, response);
		
	}
	
	private void buscarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
		int legajo = Integer.parseInt(request.getParameter("legajo"));
		Integer leg = legajo;

		
		Persona perBuscada = null;
		
		try {
			perBuscada = pLogic.getByLegajo(new Persona(leg));
			List<Inscripcion> notasAlumno = new InscripcionLogic().getAll(perBuscada);
			HttpSession sesion = request.getSession();
			sesion.setAttribute("perBuscada", perBuscada);
			sesion.setAttribute("notasAlumno", notasAlumno);
			response.sendRedirect("listadoNotasAlumno.jsp");
			
		} catch(UnmatchException u) {
			String message = u.getMessage();
			String ruta = "principal.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
	}
	
	
	
	
}
