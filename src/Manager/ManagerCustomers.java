package Manager;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import General.*;
import java.io.*;
import Customer.*;

public class ManagerCustomers extends JPanel {
    private static final long serialVersionUID = 5272739775090170034L;

    JPanel Info;
    int Count;
    Customer[] allCustomers;
    User currentUser;
    ManagerFrame parent;

    public ManagerCustomers(User u, ManagerFrame p) {
        parent = p;
        currentUser = u;
        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));
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

    private void showData() {
        ImageIcon deleteIcon = new CustomIcon(currentUser.theme.main.icon + "Delete", 28, 28);
        ImageIcon editIcon = new CustomIcon(currentUser.theme.main.icon + "Edit", 28, 28);
        ImageIcon cartIcon = new CustomIcon(currentUser.theme.main.icon + "Cart", 28, 28);
        ImageIcon historyIcon = new CustomIcon(currentUser.theme.main.icon + "History", 28, 28);

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
        editPanel.setLayout(null);
        editPanel.setSize(3 * margin + 2 * w, 7 * margin + 6 * h);

        JLabel nameLabel = new JLabel("Name:", 4);
        nameLabel.setBounds(margin, margin, w, h);
        editPanel.add(nameLabel);

        JLabel lastNameLabel = new JLabel("Last Name:", 4);
        lastNameLabel.setBounds(margin, 2 * margin + h, w, h);
        editPanel.add(lastNameLabel);

        JLabel usernameLabel = new JLabel("Username:", 4);
        usernameLabel.setBounds(margin, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameLabel);

        JLabel addressLabel = new JLabel("Address:", 4);
        addressLabel.setBounds(margin, 4 * margin + 3 * h, w, h);
        editPanel.add(addressLabel);

        JLabel phoneLabel = new JLabel("Phone Number:", 4);
        phoneLabel.setBounds(margin, 5 * margin + 4 * h + 30, w, h);
        editPanel.add(phoneLabel);

        JTextField nameField = new JTextField(allCustomers[index].name, 4);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextField lastNameField = new JTextField(allCustomers[index].lastName, 4);
        lastNameField.setBounds(2 * margin + w, 2 * margin + h, w, h);
        editPanel.add(lastNameField);

        JTextField usernameField = new JTextField(allCustomers[index].username, 4);
        usernameField.setBounds(2 * margin + w, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameField);

        JTextArea addressField = new JTextArea(allCustomers[index].address);
        addressField.setBounds(2 * margin + w, 4 * margin + 3 * h, w, 2 * h);
        addressField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        addressField.setLineWrap(true);
        editPanel.add(addressField);

        JTextField phoneField = new JTextField(allCustomers[index].phoneNumber, 4);
        phoneField.setBounds(2 * margin + w, 5 * margin + 4 * h + 30, w, h);
        editPanel.add(phoneField);

        JButton save = new JButton("Save");
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
        cancel.setBounds(2 * margin + w, 6 * margin + 5 * h + 30, w, h);
        cancel.addActionListener((e) -> {
            dialog.dispose();
        });
        editPanel.add(cancel);
        editPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        dialog.add(editPanel);
        dialog.setUndecorated(true);
        dialog.setSize(3 * margin + 2 * w, 7 * margin + 7 * h);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    private void showCart(JButton b) {
        int index = (b.getY() - 5) / 40;
        showOrder(allCustomers[index].order);
    }

    private void ShowOrderData(Customer c, JButton b) {
        int index = (b.getY() - 20) / 50;
        showOrder(c.pastOrders[index]);
    }

    private void showOrder(Order o) {
        try {
            int length = o.products.length + 2;
            long totalPrice = 0;
            CustomScrollDialog dialog = new CustomScrollDialog(length);

            JLabel productLabel = new JLabel("Product", 0);
            productLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.gray));
            dialog.addLabel(productLabel, 0, 0);

            JLabel amountLabel = new JLabel("Amount", 0);
            amountLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.gray));
            dialog.addLabel(amountLabel, 0, 1);

            JLabel priceLabel = new JLabel("Price", 0);
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
            empty.setBorder(new MatteBorder(1, 0, 0, 0, Color.gray));
            dialog.addLabel(empty, length - 1, 0);

            JLabel tpl = new JLabel("Total price: ", 0);
            tpl.setBorder(new MatteBorder(1, 0, 0, 0, Color.gray));
            dialog.addLabel(tpl, length - 1, 1);

            JLabel tp = new JLabel(Long.toString(totalPrice), 0);
            tp.setBorder(new MatteBorder(1, 0, 0, 0, Color.gray));
            dialog.addLabel(tp, length - 1, 2);

        } catch (NullPointerException n) {
            System.out.println("null");
            CustomScrollDialog dialog = new CustomScrollDialog(1);
            dialog.addLabel(new JLabel("Cart is empty.", 0), 0, 1);
        }
    }

    public void ShowHistory(JButton b) {
        int index = (b.getY() - 5) / 40;
        CustomScrollDialog dialog = new CustomScrollDialog(allCustomers[index].pastOrders.length);

        for (int i = 0; i < allCustomers[index].pastOrders.length; i++) {
            JButton jb = new JButton("Order #" + (i + 1) + " - " + allCustomers[index].pastOrders[i].status);
            dialog.addButton(jb);
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

    private void readData() {
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

    private void writeData(int remove) {
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
        parent.addPanel(new ManagerCustomers(currentUser, parent));
    }
}
