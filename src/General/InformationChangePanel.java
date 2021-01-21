package General;

import javax.swing.*;
import java.awt.*;

public class InformationChangePanel extends JPanel {
    private static final long serialVersionUID = 743221474354971601L;

    JLabel label = new JLabel();
    JTextField[] fields = new JTextField[10];
    ImageIcon managerIcon = new ImageIcon("images.jpg");
    JButton btn = new JButton();
    JPasswordField passwordField = new JPasswordField();

    User currentUser;

    InformationChangePanel(User u) {

        currentUser = u;

        label.setIcon(managerIcon);
        label.setBounds(220, 15, 300, 250);
        label.setBackground(currentUser.theme.main.background);

        passwordField.setVisible(true);
        passwordField.setText(currentUser.password);

        btn.setBounds(90, 570, 520, 40);
        btn.setBackground(new Color(111, 207, 151));
        //btn.setForeground(Color.BLACK);
        btn.setText("Edit Information");
        btn.setFont(currentUser.theme.main.font);
        add(btn);

        for (int i = 0; i < 10; i++) {
            fields[i] = new JTextField();
        }
        int hight = 270;
        fields[0].setText("Username:");
        fields[1].setText(currentUser.username);
        fields[2].setText("Password:");
        fields[3].setText(currentUser.password);
        fields[4].setText("First Name:");
        fields[5].setText(currentUser.name);
        fields[6].setText("Last Name:");
        fields[7].setText(currentUser.lastName);
        fields[8].setText("Phone Number:");
        fields[9].setText(currentUser.phoneNumber);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                fields[i].setFont(currentUser.theme.main.font);
                fields[i].setForeground(currentUser.theme.main.fontColor);
                fields[i].setBackground(currentUser.theme.main.background);
                fields[i].setBounds(50, hight, 240, 35);
                hight = hight + 60;

            } else {
                fields[i].setBounds(291, hight - 60, 320, 35);
                fields[i].setBackground(Color.white);
                if (i == 3) {
                    passwordField.setBackground(Color.white);
                    passwordField.setBounds(291, hight - 60, 320, 35);
                }
            }

            fields[i].setFont(currentUser.theme.main.font);
            fields[i].setBorder(null);
            fields[i].setHorizontalAlignment(SwingConstants.CENTER);
            fields[i].setVisible(true);
            fields[i].setEditable(false);

            this.add(fields[i]);
        }
        fields[3].setVisible(false);
        btn.addActionListener(e -> {
            if (btn.getText().equals("Edit Information")) {
                fields[1].setEditable(true);
                fields[3].setEditable(true);
                fields[5].setEditable(true);
                fields[7].setEditable(true);
                fields[9].setEditable(true);
                fields[3].setVisible(true);
                passwordField.setVisible(false);
                btn.setText("Save Information");
            } else {
                fields[1].setEditable(false);
                fields[3].setEditable(false);
                fields[5].setEditable(false);
                fields[7].setEditable(false);
                fields[9].setEditable(false);
                fields[3].setVisible(false);
                passwordField.setVisible(true);
                btn.setText("Edit Information");
            }
        });
        passwordField.setEditable(false);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBorder(null);
        this.add(passwordField);
        this.add(label);
        this.setBackground(currentUser.theme.main.background);
        this.setLayout(null);
        this.setVisible(true);
    }

}
