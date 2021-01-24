package Customer;

import javax.swing.*;

import General.*;

public class CustomerSetting extends JPanel {
	private static final long serialVersionUID = -1888229805702323590L;
	
	Customer currentUser;
    CustomerFrame parent;

    public CustomerSetting(CustomerFrame p, Customer u) {
        parent = p;
        currentUser = u;

        CustomerInformation changePanel = new CustomerInformation(currentUser);
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

