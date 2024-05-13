package bll;

import java.util.List;
public class UserResponse extends Response {
    public Users user;
    public List<Users> users;

    public UserResponse(boolean success, String message, Users user) {
        super(success, message);
        this.user = user;
    }
    public UserResponse(boolean success, String message, List<Users> users) {
        super(success, message);
        this.users = users;
    }


}