package Customer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class CustomerSetting extends JPanel {
    private static final long serialVersionUID = -1888229805702323590L;

    Customer currentUser;
    CustomerFrame parent;

    public CustomerSetting(CustomerFrame p, Customer u) {
        parent = p;
        currentUser = u;

        CustomerInformation changePanel = new CustomerInformation(parent, currentUser, this);
        changePanel.setBackground(currentUser.theme.main.background);
        ThemePanel themePanel = new ThemePanel(parent, currentUser, this);
        themePanel.setBackground(currentUser.theme.main.background);
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(currentUser.theme.main.font);
        tabs.setForeground(currentUser.theme.main.fontColor);
        tabs.setBackground(currentUser.theme.main.background);
        tabs.setVisible(true);
        tabs.add("                             Informations                              ", changePanel);
        tabs.add("                                     Theme                                      ", themePanel);

        setLayout(null);
        tabs.setBorder(null);
        tabs.setBounds(-2, 0, 800, 720);
        add(tabs);

        setBackground(currentUser.theme.main.background);
        setVisible(true);
    }
}

class ThemePanel extends JPanel {
    private static final long serialVersionUID = 6166827639711132804L;

    JSeparator separator = new JSeparator();
    JLabel sample;
    CustomerFrame parent;
    Customer currentUser;
    CustomerSetting root;
    int index = 0;

    public ThemePanel(CustomerFrame p, Customer u, CustomerSetting r) {
        parent = p;
        currentUser = u;
        root = r;

        sample = new JLabel("Preview", 0);
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
                    themeButton.addActionListener(e -> new CustomerTheme(parent, root, currentUser));
                    break;
            }

            add(themeButton);
        }

        JButton apply = new JButton("Apply Selected Theme");
        apply.setBackground(currentUser.theme.submitColor);
        apply.setBounds(365, 540, 300, 60);
        apply.addActionListener((e) -> {
            currentUser.theme.setAll(index);
            new CustomerWriter(currentUser);
            parent.dispose();
            new CustomerFrame(currentUser);
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

        String[] names = { "LightTheme.png", "DarkTheme.png", "ClassicTheme.png", "ModernTheme.png" };

        sample.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Themes\\" + names[index]));

        parent.revalidate();
        parent.repaint();
    }

}