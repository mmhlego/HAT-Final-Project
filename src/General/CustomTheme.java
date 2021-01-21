package General;

import javax.swing.*;
import java.awt.*;

public class CustomTheme extends JDialog {
    private static final long serialVersionUID = -7114970084885205201L;

    User currentUser;
    JFrame parent;
    Color bcgc;
    Color spc;
    Color dlgc;

    CustomTheme(User u, JFrame f) {
        currentUser = u;
        parent = f;

        bcgc = currentUser.theme.main.background;
        spc = currentUser.theme.sidePanel.background;
        dlgc = currentUser.theme.dialog.background;

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(100, 20, 300, 300);
        layeredPane.setLayout(null);
        JPanel[] example = new JPanel[4];
        for (int i = 0; i < example.length; i++) {
            example[i] = new JPanel();
        }
        this.setBounds(100, 100, 500, 500);

        example[0].setBounds(0, 0, 50, 280);
        example[0].setBackground(currentUser.theme.sidePanel.background);
        example[1].setBackground(Color.red);
        example[2].setBackground(currentUser.theme.main.background);
        example[3].setBackground(currentUser.theme.dialog.background);
        example[1].setBounds(0, 280, 50, 20);
        example[2].setBounds(50, 0, 250, 300);
        example[3].setBounds(125, 100, 100, 100);
        String[] sidePanel = { "side panel theme", "cyan", "gray", "lime", "orange", "light", "dark", "brown",
                "classic", "magenta" };
        String[] background = { "background theme", "cyan", "gray", "lime", "orange", "light", "dark", "brown",
                "classic", "magenta" };
        String[] dialog = { "dialog theme", "cyan", "gray", "lime", "orange", "light", "dark", "brown", "classic",
                "magenta" };
        JComboBox<String> sidePanelTheme = new JComboBox<>(sidePanel);
        JComboBox<String> backgroundTheme = new JComboBox<>(background);
        JComboBox<String> dialogTheme = new JComboBox<>(dialog);
        sidePanelTheme.setBounds(20, 350, 140, 25);
        backgroundTheme.setBounds(180, 350, 140, 25);
        dialogTheme.setBounds(340, 350, 140, 25);

        JButton apply = new JButton("Apply");
        apply.setBounds(50, 400, 200, 25);
        add(apply);

        JButton save = new JButton("Save");
        apply.setBounds(250, 400, 200, 25);
        add(apply);

        add(sidePanelTheme);
        add(backgroundTheme);
        add(dialogTheme);

        apply.addActionListener(e -> {

            int sp = sidePanelTheme.getSelectedIndex();
            int bcg = backgroundTheme.getSelectedIndex();
            int dlg = dialogTheme.getSelectedIndex();

            switch (bcg) {
                case 1:
                    bcgc = Color.cyan;
                    break;
                case 2:
                    bcgc = Color.gray;
                    break;
                case 3:
                    bcgc = new Color(0x00FF00);
                    break;
                case 4:
                    bcgc = Color.orange;
                    break;
                case 5:
                    bcgc = new Color(0xF2F2F2);
                    break;
                case 6:
                    bcgc = new Color(0x393E46);
                    break;
                case 7:
                    bcgc = new Color(0x440000);
                    break;
                case 8:
                    bcgc = new Color(0x363333);
                    break;
                case 9:
                    bcgc = Color.magenta;
                    break;
            }
            switch (sp) {
                case 1:
                    spc = Color.cyan;
                    break;
                case 2:
                    spc = Color.gray;
                    break;
                case 3:
                    spc = new Color(0x00FF00);
                    break;
                case 4:
                    spc = Color.orange;
                    break;
                case 5:
                    spc = new Color(0xF2F2F2);
                    break;
                case 6:
                    spc = new Color(0x393E46);
                    break;
                case 7:
                    spc = new Color(0x440000);
                    break;
                case 8:
                    spc = new Color(0x363333);
                    break;
                case 9:
                    spc = Color.magenta;
                    break;
            }
            switch (dlg) {
                case 1:
                    dlgc = Color.cyan;
                    break;
                case 2:
                    dlgc = Color.gray;
                    break;
                case 3:
                    dlgc = new Color(0x00FF00);
                    break;
                case 4:
                    dlgc = Color.orange;
                    break;
                case 5:
                    dlgc = new Color(0xF2F2F2);
                    break;
                case 6:
                    dlgc = new Color(0x393E46);
                    break;
                case 7:
                    dlgc = new Color(0x440000);
                    break;
                case 8:
                    dlgc = new Color(0x363333);
                    break;
                case 9:
                    dlgc = Color.magenta;
                    break;
            }
            //    currentUser.theme.sidePanel.setTheme();
            System.out.println(spc);
            System.out.println(dlgc);
            System.out.println(bcgc);

            example[0].setBackground(spc);
            example[1].setBackground(currentUser.theme.sidePanel.exit);
            example[2].setBackground(bcgc);
            example[3].setBackground(dlgc);
            repaint();
            revalidate();

        });
        save.addActionListener(e -> {//    currentUser.theme.sidePanel.setTheme(spc.getSelectedItem,bcg.getSelectedItem,dlg.getSelectedItem)
        });

        this.setBackground(currentUser.theme.dialog.background);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        for (int i = 0; i < example.length; i++) {
            if (i != 3)
                layeredPane.add(example[i], 0);
            else
                layeredPane.add(example[i], 0);

            example[i].setVisible(true);
        }
        layeredPane.setLayout(null);
        this.add(layeredPane);
        this.setLayout(null);
        this.setVisible(true);

    }

}
