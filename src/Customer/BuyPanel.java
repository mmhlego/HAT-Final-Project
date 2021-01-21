package Customer;

import javax.swing.*;
import java.awt.*;
import General.*;

public class BuyPanel extends JDialog {
    private static final long serialVersionUID = -6769961606333376437L;

    JLabel productPicture = new JLabel(new ImageIcon("images1.jpg"));
    JTextField[] productsInformation = new JTextField[9];
    JTextArea description = new JTextArea();
    JButton[] buttons = new JButton[3];
    JPanel buy = new JPanel();
    Customer currentUser;
    int count = 0;
    JFrame parent;

    BuyPanel(Customer user/*,JFrame frame*/) {
        productsInformation[8] = new JTextField();

        currentUser = user;

        Product product = new Product("Product", "Description", 10, 120000);

        productPicture.setBounds(145, 10, 205, 215);
        productPicture.setVisible(true);

        description.setText(product.description);
        description.setBackground(currentUser.theme.main.background);
        description.setEditable(false);
        description.setForeground(Color.BLACK);
        description.setBounds(50, 365, 400, 50);
        buy.add(description);

        int height = 240;
        for (int i = 0; i < 8; i++) {
            productsInformation[i] = new JTextField();
            if (i % 2 == 0) {
                productsInformation[i].setBounds(50, height, 200, 25);

            } else {
                productsInformation[i].setBounds(250, height, 200, 25);
                height += 30;
            }
            productsInformation[i].setBackground(currentUser.theme.main.background);
            productsInformation[i].setForeground(Color.BLACK);
            productsInformation[i].setHorizontalAlignment(SwingConstants.CENTER);
            productsInformation[i].setBorder(null);
            productsInformation[i].setEditable(false);
            buy.add(productsInformation[i]);
        }
        productsInformation[1].setText(product.name);
        productsInformation[0].setText("Name:");
        //productsInformation[3].setText(product.discount);
        productsInformation[2].setText("Discount:");
        productsInformation[5].setText(String.valueOf(product.price));
        productsInformation[4].setText("Price:");
        productsInformation[7].setText(String.valueOf(product.amount));
        productsInformation[6].setText("Remain amount:");
        productsInformation[8].setBounds(150, 440, 200, 25);
        productsInformation[8].setText(String.valueOf(count));
        productsInformation[8].setBackground(currentUser.theme.sidePanel.background);
        productsInformation[8].setForeground(Color.BLACK);
        productsInformation[8].setEditable(false);
        productsInformation[8].setBorder(null);
        productsInformation[8].setHorizontalAlignment(SwingConstants.CENTER);
        buy.add(productsInformation[8]);

        buttons[0] = new JButton("+");
        buttons[0].setBounds(50, 440, 100, 25);
        buttons[1] = new JButton("-");
        buttons[1].setBounds(350, 440, 100, 25);
        buttons[2] = new JButton("Buy");
        buttons[2].setBounds(50, 470, 400, 25);

        buy.add(buttons[0]);
        buy.add(buttons[1]);
        buy.add(buttons[2]);

        buy.setBorder(null);
        buy.setLayout(null);
        buy.setBounds(0, 0, 500, 500);
        buy.setBackground(currentUser.theme.main.background);
        buy.add(productPicture);
        buy.setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(buy);
        setBounds(100, 100, 506, 528);
        setLayout(null);
        setBackground(currentUser.theme.main.background);
        setVisible(true);
        setResizable(false);
    }

}
