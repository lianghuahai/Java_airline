package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ComprehensiveFlightInfo;
import Bean.Reservation;
import Bean.User;
import Service.ReservationService;

/**
 * Servlet implementation class ReservationsByCustomerServlet
 */
public class ReservationsByCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService rs =  new ReservationService();
	
    /**
     * Default constructor. 
     */
    public ReservationsByCustomerServlet() {
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
		User user = request.getSession().getAttribute("existUser");
		
		int id = user.getId();
		
		
		List<Reservation> reservations = rs.getAllReservationGivenCustomer(id);
		String responseStr = "";
		for(Reservation r: reservations){
			responseStr += r.getReservationNo() + ", " + r.getReservationDate() + ", " + r.getBookingFee() + ", " + r.getTotalFare() + "<br>";
		}
		response.getWriter().write(responseStr);
	}

}
