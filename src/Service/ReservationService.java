package Service;

import java.util.List;

import Bean.Reservation;
import Dao.ReservationDao;

public class ReservationService {
	
	private ReservationDao rd = new ReservationDao();
	
	public List<Reservation> getMonthReport(String dateFrom, String dateTo){
		return rd.getMonthReport(dateFrom, dateTo);
	}

}
