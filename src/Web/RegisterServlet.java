package Web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Service.registerService;
import Bean.User;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2758696100207415197L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
//	        System.out.println("email"+request.getParameter("email"));
//                System.out.println("fname"+request.getParameter("fname"));
//                System.out.println("lname"+request.getParameter("lname"));
//                System.out.println("address"+request.getParameter("address"));
//                System.out.println("city"+request.getParameter("city"));
//                System.out.println("state"+request.getParameter("state"));
//                System.out.println("zipcode"+request.getParameter("zipcode"));
//                System.out.println("password"+request.getParameter("password"));
                
                User user = new User();
                try {
                    System.out.println("1");
                    BeanUtils.populate(user, request.getParameterMap());
                    System.out.println("1");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println(user);
//                user.setAddress(request.getParameter("address"));
//                user.setEmail(request.getParameter("email"));
//                user.setCity(request.getParameter("city"));
//                user.setFirstName(request.getParameter("fname"));
//                user.setLastName(request.getParameter("lname"));
//                user.setState(request.getParameter("state"));
//                user.setPassword(request.getParameter("password"));
//                user.setZipCode(request.getParameter("zipcode"));
                //call service
//                registerService rs = new registerService();
//                rs.register(user);
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
		response.sendRedirect("index.jsp");
	}

}
