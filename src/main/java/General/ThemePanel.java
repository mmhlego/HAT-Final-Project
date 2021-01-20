package General;

import javax.swing.*;

public class ThemePanel extends JPanel {
    private static final long serialVersionUID = 6166827639711132804L;

    JSeparator separator = new JSeparator();
    User currentUser;
    JFrame parent;

    ThemePanel(JFrame p, User u) {
        parent = p;
        currentUser = u;

        JPanel sample = new JPanel();
        sample.setBackground(currentUser.theme.main.background);
        sample.setBounds(365, 195, 300, 233);
        add(sample);

        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(340, 20, 3, 580);
        add(separator);
        int height = 50;
        for (int i = 0; i < 4; i++) {
            JButton themeButton = new JButton();
            themeButton.setBounds(30, height, 230, 75);
            themeButton.addActionListener((e) -> {
                change(themeButton);
            });
            add(themeButton);
            height += 150;
        }
        setBackground(currentUser.theme.main.background);

        this.setLayout(null);
        this.setVisible(true);
    }

    public void change(JButton b) {
        int index = (b.getY() - 50) / 150;

        currentUser.theme.setAll(index);
        System.out.println(index);

        parent.revalidate();
        parent.repaint();
    }

}
