package Bean;

public class Flight {
    private String departDate;
    private String returnDate;
    private String departCity;
    private String arriveCity;
    private int adults;
    private int kids;
    private String classLevel;
    
    
    
    public String getDepartDate() {
        return departDate;
    }
    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
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
    public int getAdults() {
        return adults;
    }
    public void setAdults(int adults) {
        this.adults = adults;
    }
    public int getKids() {
        return kids;
    }
    public void setKids(int kids) {
        this.kids = kids;
    }
    public String getClassLevel() {
        return classLevel;
    }
    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }
    

}
