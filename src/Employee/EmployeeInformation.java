package Employee;

import javax.swing.*;
import java.awt.*;

public class EmployeeInformation extends JPanel {
    private static final long serialVersionUID = -482725039604356219L;

    JLabel label = new JLabel();
    JButton btn = new JButton();
    JPasswordField passwordField = new JPasswordField();

    Employee currentUser;

    public EmployeeInformation(Employee u) {

        currentUser = u;

        label.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\EditSettings.png"));
        label.setBounds(220, 7, 300, 250);
        label.setBackground(currentUser.theme.main.background);

        passwordField.setVisible(true);
        passwordField.setText(currentUser.password);

        btn.setBounds(90, 570, 520, 40);
        btn.setBackground(new Color(111, 207, 151));
        //btn.setForeground(Color.BLACK);
        btn.setText("Edit Information");
        btn.setFont(currentUser.theme.main.font);
        add(btn);

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

        userNameShow.setBackground(currentUser.theme.main.background);
        showPassword.setBackground(currentUser.theme.main.background);
        firstNameShow.setBackground(currentUser.theme.main.background);
        lastNameShow.setBackground(currentUser.theme.main.background);
        phoneNumberShow.setBackground(currentUser.theme.main.background);

        userNameShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        showPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        firstNameShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        lastNameShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        phoneNumberShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));

        userName.setBounds(50, 270, 240, 35);
        userNameShow.setBounds(291, 270, 320, 35);
        password.setBounds(50, 330, 240, 35);
        showPassword.setBounds(291, 330, 320, 35);
        firstName.setBounds(50, 390, 240, 35);
        firstNameShow.setBounds(291, 390, 320, 35);
        lastName.setBounds(50, 450, 240, 35);
        lastNameShow.setBounds(291, 450, 320, 35);
        phoneNumber.setBounds(50, 510, 240, 35);
        phoneNumberShow.setBounds(291, 510, 320, 35);

        passwordField.setBackground(currentUser.theme.main.background);
        passwordField.setFont(currentUser.theme.main.font);
        passwordField.setForeground(currentUser.theme.main.fontColor);
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        passwordField.setBounds(291, 330, 320, 35);

        userNameShow.setHorizontalAlignment(SwingConstants.CENTER);
        showPassword.setHorizontalAlignment(SwingConstants.CENTER);
        firstNameShow.setHorizontalAlignment(SwingConstants.CENTER);
        lastNameShow.setHorizontalAlignment(SwingConstants.CENTER);
        phoneNumberShow.setHorizontalAlignment(SwingConstants.CENTER);

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

        userNameShow.setEditable(false);
        showPassword.setEditable(false);
        firstNameShow.setEditable(false);
        lastNameShow.setEditable(false);
        phoneNumberShow.setEditable(false);

        btn.addActionListener(e -> {
            if (btn.getText().equals("Edit Information")) {
                userNameShow.setEditable(true);
                showPassword.setEditable(true);
                firstNameShow.setEditable(true);
                lastNameShow.setEditable(true);
                phoneNumberShow.setEditable(true);
                showPassword.setVisible(true);
                passwordField.setVisible(false);
                btn.setText("Save Information");
            } else {
                userNameShow.setEditable(false);
                showPassword.setEditable(false);
                firstNameShow.setEditable(false);
                lastNameShow.setEditable(false);
                phoneNumberShow.setEditable(false);
                showPassword.setVisible(false);
                passwordField.setVisible(true);
                btn.setText("Edit Information");
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
        this.add(passwordField);
        this.add(label);
        this.setBackground(currentUser.theme.main.background);
        this.setLayout(null);
        this.setVisible(true);
    }

}
