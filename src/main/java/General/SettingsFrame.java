package General;

import javax.swing.*;

public class SettingsFrame extends JPanel {

    User currentUser;

    public SettingsFrame(User u) {
        currentUser = u;

        InformationChangePanel changePanel = new InformationChangePanel(currentUser);
        changePanel.setBackground(currentUser.theme.background);
        ThemePanel themePanel = new ThemePanel(currentUser);
        themePanel.setBackground(currentUser.theme.background);
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(currentUser.theme.font);
        tabs.setForeground(currentUser.theme.fontColor);
        tabs.setBackground(currentUser.theme.background);
        tabs.setVisible(true);
        tabs.add("Informations", changePanel);
        tabs.add("Theme", themePanel);

        setLayout(null);
        tabs.setBorder(null);
        tabs.setBounds(0, 0, 700, 700);
        add(tabs);

        setBackground(currentUser.theme.background);
        setVisible(true);
    }
}
