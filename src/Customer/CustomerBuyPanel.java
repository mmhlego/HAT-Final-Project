package Customer;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import General.*;

public class CustomerBuyPanel extends JDialog {
    private static final long serialVersionUID = -4766367936647229462L;

    JTextArea description = new JTextArea();
    JButton addButton, removeButton, buyButton , Cancel;
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
        JLabel ProductPicture = new JLabel();

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

        name.setBounds(50, 210, 200, 25);
        nameShow.setBounds(250, 210, 200, 25);
        discount.setBounds(50, 240, 200, 25);
        discountShow.setBounds(250, 240, 200, 25);
        price.setBounds(50, 270, 200, 25);
        priceShow.setBounds(250, 270, 200, 25);
        amount.setBounds(50, 300, 200, 25);
        amountShow.setBounds(250, 300, 200, 25);

        ProductPicture.setBounds(150, 10, 190, 190);/////////////////////////
        ProductPicture.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Frame Icons\\Product Icon.png"));
        ProductPicture.setVisible(true);

        description.setText(currentProduct.description);
        description.setBackground(currentUser.theme.main.background);
        description.setEditable(false);
        description.setLineWrap(true);
        description.setBounds(50, 335, 400, 50);
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
        buyAmount.setBounds(100, 420, 75, 50);
        buyAmount.setText(String.valueOf(count));
        //productsInformation[8].setBackground(currentUser.theme.sidepanel);
        buyAmount.setForeground(Color.BLACK);
        buyAmount.setBorder(null);
        buyAmount.setHorizontalAlignment(SwingConstants.CENTER);

        buy.add(buyAmount);

        removeButton = new JButton("+");
        removeButton.setBounds(175, 420, 50, 50);
        removeButton.addActionListener(e -> {
            long tempCount = Integer.parseInt(buyAmount.getText());
            buyAmount.setText(String.valueOf(++tempCount));
            removeButton.setEnabled(tempCount != Long.parseLong(buyAmount.getText()));
            addButton.setEnabled(true);
        });

        addButton = new JButton("-");
        addButton.setBounds(50, 420, 50, 50);
        addButton.setEnabled(false);
        addButton.addActionListener(e -> {
            int tempCount = Integer.parseInt(buyAmount.getText());
            buyAmount.setText(String.valueOf(--tempCount));
            addButton.setEnabled(Long.parseLong(buyAmount.getText()) != 0);
            removeButton.setEnabled(tempCount != Long.parseLong(amountShow.getText()));
            removeButton.setEnabled(true);
        });

        buyButton = new JButton("Buy");
        buyButton.setBounds(275, 420, 175, 50);
        buyButton.addActionListener(e -> {
            lastAmount = currentProduct.amount - Long.parseLong(buyAmount.getText());
            amountShow.setText(String.valueOf(lastAmount));
        });

        Cancel = new JButton("Cancel");
        Cancel.setBounds(50, 490, 400, 50);
        Cancel.addActionListener((e) -> 
        {
            dispose();
        });

        buy.add(removeButton);
        buy.add(addButton);
        buy.add(buyButton);
        buy.setLayout(null);
        buy.setBackground(currentUser.theme.main.background);
        buy.add(ProductPicture);
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
        buy.add(Cancel);
        buy.setBorder(new LineBorder(Color.BLACK, 1));

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