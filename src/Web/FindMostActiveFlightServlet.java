package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ReportInfoService;
import Bean.ComprehensiveFlightInfo;
import Bean.Reservation;

/**
 * Servlet implementation class FindMostActiveFlightServlet
 */
public class FindMostActiveFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ReportInfoService pi = new ReportInfoService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMostActiveFlightServlet() {
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
	   System.out.println("FindMostActiveFlightServlet");
	    List<ComprehensiveFlightInfo> FindMostActiveFlight =pi.getMostActiveFlights();
            for (ComprehensiveFlightInfo reservation : FindMostActiveFlight) {
                response.getWriter().write("<label>"+reservation.getAirlineName()+"</label>,");
                response.getWriter().write("<label>"+reservation.getFlightNo()+"</label>,");
                response.getWriter().write(reservation.getDaysOperating()+",");
                response.getWriter().write(reservation.getMaxLengthOfStay()+",");
                response.getWriter().write(reservation.getMinLengthOfStay()+",");
                response.getWriter().write(reservation.getNoOfSeats()+"<br>");
          }
	}

}
