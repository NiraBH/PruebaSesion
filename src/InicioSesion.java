

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InicioSesion
 */
@WebServlet("/InicioSesion")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session =  request.getSession(true);
		
		if (null!=session.getAttribute("contador"))
		{
			session.setAttribute("contador", (int)session.getAttribute("contador")+1);
            response.sendRedirect("UsuarioDentro.jsp");
		}
		else
		{
			session.setAttribute("contador", 0);
	         response.sendRedirect("UsuarioDentro.jsp");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
        String nombre;
        nombre = request.getParameter("nombre");
        sesion.getAttribute("contador");
        sesion.setAttribute("contador", 0);
        
        if(sesion.getAttribute("nombre") == null)
        {
            
            sesion.setAttribute("nombre", nombre);
            
            response.sendRedirect("UsuarioDentro.jsp");
        }
        else
        {
        	sesion.invalidate();
            response.sendRedirect("Inicio.jsp");
        }
	}

}
