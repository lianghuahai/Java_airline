package Bean;

public class loginUser {
    private String username;
    @Override
    public String toString() {
        return "loginUser [username=" + username + ", password=" + password + "]";
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    private String password;

}
