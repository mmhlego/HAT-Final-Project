package General;

import javax.swing.*;

public class SettingsFrame extends JPanel {
    private static final long serialVersionUID = 2541312498453723523L;

    User currentUser;
    JFrame parent;

    public SettingsFrame(JFrame p, User u) {
        parent = p;
        currentUser = u;

        InformationChangePanel changePanel = new InformationChangePanel(currentUser);
        changePanel.setBackground(currentUser.theme.main.background);
        ThemePanel themePanel = new ThemePanel(parent, currentUser);
        themePanel.setBackground(currentUser.theme.main.background);
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(currentUser.theme.main.font);
        tabs.setForeground(currentUser.theme.main.fontColor);
        tabs.setBackground(currentUser.theme.main.background);
        tabs.setVisible(true);
        tabs.add("                                  Informations                                  ", changePanel);
        tabs.add("                                  Theme                                  ", themePanel);

        setLayout(null);
        tabs.setBorder(null);
        tabs.setBounds(-3, 0, 800, 700);
        add(tabs);

        setBackground(currentUser.theme.main.background);
        setVisible(true);
    }
}
