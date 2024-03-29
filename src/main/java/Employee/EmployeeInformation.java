package Employee;

import javax.swing.*;
import java.awt.*;

public class EmployeeInformation extends JPanel {
    private static final long serialVersionUID = -482725039604356219L;

    JLabel label = new JLabel();
    JButton btn = new JButton();
    JPasswordField passwordField = new JPasswordField();
    EmployeeFrame parent;
    Employee currentUser;
    EmployeeSetting root;

    public EmployeeInformation(EmployeeFrame p, Employee u, EmployeeSetting r) {
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
        //btn.setForeground(Color.BLACK);
        btn.setText(currentUser.language.settings.edit);
        btn.setFont(currentUser.theme.main.font);
        add(btn);

        JLabel userName = new JLabel(currentUser.language.settings.useername, 0);
        JTextField userNameShow = new JTextField(currentUser.username);
        JLabel password = new JLabel(currentUser.language.settings.password, 0);
        JTextField showPassword = new JTextField(currentUser.password);
        JLabel firstName = new JLabel(currentUser.language.settings.firstName, 0);
        JTextField firstNameShow = new JTextField(currentUser.name);
        JLabel lastName = new JLabel(currentUser.language.settings.lastName, 0);
        JTextField lastNameShow = new JTextField(currentUser.lastName);
        JLabel phoneNumber = new JLabel(currentUser.language.settings.phone, 0);
        JTextField phoneNumberShow = new JTextField(currentUser.phoneNumber);
        JLabel ID = new JLabel(currentUser.language.settings.id, 0);
        JTextField IDShow = new JTextField(currentUser.ID);

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
        ID.setFont(currentUser.theme.main.font);
        IDShow.setFont(currentUser.theme.main.font);

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
        ID.setForeground(currentUser.theme.main.fontColor);
        IDShow.setForeground(currentUser.theme.main.fontColor);

        userNameShow.setBackground(currentUser.theme.main.background);
        showPassword.setBackground(currentUser.theme.main.background);
        firstNameShow.setBackground(currentUser.theme.main.background);
        lastNameShow.setBackground(currentUser.theme.main.background);
        phoneNumberShow.setBackground(currentUser.theme.main.background);
        IDShow.setBackground(currentUser.theme.main.background);

        userNameShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        showPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        firstNameShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        lastNameShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        phoneNumberShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        IDShow.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        /*ID.
        IDShow.*/

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
        ID.setBounds(50, 570, 240, 35);
        IDShow.setBounds(291, 570, 320, 35);

        passwordField.setBackground(currentUser.theme.main.background);
        passwordField.setFont(currentUser.theme.main.font);
        passwordField.setForeground(currentUser.theme.main.fontColor);
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.main.fontColor));
        passwordField.setBounds(291, 330, 320, 35);

        userNameShow.setHorizontalAlignment(SwingConstants.CENTER);
        showPassword.setHorizontalAlignment(SwingConstants.CENTER);
        firstNameShow.setHorizontalAlignment(SwingConstants.CENTER);
        lastNameShow.setHorizontalAlignment(SwingConstants.CENTER);
        phoneNumberShow.setHorizontalAlignment(SwingConstants.CENTER);
        IDShow.setHorizontalAlignment(SwingConstants.CENTER);

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
        ID.setVisible(true);
        IDShow.setVisible(true);

        userNameShow.setEditable(false);
        showPassword.setEditable(false);
        firstNameShow.setEditable(false);
        lastNameShow.setEditable(false);
        phoneNumberShow.setEditable(false);
        IDShow.setEditable(false);

        btn.addActionListener(e -> {
            if (btn.getText().equals(currentUser.language.settings.edit)) {
                userNameShow.setEditable(true);
                showPassword.setEditable(true);
                firstNameShow.setEditable(true);
                lastNameShow.setEditable(true);
                phoneNumberShow.setEditable(true);
                showPassword.setVisible(true);
                IDShow.setEditable(false);
                passwordField.setVisible(false);
                btn.setText(currentUser.language.settings.save);
            } else {
                userNameShow.setEditable(false);
                showPassword.setEditable(false);
                firstNameShow.setEditable(false);
                lastNameShow.setEditable(false);
                phoneNumberShow.setEditable(false);
                showPassword.setVisible(false);
                IDShow.setEditable(false);
                passwordField.setVisible(true);
                btn.setText(currentUser.language.settings.edit);

                currentUser.username = userNameShow.getText();
                currentUser.password = showPassword.getText();
                currentUser.name = firstNameShow.getText();
                currentUser.lastName = lastNameShow.getText();
                currentUser.phoneNumber = phoneNumberShow.getText();

                new EmployeeWriter(currentUser);
                parent.dispose();
                new EmployeeFrame(currentUser);
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
        this.add(ID);
        this.add(IDShow);
        this.add(passwordField);
        this.add(label);
        this.setBackground(currentUser.theme.main.background);
        this.setLayout(null);
        this.setVisible(true);
    }
}
