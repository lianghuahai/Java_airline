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
 * Servlet implementation class BestSellerFlightsServlet
 */
public class BestSellerFlightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportInfoService ri = new ReportInfoService();

    /**
     * Default constructor. 
     */
    public BestSellerFlightsServlet() {
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
		List<ComprehensiveFlightInfo> bestSellerFlights = ri.getBestSellerFlights();
		String responseStr = "";
		for(ComprehensiveFlightInfo f: bestSellerFlights){
			responseStr += f.getAirlineName() + ", " +f.getFlightNo() + ", " + f.getReservedSeatPercentage() + "<br>";
		}
		response.getWriter().write(responseStr);
	}

}
