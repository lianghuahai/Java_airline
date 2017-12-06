package Bean;

public class ComprehensiveFlightInfo {
	@Override
    public String toString() {
        return "ComprehensiveFlightInfo [airlineName=" + airlineName + ", flightNo=" + flightNo
                + ", noOfSeats=" + noOfSeats + ", daysOperating=" + daysOperating + ", minLengthOfStay="
                + minLengthOfStay + ", maxLengthOfStay=" + maxLengthOfStay + ", legNo=" + legNo
                + ", arriveTime=" + arriveTime + ", departTime=" + departTime + ", departAirport="
                + departAirport + ", arriveAirport=" + arriveAirport + "]";
    }
    private String airlineName;
	private int flightNo;
	private int noOfSeats;
	private String daysOperating;
	private int minLengthOfStay;
	private int maxLengthOfStay;
	private int legNo;
	private String arriveTime;
	private String departTime;
	private String departAirport;
	private String arriveAirport;
	
	
	
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getDaysOperating() {
		return daysOperating;
	}
	public void setDaysOperating(String daysOperating) {
		this.daysOperating = daysOperating;
	}
	public int getMinLengthOfStay() {
		return minLengthOfStay;
	}
	public void setMinLengthOfStay(int minLengthOfStay) {
		this.minLengthOfStay = minLengthOfStay;
	}
	public int getMaxLengthOfStay() {
		return maxLengthOfStay;
	}
	public void setMaxLengthOfStay(int maxLengthOfStay) {
		this.maxLengthOfStay = maxLengthOfStay;
	}
	public int getLegNo() {
		return legNo;
	}
	public void setLegNo(int legNo) {
		this.legNo = legNo;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
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
}
