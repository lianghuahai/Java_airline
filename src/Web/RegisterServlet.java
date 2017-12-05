package Web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Service.UserService;
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
	    response.setContentType("text/text");
            response.setCharacterEncoding("UTF-8");
	        User newUser = new User();
                try {
                    BeanUtils.populate(newUser, request.getParameterMap());
                    newUser.setLevel("customer");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println(newUser);
                UserService rs = new UserService();
                boolean user =rs.register(newUser);
                if(user){
                    //not exist, can register
//                    request.getSession().setAttribute("registerSuccess", "register Success");
                    response.sendRedirect(request.getContextPath()+"/login.jsp");
                }else{
                    //exist, unable to register
//                    response.sendRedirect(request.getContextPath()+"/register.jsp");
                    request.setAttribute("register_false", "User exist");
                    request.getRequestDispatcher("/register.jsp").forward(request,response);
                }
                
                
                
                
                
//                user.setAddress(request.getParameter("address"));
//                user.setEmail(request.getParameter("email"));
//                user.setCity(request.getParameter("city"));
//                user.setFirstName(request.getParameter("fname"));
//                user.setLastName(request.getParameter("lname"));
//                user.setState(request.getParameter("state"));
//                user.setPassword(request.getParameter("password"));
//                user.setZipCode(request.getParameter("zipcode"));
                //call service
                
	}

}
