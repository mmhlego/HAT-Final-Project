package General;

import javax.swing.*;

public class ThemePanel extends JPanel {
    JButton[] themeButtons = new JButton[4];
    JSeparator separator = new JSeparator();

    User currentUser;

    static int x = 0;

    ThemePanel(User u) {

        currentUser = u;

        JPanel sample = new JPanel();
        sample.setBackground(currentUser.theme.sidepanel);
        sample.setBounds(365, 195, 300, 233);
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(340, 20, 3, 580);
        add(separator);
        int height = 50;
        for (int i = 0; i < themeButtons.length; i++) {
            themeButtons[i] = new JButton();
            themeButtons[i].setBounds(30, height, 230, 75);
            height += 150;
            add(themeButtons[i]);
        }
        setBackground(currentUser.theme.background);
        add(sample);
        this.setLayout(null);
        this.setVisible(true);
    }

}
