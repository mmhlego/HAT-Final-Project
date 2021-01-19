package Manager;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import Employee.Employee;
import General.*;

public class ManagerEmployees extends JPanel {
    JPanel Info;
    int Count = 0;

    Manager currentUser;
    Employee[] allEmployee;
    ManagerFrame parent;

    public ManagerEmployees(Manager man, ManagerFrame p) {
        currentUser = man;
        parent = p;

        setLayout(null);

        showData();

        JButton addNew = new JButton("Add New Employee");
        addNew.setBounds(10, 640, 680, 50);
        addNew.setBackground(new Color(111, 207, 151));
        addNew.setBorder(null);
        addNew.addActionListener((e) -> {
            addNew();
        });
        add(addNew);

        setBackground(currentUser.theme.background);
        setVisible(true);
    }

    private void readData() {
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream("data\\Employees.dat"));

            allEmployee = (Employee[]) reader.readObject();
            Count = allEmployee.length;

            reader.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void showData() {
        readData();

        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));
        Info.setPreferredSize(new Dimension(660, Count * 40));

        ImageIcon deleteIcon = new CustomIcon(currentUser.theme.icon + "Delete", 28, 28);
        ImageIcon editIcon = new CustomIcon(currentUser.theme.icon + "Edit", 28, 28);

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
            m -= 15;
            Edit.addActionListener((e) -> {
                edit(Edit);
            });
            Info.add(Edit);

            JLabel Employee = new JLabel(allEmployee[i].lastName + " " + allEmployee[i].name);
            Employee.setFont(currentUser.theme.font);
            Employee.setForeground(currentUser.theme.fontColor);
            Employee.setBounds(5, i * 40 + 5, m, 30);
            Info.add(Employee);
        }

        Info.setBackground(currentUser.theme.background);

        JScrollPane PanelScroll = new JScrollPane(Info);
        PanelScroll.setBounds(10, 10, 680, 610);
        PanelScroll.setBorder(null);
        PanelScroll.getVerticalScrollBar().setBackground(currentUser.theme.background);
        PanelScroll.getVerticalScrollBar().setBorder(null);
        PanelScroll.getVerticalScrollBar().setUnitIncrement(10);
        PanelScroll.setBackground(currentUser.theme.background);

        add(PanelScroll);

        revalidate();
        repaint();
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

        JLabel IDlLabel = new JLabel("ID:", 4);
        IDlLabel.setBounds(margin, 4 * margin + 3 * h, w, h);
        editPanel.add(IDlLabel);

        JLabel phoneLabel = new JLabel("Phone Number:", 4);
        phoneLabel.setBounds(margin, 5 * margin + 4 * h, w, h);
        editPanel.add(phoneLabel);

        JTextField nameField = new JTextField(allEmployee[index].name, 4);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextField lastNameField = new JTextField(allEmployee[index].lastName, 4);
        lastNameField.setBounds(2 * margin + w, 2 * margin + h, w, h);
        editPanel.add(lastNameField);

        JTextField usernameField = new JTextField(allEmployee[index].username, 4);
        usernameField.setBounds(2 * margin + w, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameField);

        JTextField IDField = new JTextField(allEmployee[index].ID, 4);
        IDField.setBounds(2 * margin + w, 4 * margin + 3 * h, w, h);
        editPanel.add(IDField);

        JTextField phoneField = new JTextField(allEmployee[index].phoneNumber, 4);
        phoneField.setBounds(2 * margin + w, 5 * margin + 4 * h, w, h);
        editPanel.add(phoneField);

        JButton save = new JButton("Save");
        save.setBounds(margin, 6 * margin + 5 * h, w, h);
        save.addActionListener((e) -> {

            readData();

            allEmployee[index].name = nameField.getText();
            allEmployee[index].lastName = lastNameField.getText();
            allEmployee[index].username = usernameField.getText();
            allEmployee[index].ID = IDField.getText();
            allEmployee[index].phoneNumber = phoneField.getText();

            try {
                ObjectOutputStream reader = new ObjectOutputStream(new FileOutputStream("data\\Employees.dat"));
                reader.writeObject(allEmployee);
                reader.close();
            } catch (Exception E) {

            }

            JOptionPane.showMessageDialog(dialog, "Employee information updated successfully.", "Employee Updated", 1);

            dialog.dispose();
            reloadPage();
        });
        editPanel.add(save);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(2 * margin + w, 6 * margin + 5 * h, w, h);
        cancel.addActionListener((e) -> {
            dialog.dispose();
        });
        editPanel.add(cancel);

        dialog.add(editPanel);
        dialog.setBounds(500, 200, 3 * margin + 2 * w + 13, 7 * margin + 7 * h);
        dialog.setResizable(false);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    public void addNew() {
        int h = 30, w = 200, margin = 20;

        JDialog dialog = new JDialog(parent, "Edit Information");

        JPanel editPanel = new JPanel();
        editPanel.setLayout(null);
        editPanel.setSize(3 * margin + 2 * w, 8 * margin + 7 * h);

        JLabel nameLabel = new JLabel("Name:", 4);
        nameLabel.setBounds(margin, margin, w, h);
        editPanel.add(nameLabel);

        JLabel lastNameLabel = new JLabel("Last Name:", 4);
        lastNameLabel.setBounds(margin, 2 * margin + h, w, h);
        editPanel.add(lastNameLabel);

        JLabel usernameLabel = new JLabel("Username:", 4);
        usernameLabel.setBounds(margin, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password:", 4);
        passwordLabel.setBounds(margin, 4 * margin + 3 * h, w, h);
        editPanel.add(passwordLabel);

        JLabel IDlLabel = new JLabel("ID:", 4);
        IDlLabel.setBounds(margin, 5 * margin + 4 * h, w, h);
        editPanel.add(IDlLabel);

        JLabel phoneLabel = new JLabel("Phone Number:", 4);
        phoneLabel.setBounds(margin, 6 * margin + 5 * h, w, h);
        editPanel.add(phoneLabel);

        JTextField nameField = new JTextField("", 4);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextField lastNameField = new JTextField("", 4);
        lastNameField.setBounds(2 * margin + w, 2 * margin + h, w, h);
        editPanel.add(lastNameField);

        JTextField usernameField = new JTextField("", 4);
        usernameField.setBounds(2 * margin + w, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameField);

        JTextField passwordField = new JTextField("", 4);
        passwordField.setBounds(2 * margin + w, 4 * margin + 3 * h, w, h);
        editPanel.add(passwordField);

        JTextField IDField = new JTextField("", 4);
        IDField.setBounds(2 * margin + w, 5 * margin + 4 * h, w, h);
        editPanel.add(IDField);

        JTextField phoneField = new JTextField("", 4);
        phoneField.setBounds(2 * margin + w, 6 * margin + 5 * h, w, h);
        editPanel.add(phoneField);

        JButton save = new JButton("Save");
        save.setBounds(margin, 7 * margin + 6 * h, w, h);
        save.addActionListener((e) -> {

            readData();

            addToFile(new Employee(nameField.getText(), lastNameField.getText(), usernameField.getText(),
                    passwordField.getText(), phoneField.getText(), IDField.getText()));

            dialog.dispose();
            reloadPage();
        });
        editPanel.add(save);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(2 * margin + w, 7 * margin + 6 * h, w, h);
        cancel.addActionListener((e) -> {
            dialog.dispose();
        });
        editPanel.add(cancel);

        dialog.add(editPanel);
        dialog.setBounds(500, 200, 3 * margin + 2 * w + 13, 8 * margin + 8 * h);
        dialog.setResizable(false);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    public void sure(JButton b) {
        int index = (b.getY() - 5) / 40;

        String data = "\nName: " + allEmployee[index].name + "\nLast Name: " + allEmployee[index].lastName + "\nID: "
                + allEmployee[index].ID + "\nPhone number: " + allEmployee[index].phoneNumber;
        int ans = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete employee with these information?" + data, "Are you sure",
                JOptionPane.YES_NO_OPTION);

        if (ans == 0) {
            writeData(index);

            JOptionPane.showMessageDialog(this, "Employee removed successfully.", "Employee Rmoved", 1);

            reloadPage();
        }
    }

    public void addToFile(Employee em) {
        try {
            ObjectOutputStream reader = new ObjectOutputStream(new FileOutputStream("data\\Employees.dat"));

            Employee[] temp = new Employee[Count + 1];

            for (int i = 0; i < Count; i++) {
                System.out.print(i);
                temp[i] = allEmployee[i];
            }

            temp[Count] = em;

            reader.writeObject(temp);

            reader.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void writeData(int remove) {
        try {
            ObjectOutputStream reader = new ObjectOutputStream(new FileOutputStream("data\\Employees.dat"));

            Employee[] temp = new Employee[Count - 1];

            for (int i = 0; i < remove; i++) {
                System.out.print(i);
                temp[i] = allEmployee[i];
            }

            for (int i = remove + 1; i < Count; i++) {
                temp[i - 1] = allEmployee[i];
            }

            reader.writeObject(temp);

            reader.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void reloadPage() {
        parent.addPanel(new ManagerEmployees(currentUser, parent));
    }

}
