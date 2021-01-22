package Customer;

import General.*;

public class Customer extends User {
    private static final long serialVersionUID = 3155784291214885674L;

    public String address = "address";
    public Order order = null;
    public Order[] pastOrders = new Order[0];
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

    public boolean equals(Customer c) {
        if (this.name.equals(c.name) && this.lastName.equals(c.lastName) && this.username.equals(c.username)
                && this.password.equals(c.password) && this.phoneNumber.equals(c.phoneNumber)
                && this.address.equals(c.address) && this.balance == c.balance) {
            return true;
        }
        return false;
    }
}
