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
import entities.Persona;
import entities.Plan;
import logic.MateriaLogic;
import logic.PersonaLogic;
import logic.PlanLogic;
import logic.UnmatchException;

/**
 * Servlet implementation class ControladorLogin
 */
/*@WebServlet("/ControladorLogin")*/
@WebServlet(name="ControladorLogin",urlPatterns={"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		Persona per = null;
		
		try {
			per = new PersonaLogic().getByUser(new Persona(user, password));
			List<Persona> alumnos = new PersonaLogic().getAllAlumnos();
			List<Plan> planes = new PlanLogic().getAll();
			List<Materia> materias = new MateriaLogic().getAll();
			HttpSession sesion = request.getSession();
			sesion.setAttribute("persona", per);
			sesion.setAttribute("alusAcademia", alumnos);
			sesion.setAttribute("planes", planes);
			sesion.setAttribute("materiasAcademia", materias);
			response.sendRedirect("principal.jsp");
			
		}catch(UnmatchException u) {
			String message = u.getMessage();
			String ruta = "index.jsp";
			request.setAttribute("mensaje", message);
			request.setAttribute("enlaceAnterior", ruta);
			request.getRequestDispatcher("/WEB-INF/paginas/errores/error.jsp").forward(request, response);
		}
		
	}

}
