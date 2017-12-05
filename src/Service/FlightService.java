package Service;

import java.util.ArrayList;
import java.util.List;

import Bean.Flight;
import Bean.FlightInformaiton;
import Dao.FlightDao;

public class FlightService {
    FlightDao fd =  new FlightDao();
    public List <FlightInformaiton> findOnewayFight(Flight flight) {
        List <FlightInformaiton> totalList = new ArrayList<FlightInformaiton>();
        totalList=fd.findOnewayFightNoStop(flight);
        return totalList;
    }

}
