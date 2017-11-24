package Bean;

public class Auctions {
        private int airlineID;
        private int flightNo;
        private String classLevel;
        private String date;
        private double nyop;
        private int accepted;
        
    public int getAirlineID() {
        return airlineID;
    }
    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }
    public int getFlightNo() {
        return flightNo;
    }
    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }
    public String getClassLevel() {
        return classLevel;
    }
    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getNyop() {
        return nyop;
    }
    public void setNyop(double nyop) {
        this.nyop = nyop;
    }
    public int getAccepted() {
        return accepted;
    }
    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }
    
}
