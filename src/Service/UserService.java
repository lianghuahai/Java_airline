package Service;

import java.util.List;

import Bean.User;
import Dao.UserDao;

public class UserService {
     private UserDao ud = new UserDao();

    public boolean register(User user) {
        User existUser = ud.findUserbyEmail(user.getEmail());
        if (existUser==null) {
            ud.register(user);
            return true;
        } else {
            return false;
        }
    }

    public User checkLogin(String email,String password) {
        User user =ud.findUserbyEmail(email);
        if(user!=null){
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    
    public void addEmployee(User user){
    	ud.addEmployee(user);
    }
    
    public void deleteEmployee(int SSN){
    	ud.deleteEmployee(SSN);
    }
    
    public void deleteCustomer(int accountNo){
    	ud.deleteCustomer(accountNo);
    }
    
    public List<User> getCustomerMailingList(){
    	return ud.getCustomerMailingList();
    }
}
