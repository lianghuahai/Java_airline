package Bean;

public class Reservation {
	private int reservationNo;
	private String ReservationDate;
	private double bookingFee;
	private double totalFare;
	
	private int flightNo;
	private String airlineName;
	private int accountNo;
	
	private int repSSN;
	
	private int LegNo;
	
	private String firstName;
	private String lastName;
	
	private String destinationCity;
	
	private double totalRevenue;
	
	@Override
    public String toString() {
        return "Reservation [reservationNo=" + reservationNo + ", ReservationDate=" + ReservationDate
                + ", bookingFee=" + bookingFee + ", totalFare=" + totalFare + ", flightNo=" + flightNo
                + ", airlineName=" + airlineName + ", accountNo=" + accountNo + ", repSSN=" + repSSN
                + ", LegNo=" + LegNo + ", firstName=" + firstName + ", lastName=" + lastName
                + ", destinationCity=" + destinationCity + ", totalRevenue=" + totalRevenue + "]";
    }
    public String getReservationDate() {
		return ReservationDate;
	}
	public void setReservationDate(String reservationDate) {
		ReservationDate = reservationDate;
	}
	public double getBookingFee() {
		return bookingFee;
	}
	public void setBookingFee(double bookingFee) {
		this.bookingFee = bookingFee;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public double getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	public int getRepSSN() {
		return repSSN;
	}
	public void setRepSSN(int repSSN) {
		this.repSSN = repSSN;
	}
	public int getLegNo() {
		return LegNo;
	}
	public void setLegNo(int legNo) {
		LegNo = legNo;
	}
}
