package Sistema;

import usuarios.User;
import java.util.ArrayList;
public class Library{
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers(){
        return this.users;
    }
}