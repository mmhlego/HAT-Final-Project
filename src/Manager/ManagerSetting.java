package Manager;

import javax.swing.*;

import General.*;

public class ManagerSetting extends JPanel {
	private static final long serialVersionUID = -566165075426378234L;
	
	Manager currentUser;
    ManagerFrame parent;

        public ManagerSetting(ManagerFrame p, Manager u) {
        parent = p;
        currentUser = u;

        ManagerInformation changePanel = new ManagerInformation(currentUser);
        changePanel.setBackground(currentUser.theme.main.background);
        ThemePanel themePanel = new ThemePanel(parent, currentUser);
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
