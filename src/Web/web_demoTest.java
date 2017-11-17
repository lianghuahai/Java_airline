package Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		
		Cookie loginCooki = new Cookie(username, password) ;
		response.addCookie(loginCooki);
		
		response.sendRedirect("index.jsp");
		//request.getSession().setAttribute("checkcode_session", checkcode);
//		request.setAttribute("test", "你好");
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		//user login  add to cookie then send to browser
//		new Cookie(String name, String value) ;
//		response.addCookie(Cookie cookie) ；把cookie通过相应头的方式。传递给浏览器
		
//		response.setHeader("refresh", "10;url=index.jsp");  refresh website by 10s
		
		//jsp
//		<%=request.getAttribute(“name”);>
//		等价于 ${requestScope.name}
	}


}
