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
 * Servlet implementation class FindEmployeePerformanceServlet
 */
public class FindEmployeePerformanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService rs =  new ReservationService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindEmployeePerformanceServlet() {
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
	          List<Reservation> EmployeePerformance =rs.getTopCustomerRepresentativeOfRevenue();
	          for (Reservation reservation : EmployeePerformance) {
	              response.getWriter().write("<label class='flight-label'><label class='word'>FirstName:</label>"+reservation.getFirstName()+"</label>");
	              response.getWriter().write("<label class='flight-label'><label class='word'>LastName:</label>"+reservation.getLastName()+"</label>");
	              response.getWriter().write("<label class='flight-label'><label class='word'>BookingFee:</label>"+reservation.getBookingFee()+"</label><br>");
                }
	}

}
