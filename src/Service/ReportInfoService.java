package Service;

import java.util.List;

import Bean.ComprehensiveFlightInfo;
import Dao.FlightReportDao;

public class ReportInfoService {
	private FlightReportDao fd =new FlightReportDao();
	
	public List<ComprehensiveFlightInfo> getAllFlightInfo(){
	    System.out.println(fd.getAllFlightInfo());
		return fd.getAllFlightInfo();
	}
	
	public List<ComprehensiveFlightInfo> getMostActiveFlights(){
		return fd.getMostActiveFlights();
	}
	
	public List<ComprehensiveFlightInfo> getAllFlightsOfAirport(String airportName){
		return fd.getAllFlightsOfAirport(airportName);
	}
	
	public List<ComprehensiveFlightInfo> getRecommendedFlightsOfCustomer(int accountNo){
		return fd.getRecommendedFlightsOfCustomer(accountNo);
	}
	
	public List<ComprehensiveFlightInfo> getBestSellerFlights(){
		return fd.getBestSellerFlights();
	}
}
