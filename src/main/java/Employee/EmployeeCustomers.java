package Employee;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import General.*;
import java.io.*;
import Customer.*;

public class EmployeeCustomers extends JPanel {
    private static final long serialVersionUID = 5272739775090170034L;

    JPanel Info;
    int Count;
    Customer[] allCustomers;
    Employee currentUser;
    EmployeeFrame parent;

    public EmployeeCustomers(Employee u, EmployeeFrame p) {
        parent = p;
        currentUser = u;
        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(currentUser.theme.main.background);
        Info.setPreferredSize(new Dimension(660, Count * 40));

        setLayout(null);
        Info.setBackground(currentUser.theme.main.background);

        JScrollPane PanelScroll = new JScrollPane(Info);
        PanelScroll.setBorder(null);
        PanelScroll.setBounds(10, 10, 680, 680);
        PanelScroll.getVerticalScrollBar().setBackground(currentUser.theme.main.background);
        PanelScroll.getVerticalScrollBar().setBorder(null);
        PanelScroll.getVerticalScrollBar().setUnitIncrement(10);
        PanelScroll.setBackground(currentUser.theme.main.background);

        add(PanelScroll);

        showData();

        setBackground(currentUser.theme.main.background);
        setVisible(true);
    }

    public void showData() {
        ImageIcon deleteIcon = new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Main\\"
                + currentUser.theme.main.icon + "Delete.png");
        ImageIcon editIcon = new ImageIcon(
                System.getProperty("user.dir") + "\\Images\\Icons\\Main\\" + currentUser.theme.main.icon + "Edit.png");
        ImageIcon cartIcon = new ImageIcon(
                System.getProperty("user.dir") + "\\Images\\Icons\\Main\\" + currentUser.theme.main.icon + "Cart.png");
        ImageIcon historyIcon = new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Main\\"
                + currentUser.theme.main.icon + "Order History.png");

        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));

            allCustomers = (Customer[]) reader.readObject();

            Count = allCustomers.length;
            Info.setPreferredSize(new Dimension(660, Count * 40));

            reader.close();

            for (int i = 0; i < Count; i++) {
                int m = 660 - 45;
                JButton Delete = new JButton();
                Delete.setBounds(m, i * 40 + 5, 30, 30);
                Delete.setIcon(deleteIcon);
                Delete.setBackground(null);
                Delete.setBorder(null);
                m -= 40;
                Delete.addActionListener((e) -> {
                    sure(Delete);
                });
                Info.add(Delete);

                JButton Edit = new JButton();
                Edit.setBounds(m, i * 40 + 5, 30, 30);
                Edit.setIcon(editIcon);
                Edit.setBackground(null);
                Edit.setBorder(null);
                m -= 40;
                Edit.addActionListener((e) -> {
                    edit(Edit);
                });
                Info.add(Edit);

                JButton Cart = new JButton();
                Cart.setBounds(m, i * 40 + 5, 30, 30);
                Cart.setIcon(cartIcon);
                Cart.setBackground(null);
                Cart.setBorder(null);
                m -= 40;
                Cart.addActionListener((e) -> showCart(Cart));
                Info.add(Cart);

                JButton History = new JButton();
                History.setBounds(m, i * 40 + 5, 30, 30);
                History.setIcon(historyIcon);
                History.setBackground(null);
                History.setBorder(null);
                m -= 15;
                History.addActionListener((e) -> {
                    ShowHistory(History);
                });
                Info.add(History);

                JLabel Costumer = new JLabel(allCustomers[i].lastName + " " + allCustomers[i].name);
                Costumer.setFont(currentUser.theme.main.font);
                Costumer.setForeground(currentUser.theme.main.fontColor);
                Costumer.setBounds(5, i * 40 + 5, m, 30);
                Info.add(Costumer);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void edit(JButton b) {
        int index = (b.getY() - 5) / 40;

        int h = 30, w = 200, margin = 20;

        JDialog dialog = new JDialog(parent, "Edit Information");

        JPanel editPanel = new JPanel();
        editPanel.setBackground(currentUser.theme.dialog.background);
        editPanel.setForeground(currentUser.theme.dialog.fontColor);
        editPanel.setFont(currentUser.theme.dialog.font);
        editPanel.setLayout(null);
        editPanel.setSize(3 * margin + 2 * w, 7 * margin + 6 * h);

        JLabel nameLabel = new JLabel("Name:", 4);
        nameLabel.setBackground(currentUser.theme.dialog.background);
        nameLabel.setForeground(currentUser.theme.dialog.fontColor);
        nameLabel.setFont(currentUser.theme.dialog.font);
        nameLabel.setBounds(margin, margin, w, h);
        editPanel.add(nameLabel);

        JLabel lastNameLabel = new JLabel("Last Name:", 4);
        lastNameLabel.setBackground(currentUser.theme.dialog.background);
        lastNameLabel.setForeground(currentUser.theme.dialog.fontColor);
        lastNameLabel.setFont(currentUser.theme.dialog.font);
        lastNameLabel.setBounds(margin, 2 * margin + h, w, h);
        editPanel.add(lastNameLabel);

        JLabel usernameLabel = new JLabel("Username:", 4);
        usernameLabel.setBackground(currentUser.theme.dialog.background);
        usernameLabel.setForeground(currentUser.theme.dialog.fontColor);
        usernameLabel.setFont(currentUser.theme.dialog.font);
        usernameLabel.setBounds(margin, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameLabel);

        JLabel addressLabel = new JLabel("Address:", 4);
        addressLabel.setBackground(currentUser.theme.dialog.background);
        addressLabel.setForeground(currentUser.theme.dialog.fontColor);
        addressLabel.setFont(currentUser.theme.dialog.font);
        addressLabel.setBounds(margin, 4 * margin + 3 * h, w, h);
        editPanel.add(addressLabel);

        JLabel phoneLabel = new JLabel("Phone Number:", 4);
        phoneLabel.setBackground(currentUser.theme.dialog.background);
        phoneLabel.setForeground(currentUser.theme.dialog.fontColor);
        phoneLabel.setFont(currentUser.theme.dialog.font);
        phoneLabel.setBounds(margin, 5 * margin + 4 * h + 30, w, h);
        editPanel.add(phoneLabel);

        JTextField nameField = new JTextField(allCustomers[index].name, 4);
        nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        nameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        nameField.setBackground(currentUser.theme.dialog.buttonBackground);
        nameField.setForeground(currentUser.theme.dialog.fontColor);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextField lastNameField = new JTextField(allCustomers[index].lastName, 4);
        lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        lastNameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        lastNameField.setBackground(currentUser.theme.dialog.buttonBackground);
        lastNameField.setForeground(currentUser.theme.dialog.fontColor);
        lastNameField.setBounds(2 * margin + w, 2 * margin + h, w, h);
        editPanel.add(lastNameField);

        JTextField usernameField = new JTextField(allCustomers[index].username, 4);
        usernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        usernameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        usernameField.setBackground(currentUser.theme.dialog.buttonBackground);
        usernameField.setForeground(currentUser.theme.dialog.fontColor);
        usernameField.setBounds(2 * margin + w, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameField);

        JTextArea addressField = new JTextArea(allCustomers[index].address);
        addressField.setBackground(currentUser.theme.dialog.textFieldBackground);
        addressField.setBackground(currentUser.theme.dialog.buttonBackground);
        addressField.setForeground(currentUser.theme.dialog.fontColor);
        addressField.setBounds(2 * margin + w, 4 * margin + 3 * h, w, 2 * h);
        addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        addressField.setLineWrap(true);
        editPanel.add(addressField);

        JTextField phoneField = new JTextField(allCustomers[index].phoneNumber, 4);
        phoneField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        phoneField.setBackground(currentUser.theme.dialog.textFieldBackground);
        phoneField.setBackground(currentUser.theme.dialog.buttonBackground);
        phoneField.setForeground(currentUser.theme.dialog.fontColor);
        phoneField.setBounds(2 * margin + w, 5 * margin + 4 * h + 30, w, h);
        editPanel.add(phoneField);

        JButton save = new JButton("Save");
        save.setBackground(currentUser.theme.dialog.buttonBackground);
        save.setForeground(currentUser.theme.dialog.fontColor);
        save.setFont(currentUser.theme.dialog.font);
        save.setBounds(margin, 6 * margin + 5 * h + 30, w, h);
        save.addActionListener((e) -> {

            readData();

            allCustomers[index].name = nameField.getText();
            allCustomers[index].lastName = lastNameField.getText();
            allCustomers[index].username = usernameField.getText();
            allCustomers[index].address = addressField.getText();
            allCustomers[index].phoneNumber = phoneField.getText();

            try {
                ObjectOutputStream writer = new ObjectOutputStream(
                        new FileOutputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));
                writer.writeObject(allCustomers);
                writer.close();
            } catch (Exception E) {

            }

            JOptionPane.showMessageDialog(dialog, "Customer information updated successfully.", "Customer Updated", 1);

            dialog.dispose();
            reloadPage();
        });
        editPanel.add(save);

        JButton cancel = new JButton("Cancel");
        cancel.setBackground(currentUser.theme.dialog.buttonBackground);
        cancel.setForeground(currentUser.theme.dialog.fontColor);
        cancel.setFont(currentUser.theme.dialog.font);
        cancel.setBounds(2 * margin + w, 6 * margin + 5 * h + 30, w, h);
        cancel.addActionListener((e) -> {
            dialog.dispose();
        });
        editPanel.add(cancel);
        editPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        dialog.add(editPanel);
        dialog.setBackground(currentUser.theme.main.background);
        dialog.setUndecorated(true);
        dialog.setSize(3 * margin + 2 * w, 7 * margin + 7 * h);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    public void showCart(JButton b) {
        int index = (b.getY() - 5) / 40;
        showOrder(allCustomers[index].order);
    }

    public void ShowOrderData(Customer c, JButton b) {
        int index = (b.getY() - 20) / 50;
        showOrder(c.pastOrders[index]);
    }

    public void showOrder(Order o) {
        try {
            int length = o.products.length + 2;
            long totalPrice = 0;
            CustomScrollDialog dialog = new CustomScrollDialog(length, currentUser.theme);

            if (length == 2) {
                dialog.addLabel(new JLabel("Cart is empty.", 0), 0, 1);
                return;
            }

            JLabel productLabel = new JLabel("Product", 0);
            productLabel.setBackground(currentUser.theme.dialog.background);
            productLabel.setForeground(currentUser.theme.dialog.fontColor);
            productLabel.setFont(currentUser.theme.dialog.font);
            productLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.gray));
            dialog.addLabel(productLabel, 0, 0);

            JLabel amountLabel = new JLabel("Amount", 0);
            amountLabel.setBackground(currentUser.theme.dialog.background);
            amountLabel.setForeground(currentUser.theme.dialog.fontColor);
            amountLabel.setFont(currentUser.theme.dialog.font);
            amountLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.gray));
            dialog.addLabel(amountLabel, 0, 1);

            JLabel priceLabel = new JLabel("Price", 0);
            priceLabel.setBackground(currentUser.theme.dialog.background);
            priceLabel.setForeground(currentUser.theme.dialog.fontColor);
            priceLabel.setFont(currentUser.theme.dialog.font);
            priceLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.gray));
            dialog.addLabel(priceLabel, 0, 2);

            for (int i = 0; i < length - 2; i++) {
                long p = o.products[i].price;
                int c = o.count[i];
                dialog.addLabel(new JLabel(o.products[i].name, 0), 1 + i, 0);
                dialog.addLabel(new JLabel(Integer.toString(c), 0), 1 + i, 1);
                if (o.products[i].discount > 0) {
                    int dis = 100 - o.products[i].discount;
                    dialog.addLabel(new JLabel(c + "*" + Long.toString(p) + "*" + dis + "%", 0), 1 + i, 2);
                    totalPrice += c * p * dis / 100;
                } else {
                    dialog.addLabel(new JLabel(c + "*" + Long.toString(p), 0), 1 + i, 2);
                    totalPrice += c * p;
                }
            }
            JLabel empty = new JLabel("", 0);
            empty.setBackground(currentUser.theme.dialog.background);
            empty.setForeground(currentUser.theme.dialog.fontColor);
            empty.setFont(currentUser.theme.dialog.font);
            empty.setBorder(new MatteBorder(1, 0, 0, 0, Color.gray));
            dialog.addLabel(empty, length - 1, 0);

            JLabel tpl = new JLabel("Total price: ", 0);
            tpl.setBackground(currentUser.theme.dialog.background);
            tpl.setForeground(currentUser.theme.dialog.fontColor);
            tpl.setFont(currentUser.theme.dialog.font);
            tpl.setBorder(new MatteBorder(1, 0, 0, 0, Color.gray));
            dialog.addLabel(tpl, length - 1, 1);

            JLabel tp = new JLabel(Long.toString(totalPrice), 0);
            tp.setBackground(currentUser.theme.dialog.background);
            tp.setForeground(currentUser.theme.dialog.fontColor);
            tp.setFont(currentUser.theme.dialog.font);
            tp.setBorder(new MatteBorder(1, 0, 0, 0, Color.gray));
            dialog.addLabel(tp, length - 1, 2);

        } catch (NullPointerException n) {
            CustomScrollDialog dialog = new CustomScrollDialog(1, currentUser.theme);
            dialog.addLabel(new JLabel("Cart is empty.", 0), 0, 1);
        }
    }

    public void ShowHistory(JButton b) {
        int index = (b.getY() - 5) / 40;
        CustomScrollDialog dialog = new CustomScrollDialog(allCustomers[index].pastOrders.length, currentUser.theme);

        for (int i = 0; i < allCustomers[index].pastOrders.length; i++) {
            JButton jb = new JButton("Order #" + (i + 1) + " - " + allCustomers[index].pastOrders[i].status);
            jb.setForeground(currentUser.theme.dialog.fontColor);
            jb.setFont(currentUser.theme.dialog.font);
            dialog.addButton(jb);
            jb.setBackground(currentUser.theme.dialog.buttonBackground);
            jb.addActionListener((e) -> ShowOrderData(allCustomers[index], jb));
        }
    }

    public void sure(JButton b) {
        int index = (b.getY() - 5) / 40;

        String data = "\nName: " + allCustomers[index].name + "\nLast Name: " + allCustomers[index].lastName
                + "\nPhone Number: " + allCustomers[index].phoneNumber + "\nAddress: " + allCustomers[index].address;
        int ans = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete customer with these information?" + data, "Are you sure",
                JOptionPane.YES_NO_OPTION);

        if (ans == 0) {
            writeData(index);
            JOptionPane.showMessageDialog(this, "Customer removed successfully.", "Customer Rmoved", 1);
            reloadPage();
        }
    }

    public void readData() {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));

            allCustomers = (Customer[]) reader.readObject();
            Count = allCustomers.length;
            reader.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void writeData(int remove) {
        try {
            ObjectOutputStream reader = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));

            Customer[] temp = new Customer[Count - 1];

            for (int i = 0; i < remove; i++) {
                temp[i] = allCustomers[i];
            }

            for (int i = remove + 1; i < Count; i++) {
                temp[i - 1] = allCustomers[i];
            }

            reader.writeObject(temp);
            reader.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void reloadPage() {
        parent.addPanel(new EmployeeCustomers(currentUser, parent));
    }
}
