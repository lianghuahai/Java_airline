package Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Reservation;
import Service.ReservationService;

/**
 * Servlet implementation class RecordReservationServlet
 */
public class RecordReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService rs =  new ReservationService();

    /**
     * Default constructor. 
     */
    public RecordReservationServlet() {
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
		r.setReservationDate("2017-12-07");
		r.setAccountNo(accountNo);
		r.setRepSSN(repSSN);
		r.setBookingFee(bookingFee);
		r.setTotalFare(totalFare);
		rs.recordReservation(r);
	}

}
