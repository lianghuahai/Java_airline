package Service;

import java.util.List;

import Bean.Flight;
import Dao.FlightDao;

public class FlightService {
    FlightDao fd =  new FlightDao();
    public List <Flight> findOnewayFight(Flight flight) {
        
        return fd.findOnewayFight(flight);
    }

}
