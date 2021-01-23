package Manager;

import javax.swing.*;

public class ManagerMain extends JPanel {
    private static final long serialVersionUID = -6098069108891511310L;

    JLabel label = new JLabel();
    JTextField[] fields = new JTextField[10];
    ManagerFrame parent;
    Manager currentUser;

    public ManagerMain(Manager m, ManagerFrame p) {
        currentUser = m;
        parent = p;
        parent.setIconImage(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Frame Icons\\Manager.png").getImage());
        parent.setTitle("Manager");
        label.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Manager.png"));
        label.setBounds(225, 25, 250, 250);
        label.setBackground(currentUser.theme.main.background);

        for (int i = 0; i < fields.length; i++)
            fields[i] = new JTextField();
        int hight = 300;
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

        for (int i = 0; i < fields.length; i++) {
            fields[i].setBackground(currentUser.theme.main.background);
            if (i % 2 == 0) {

                fields[i].setBounds(50, hight, 300, 35);
                hight = hight + 60;
            } else {

                fields[i].setBounds(351, hight - 60, 300, 35);
            }
            fields[i].setFont(currentUser.theme.main.font);
            fields[i].setForeground(currentUser.theme.main.fontColor);
            fields[i].setBorder(null);
            fields[i].setHorizontalAlignment(SwingConstants.CENTER);
            fields[i].setVisible(true);
            fields[i].setEditable(false);

            this.add(fields[i]);
        }

        add(label);
        setLayout(null);
        setBounds(0, 0, 700, 700);
        setBackground(currentUser.theme.main.background);

    }

   
}
