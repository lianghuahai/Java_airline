package Web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Service.FlightService;
import Bean.Flight;
import Bean.FlightInformaiton;

/**
 * Servlet implementation class SearchFlightServlet
 */
public class SearchFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private FlightService  fs =  new FlightService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setCharacterEncoding("UTF-8");
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
                List <FlightInformaiton>resultList = fs.findOnewayFight(flight);

                
                for(FlightInformaiton f: resultList){
                   System.out.println(f.getAirline());
            }
                request.setAttribute("resultList", resultList);
                request.getRequestDispatcher("/search.jsp").forward(request, response);
	    

                
                
                
                
                
	    
	    
	}

}
