package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ComprehensiveFlightInfo;
import Service.ReportInfoService;

/**
 * Servlet implementation class ListAllFlightServlet
 */
public class ListAllFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReportInfoService rf =  new ReportInfoService();
 
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
	        System.out.println("ListAllFlightServlet");
	        List<ComprehensiveFlightInfo> list= rf.getAllFlightInfo();
	        request.setAttribute("list", list);
	        System.out.println(list);
	        request.getRequestDispatcher("/allFlights.jsp").forward(request, response);
	}

}
