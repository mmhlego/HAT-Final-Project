package Manager;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ManagerSetting extends JPanel {
    private static final long serialVersionUID = -1888229805702323590L;

    Manager currentUser;
    ManagerFrame parent;

    public ManagerSetting(ManagerFrame p, Manager u) {
        parent = p;
        currentUser = u;

        ManagerInformation changePanel = new ManagerInformation(parent, currentUser, this);
        changePanel.setBackground(currentUser.theme.main.background);
        ThemePanel themePanel = new ThemePanel(parent, currentUser, this);
        themePanel.setBackground(currentUser.theme.main.background);
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(currentUser.theme.main.font);
        tabs.setForeground(currentUser.theme.main.fontColor);
        tabs.setBackground(currentUser.theme.main.background);
        tabs.setVisible(true);
        tabs.add("                             " + currentUser.language.settings.information
                + "                              ", changePanel);
        tabs.add("                                     " + currentUser.language.settings.theme
                + "                                      ", themePanel);

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
    ManagerFrame parent;
    Manager currentUser;
    ManagerSetting root;
    int index = 0;

    public ThemePanel(ManagerFrame p, Manager u, ManagerSetting r) {
        parent = p;
        currentUser = u;
        root = r;

        sample = new JLabel(currentUser.language.settings.preview, 0);
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
                    themeButton.setText(currentUser.language.settings.lightTheme);
                    break;
                case 1:
                    themeButton.setText(currentUser.language.settings.darkTheme);
                    break;
                case 2:
                    themeButton.setText(currentUser.language.settings.classicTheme);
                    break;
                case 3:
                    themeButton.setText(currentUser.language.settings.modernTheme);
                    break;
                case 4:
                    themeButton.setText(currentUser.language.settings.customTheme);
                    themeButton.addActionListener(e -> new ManagerTheme(parent, root, currentUser));
                    break;
            }

            add(themeButton);
        }

        JButton apply = new JButton(currentUser.language.settings.applySelected);
        apply.setBackground(currentUser.theme.submitColor);
        apply.setBounds(365, 540, 300, 60);
        apply.addActionListener((e) -> {
            currentUser.theme.setAll(index);
            new ManagerWriter(currentUser);
            parent.dispose();
            new ManagerFrame(currentUser);
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