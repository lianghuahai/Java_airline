package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ReportInfoService;
import Service.ReservationService;
import Bean.ComprehensiveFlightInfo;
import Bean.Reservation;

/**
 * Servlet implementation class FlightByGivenAirport
 */
public class FlightByGivenAirport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportInfoService ri = new ReportInfoService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightByGivenAirport() {
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
	    List<ComprehensiveFlightInfo> FlightByGivenAirport=ri.getAllFlightsOfAirport(request.getParameter("airportName"));
	           request.setAttribute("FlightByGivenAirport", FlightByGivenAirport);
	            request.getRequestDispatcher("/customerHasSeats.jsp").forward(request, response);
	     }

}
