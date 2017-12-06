package Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Bean.User;
import Service.UserService;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5637191870874473568L;
	private UserService us = new UserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	    System.out.println("loginserlvet");
    	//check login status
    	User existUser  =us.checkLogin(request.getParameter("email"),request.getParameter("password"));
    	response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
        System.out.println(existUser);
    	if(existUser!=null){
    	    request.getSession().setAttribute("existUser", existUser);
    	    request.getSession().removeAttribute("login_status");
    	    if(existUser.getLevel().equals("manager")){
    	        
    	        response.sendRedirect(request.getContextPath()+"/managerIndex.jsp");
    	    }else{
    	        response.sendRedirect(request.getContextPath()+"/index.jsp");
    	        
    	    }
    	}else{
    	    request.setAttribute("login_status", "Password not correct or user account is not exist!");
//    	    response.sendRedirect(request.getContextPath()+"/login.jsp");  
    	    request.getRequestDispatcher("/login.jsp").forward(request,response);
    	}
////	
	
     }
}
