package Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Reservation;
import Service.ReservationService;

/**
 * Servlet implementation class AddFlightToReservationServlet
 */
public class AddFlightToReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService rs =  new ReservationService();

    /**
     * Default constructor. 
     */
    public AddFlightToReservationServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        Reservation r = new Reservation();
        r.setReservationNo(Integer.valueOf(request.getParameter("ReservationNo")));
        r.setAirlineName(request.getParameter("AirlineName"));
        r.setFlightNo(Integer.valueOf(request.getParameter("FlightNo")));
        r.setLegNo(Integer.valueOf(request.getParameter("LegNo")));
        rs.addFlightToReservation(r);
	}

}
