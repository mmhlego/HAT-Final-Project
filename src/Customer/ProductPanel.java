package Customer;

import javax.swing.*;
import java.awt.*;
//import General.*;

public class ProductPanel extends JPanel {
    private static final long serialVersionUID = 499751707819600223L;

    JButton[] allProducts = new JButton[100];
    Customer currentUser;

    ProductPanel(Customer user, JFrame parent) {
        int height = 20;
        int width = 50;

        for (int i = 0; i < allProducts.length; i++) {
            allProducts[i] = new JButton();
            allProducts[i].setBounds(width, height, 275, 100);
            if (i % 2 == 0)
                width += 325;
            else {
                height += 120;
                width -= 325;
            }
            allProducts[i].addActionListener(e -> new BuyPanel(currentUser));
            add(allProducts[i]);
        }
        currentUser = user;
        setPreferredSize(new Dimension(680, height + 20));
        setLayout(null);
        setBackground(currentUser.theme.main.background);
        setBorder(null);
        setAutoscrolls(true);
        setVisible(true);

    }

}
