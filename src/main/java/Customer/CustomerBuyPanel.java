package Customer;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*;
import General.*;

public class CustomerBuyPanel extends JDialog {
    private static final long serialVersionUID = -4766367936647229462L;

    JTextArea description = new JTextArea();
    JButton addButton, removeButton, buyButton, Cancel;
    JPanel buy = new JPanel();
    Customer currentUser;
    int count = 1;
    long lastAmount = -1;
    Product[] allProducts;
    Product currentProduct;
    CustomerProducts parent;

    CustomerBuyPanel(Customer user, Product p, CustomerProducts pa) {
        parent = pa;

        readProductsFromFile();

        currentProduct = p;
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

        name.setBackground(currentUser.theme.dialog.background);
        nameShow.setBackground(currentUser.theme.dialog.background);
        discount.setBackground(currentUser.theme.dialog.background);
        discountShow.setBackground(currentUser.theme.dialog.background);
        price.setBackground(currentUser.theme.dialog.background);
        priceShow.setBackground(currentUser.theme.dialog.background);
        amount.setBackground(currentUser.theme.dialog.background);
        amountShow.setBackground(currentUser.theme.dialog.background);
        buyAmount.setBackground(currentUser.theme.dialog.background);

        name.setForeground(currentUser.theme.dialog.fontColor);
        nameShow.setForeground(currentUser.theme.dialog.fontColor);
        discount.setForeground(currentUser.theme.dialog.fontColor);
        discountShow.setForeground(currentUser.theme.dialog.fontColor);
        price.setForeground(currentUser.theme.dialog.fontColor);
        priceShow.setForeground(currentUser.theme.dialog.fontColor);
        amount.setForeground(currentUser.theme.dialog.fontColor);
        amountShow.setForeground(currentUser.theme.dialog.fontColor);
        buyAmount.setForeground(currentUser.theme.dialog.fontColor);

        name.setFont(currentUser.theme.dialog.font);
        nameShow.setFont(currentUser.theme.dialog.font);
        discount.setFont(currentUser.theme.dialog.font);
        discountShow.setFont(currentUser.theme.dialog.font);
        price.setFont(currentUser.theme.dialog.font);
        priceShow.setFont(currentUser.theme.dialog.font);
        amount.setFont(currentUser.theme.dialog.font);
        amountShow.setFont(currentUser.theme.dialog.font);
        buyAmount.setFont(currentUser.theme.dialog.font);

        name.setBounds(50, 240, 120, 25);
        nameShow.setBounds(170, 240, 280, 25);
        discount.setBounds(50, 300, 120, 25);
        discountShow.setBounds(170, 300, 280, 25);
        price.setBounds(50, 270, 120, 25);
        priceShow.setBounds(170, 270, 280, 25);
        amount.setBounds(50, 330, 120, 25);
        amountShow.setBounds(170, 330, 280, 25);

        ProductPicture.setBounds(135, 10, 220, 220);
        ProductPicture.setIcon(new ImageIcon(
                System.getProperty("user.dir") + "\\Images\\Products Icons\\" + currentProduct.name + ".png"));

        if (!(new File(System.getProperty("user.dir") + "\\Images\\Products Icons\\" + currentProduct.name + ".png")
                .exists())) {
            ProductPicture
                    .setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Frame Icons\\Product Icon.png"));
        }
        ProductPicture.setVisible(true);

        JLabel DiscountShow = new JLabel();
        DiscountShow.setBounds(365, 10, 128, 128);

        if (currentProduct.amount == 0) {
            DiscountShow.setIcon(new ImageIcon(
                    System.getProperty("user.dir") + "\\Images\\Products Icons\\Events\\Out Of Stock.png"));
            JLabel LowAmount = new JLabel("Out Of Stock !", 0);
            LowAmount.setFont(new Font("Dialog", Font.BOLD, 16));
            LowAmount.setForeground(currentUser.theme.dialog.fontColor);
            LowAmount.setBounds(365, 148, 128, 30);
            buy.add(LowAmount);
        } else if (currentProduct.discount >= 15) {
            DiscountShow.setIcon(
                    new ImageIcon(System.getProperty("user.dir") + "\\Images\\Products Icons\\Events\\Hot Sale.png"));
            JLabel LowAmount = new JLabel("Special Offer !", 0);
            LowAmount.setFont(new Font("Dialog", Font.BOLD, 16));
            LowAmount.setForeground(currentUser.theme.dialog.fontColor);
            LowAmount.setBounds(365, 148, 128, 30);
            buy.add(LowAmount);
        } else if (currentProduct.amount <= 10) {
            DiscountShow.setIcon(
                    new ImageIcon(System.getProperty("user.dir") + "\\Images\\Products Icons\\Events\\Shelf.png"));
        }

        if (currentProduct.amount >= 1 && currentProduct.amount <= 10) {
            JLabel LowAmount = new JLabel("Only " + currentProduct.amount + " Left !", 0);
            LowAmount.setFont(new Font("Dialog", Font.BOLD, 16));
            LowAmount.setForeground(currentUser.theme.dialog.fontColor);
            LowAmount.setBounds(365, 148, 128, 30);
            buy.add(LowAmount);
        }

        description.setText(currentProduct.description);
        description.setBackground(currentUser.theme.dialog.background);
        description.setForeground(currentUser.theme.dialog.fontColor);
        description.setEditable(false);
        description.setLineWrap(true);
        description.setBounds(50, 335, 400, 50);
        buy.add(description);

        nameShow.setText(currentProduct.name);
        name.setText(currentUser.language.products.name);

        discount.setText("Discount:");
        discountShow.setText(Integer.toString(currentProduct.discount) + " %");

        priceShow.setText(String.valueOf(currentProduct.price));
        price.setText(currentUser.language.products.price);
        if (lastAmount == -1) {
            amountShow.setText(String.valueOf(currentProduct.amount));
        } else {
            amountShow.setText(String.valueOf(lastAmount));
        }
        amount.setText("Remain amount:");

        buyAmount.setBounds(225, 420, 50, 50);
        buyAmount.setText(String.valueOf(count));
        buyAmount.setForeground(currentUser.theme.dialog.fontColor);
        buyAmount.setBackground(currentUser.theme.dialog.background);
        buyAmount.setFont(currentUser.theme.dialog.font);
        buyAmount.setBorder(null);
        buyAmount.setHorizontalAlignment(SwingConstants.CENTER);
        buy.add(buyAmount);

        addButton = new JButton("+");
        addButton.setBounds(275, 420, 50, 50);
        addButton.setBackground(currentUser.theme.dialog.buttonBackground);
        addButton.setForeground(currentUser.theme.dialog.fontColor);
        addButton.setFont(currentUser.theme.dialog.font);
        if (currentProduct.amount <= 0) {
            addButton.setEnabled(false);
        }
        addButton.addActionListener(e -> {
            int tempCount = Integer.parseInt(buyAmount.getText());
            buyAmount.setText(String.valueOf(++tempCount));
            removeButton.setEnabled(Long.parseLong(buyAmount.getText()) >= 2);
            addButton.setEnabled(tempCount != currentProduct.amount);
        });

        removeButton = new JButton("-");
        removeButton.setBounds(175, 420, 50, 50);
        removeButton.setEnabled(false);
        removeButton.setBackground(currentUser.theme.dialog.buttonBackground);
        removeButton.setForeground(currentUser.theme.dialog.fontColor);
        removeButton.setFont(currentUser.theme.dialog.font);
        removeButton.addActionListener(e -> {
            int tempCount = Integer.parseInt(buyAmount.getText());
            buyAmount.setText(String.valueOf(--tempCount));
            removeButton.setEnabled(Long.parseLong(buyAmount.getText()) >= 2);
            addButton.setEnabled(tempCount != currentProduct.amount);
        });

        buyButton = new JButton(currentUser.language.products.addToCart);
        buyButton.setBounds(50, 490, 400, 50);
        buyButton.setBackground(currentUser.theme.submitColor);
        buyButton.addActionListener(e -> {
            lastAmount = currentProduct.amount - Long.parseLong(buyAmount.getText());
            amountShow.setText(String.valueOf(lastAmount));
            if (Long.parseLong(buyAmount.getText()) > 0) {
                addToCart(Long.parseLong(buyAmount.getText()));
            }
            parent.reloadPage();
            dispose();
        });

        Cancel = new JButton(currentUser.language.products.back);
        Cancel.setBounds(25, 25, 75, 40);
        Cancel.setBackground(currentUser.theme.dialog.buttonBackground);
        Cancel.setForeground(currentUser.theme.dialog.fontColor);
        Cancel.setFont(currentUser.theme.dialog.font);
        Cancel.addActionListener((e) -> {
            dispose();
        });

        if (currentProduct.amount == 0) {
            buyAmount.setText("0");
        }

        buy.add(removeButton);
        buy.add(addButton);
        buy.add(buyButton);
        buy.setLayout(null);
        buy.setBackground(currentUser.theme.dialog.background);
        buy.add(ProductPicture);
        buy.add(DiscountShow);
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
        setBackground(currentUser.theme.dialog.background);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
    }

    public void readProductsFromFile() {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));
            allProducts = (Product[]) reader.readObject();
            reader.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void writeProductsToFile() {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));
            writer.writeObject(allProducts);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void addToCart(long c) {
        int length = currentUser.order.products.length;
        Order temp = currentUser.order;

        currentUser.order = new Order();
        currentUser.order.status = Order.IN_PROGRESS;
        currentUser.order.products = new Product[length + 1];
        currentUser.order.count = new int[length + 1];

        for (int i = 0; i < length; i++) {
            currentUser.order.products[i] = temp.products[i];
            currentUser.order.count[i] = temp.count[i];
        }

        currentUser.order.products[length] = currentProduct;
        currentUser.order.count[length] = (int) c;

        allProducts[currentProduct.index].amount -= c;
        writeProductsToFile();
        new CustomerWriter(currentUser);
    }
}