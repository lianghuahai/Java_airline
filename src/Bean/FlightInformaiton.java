package Bean;

import java.util.ArrayList;
import java.util.List;

public class FlightInformaiton {
    private String departTime;
    private String returnTime;
    private String departAirport;
    private String arriveAirport;
    private List<String> airline = new ArrayList<String>();
    private int stop;
    public List<String> getTransferAirport() {
        return transferAirport;
    }
    public void setTransferAirport(List<String> transferAirport) {
        this.transferAirport = transferAirport;
    }
    public void setAirline(List<String> airline) {
        this.airline = airline;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    private List<String> transferAirport= new ArrayList<String>();
   
    private double ticketPrice;
    private String departCity;
    private String arriveCity;
    
public String getDepartCity() {
        return departCity;
    }
    public void setDepartCity(String departCity) {
        this.departCity = departCity;
    }
    public String getArriveCity() {
        return arriveCity;
    }
    public void setArriveCity(String arriveCity) {
        this.arriveCity = arriveCity;
    }
    //    private String durationTime
    public String getDepartTime() {
        return departTime;
    }
    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }
    public String getReturnTime() {
        return returnTime;
    }
    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
    public String getDepartAirport() {
        return departAirport;
    }
    public void setDepartAirport(String departAirport) {
        this.departAirport = departAirport;
    }
    public String getArriveAirport() {
        return arriveAirport;
    }
    public void setArriveAirport(String arriveAirport) {
        this.arriveAirport = arriveAirport;
    }
    public List<String> getAirline() {
        return airline;
    }
    
    public int getStop() {
        return stop;
    }
    public void setStop(int stop) {
        this.stop = stop;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(Double string) {
        this.ticketPrice = string;
    }
    @Override
    public String toString() {
        return "FlightInformaiton [departTime=" + departTime + ", returnTime=" + returnTime
                + ", departAirport=" + departAirport + ", arriveAirport=" + arriveAirport + ", airline="
                + airline + ", stop=" + stop + ", ticketPrice=" + ticketPrice + "]";
    }
    
    
}
