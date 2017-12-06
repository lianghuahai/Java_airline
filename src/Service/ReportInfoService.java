package Service;

import java.util.List;

import Bean.ComprehensiveFlightInfo;
import Dao.FlightReportDao;

public class ReportInfoService {
	private FlightReportDao fd;
	
	public List<ComprehensiveFlightInfo> getAllFlightInfo(){
		return fd.getAllFlightInfo();
	}
	
	public List<ComprehensiveFlightInfo> getMostActiveFlights(){
		return fd.getMostActiveFlights();
	}
	
	public List<ComprehensiveFlightInfo> getAllFlightsOfAirport(String airportName){
		return fd.getAllFlightsOfAirport(airportName);
	}
}
