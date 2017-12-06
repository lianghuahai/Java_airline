package Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.User;
import Dao.UserDao;

/**
 * Servlet implementation class ChecSSNServlet
 */
public class ChecSSNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao ud =  new UserDao();
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
	    int ssn = Integer.valueOf(request.getParameter("SSN"));
	    User existUser  =ud.findUserbySSN(ssn);
            if(existUser!=null){
                    System.out.println("flase");
                    request.setAttribute("ssn_valid", false);
                }else{
                    System.out.println("true");
                    request.setAttribute("ssn_valid", true);
                }
//          List list = new ArrayList();
//          list.add(flag);
//              request.getRequestDispatcher("/register.jsp").forward(request,response);  
//              JSONArray jsonArray = JSONArray.fromObject(list);       
//              response.getWriter().print(jsonArray.toString());
            response.setContentType("text/text");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(request.getAttribute("ssn_valid"));
	    
	}

}
