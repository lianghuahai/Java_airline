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
 * Servlet implementation class SearchByFlghtServlet
 */
public class SearchByFlghtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService rs =  new ReservationService();
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
		System.out.println("SearchByFlghtServlet");
		System.out.println(request.getParameter("airlineName"));
		System.out.println(request.getParameter("flightNo"));
		List<Reservation> listByFlight=rs.getReservationsByFlight(request.getParameter("airlineName"), Integer.valueOf(request.getParameter("flightNo")));
		System.out.println(listByFlight);
		request.setAttribute("listByFlight", listByFlight);
//		response.sendRedirect(request.getContextPath()+"/listReservation.jsp");
		request.getRequestDispatcher("/listReservation.jsp").forward(request, response);
	}

}
