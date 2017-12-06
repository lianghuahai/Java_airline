package Service;

import java.util.List;

import Bean.Reservation;
import Dao.ReservationDao;

public class ReservationService {
	
	private ReservationDao rd = new ReservationDao();
	
	public List<Reservation> getMonthReport(String dateFrom, String dateTo){
		return rd.getMonthReport(dateFrom, dateTo);
	}
	
	public List<Reservation> getReservationsByFlight(String airlineName, int flightNo){
		return rd.getReservationsByFlight(airlineName, flightNo);
	}
	
	public List<Reservation> getReservationsByCustomer(String firstName, String lastName){
		return rd.getReservationsByCustomer(firstName, lastName);
	}
	
	public List<Reservation> getReservationsByDestinationCity(String destinationCity){
		return rd.getReservationsByDestinationCity(destinationCity);
	}

}