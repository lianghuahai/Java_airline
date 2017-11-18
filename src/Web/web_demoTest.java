package Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class web_demoTest extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4707825467227803844L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String username = request.getParameter("fname");
		String password = request.getParameter("lname");
		System.out.println("registerserlvet");
		System.out.println(username);
		System.out.println(password);
		response.sendRedirect("index.jsp");
		//request.getSession().setAttribute("checkcode_session", checkcode);
	}


}
