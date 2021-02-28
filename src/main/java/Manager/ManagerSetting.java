package Manager;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;
import General.Language;

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

    //Manager0
    JLabel sampleTheme;
    ManagerFrame parent;
    Manager currentUser;
    ManagerSetting root;
    int index = 0;
    JRadioButton persianLang = new JRadioButton("فارسی");
    JRadioButton englishLang = new JRadioButton("English");

    public ThemePanel(ManagerFrame p, Manager u, ManagerSetting r) {
        parent = p;
        currentUser = u;
        root = r;

        index = currentUser.theme.mode;
        JTextArea sampleText = new JTextArea();
        sampleText.setBounds(375, 20, 300, 110);
        sampleText.setText(currentUser.language.settings.sampleText);
        sampleText.setBackground(currentUser.theme.main.background);
        sampleText.setForeground(currentUser.theme.main.fontColor);
        sampleText.setFont(currentUser.theme.main.font);
        add(sampleText);

        sampleTheme = new JLabel(currentUser.language.settings.preview, 0);
        sampleTheme.setBorder(new LineBorder(Color.black, 1));
        sampleTheme.setBounds(375, 170, 300, 233);
        add(sampleTheme);

        ButtonGroup group = new ButtonGroup();
        group.add(persianLang);
        group.add(englishLang);
        //maybe this has abug
        persianLang.setFont(currentUser.theme.main.font);
        persianLang.setBounds(150, 75, 100, 55);
        persianLang.setForeground(currentUser.theme.main.fontColor);
        persianLang.setBackground(currentUser.theme.main.background);
        persianLang.addActionListener((e) -> {
            sampleText.setText(currentUser.language.settings.sampleTextList[Language.PERSIAN]);
            //currentUser.language.set(Language.PERSIAN);
            repaint();
            revalidate();
        });
        add(persianLang);

        englishLang.setFont(currentUser.theme.main.font);
        englishLang.setBounds(150, 20, 100, 55);
        englishLang.setForeground(currentUser.theme.main.fontColor);
        englishLang.setBackground(currentUser.theme.main.background);
        englishLang.addActionListener((e) -> {
            sampleText.setText(currentUser.language.settings.sampleTextList[Language.ENGLISH]);
            //currentUser.language.set(Language.ENGLISH);
            repaint();
            revalidate();
        });
        add(englishLang);

        JSeparator VSeparator = new JSeparator();
        VSeparator.setOrientation(SwingConstants.HORIZONTAL);
        VSeparator.setBounds(20, 150, 655, 5);
        add(VSeparator);

        /*JSeparator HSeparator = new JSeparator();
        HSeparator.setOrientation(SwingConstants.VERTICAL);
        HSeparator.setBounds(349, 20, 3, 545);
        add(HSeparator);*/

        for (int i = 0; i < 5; i++) {
            JButton themeButton = new JButton();
            themeButton.setBounds(20, 170 + i * 86, 305, 50);
            themeButton.setBackground(currentUser.theme.main.buttonColor);
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
        //apply.setBounds(365, 540, 300, 60);
        apply.setBounds(20, 600, 660, 50);
        apply.addActionListener((e) -> {
            if (persianLang.isSelected()) {
                currentUser.language.set(Language.PERSIAN);
            } else if (englishLang.isSelected()) {
                currentUser.language.set(Language.ENGLISH);
            }
            currentUser.theme.setAll(index);
            new ManagerWriter(currentUser);
            parent.dispose();
            new ManagerFrame(currentUser);
        });

        add(apply);
        setBackground(currentUser.theme.main.background);
        setLayout(null);
        setVisible(true);

    }

    public void changeTheme(JButton b) {
        index = (b.getY() - 60) / 120;
        if (index == 4) {
            return;
        }

        String[] names = { "LightTheme.png", "DarkTheme.png", "ClassicTheme.png", "ModernTheme.png" };

        sampleTheme.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Themes\\" + names[index]));

        parent.revalidate();
        parent.repaint();
    }

}