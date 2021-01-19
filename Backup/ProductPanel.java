import javax.swing.*;
import java.awt.*;
import java.util.Currency;
import Customer.Customer;

public class ProductPanel extends JPanel {
    JButton[] products = new JButton[100];
    Customer currentUser;

    ProductPanel(Customer user, JFrame parent) {
        int height = 20;
        int width = 50;
        for (int i = 0; i < products.length; i++) {
            products[i] = new JButton();
            products[i].setBounds(width, height, 275, 100);
            if (i % 2 == 0)
                width += 325;
            else {
                height += 120;
                width -= 325;
            }
            products[i].addActionListener(e -> new BuyPanel(currentUser));
            add(products[i]);
        }
        currentUser = user;
        setPreferredSize(new Dimension(680, height + 20));
        setLayout(null);
        setBackground(currentUser.theme.background);
        setBorder(null);
        setAutoscrolls(true);
        setVisible(true);

    }

}
