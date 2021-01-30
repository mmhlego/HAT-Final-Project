package Customer;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

import General.*;

public class CustomerCart extends JPanel {
    private static final long serialVersionUID = 5679015742552960498L;

    JPanel Info;
    int Count;
    Customer currentUser;
    CustomerFrame parent;
    Product[] allProducts;
    JLabel calculatedTotalDiscount, calculatedTotalPrice, error = new JLabel();
    JLabel[] totalPriceLabels;
    JButton submit;
    long total = 0, totalDiscount = 0;

    public CustomerCart(Customer c, CustomerFrame p) {
        currentUser = c;
        parent = p;
        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));

        readProductsFromFile();

        JLabel nameLabel = new JLabel("Product name", 0);
        nameLabel.setBounds(10, 20, 250, 30);
        nameLabel.setFont(currentUser.theme.main.font);
        nameLabel.setForeground(currentUser.theme.main.fontColor);
        nameLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        Info.add(nameLabel);

        JLabel priceLabel = new JLabel("Base Price", 0);
        priceLabel.setBounds(260, 20, 110, 30);
        priceLabel.setFont(currentUser.theme.main.font);
        priceLabel.setForeground(currentUser.theme.main.fontColor);
        priceLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        Info.add(priceLabel);

        JLabel topAmountLabel = new JLabel("Amount", 0);
        topAmountLabel.setBounds(370, 20, 90, 30);
        topAmountLabel.setFont(currentUser.theme.main.font);
        topAmountLabel.setForeground(currentUser.theme.main.fontColor);
        topAmountLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        Info.add(topAmountLabel);

        JLabel discountLabel = new JLabel("Discount", 0);
        discountLabel.setBounds(460, 20, 70, 30);
        discountLabel.setFont(currentUser.theme.main.font);
        discountLabel.setForeground(currentUser.theme.main.fontColor);
        discountLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        Info.add(discountLabel);

        JLabel totalPriceLabel = new JLabel("Total Price", 0);
        totalPriceLabel.setBounds(530, 20, 100, 30);
        totalPriceLabel.setFont(currentUser.theme.main.font);
        totalPriceLabel.setForeground(currentUser.theme.main.fontColor);
        totalPriceLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        Info.add(totalPriceLabel);

        JLabel calculatedTotalDiscountLabel = new JLabel("Total Discount:", 0);
        calculatedTotalDiscountLabel.setFont(currentUser.theme.main.font);
        calculatedTotalDiscountLabel.setBounds(410, 510, 120, 30);
        calculatedTotalDiscountLabel.setFont(currentUser.theme.main.font);
        calculatedTotalDiscountLabel.setForeground(currentUser.theme.main.fontColor);
        calculatedTotalDiscountLabel.setBorder(null);
        add(calculatedTotalDiscountLabel);

        calculatedTotalDiscount = new JLabel("0", 0);
        calculatedTotalDiscount.setFont(currentUser.theme.main.font);
        calculatedTotalDiscount.setBounds(530, 510, 130, 30);
        calculatedTotalDiscount.setFont(currentUser.theme.main.font);
        calculatedTotalDiscount.setForeground(currentUser.theme.main.fontColor);
        calculatedTotalDiscount.setBorder(null);
        add(calculatedTotalDiscount);

        JLabel calculatedTotalPriceLabel = new JLabel("Total Price:", 0);
        calculatedTotalPriceLabel.setFont(currentUser.theme.main.font);
        calculatedTotalPriceLabel.setBounds(410, 540, 120, 30);
        calculatedTotalPriceLabel.setFont(currentUser.theme.main.font);
        calculatedTotalPriceLabel.setForeground(currentUser.theme.main.fontColor);
        calculatedTotalPriceLabel.setBorder(null);
        add(calculatedTotalPriceLabel);

        calculatedTotalPrice = new JLabel("0", 0);
        calculatedTotalPrice.setFont(currentUser.theme.main.font);
        calculatedTotalPrice.setBounds(530, 540, 130, 30);
        calculatedTotalPrice.setFont(currentUser.theme.main.font);
        calculatedTotalPrice.setForeground(currentUser.theme.main.fontColor);
        calculatedTotalPrice.setBorder(null);
        add(calculatedTotalPrice);

        submit = new JButton();
        submit.setEnabled(false);
        submit.setBounds(30, 620, 640, 50);
        submit.setFont(currentUser.theme.main.font);
        submit.setForeground(currentUser.theme.main.fontColor);
        submit.setBackground(new Color(111, 207, 151));
        submit.setBorder(null);
        submit.addActionListener((e) -> buyProducts());
        add(submit);

        Count = currentUser.order.products.length;

        totalPriceLabels = new JLabel[Count];

        ImageIcon addImage = new ImageIcon(
                System.getProperty("user.dir") + "\\Images\\Icons\\Main\\" + currentUser.theme.main.icon + "Add.png");

        ImageIcon removeImage = new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Main\\"
                + currentUser.theme.main.icon + "Substract.png");

        ImageIcon deleteImage = new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Main\\"
                + currentUser.theme.main.icon + "Delete.png");

        Info.setPreferredSize(new Dimension(660, 60 + Count * 50));

        for (int i = 0; i < Count; i++) {
            nameLabel = new JLabel(currentUser.order.products[i].name, 0);
            nameLabel.setBounds(10, 60 + 50 * i, 250, 30);
            nameLabel.setBorder(null);
            Info.add(nameLabel);

            long price = currentUser.order.products[i].price;
            priceLabel = new JLabel(Long.toString(price), 0);
            priceLabel.setBounds(260, 60 + 50 * i, 110, 30);
            priceLabel.setBorder(null);
            Info.add(priceLabel);

            int amount = currentUser.order.count[i];
            JLabel amountLabel = new JLabel(Integer.toString(amount), 0);
            amountLabel.setBounds(400, 60 + 50 * i, 30, 30);
            amountLabel.setBorder(null);
            Info.add(amountLabel);

            JButton removeButton = new JButton();
            removeButton.setIcon(removeImage);
            removeButton.setBounds(370, 60 + 50 * i, 30, 30);
            removeButton.setBorder(null);
            removeButton.setBackground(null);
            Info.add(removeButton);

            JButton addButton = new JButton();
            addButton.setIcon(addImage);
            addButton.setBounds(430, 60 + 50 * i, 30, 30);
            addButton.setBorder(null);
            addButton.setBackground(null);
            Info.add(addButton);

            checkAvailability(addButton, removeButton);
            removeButton.addActionListener((e) -> removeFromProduct(removeButton, amountLabel, addButton));
            addButton.addActionListener((e) -> addToProduct(addButton, amountLabel, removeButton));

            int discount = currentUser.order.products[i].discount;
            discountLabel = new JLabel(discount + " %", 0);
            discountLabel.setBounds(460, 60 + 50 * i, 70, 30);
            discountLabel.setBorder(null);
            Info.add(discountLabel);

            long totalPrice = amount * price * (100 - discount) / 100;
            totalPriceLabels[i] = new JLabel(Long.toString(totalPrice), 0);
            totalPriceLabels[i].setBounds(530, 60 + 50 * i, 100, 30);
            totalPriceLabels[i].setBorder(null);
            Info.add(totalPriceLabels[i]);

            JButton deleteButton = new JButton();
            deleteButton.setIcon(deleteImage);
            deleteButton.setBounds(630, 60 + 50 * i, 30, 30);
            deleteButton.setBorder(null);
            deleteButton.setBackground(null);
            deleteButton.addActionListener((e) -> deleteProduct(deleteButton));
            Info.add(deleteButton);
        }

        updatePrice();

        setLayout(null);
        Info.setBackground(currentUser.theme.main.background);

        JScrollPane PanelScroll = new JScrollPane(Info);
        PanelScroll.setBorder(null);
        PanelScroll.setBounds(10, 10, 680, 500);
        PanelScroll.getVerticalScrollBar().setBackground(currentUser.theme.main.background);
        PanelScroll.getVerticalScrollBar().setBorder(null);
        PanelScroll.getVerticalScrollBar().setUnitIncrement(10);
        PanelScroll.setBackground(currentUser.theme.main.background);
        PanelScroll.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));

        add(PanelScroll);

        setBackground(currentUser.theme.main.background);
        setVisible(true);
    }

    public void deleteProduct(JButton deleteButton) {
        int index = (deleteButton.getY() - 60) / 50;
        Product currentProduct = currentUser.order.products[index];
        long amount = currentUser.order.count[index];

        allProducts[currentProduct.index].amount += amount;
        writeProductsToFile();

        Count = currentUser.order.products.length;

        Order temp = currentUser.order;
        currentUser.order = new Order();
        currentUser.order.status = Order.IN_PROGRESS;
        currentUser.order.products = new Product[Count - 1];
        currentUser.order.count = new int[Count - 1];

        for (int i = 0; i < index; i++) {
            currentUser.order.products[i] = temp.products[i];
            currentUser.order.count[i] = temp.count[i];
        }
        for (int i = index + 1; i < Count; i++) {
            currentUser.order.products[i - 1] = temp.products[i];
            currentUser.order.count[i - 1] = temp.count[i];
        }

        //updateCurrentUser();
        new CustomerWriter(currentUser);
        writeProductsToFile();
        parent.addPanel(new CustomerCart(currentUser, parent));
    }

    public void addToProduct(JButton addButton, JLabel l, JButton removeButton) {
        int index = (addButton.getY() - 60) / 50;
        Product p = currentUser.order.products[index];
        currentUser.order.count[index] += 1;
        allProducts[p.index].amount -= 1;
        l.setText(Integer.toString(currentUser.order.count[index]));

        //updateCurrentUser();
        new CustomerWriter(currentUser);

        checkAvailability(addButton, removeButton);
        updatePrice();
    }

    public void removeFromProduct(JButton removeButton, JLabel l, JButton addButton) {
        int index = (removeButton.getY() - 60) / 50;
        Product p = currentUser.order.products[index];
        currentUser.order.count[index] -= 1;
        allProducts[p.index].amount += 1;
        l.setText(Integer.toString(currentUser.order.count[index]));

        //updateCurrentUser();

        checkAvailability(addButton, removeButton);
        updatePrice();
    }

    public void checkAvailability(JButton addButton, JButton removeButton) {
        int index = (addButton.getY() - 60) / 50;
        Product currentProduct = currentUser.order.products[index];

        if (allProducts[currentProduct.index].amount > 0) {
            addButton.setEnabled(true);
        } else {
            addButton.setEnabled(false);
        }

        if (currentUser.order.count[index] <= 1) {
            removeButton.setEnabled(false);
        } else {
            removeButton.setEnabled(true);
        }

        writeProductsToFile();
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

    public void updatePrice() {
        total = 0;
        totalDiscount = 0;
        Count = currentUser.order.products.length;

        for (int i = 0; i < Count; i++) {
            long price = currentUser.order.products[i].price;
            int amount = currentUser.order.count[i];
            int discount = currentUser.order.products[i].discount;
            long totalPrice = amount * price * (100 - discount) / 100;

            totalDiscount += amount * price * discount / 100;

            Info.getComponent(i * 8 + 6).setBackground(Color.BLUE);
            Info.revalidate();
            Info.repaint();

            totalPriceLabels[i].setText(Long.toString(totalPrice));

            total += totalPrice;
        }

        if ((totalDiscount + total) > 0) {
            calculatedTotalDiscount.setText(Long.toString(totalDiscount) + " ("
                    + Long.toString(totalDiscount * 100 / (totalDiscount + total)) + "%)");
        } else {
            calculatedTotalDiscount.setText(Long.toString(totalDiscount) + " (0%)");
        }

        calculatedTotalPrice.setText(Long.toString(total));

        submit.setText("Purchase " + Long.toString(total) + " Rials");
        submit.setEnabled(false);
        if (total > currentUser.balance) {
            error = new JLabel("Low account balance (" + Long.toString(currentUser.balance) + ")");
            error.setBounds(30, 670, 640, 20);
            error.setForeground(Color.RED);
            error.setVisible(true);
            add(error);
        } else if (Count == 0) {
            error = new JLabel("Cart is empty.");
            error.setBounds(30, 670, 640, 20);
            error.setForeground(Color.RED);
            error.setVisible(true);
            add(error);
        } else {
            submit.setEnabled(true);
            error.setVisible(false);
        }
    }

    public void buyProducts() {
        new InvoiceCreator(currentUser.order, totalDiscount, total);

        JOptionPane.showMessageDialog(this, "Purchase Successful", "Success", 1);

        currentUser.balance -= total;
        currentUser.order.status = Order.RECIVED;

        Order[] temp = currentUser.pastOrders;

        currentUser.pastOrders = new Order[temp.length + 1];
        currentUser.pastOrders[0] = currentUser.order;

        for (int i = 0; i < temp.length; i++) {
            currentUser.pastOrders[i + 1] = temp[i];
        }

        currentUser.order = new Order();
        // updateCurrentUser();
        new CustomerWriter(currentUser);
        parent.UpdateBalance();
        parent.addPanel(new CustomerCart(currentUser, parent));
    }
}
