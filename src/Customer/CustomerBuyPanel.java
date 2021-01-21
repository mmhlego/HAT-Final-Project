package Customer;

import javax.swing.*;
import java.awt.*;
import General.*;

public class CustomerBuyPanel extends JDialog {
    private static final long serialVersionUID = -4766367936647229462L;

    JLabel productPicture = new JLabel(new ImageIcon("images1.jpg"));

    JTextArea description = new JTextArea();
    JButton addButton, removeButton, buyButton;
    JPanel buy = new JPanel();
    Customer currentUser;
    int count = 0;
    long lastAmount = -1;
    JFrame parent;



    CustomerBuyPanel(Customer user, Product currentProduct) {
        currentUser = user;
        JLabel name = new JLabel();
        JLabel nameShow = new JLabel();
        JLabel discount = new JLabel();
        JLabel discountShow = new JLabel();
        JLabel price = new JLabel();
        JLabel priceShow = new JLabel();
        JLabel amount = new JLabel();
        JLabel amountShow = new JLabel();
        JLabel buyAmount = new JLabel();

        name.setHorizontalTextPosition(SwingConstants.CENTER);
        nameShow.setHorizontalTextPosition(SwingConstants.CENTER);
        discount.setHorizontalTextPosition(SwingConstants.CENTER);
        discountShow.setHorizontalTextPosition(SwingConstants.CENTER);
        price.setHorizontalTextPosition(SwingConstants.CENTER);
        priceShow.setHorizontalTextPosition(SwingConstants.CENTER);
        amount.setHorizontalTextPosition(SwingConstants.CENTER);
        amountShow.setHorizontalTextPosition(SwingConstants.CENTER);
        buyAmount.setHorizontalTextPosition(SwingConstants.CENTER);

        name.setForeground(currentUser.theme.main.fontColor);
        nameShow.setForeground(currentUser.theme.main.fontColor);
        discount.setForeground(currentUser.theme.main.fontColor);
        discountShow.setForeground(currentUser.theme.main.fontColor);
        price.setForeground(currentUser.theme.main.fontColor);
        priceShow.setForeground(currentUser.theme.main.fontColor);
        amount.setForeground(currentUser.theme.main.fontColor);
        amountShow.setForeground(currentUser.theme.main.fontColor);
        buyAmount.setForeground(currentUser.theme.main.fontColor);

        name.setFont(currentUser.theme.main.font);
        nameShow.setFont(currentUser.theme.main.font);
        discount.setFont(currentUser.theme.main.font);
        discountShow.setFont(currentUser.theme.main.font);
        price.setFont(currentUser.theme.main.font);
        priceShow.setFont(currentUser.theme.main.font);
        amount.setFont(currentUser.theme.main.font);
        amountShow.setFont(currentUser.theme.main.font);
        buyAmount.setFont(currentUser.theme.main.font);

        name.setBounds(50,240,200,25);
        nameShow.setBounds(250,240,200,25);
        discount.setBounds(50,270,200,25);
        discountShow.setBounds(250,270,200,25);
        price.setBounds(50,300,200,25);
        priceShow.setBounds(250,300,200,25);
        amount.setBounds(50,330,200,25);
        amountShow.setBounds(250,330,200,25);

        productPicture.setBounds(145, 10, 205, 215);
        productPicture.setVisible(true);

        description.setText(currentProduct.description);
        description.setBackground(currentUser.theme.main.background);
        description.setEditable(false);
        //description.setForeground(Color.BLACK);
        description.setBounds(50, 365, 400, 50);
        buy.add(description);

        nameShow.setText(currentProduct.name);
        name.setText("Name:");
        discount.setText("Discount:");
        priceShow.setText(String.valueOf(currentProduct.price));
        price.setText("Price:");
        if (lastAmount == -1)
            amountShow.setText(String.valueOf(currentProduct.amount));
        else
            amountShow.setText(String.valueOf(lastAmount));
        amount.setText("Remain amount:");
        buyAmount.setBounds(100, 450, 75, 50);
        buyAmount.setText(String.valueOf(count));
        //productsInformation[8].setBackground(currentUser.theme.sidepanel);
        buyAmount.setForeground(Color.BLACK);
        buyAmount.setBorder(null);
        buyAmount.setHorizontalAlignment(SwingConstants.CENTER);

        buy.add(buyAmount);

        removeButton = new JButton("+");
        removeButton.setBounds(175, 450, 50, 50);
        removeButton.addActionListener(e -> {
            long tempCount = Integer.parseInt(buyAmount.getText());
            buyAmount.setText(String.valueOf(++tempCount));
            removeButton.setEnabled(tempCount != Long.parseLong(buyAmount.getText()));
            addButton.setEnabled(true);
        });

        addButton = new JButton("-");
        addButton.setBounds(50, 450, 50, 50);
        addButton.setEnabled(false);
        addButton.addActionListener(e -> {
            int tempCount = Integer.parseInt(buyAmount.getText());
            buyAmount.setText(String.valueOf(--tempCount));
            addButton.setEnabled(Long.parseLong(buyAmount.getText()) != 0);
            removeButton.setEnabled(tempCount != Long.parseLong(amountShow.getText()));
            removeButton.setEnabled(true);
        });

        buyButton = new JButton("Buy");
        buyButton.setBounds(275, 450, 175, 50);
        buyButton.addActionListener(e -> {
            lastAmount = currentProduct.amount - Long.parseLong(buyAmount.getText());
            amountShow.setText(String.valueOf(lastAmount));
        });

        buy.add(removeButton);
        buy.add(addButton);
        buy.add(buyButton);
        buy.setLayout(null);
        buy.setBackground(currentUser.theme.main.background);
        buy.add(productPicture);
        buy.setVisible(true);
        buy.add(name);
        buy.add(nameShow);
        buy.add(discount);
        buy.add(discountShow);
        buy.add(amount);
        buy.add(amountShow);
        buy.add(price);
        buy.add(priceShow);
        buy.add(buyAmount);

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