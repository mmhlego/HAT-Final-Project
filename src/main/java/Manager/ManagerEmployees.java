package Manager;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import Employee.*;

public class ManagerEmployees extends JPanel {
    private static final long serialVersionUID = -633045104537689790L;

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

        JButton addNew = new JButton(currentUser.language.employee.add);
        addNew.setBounds(10, 640, 680, 50);
        addNew.setBackground(currentUser.theme.submitColor);
        addNew.setForeground(currentUser.theme.main.fontColor);
        addNew.setFont(currentUser.theme.main.font);
        addNew.setBorder(null);
        addNew.addActionListener((e) -> {
            addNew();
        });
        add(addNew);

        setBackground(currentUser.theme.main.background);
        setVisible(true);
    }

    public void readData() {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Employees.dat"));

            allEmployee = (Employee[]) reader.readObject();
            Count = allEmployee.length;

            reader.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void showData() {
        readData();

        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));
        Info.setPreferredSize(new Dimension(660, Count * 40));

        ImageIcon deleteIcon = new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Main\\"
                + currentUser.theme.main.icon + "Delete.png");
        ImageIcon editIcon = new ImageIcon(
                System.getProperty("user.dir") + "\\Images\\Icons\\Main\\" + currentUser.theme.main.icon + "Edit.png");

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
            Employee.setFont(currentUser.theme.main.font);
            Employee.setForeground(currentUser.theme.main.fontColor);
            Employee.setBounds(5, i * 40 + 5, m, 30);
            Info.add(Employee);
        }

        Info.setBackground(currentUser.theme.main.background);

        JScrollPane PanelScroll = new JScrollPane(Info);
        PanelScroll.setBounds(10, 10, 680, 610);
        PanelScroll.setBorder(null);
        PanelScroll.getVerticalScrollBar().setBackground(currentUser.theme.main.background);
        PanelScroll.getVerticalScrollBar().setBorder(null);
        PanelScroll.getVerticalScrollBar().setUnitIncrement(10);
        PanelScroll.setBackground(currentUser.theme.main.background);

        add(PanelScroll);

        revalidate();
        repaint();
    }

    public void edit(JButton b) {
        int index = (b.getY() - 5) / 40;

        int h = 30, w = 200, margin = 20;

        JDialog dialog = new JDialog(parent, currentUser.language.employee.edit);

        JPanel editPanel = new JPanel();
        editPanel.setBackground(currentUser.theme.dialog.background);
        editPanel.setForeground(currentUser.theme.dialog.fontColor);
        editPanel.setFont(currentUser.theme.dialog.font);
        editPanel.setLayout(null);
        editPanel.setSize(3 * margin + 2 * w, 7 * margin + 6 * h);

        JLabel nameLabel = new JLabel(currentUser.language.employee.name, 4);
        nameLabel.setBackground(currentUser.theme.dialog.background);
        nameLabel.setForeground(currentUser.theme.dialog.fontColor);
        nameLabel.setFont(currentUser.theme.dialog.font);
        nameLabel.setBounds(margin, margin, w, h);
        editPanel.add(nameLabel);

        JLabel lastNameLabel = new JLabel(currentUser.language.employee.lastName, 4);
        lastNameLabel.setBackground(currentUser.theme.dialog.background);
        lastNameLabel.setForeground(currentUser.theme.dialog.fontColor);
        lastNameLabel.setFont(currentUser.theme.dialog.font);
        lastNameLabel.setBounds(margin, 2 * margin + h, w, h);
        editPanel.add(lastNameLabel);

        JLabel usernameLabel = new JLabel(currentUser.language.employee.userName, 4);
        usernameLabel.setBackground(currentUser.theme.dialog.background);
        usernameLabel.setForeground(currentUser.theme.dialog.fontColor);
        usernameLabel.setFont(currentUser.theme.dialog.font);
        usernameLabel.setBounds(margin, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameLabel);

        JLabel IDlLabel = new JLabel(currentUser.language.employee.ID, 4);
        IDlLabel.setBackground(currentUser.theme.dialog.background);
        IDlLabel.setForeground(currentUser.theme.dialog.fontColor);
        IDlLabel.setFont(currentUser.theme.dialog.font);
        IDlLabel.setBounds(margin, 4 * margin + 3 * h, w, h);
        editPanel.add(IDlLabel);

        JLabel phoneLabel = new JLabel(currentUser.language.employee.phone, 4);
        phoneLabel.setBackground(currentUser.theme.dialog.background);
        phoneLabel.setForeground(currentUser.theme.dialog.fontColor);
        phoneLabel.setFont(currentUser.theme.dialog.font);
        phoneLabel.setBounds(margin, 5 * margin + 4 * h, w, h);
        editPanel.add(phoneLabel);

        JTextField nameField = new JTextField(allEmployee[index].name, 4);
        nameField.setForeground(currentUser.theme.dialog.fontColor);
        nameField.setFont(currentUser.theme.dialog.font);
        nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        nameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextField lastNameField = new JTextField(allEmployee[index].lastName, 4);
        lastNameField.setForeground(currentUser.theme.dialog.fontColor);
        lastNameField.setFont(currentUser.theme.dialog.font);
        lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        lastNameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        lastNameField.setBounds(2 * margin + w, 2 * margin + h, w, h);
        editPanel.add(lastNameField);

        JTextField usernameField = new JTextField(allEmployee[index].username, 4);
        usernameField.setForeground(currentUser.theme.dialog.fontColor);
        usernameField.setFont(currentUser.theme.dialog.font);
        usernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        usernameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        usernameField.setBounds(2 * margin + w, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameField);

        JTextField IDField = new JTextField(allEmployee[index].ID, 4);
        IDField.setForeground(currentUser.theme.dialog.fontColor);
        IDField.setFont(currentUser.theme.dialog.font);
        IDField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        IDField.setBackground(currentUser.theme.dialog.textFieldBackground);
        IDField.setBounds(2 * margin + w, 4 * margin + 3 * h, w, h);
        editPanel.add(IDField);

        JTextField phoneField = new JTextField(allEmployee[index].phoneNumber, 4);
        phoneField.setForeground(currentUser.theme.dialog.fontColor);
        phoneField.setFont(currentUser.theme.dialog.font);
        phoneField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        phoneField.setBackground(currentUser.theme.dialog.textFieldBackground);
        phoneField.setBounds(2 * margin + w, 5 * margin + 4 * h, w, h);
        editPanel.add(phoneField);

        JButton save = new JButton(currentUser.language.employee.save);
        save.setForeground(currentUser.theme.dialog.fontColor);
        save.setFont(currentUser.theme.dialog.font);
        save.setBackground(currentUser.theme.dialog.buttonBackground);
        save.setBounds(margin, 6 * margin + 5 * h, w, h);
        save.addActionListener((e) -> {

            readData();

            allEmployee[index].name = nameField.getText();
            allEmployee[index].lastName = lastNameField.getText();
            allEmployee[index].username = usernameField.getText();
            allEmployee[index].ID = IDField.getText();
            allEmployee[index].phoneNumber = phoneField.getText();

            try {
                ObjectOutputStream reader = new ObjectOutputStream(
                        new FileOutputStream(System.getProperty("user.dir") + "\\data\\Employees.dat"));
                reader.writeObject(allEmployee);
                reader.close();
            } catch (Exception E) {

            }

            JOptionPane.showMessageDialog(dialog, currentUser.language.employee.updateDescription,
                    currentUser.language.employee.updateTitle, 1);

            dialog.dispose();
            reloadPage();
        });
        editPanel.add(save);

        JButton cancel = new JButton(currentUser.language.employee.cancel);
        cancel.setForeground(currentUser.theme.dialog.fontColor);
        cancel.setFont(currentUser.theme.dialog.font);
        cancel.setBackground(currentUser.theme.dialog.buttonBackground);
        cancel.setBounds(2 * margin + w, 6 * margin + 5 * h, w, h);
        cancel.addActionListener((e) -> {
            dialog.dispose();
        });
        editPanel.add(cancel);
        editPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        dialog.setUndecorated(true);
        dialog.add(editPanel);
        dialog.setSize(3 * margin + 2 * w, 7 * margin + 6 * h);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    public void addNew() {
        int h = 30, w = 200, margin = 20;

        JDialog dialog = new JDialog(parent, currentUser.language.employee.edit);

        JPanel editPanel = new JPanel();
        editPanel.setBackground(currentUser.theme.dialog.background);
        editPanel.setForeground(currentUser.theme.dialog.fontColor);
        editPanel.setFont(currentUser.theme.dialog.font);
        editPanel.setLayout(null);
        editPanel.setSize(3 * margin + 2 * w, 8 * margin + 7 * h);

        JLabel nameLabel = new JLabel(currentUser.language.employee.name, 4);
        nameLabel.setBackground(currentUser.theme.dialog.background);
        nameLabel.setForeground(currentUser.theme.dialog.fontColor);
        nameLabel.setFont(currentUser.theme.dialog.font);
        nameLabel.setBounds(margin, margin, w, h);
        editPanel.add(nameLabel);

        JLabel lastNameLabel = new JLabel(currentUser.language.employee.lastName, 4);
        lastNameLabel.setBackground(currentUser.theme.dialog.background);
        lastNameLabel.setForeground(currentUser.theme.dialog.fontColor);
        lastNameLabel.setFont(currentUser.theme.dialog.font);
        lastNameLabel.setBounds(margin, 2 * margin + h, w, h);
        editPanel.add(lastNameLabel);

        JLabel usernameLabel = new JLabel(currentUser.language.employee.userName, 4);
        usernameLabel.setBackground(currentUser.theme.dialog.background);
        usernameLabel.setForeground(currentUser.theme.dialog.fontColor);
        usernameLabel.setFont(currentUser.theme.dialog.font);
        usernameLabel.setBounds(margin, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameLabel);

        JLabel passwordLabel = new JLabel(currentUser.language.employee.password, 4);
        passwordLabel.setBackground(currentUser.theme.dialog.background);
        passwordLabel.setForeground(currentUser.theme.dialog.fontColor);
        passwordLabel.setFont(currentUser.theme.dialog.font);
        passwordLabel.setBounds(margin, 4 * margin + 3 * h, w, h);
        editPanel.add(passwordLabel);

        JLabel IDlLabel = new JLabel(currentUser.language.employee.ID, 4);
        IDlLabel.setBackground(currentUser.theme.dialog.background);
        IDlLabel.setForeground(currentUser.theme.dialog.fontColor);
        IDlLabel.setFont(currentUser.theme.dialog.font);
        IDlLabel.setBounds(margin, 5 * margin + 4 * h, w, h);
        editPanel.add(IDlLabel);

        JLabel phoneLabel = new JLabel(currentUser.language.employee.phone, 4);
        phoneLabel.setBackground(currentUser.theme.dialog.background);
        phoneLabel.setForeground(currentUser.theme.dialog.fontColor);
        phoneLabel.setFont(currentUser.theme.dialog.font);
        phoneLabel.setBounds(margin, 6 * margin + 5 * h, w, h);
        editPanel.add(phoneLabel);

        JTextField nameField = new JTextField("", 4);
        nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        nameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        nameField.setFont(currentUser.theme.dialog.font);
        nameField.setForeground(currentUser.theme.dialog.fontColor);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextField lastNameField = new JTextField("", 4);
        lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        lastNameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        lastNameField.setFont(currentUser.theme.dialog.font);
        lastNameField.setForeground(currentUser.theme.dialog.fontColor);
        lastNameField.setBounds(2 * margin + w, 2 * margin + h, w, h);
        editPanel.add(lastNameField);

        JTextField usernameField = new JTextField("", 4);
        usernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        usernameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        usernameField.setFont(currentUser.theme.dialog.font);
        usernameField.setForeground(currentUser.theme.dialog.fontColor);
        usernameField.setBounds(2 * margin + w, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameField);

        JTextField passwordField = new JTextField("", 4);
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        passwordField.setBackground(currentUser.theme.dialog.textFieldBackground);
        passwordField.setFont(currentUser.theme.dialog.font);
        passwordField.setForeground(currentUser.theme.dialog.fontColor);
        passwordField.setBounds(2 * margin + w, 4 * margin + 3 * h, w, h);
        editPanel.add(passwordField);

        JTextField IDField = new JTextField("", 4);
        IDField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        IDField.setBackground(currentUser.theme.dialog.textFieldBackground);
        IDField.setFont(currentUser.theme.dialog.font);
        IDField.setForeground(currentUser.theme.dialog.fontColor);
        IDField.setBounds(2 * margin + w, 5 * margin + 4 * h, w, h);
        editPanel.add(IDField);

        JTextField phoneField = new JTextField("", 4);
        phoneField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        phoneField.setBackground(currentUser.theme.dialog.textFieldBackground);
        phoneField.setFont(currentUser.theme.dialog.font);
        phoneField.setForeground(currentUser.theme.dialog.fontColor);
        phoneField.setBounds(2 * margin + w, 6 * margin + 5 * h, w, h);
        editPanel.add(phoneField);

        JButton save = new JButton(currentUser.language.employee.save);
        save.setBackground(currentUser.theme.dialog.buttonBackground);
        save.setFont(currentUser.theme.dialog.font);
        save.setForeground(currentUser.theme.dialog.fontColor);
        save.setBounds(margin, 7 * margin + 6 * h, w, h);
        save.addActionListener((e) -> {
            readData();

            addToFile(new Employee(nameField.getText(), lastNameField.getText(), usernameField.getText(),
                    passwordField.getText(), phoneField.getText(), IDField.getText()));

            dialog.dispose();
            reloadPage();
        });
        editPanel.add(save);

        JButton cancel = new JButton(currentUser.language.employee.cancel);
        cancel.setBackground(currentUser.theme.dialog.buttonBackground);
        cancel.setFont(currentUser.theme.dialog.font);
        cancel.setForeground(currentUser.theme.dialog.fontColor);
        cancel.setBounds(2 * margin + w, 7 * margin + 6 * h, w, h);
        cancel.addActionListener((e) -> {
            dialog.dispose();
        });
        editPanel.add(cancel);
        editPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        dialog.add(editPanel);
        dialog.setSize(3 * margin + 2 * w, 8 * margin + 7 * h);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setUndecorated(true);
        dialog.setVisible(true);
    }

    public void sure(JButton b) {
        int index = (b.getY() - 5) / 40;

        String data = "\n" + "  " + currentUser.language.employee.firstName + " :  " + allEmployee[index].name + "\n"
                + "  " + currentUser.language.employee.lastName + " :  " + allEmployee[index].lastName + "\n" + "  "
                + currentUser.language.employee.ID + " :  " + allEmployee[index].ID + "\n" + "  "
                + currentUser.language.employee.phone + " :  " + allEmployee[index].phoneNumber;
        int ans = JOptionPane.showConfirmDialog(this, currentUser.language.employee.areYouSureDescription + data,
                currentUser.language.employee.areYouSureTitle, JOptionPane.YES_NO_OPTION);

        if (ans == 0) {
            writeData(index);

            JOptionPane.showMessageDialog(this, currentUser.language.employee.removeDescription,
                    currentUser.language.employee.removeTitle, 1);

            reloadPage();
        }
    }

    public void addToFile(Employee em) {
        try {
            ObjectOutputStream reader = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Employees.dat"));

            Employee[] temp = new Employee[Count + 1];

            for (int i = 0; i < Count; i++) {
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
            ObjectOutputStream reader = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Employees.dat"));

            Employee[] temp = new Employee[Count - 1];

            for (int i = 0; i < remove; i++) {
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
