package Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5637191870874473568L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("loginserlvet");
		System.out.println(username);
		System.out.println(password);
		
		// login success  go to home page
		response.sendRedirect("index.jsp"); 
//		response.setHeader("refresh", "10;url=index.jsp");  refresh website by 10s
		
		
	}

}
