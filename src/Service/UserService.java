package Service;

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
}
