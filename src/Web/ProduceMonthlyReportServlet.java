package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Reservation;
import Service.ReservationService;

/**
 * Servlet implementation class ProduceMonthlyReportServlet
 */
public class ProduceMonthlyReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           private ReservationService rs = new ReservationService();


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
	    System.out.println("produceMonthlyReportServlet");
	    List<Reservation> list =rs.getMonthReport(request.getParameter("departDate"), request.getParameter("returnDate"));
	    
	    request.setAttribute("list", list);
	    System.out.println(list);
	    request.getRequestDispatcher("/monthlyReport.jsp").forward(request, response);
//	    response.sendRedirect(request.getContextPath()+"/monthlyReport.jsp");
//	    response.getWriter().print("");
	    
	}

}
