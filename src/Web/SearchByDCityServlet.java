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
 * Servlet implementation class SearchByDCityServlet
 */
public class SearchByDCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService rs =  new ReservationService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("SearchByDCityServlet");
	    System.out.println(request.getParameter("dcity"));
	    List<Reservation> listBydcity= rs.getReservationsByDestinationCity(request.getParameter("dcity"));
	    request.setAttribute("listBydcity", listBydcity);
	    request.getRequestDispatcher("/listReservation.jsp").forward(request, response);
	}

}
