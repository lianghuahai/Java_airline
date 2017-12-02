package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Airline;
import Service.AirlineService;

public class AirlineServlet extends HttpServlet {

	private static final long serialVersionUID = 9202533352181389230L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	        System.out.println("departDate"+request.getParameter("departDate"));
	        System.out.println("returnDate"+request.getParameter("returnDate"));
	        System.out.println("departCity"+request.getParameter("departCity"));
	        System.out.println("arriveCity"+request.getParameter("arriveCity"));
	        System.out.println("adults"+request.getParameter("adults"));
	        System.out.println("kids"+request.getParameter("kids"));
	        System.out.println("classLevel"+request.getAttribute("classLevel"));
	        
	        
	        
	        
	    
	    
	    
		AirlineService als = new AirlineService();
		List<Airline> allAirline = als.findAllAirline();
		request.setAttribute("airlineList", allAirline);
		request.getRequestDispatcher("resultFlight.jsp").forward(request, response);
	}
}
