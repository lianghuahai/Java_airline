package Bean;

public class User {
            	private String email;
            	 private String firstname;
	        private String lastname;
	        private String address;
	        private String city;
	        private String state;
	        private String zipcode;
	        private String password;
	        private String level;
	        
	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }




    public void setCity(String city) {
        this.city = city;
    }




    public String getState() {
        return state;
    }




    public void setState(String state) {
        this.state = state;
    }




    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", address="
                + address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", password="
                + password + ", level=" + level + "]";
    }

  

}
