package Web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.BeanUtils;

import Bean.User;
import Bean.loginUser;
import Dao.UserDao;
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
    	if(existUser!=null){
    	    request.getSession().setAttribute("existUser", existUser);
    	    response.sendRedirect(request.getContextPath()+"/index.jsp");  
    	}else{
    	    response.sendRedirect(request.getContextPath()+"/login.jsp");  
    	}
////	
	
     }
}
