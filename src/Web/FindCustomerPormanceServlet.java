package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ReservationService;
import Bean.Reservation;

/**
 * Servlet implementation class FindCustomerPormanceServlet
 */
public class FindCustomerPormanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService rs =  new ReservationService();

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
	    List<Reservation> EmployeePerformance =rs.getTopCustomerOfRevenue();
            for (Reservation reservation : EmployeePerformance) {
                response.getWriter().write(reservation.getFirstName()+",");
                response.getWriter().write(reservation.getLastName()+",");
                response.getWriter().write(reservation.getBookingFee()+"<br>");
          }
	}

}
