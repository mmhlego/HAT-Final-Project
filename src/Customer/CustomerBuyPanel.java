package Customer;

import javax.swing.*;
import java.awt.*;
import General.*;

public class CustomerBuyPanel extends JDialog {
    private static final long serialVersionUID = -4766367936647229462L;

    JLabel productPicture = new JLabel(new ImageIcon("images1.jpg"));
    JTextField[] productsInformation = new JTextField[9];
    JTextArea description = new JTextArea();
    JButton addButton, removeButton, buyButton;
    JPanel buy = new JPanel();
    Customer currentUser;
    int count = 0;
    long lastAmount = -1;
    JFrame parent;

    CustomerBuyPanel(Customer user, Product currentProduct) {
        productsInformation[8] = new JTextField();

        currentUser = user;

        productPicture.setBounds(145, 10, 205, 215);
        productPicture.setVisible(true);

        description.setText(currentProduct.description);
        description.setBackground(currentUser.theme.main.background);
        description.setEditable(false);
        //description.setForeground(Color.BLACK);
        description.setBounds(50, 365, 400, 50);
        buy.add(description);

        int height = 240;
        for (int i = 0; i < 8; i++) {
            productsInformation[i] = new JTextField();

            productsInformation[i].setFont(currentUser.theme.main.font);
            productsInformation[i].setForeground(currentUser.theme.main.fontColor);
            if (i % 2 == 0) {
                productsInformation[i].setBounds(50, height, 200, 25);

            } else {
                productsInformation[i].setBounds(250, height, 200, 25);
                height += 30;
            }
            productsInformation[i].setBackground(currentUser.theme.main.background);
            //productsInformation[i].setForeground(Color.BLACK);
            productsInformation[i].setHorizontalAlignment(SwingConstants.CENTER);
            productsInformation[i].setBorder(null);
            productsInformation[i].setEditable(false);
            buy.add(productsInformation[i]);
        }

        productsInformation[1].setText(currentProduct.name);
        productsInformation[0].setText("Name:");
        productsInformation[2].setText("Discount:");
        productsInformation[5].setText(String.valueOf(currentProduct.price));
        productsInformation[4].setText("Price:");
        if (lastAmount == -1)
            productsInformation[7].setText(String.valueOf(currentProduct.amount));
        else
            productsInformation[7].setText(String.valueOf(lastAmount));
        productsInformation[6].setText("Remain amount:");
        productsInformation[8].setBounds(100, 450, 75, 50);
        productsInformation[8].setText(String.valueOf(count));
        //productsInformation[8].setBackground(currentUser.theme.sidepanel);
        productsInformation[8].setForeground(Color.BLACK);
        productsInformation[8].setEditable(false);
        productsInformation[8].setBorder(null);
        productsInformation[8].setHorizontalAlignment(SwingConstants.CENTER);

        buy.add(productsInformation[8]);

        removeButton = new JButton("+");
        removeButton.setBounds(175, 450, 50, 50);
        removeButton.addActionListener(e -> {
            long tempCount = Integer.parseInt(productsInformation[8].getText());
            productsInformation[8].setText(String.valueOf(++tempCount));
            removeButton.setEnabled(tempCount != Long.parseLong(productsInformation[7].getText()));
            addButton.setEnabled(true);
        });

        addButton = new JButton("-");
        addButton.setBounds(50, 450, 50, 50);
        addButton.setEnabled(false);
        addButton.addActionListener(e -> {
            int tempCount = Integer.parseInt(productsInformation[8].getText());
            productsInformation[8].setText(String.valueOf(--tempCount));
            addButton.setEnabled(Long.parseLong(productsInformation[8].getText()) != 0);
            removeButton.setEnabled(tempCount != Long.parseLong(productsInformation[7].getText()));
            removeButton.setEnabled(true);
        });

        buyButton = new JButton("Buy");
        buyButton.setBounds(275, 450, 175, 50);
        buyButton.addActionListener(e -> {
            lastAmount = currentProduct.amount - Long.parseLong(productsInformation[8].getText());
            productsInformation[7].setText(String.valueOf(lastAmount));
        });

        buy.add(removeButton);
        buy.add(addButton);
        buy.add(buyButton);
        buy.setLayout(null);
        buy.setBackground(currentUser.theme.main.background);
        buy.add(productPicture);
        buy.setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(buy);
        setSize(500, 550);
        setLocationRelativeTo(null);
        setBackground(currentUser.theme.main.background);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
    }
}