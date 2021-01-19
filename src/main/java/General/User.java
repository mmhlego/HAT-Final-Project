package General;

import java.io.Serializable;

public class User implements Serializable {
    /*public String username = "username";
    public String password = "password";
    public String name = "first name";
    public String lastName = "last name";
    public String phoneNumber = "09123456789";*/
    public String username;
    public String password;
    public String name;
    public String lastName;
    public String phoneNumber;
    public Theme theme = new Theme();
}
