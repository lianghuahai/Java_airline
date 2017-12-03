package Service;

import java.util.List;

import Bean.Airline;
import Dao.AirlineDao;

public class AirlineService {
        AirlineDao ald = new AirlineDao();
	public List<Airline> findAllAirline(){
		return ald.findAllAirline();
	}
}
