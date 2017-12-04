package Bean;

public class FlightInformaiton {
    private String departTime;
    private String returnTime;
    private String departAirport;
    private String arriveAirport;
    private String airline;
    private String stop;
    private double ticketPrice;
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
    public String getAirline() {
        return airline;
    }
    public void setAirline(String airline) {
        this.airline = airline;
    }
    public String getStop() {
        return stop;
    }
    public void setStop(String stop) {
        this.stop = stop;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    @Override
    public String toString() {
        return "FlightInformaiton [departTime=" + departTime + ", returnTime=" + returnTime
                + ", departAirport=" + departAirport + ", arriveAirport=" + arriveAirport + ", airline="
                + airline + ", stop=" + stop + ", ticketPrice=" + ticketPrice + "]";
    }
    
    
}