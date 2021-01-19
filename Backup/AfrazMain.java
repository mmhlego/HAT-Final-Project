import javax.swing.*;
import java.awt.*;
import Customer.Customer;
import java.io.*;

public class AfrazMain {

    public static void main(String[] args) {

        Customer[] allCustomers;
        Customer c;

        try {
            allCustomers = (Customer[]) new ObjectInputStream(new FileInputStream("data\\Customers.dat")).readObject();

            c = allCustomers[0];

            JFrame f = new JFrame();
            f.setLayout(null);
            f.setBounds(0, 0, 720, 720);
            JScrollPane p = new JScrollPane(new ProductPanel(c, f));
            p.setBounds(0, 0, 700, 700);
            p.setBorder(null);
            p.setBackground(c.theme.background);
            p.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            p.setPreferredSize(new Dimension(700, 700));
            p.setVisible(true);
            f.add(p);
            f.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
