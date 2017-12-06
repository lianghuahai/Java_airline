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

/**
 * Servlet implementation class RegisterEmployee
 */
public class RegisterEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("RegisterEmployeeServlet");
	    response.setCharacterEncoding("UTF-8");
            User newUser = new User();
            try {
                BeanUtils.populate(newUser, request.getParameterMap());
                if((request.getParameter("isManager"))==null){
                    newUser.setLevel("empolyee");
                    newUser.setIsManager(0);
                }else{
                    newUser.setLevel("manager");
                    newUser.setIsManager(1);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            UserService rs = new UserService();
            rs.addEmployee(newUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
            
            
	}

}
