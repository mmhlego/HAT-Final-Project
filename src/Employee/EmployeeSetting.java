package Employee;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class EmployeeSetting extends JPanel {
    private static final long serialVersionUID = -1888229805702323590L;

    Employee currentUser;
    EmployeeFrame parent;

    public EmployeeSetting(EmployeeFrame p, Employee u) {
        parent = p;
        currentUser = u;

        EmployeeInformation changePanel = new EmployeeInformation(parent, currentUser, this);
        changePanel.setBackground(currentUser.theme.main.background);
        ThemePanel themePanel = new ThemePanel(parent, currentUser, this);
        themePanel.setBackground(currentUser.theme.main.background);
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(currentUser.theme.main.font);
        tabs.setForeground(currentUser.theme.main.fontColor);
        tabs.setBackground(currentUser.theme.main.background);
        tabs.setVisible(true);
        tabs.add("                              Informations                              ", changePanel);
        tabs.add("                                     Theme                                      ", themePanel);

        setLayout(null);
        tabs.setBorder(null);
        tabs.setBounds(-3, 0, 800, 700);
        add(tabs);

        setBackground(currentUser.theme.main.background);
        setVisible(true);
    }
}

class ThemePanel extends JPanel {
    private static final long serialVersionUID = 6166827639711132804L;

    JSeparator separator = new JSeparator();
    JLabel sample;
    EmployeeFrame parent;
    Employee currentUser;
    EmployeeSetting root;
    int index = 0;

    public ThemePanel(EmployeeFrame p, Employee u, EmployeeSetting r) {
        parent = p;
        currentUser = u;
        root = r;

        sample = new JLabel("Previw", 0);
        sample.setBorder(new LineBorder(Color.black, 1));
        sample.setBounds(365, 195, 300, 233);
        add(sample);

        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(340, 20, 3, 580);
        add(separator);

        for (int i = 0; i < 5; i++) {
            JButton themeButton = new JButton();
            themeButton.setBounds(30, 60 + i * 120, 230, 60);
            themeButton.addActionListener((e) -> {
                changeTheme(themeButton);
            });
            switch (i) {
                case 0:
                    themeButton.setText("Light Theme");
                    break;
                case 1:
                    themeButton.setText("Dark Theme");
                    break;
                case 2:
                    themeButton.setText("Classic Theme");
                    break;
                case 3:
                    themeButton.setText("Modern Theme");
                    break;
                case 4:
                    themeButton.setText("Custom Theme");
                    themeButton.addActionListener(e -> new EmployeeTheme(parent, root, currentUser));
                    break;
            }

            add(themeButton);
        }

        JButton apply = new JButton("Apply Selected Theme");
        apply.setBackground(currentUser.theme.submitColor);
        apply.setBounds(365, 540, 300, 60);
        apply.addActionListener((e) -> {
            currentUser.theme.setAll(index);
            //root.openAndSaveData(currentUser);
            new EmployeeWriter(currentUser);
            parent.dispose();
            new EmployeeFrame(currentUser);
        });
        add(apply);

        setBackground(currentUser.theme.main.background);

        this.setLayout(null);
        this.setVisible(true);

    }

    public void changeTheme(JButton b) {
        index = (b.getY() - 60) / 120;
        if (index == 4) {
            return;
        }

        String[] names = { "LightTheme.png", "DarkTheme.png", "ClassicThemee.png", "ModernTheme.png" };

        sample.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Themes\\" + names[index]));

        parent.revalidate();
        parent.repaint();
    }

}