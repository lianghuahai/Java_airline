package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.User;
import Service.UserService;

/**
 * Servlet implementation class getMailListServlet
 */
public class getMailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();

    /**
     * Default constructor. 
     */
    public getMailListServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = us.getCustomerMailingList();
		String responseStr = "";
		for(User u: users){
			responseStr += u.getFirstname() + ", " + u.getLastname() + ", " + u.getEmail() + "<br>";
		}
		response.getWriter().write(responseStr);
	}

}
