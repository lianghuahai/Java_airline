package Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.User;
import Dao.UserDao;

/**
 * Servlet implementation class checkEmailServlet
 */
public class checkEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao ud =  new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    User existUser  =ud.findUserbyEmail(request.getParameter("email"));
	    if(existUser!=null){
	            System.out.println("flase");
	            request.setAttribute("Email_valid", false);
	        }else{
	            System.out.println("true");
	            request.setAttribute("Email_valid", true);
	        }
//	    List list = new ArrayList();
//	    list.add(flag);
//	        request.getRequestDispatcher("/register.jsp").forward(request,response);  
//	        JSONArray jsonArray = JSONArray.fromObject(list);       
//	        response.getWriter().print(jsonArray.toString());
	    response.setContentType("text/text");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().print(request.getAttribute("Email_valid"));
	
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	
	
	
	
	}
}
