package Customer;

import javax.swing.*;

public class CustomerCart extends JPanel {
    private static final long serialVersionUID = 5679015742552960498L;

    Customer currentUser;
    CustomerFrame parent;

    public CustomerCart(Customer c, CustomerFrame p) {
        currentUser = c;
        parent = p;

        if (currentUser.order != null) {
            currentUser.order.printData();
        } else {
            System.out.println("null");
        }
    }
}
