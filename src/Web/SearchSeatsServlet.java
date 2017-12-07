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
 * Servlet implementation class SearchSeatsServlet
 */
public class SearchSeatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService rs = new ReservationService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSeatsServlet() {
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
	    List<Reservation> SearchCustomerReseved=rs.getCustomersOnGivenFlight(request.getParameter("airlineName"), Integer.valueOf(request.getParameter("flightNo")));
	   request.setAttribute("SearchCustomerReseved", SearchCustomerReseved);
	    request.getRequestDispatcher("/customerHasSeats.jsp").forward(request, response);
	}

}
