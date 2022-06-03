package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Materia;
import entities.Plan;
import logic.MateriaLogic;
import logic.PlanLogic;
import logic.UnmatchException;


@WebServlet("/ControladorPlan")
public class ControladorPlan extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private PlanLogic pLogic = new PlanLogic();
	
	
    public ControladorPlan() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		if (accion != null) {
			switch(accion) {
			case "editar":
				this.editarPlan(request, response);
				break;
				
			case "eliminar":
				this.eliminarPlan(request, response);
				break;
				
			default:
				this.actualizar(request, response);
				break;
			}
		}
		
		else {
			this.actualizar(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		String accion = request.getParameter("accion");
		
		if(accion != null) {
			
			switch (accion) {
			
			case "insertar":
				this.insertarPlan(request, response);
				break;
				
			case "modificar":
				this.modificarPlan(request, response);
				break;
			
			case "buscarPlan":
				this.buscarPlan(request, response);
				break;
				
			default:
				this.actualizar(request, response);
				break;
			}
		}
		
		else {
			this.actualizar(request, response);
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			List<Plan> planes = pLogic.getAll();
			HttpSession sesion = request.getSession();
			sesion.setAttribute("planes", planes);
			response.sendRedirect("planes.jsp");
			
		}catch(UnmatchException u) {
			String message = u.getMessage();
			String ruta = "principal.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}

	private void insertarPlan(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
		String descripcion = request.getParameter("descripcion");
		String especialidad = request.getParameter("especialidad");
		
		Plan pln = new Plan(descripcion, especialidad);
		
		try {
			pLogic.insert(pln);
			this.actualizar(request, response);
			
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "planes.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
	}
	
	private void editarPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		int idPlan = Integer.parseInt(request.getParameter("idPlan"));
		
		try {
			Plan pln = pLogic.getOne(new Plan(idPlan));
			request.setAttribute("plan", pln);
			String pathJspEditar = "/WEB-INF/paginas/plan/editarPlan.jsp";
			request.getRequestDispatcher(pathJspEditar).forward(request, response);
			
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "planes.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	private void modificarPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
		int idPlan = Integer.parseInt(request.getParameter("idPlan"));
		String descripcion = request.getParameter("descripcion");
		String especialidad = request.getParameter("especialidad");
		
		Plan pln = new Plan(idPlan, descripcion, especialidad);
		
		try {
			pLogic.update(pln);
			this.actualizar(request, response);
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "planes.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	private void eliminarPlan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		
		int idPlan = Integer.parseInt(request.getParameter("idPlan"));
		
		Plan pln = new Plan(idPlan);
		
		try {
			pLogic.delete(pln);
			this.actualizar(request, response);
		}catch (UnmatchException u) {
			String message = u.getMessage();
			String ruta = "planes.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
	}
	
	private void buscarPlan(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		
        String descripcion = request.getParameter("descripcion");
		
        Plan planBuscado = null;
		
		try {
			planBuscado = pLogic.getPlanByDescripcion(new Plan(descripcion));
			List<Materia> materiasPlan = new MateriaLogic().getAll(planBuscado); 
			HttpSession sesion = request.getSession();
			sesion.setAttribute("planBuscado", planBuscado);
			sesion.setAttribute("materiasPlan", materiasPlan);
			response.sendRedirect("listadoMateriasPlanes.jsp");
		}catch(UnmatchException u) {
			String message = u.getMessage();
			String ruta = "principal.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}
	
	

}