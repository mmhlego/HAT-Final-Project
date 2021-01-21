package Manager;

import General.*;

public class Manager extends User {
    private static final long serialVersionUID = -2599661966975502788L;

    public Manager(String fname, String lname, String user, String pass, String phone) {
        this.name = fname;
        this.lastName = lname;
        this.username = user;
        this.password = pass;
        this.phoneNumber = phone;
    }
}
