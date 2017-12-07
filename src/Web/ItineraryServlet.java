package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ComprehensiveFlightInfo;
import Service.ReportInfoService;

/**
 * Servlet implementation class ItineraryServlet
 */
public class ItineraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportInfoService rs =  new ReportInfoService();

    /**
     * Default constructor. 
     */
    public ItineraryServlet() {
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
		int reservationNo = Integer.valueOf(request.getParameter("reservationNo"));
		
		
		List<ComprehensiveFlightInfo> itineraryFlights = rs.getInitinery(reservationNo);
		String responseStr = "";
		for(ComprehensiveFlightInfo f: itineraryFlights){
			responseStr += f.getAirlineName() + ", " + f.getFlightNo() + ", " + f.getLegNo() + ", " + f.getArriveTime()
				+ ", " + f.getDepartTime() + ", " +f.getArriveAirport() + ", " + f.getDepartAirport() + "<br>";
		}
		response.getWriter().write(responseStr);
	}

}
