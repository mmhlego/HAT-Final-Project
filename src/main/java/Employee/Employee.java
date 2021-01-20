package Employee;

import General.*;
import java.io.Serializable;

public class Employee extends User implements Serializable {
    private static final long serialVersionUID = -7702904692029832336L;

    public Theme theme = new Theme();
    public String ID;

    public Employee(String fname, String lname, String user, String pass, String phone, String id) {
        this.name = fname;
        this.lastName = lname;
        this.username = user;
        this.password = pass;
        this.phoneNumber = phone;
        this.ID = id;
    }

}
