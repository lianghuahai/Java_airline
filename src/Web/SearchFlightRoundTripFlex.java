package Web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Bean.Flight;
import Bean.FlightInformaiton;
import Service.FlightService;

/**
 * Servlet implementation class SearchFlightRoundTripFlex
 */
public class SearchFlightRoundTripFlex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightService  fs =  new FlightService();

    /**
     * Default constructor. 
     */
    public SearchFlightRoundTripFlex() {
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
		Flight flight = new Flight();
        try {
            BeanUtils.populate(flight, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(flight);
        request.setAttribute("flight", flight);
        List <FlightInformaiton> resultList = fs.findOnewayFightFlex(flight);
        
        //FIND RETURN
        String city1 = flight.getDepartCity();
        String city2 = flight.getArriveCity();
        flight.setDepartCity(city2);
        flight.setArriveCity(city1);
        flight.setDepartDate(flight.getReturnDate());
        List <FlightInformaiton> resultListTwo = fs.findOnewayFightFlex(flight);
        

        request.setAttribute("resultList", resultList);
        request.setAttribute("resultListTwo", resultListTwo);
        request.getRequestDispatcher("/roundTrip.jsp").forward(request, response);
	}

}
