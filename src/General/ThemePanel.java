package General;

import javax.swing.*;
import java.awt.*;

public class ThemePanel extends JPanel {
    private static final long serialVersionUID = 6166827639711132804L;

    JSeparator separator = new JSeparator();
    User currentUser;
    JFrame parent;

    public ThemePanel(JFrame p, User u) {
        parent = p;
        currentUser = u;

        JPanel sample = new JPanel();
        sample.setBackground(Color.yellow);
        sample.setBounds(365, 195, 300, 233);
        add(sample);

        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(340, 20, 3, 580);
        add(separator);
        int height = 60;
        for (int i = 0; i < 5; i++) {
            JButton themeButton = new JButton();
            themeButton.setBounds(30, height, 230, 60);
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
                    themeButton.addActionListener(e -> new CustomTheme(currentUser, parent));
                    break;
            }

            add(themeButton);
            height += 120;
        }
        setBackground(currentUser.theme.main.background);

        this.setLayout(null);
        this.setVisible(true);

    }

    public void changeTheme(JButton b) {
        int index = (b.getY() - 60) / 120;

        currentUser.theme.main.set(index);
        System.out.println(index);

        parent.revalidate();
        parent.repaint();
    }

}
