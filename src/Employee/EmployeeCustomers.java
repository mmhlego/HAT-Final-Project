package Employee;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import Customer.*;
import General.*;

public class EmployeeCustomers extends JPanel {
    private static final long serialVersionUID = -8701518828823181704L;

    JPanel Info;
    int Count = 50;
    Customer[] allCustomers;
    Employee currentUser;
    EmployeeFrame parent;

    public EmployeeCustomers(Employee u, EmployeeFrame p) {
        parent = p;
        currentUser = u;
        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));
        Info.setPreferredSize(new Dimension(660, Count * 40));

        setLayout(null);

        JScrollPane PanelScroll = new JScrollPane(Info);
        PanelScroll.setBorder(null);
        PanelScroll.setBounds(10, 10, 680, 680);

        add(PanelScroll);

        showData();

        setVisible(true);
    }

    private void showData() {
        ImageIcon deleteIcon = new CustomIcon(currentUser.theme.main.icon + "Delete", 28, 28);
        ImageIcon editIcon = new CustomIcon(currentUser.theme.main.icon + "Edit", 28, 28);
        ImageIcon cartIcon = new CustomIcon(currentUser.theme.main.icon + "Cart", 28, 28);
        ImageIcon historyIcon = new CustomIcon(currentUser.theme.main.icon + "History", 28, 28);

        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream("data\\Customers.dat"));

            allCustomers = (Customer[]) reader.readObject();

            reader.close();

            Count = allCustomers.length;

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

                });
                Info.add(Edit);

                JButton Cart = new JButton();
                Cart.setBounds(m, i * 40 + 5, 30, 30);
                Cart.setIcon(cartIcon);
                Cart.setBackground(null);
                Cart.setBorder(null);
                m -= 40;
                Cart.addActionListener((e) -> {

                });
                Info.add(Cart);

                JButton History = new JButton();
                History.setBounds(m, i * 40 + 5, 30, 30);
                History.setIcon(historyIcon);
                History.setBackground(null);
                History.setBorder(null);
                m -= 15;
                History.addActionListener((e) -> {

                });
                Info.add(History);

                JLabel Costumer = new JLabel(allCustomers[i].lastName + " " + allCustomers[i].name);
                Costumer.setBounds(5, i * 40 + 5, m, 30);
                Info.add(Costumer);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
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

            JOptionPane.showMessageDialog(this, "Employee removed successfully.", "Customer Rmoved", 1);

            reloadPage();
        }
    }

    public void writeData(int remove) {
        try {
            ObjectOutputStream reader = new ObjectOutputStream(new FileOutputStream("data\\Customers.dat"));

            Customer[] temp = new Customer[Count - 1];

            for (int i = 0; i < remove; i++) {
                System.out.print(i);
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
