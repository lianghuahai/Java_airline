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
 * Servlet implementation class SearchByCustomerServlet
 */
public class SearchByCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService rs =  new ReservationService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByCustomerServlet() {
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
	    System.out.println("SearchByCustomerServlet");
            System.out.println(request.getParameter("firstName"));
            System.out.println(request.getParameter("lastName"));
            List<Reservation> listByCustomer=rs.getReservationsByCustomer(request.getParameter("firstName"), request.getParameter("lastName"));
            System.out.println(listByCustomer);
            request.setAttribute("listByCustomer", listByCustomer);
//          response.sendRedirect(request.getContextPath()+"/listReservation.jsp");
            request.getRequestDispatcher("/listReservation.jsp").forward(request, response);
	}

}
