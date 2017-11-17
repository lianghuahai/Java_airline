package Service;

import java.util.List;

import Bean.Airline;
import Dao.AirlineDao;

public class AirlineService {
	public List<Airline> findAllAirline(){
		AirlineDao ald = new AirlineDao();
		return ald.findAllAirline();
	}
}
