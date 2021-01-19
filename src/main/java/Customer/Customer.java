package Customer;

import General.*;
import java.io.Serializable;

public class Customer extends User implements Serializable {
    public String address = "address";
    public Order order;
    public long balance;

    public Customer(String fname, String lname, String user, String pass, String phone, String ad, long bal) {
        this.name = fname;
        this.lastName = lname;
        this.username = user;
        this.password = pass;
        this.phoneNumber = phone;
        this.address = ad;
        this.balance = bal;
    }
}
