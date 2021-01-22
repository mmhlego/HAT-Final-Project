package Customer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import General.*;

public class CustomerBuyPanel extends JDialog {
    private static final long serialVersionUID = -4766367936647229462L;

    JTextArea description = new JTextArea();
    JButton addButton, removeButton, buyButton, Cancel;
    JPanel buy = new JPanel();
    Customer currentUser;
    CustomerProducts parent;
    int count = 0, index;
    long lastAmount = -1;

    CustomerBuyPanel(Customer user, Product currentProduct, CustomerProducts p, int i) {
        index = i;
        parent = p;
        currentUser = user;
        JLabel name = new JLabel("", 0);
        JLabel nameShow = new JLabel("", 0);
        JLabel discount = new JLabel("", 0);
        JLabel discountShow = new JLabel("", 0);
        JLabel price = new JLabel("", 0);
        JLabel priceShow = new JLabel("", 0);
        JLabel amount = new JLabel("", 0);
        JLabel amountShow = new JLabel("", 0);
        JLabel buyAmount = new JLabel("", 0);
        JLabel ProductPicture = new JLabel();

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

        name.setBounds(50, 240, 120, 25);
        nameShow.setBounds(170, 240, 280, 25);
        discount.setBounds(50, 300, 120, 25);
        discountShow.setBounds(170, 300, 280, 25);
        price.setBounds(50, 270, 120, 25);
        priceShow.setBounds(170, 270, 280, 25);
        amount.setBounds(50, 330, 120, 25);
        amountShow.setBounds(170, 330, 280, 25);

        ProductPicture.setBounds(150, 10, 190, 190);
        ProductPicture
                .setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Frame Icons\\Product Icon.png"));
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
        discountShow.setText(Integer.toString(currentProduct.discount) + " %");

        priceShow.setText(String.valueOf(currentProduct.price));
        price.setText("Price:");
        if (lastAmount == -1) {
            amountShow.setText(String.valueOf(currentProduct.amount));
        } else {
            amountShow.setText(String.valueOf(lastAmount));
        }
        amount.setText("Remain amount:");
        buyAmount.setBounds(225, 420, 50, 50);
        buyAmount.setText(String.valueOf(count));
        //productsInformation[8].setBackground(currentUser.theme.sidepanel);
        buyAmount.setForeground(Color.BLACK);
        buyAmount.setBorder(null);
        buyAmount.setHorizontalAlignment(SwingConstants.CENTER);

        buy.add(buyAmount);

        addButton = new JButton("+");
        addButton.setBounds(275, 420, 50, 50);
        addButton.addActionListener(e -> {
            long tempCount = Integer.parseInt(buyAmount.getText());
            buyAmount.setText(String.valueOf(++tempCount));
            removeButton.setEnabled(Long.parseLong(buyAmount.getText()) != 0);
            addButton.setEnabled(tempCount != currentProduct.amount);
        });

        removeButton = new JButton("-");
        removeButton.setBounds(175, 420, 50, 50);
        removeButton.setEnabled(false);
        removeButton.addActionListener(e -> {
            int tempCount = Integer.parseInt(buyAmount.getText());
            buyAmount.setText(String.valueOf(--tempCount));
            removeButton.setEnabled(Long.parseLong(buyAmount.getText()) != 0);
            addButton.setEnabled(tempCount != currentProduct.amount);
        });

        buyButton = new JButton("Add to cart");
        buyButton.setBounds(50, 490, 400, 50);
        buyButton.setBackground(new Color(111, 207, 151));
        buyButton.addActionListener(e -> {
            lastAmount = currentProduct.amount - Long.parseLong(buyAmount.getText());
            amountShow.setText(String.valueOf(lastAmount));

            if (Long.parseLong(buyAmount.getText()) > 0) {
                parent.updateData(index, Long.parseLong(buyAmount.getText()));
            }
            dispose();
        });

        Cancel = new JButton("Back");
        Cancel.setBounds(25, 25, 75, 40);
        Cancel.addActionListener((e) -> {
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
        if (currentProduct.discount > 0) {
            buy.add(discount);
            buy.add(discountShow);
        }
        buy.add(amount);
        buy.add(amountShow);
        buy.add(price);
        buy.add(priceShow);
        buy.add(buyAmount);
        buy.add(Cancel);
        buy.setBorder(new LineBorder(Color.BLACK, 1));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(buy);
        setSize(500, 590);
        setLocationRelativeTo(null);
        setBackground(currentUser.theme.main.background);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
    }
}