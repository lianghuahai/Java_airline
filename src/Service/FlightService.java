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
        List <FlightInformaiton> noStop = fd.findOnewayFightNoStop(flight);
        List <FlightInformaiton> oneStop = fd.findOnewayFightOneStop(flight);
        for(FlightInformaiton f: noStop){
        	totalList.add(f);
        }
        for(FlightInformaiton f: oneStop){
        	totalList.add(f);
        }
        return totalList;
    }
    
    public List <FlightInformaiton> findOnewayFightFlex(Flight flight) {
        List <FlightInformaiton> totalList = new ArrayList<FlightInformaiton>();
        List <FlightInformaiton> noStop = fd.findOnewayFightNoStopFlex(flight);
        List <FlightInformaiton> oneStop = fd.findOnewayFightOneStopFlex(flight);
        for(FlightInformaiton f: noStop){
        	totalList.add(f);
        }
        for(FlightInformaiton f: oneStop){
        	totalList.add(f);
        }
        return totalList;
    }

}
