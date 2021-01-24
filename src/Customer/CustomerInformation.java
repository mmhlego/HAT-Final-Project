package Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerInformation extends JPanel {
    private static final long serialVersionUID = 2890759138378508204L;

    JLabel label = new JLabel();
    JButton btn = new JButton();
    JPasswordField passwordField = new JPasswordField();
    Customer currentUser;
    CustomerFrame parent;
    CustomerSetting root;
    Customer[] allCustomers;

    public CustomerInformation(CustomerFrame p, Customer u, CustomerSetting r) {
        parent = p;
        currentUser = u;
        root = r;

        label.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\EditSettings.png"));
        label.setBounds(220, 7, 300, 250);
        label.setBackground(currentUser.theme.main.background);

        passwordField.setVisible(true);
        passwordField.setText(currentUser.password);

        btn.setBounds(90, 620, 520, 40);
        btn.setBackground(new Color(111, 207, 151));
        btn.setText("Edit Information");
        btn.setFont(currentUser.theme.main.font);
        add(btn);

        JButton increase = new JButton();
        increase.setBackground(null);
        increase.setBorder(null);
        increase.setBounds(611, 570, 35, 35);
        increase.setIcon(new ImageIcon(
                System.getProperty("user.dir") + "\\Images\\Icons\\" + currentUser.theme.main.icon + "Addb.png"));

        JLabel userName = new JLabel("Username:", 0);
        JTextField userNameShow = new JTextField(currentUser.username);
        JLabel password = new JLabel("Password:", 0);
        JTextField showPassword = new JTextField(currentUser.password);
        JLabel firstName = new JLabel("First Name:", 0);
        JTextField firstNameShow = new JTextField(currentUser.name);
        JLabel lastName = new JLabel("Last Name:", 0);
        JTextField lastNameShow = new JTextField(currentUser.lastName);
        JLabel phoneNumber = new JLabel("Phone Number:", 0);
        JTextField phoneNumberShow = new JTextField(currentUser.phoneNumber);
        JLabel adress = new JLabel("Address:", 0);
        JTextField adressShow = new JTextField(currentUser.address);
        JScrollPane adressScroll = new JScrollPane(adressShow);
        JLabel balance = new JLabel("Balance", 0);
        JTextField balanceShow = new JTextField(String.valueOf(currentUser.balance));

        userName.setFont(currentUser.theme.main.font);
        userNameShow.setFont(currentUser.theme.main.font);
        password.setFont(currentUser.theme.main.font);
        showPassword.setFont(currentUser.theme.main.font);
        firstName.setFont(currentUser.theme.main.font);
        firstNameShow.setFont(currentUser.theme.main.font);
        lastName.setFont(currentUser.theme.main.font);
        lastNameShow.setFont(currentUser.theme.main.font);
        phoneNumber.setFont(currentUser.theme.main.font);
        phoneNumberShow.setFont(currentUser.theme.main.font);
        adress.setFont(currentUser.theme.main.font);
        adressShow.setFont(currentUser.theme.main.font);
        adressScroll.setFont(currentUser.theme.main.font);
        balance.setFont(currentUser.theme.main.font);
        balanceShow.setFont(currentUser.theme.main.font);

        userName.setForeground(currentUser.theme.main.fontColor);
        userNameShow.setForeground(currentUser.theme.main.fontColor);
        password.setForeground(currentUser.theme.main.fontColor);
        showPassword.setForeground(currentUser.theme.main.fontColor);
        firstName.setForeground(currentUser.theme.main.fontColor);
        firstNameShow.setForeground(currentUser.theme.main.fontColor);
        lastName.setForeground(currentUser.theme.main.fontColor);
        lastNameShow.setForeground(currentUser.theme.main.fontColor);
        phoneNumber.setForeground(currentUser.theme.main.fontColor);
        phoneNumberShow.setForeground(currentUser.theme.main.fontColor);
        adress.setForeground(currentUser.theme.main.fontColor);
        adressShow.setForeground(currentUser.theme.main.fontColor);
        adressScroll.setForeground(currentUser.theme.main.fontColor);
        balance.setForeground(currentUser.theme.main.fontColor);
        balanceShow.setForeground(currentUser.theme.main.fontColor);

        userNameShow.setBackground(currentUser.theme.main.background);
        showPassword.setBackground(currentUser.theme.main.background);
        firstNameShow.setBackground(currentUser.theme.main.background);
        lastNameShow.setBackground(currentUser.theme.main.background);
        phoneNumberShow.setBackground(currentUser.theme.main.background);
        adressShow.setBackground(currentUser.theme.main.background);
        adressScroll.setBackground(currentUser.theme.main.background);
        balanceShow.setBackground(currentUser.theme.main.background);

        userNameShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        showPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        firstNameShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        lastNameShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        phoneNumberShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        adressShow.setBorder(null);
        adressScroll.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        balanceShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));

        userName.setBounds(50, 270, 240, 35);
        userNameShow.setBounds(291, 270, 320, 35);
        password.setBounds(50, 320, 240, 35);
        showPassword.setBounds(291, 320, 320, 35);
        firstName.setBounds(50, 370, 240, 35);
        firstNameShow.setBounds(291, 370, 320, 35);
        lastName.setBounds(50, 420, 240, 35);
        lastNameShow.setBounds(291, 420, 320, 35);
        phoneNumber.setBounds(50, 470, 240, 35);
        phoneNumberShow.setBounds(291, 470, 320, 35);
        adress.setBounds(50, 520, 240, 45);
        adressScroll.setBounds(291, 520, 320, 45);
        balance.setBounds(50, 570, 240, 35);
        balanceShow.setBounds(291, 570, 320, 35);

        passwordField.setBackground(currentUser.theme.main.background);
        passwordField.setFont(currentUser.theme.main.font);
        passwordField.setForeground(currentUser.theme.main.fontColor);
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        passwordField.setBounds(291, 320, 320, 35);

        userNameShow.setHorizontalAlignment(SwingConstants.CENTER);
        showPassword.setHorizontalAlignment(SwingConstants.CENTER);
        firstNameShow.setHorizontalAlignment(SwingConstants.CENTER);
        lastNameShow.setHorizontalAlignment(SwingConstants.CENTER);
        phoneNumberShow.setHorizontalAlignment(SwingConstants.CENTER);
        adressShow.setHorizontalAlignment(SwingConstants.CENTER);
        balanceShow.setHorizontalAlignment(SwingConstants.CENTER);

        userName.setVisible(true);
        userNameShow.setVisible(true);
        password.setVisible(true);
        showPassword.setVisible(false);
        firstName.setVisible(true);
        firstNameShow.setVisible(true);
        lastName.setVisible(true);
        lastNameShow.setVisible(true);
        phoneNumber.setVisible(true);
        phoneNumberShow.setVisible(true);
        adress.setVisible(true);
        adressShow.setVisible(true);
        adressScroll.setVisible(true);
        balance.setVisible(true);
        balanceShow.setVisible(true);

        userNameShow.setEditable(false);
        showPassword.setEditable(false);
        firstNameShow.setEditable(false);
        lastNameShow.setEditable(false);
        phoneNumberShow.setEditable(false);
        adressShow.setEditable(false);
        balanceShow.setEditable(false);

        btn.addActionListener(e -> {
            if (btn.getText().equals("Edit Information")) {
                userNameShow.setEditable(true);
                showPassword.setEditable(true);
                firstNameShow.setEditable(true);
                lastNameShow.setEditable(true);
                phoneNumberShow.setEditable(true);
                showPassword.setVisible(true);
                adressShow.setEditable(true);
                balanceShow.setEditable(false);
                passwordField.setVisible(false);
                btn.setText("Save Information");
            } else {
                userNameShow.setEditable(false);
                showPassword.setEditable(false);
                firstNameShow.setEditable(false);
                lastNameShow.setEditable(false);
                phoneNumberShow.setEditable(false);
                adressShow.setEditable(false);
                balanceShow.setEditable(false);
                showPassword.setVisible(false);
                passwordField.setVisible(true);
                btn.setText("Edit Information");

                currentUser.username = userNameShow.getText();
                currentUser.password = showPassword.getText();
                currentUser.name = firstNameShow.getText();
                currentUser.lastName = lastNameShow.getText();
                currentUser.phoneNumber = phoneNumberShow.getText();
                currentUser.address = adressShow.getText();

                root.openAndSaveData(currentUser);
                parent.dispose();
                new CustomerFrame(currentUser);
            }
        });
        passwordField.setEditable(false);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(userName);
        this.add(userNameShow);
        this.add(password);
        this.add(showPassword);
        this.add(firstName);
        this.add(firstNameShow);
        this.add(lastName);
        this.add(lastNameShow);
        this.add(phoneNumber);
        this.add(phoneNumberShow);
        this.add(balance);
        this.add(balanceShow);
        this.add(adress);
        this.add(adressScroll);
        this.add(passwordField);
        this.add(increase);
        this.add(label);
        this.setBackground(currentUser.theme.main.background);
        this.setLayout(null);
        this.setVisible(true);
    }
}
