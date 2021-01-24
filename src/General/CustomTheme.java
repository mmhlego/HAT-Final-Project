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
        this.setBounds(100, 100, 500, 500);

        JPanel sidePanel = new JPanel();
        sidePanel.setToolTipText("Side Panel Prewiew");
        JPanel exitPanel = new JPanel();
        exitPanel.setToolTipText("Exit Prewiew");
        JPanel mainPanel = new JPanel();
        mainPanel.setToolTipText("Main Panel Prewiew");
        JPanel dialogPanel = new JPanel();
        dialogPanel.setToolTipText("Dialog Prewiew");

        sidePanel.setBounds(0, 0, 50, 280);
        sidePanel.setBackground(currentUser.theme.sidePanel.background);
        exitPanel.setBackground(Color.red);
        mainPanel.setBackground(currentUser.theme.main.background);
        dialogPanel.setBackground(currentUser.theme.dialog.background);
        exitPanel.setBounds(0, 280, 50, 20);
        mainPanel.setBounds(50, 0, 250, 300);
        dialogPanel.setBounds(125, 100, 100, 100);
        String[] sidePanelCombos = { "side panel theme", "cyan", "gray", "lime", "orange", "light", "dark", "brown",
                "classic", "magenta" };
        String[] backgroundCombos = { "background theme", "cyan", "gray", "lime", "orange", "light", "dark", "brown",
                "classic", "magenta" };
        String[] dialogCombos = { "dialog theme", "cyan", "gray", "lime", "orange", "light", "dark", "brown", "classic",
                "magenta" };
        JComboBox<String> sidePanelTheme = new JComboBox<>(sidePanelCombos);
        JComboBox<String> backgroundTheme = new JComboBox<>(backgroundCombos);
        JComboBox<String> dialogTheme = new JComboBox<>(dialogCombos);
        sidePanelTheme.setBounds(20, 350, 140, 25);
        backgroundTheme.setBounds(180, 350, 140, 25);
        dialogTheme.setBounds(340, 350, 140, 25);

        JButton apply = new JButton("Apply");
        apply.setBounds(50, 400, 200, 25);
        add(apply);

        JButton save = new JButton("Save");
        save.setBounds(250, 400, 200, 25);
        add(save);

        add(sidePanelTheme);
        add(backgroundTheme);
        add(dialogTheme);

        apply.addActionListener(e -> {

            //int siedPanelIndex = sidePanelTheme.getSelectedIndex();
            //int backgroundPanelIndex = backgroundTheme.getSelectedIndex();
            //int dialogPanelIndex = dialogTheme.getSelectedIndex();

            //    currentUser.theme.sidePanel.setTheme();*/

            sidePanel.setBackground(spc);
            exitPanel.setBackground(currentUser.theme.sidePanel.exitColor);
            mainPanel.setBackground(bcgc);
            dialogPanel.setBackground(dlgc);
            repaint();
            revalidate();

        });
        save.addActionListener(e -> {//    currentUser.theme.sidePanel.setTheme(spc.getSelectedItem,bcg.getSelectedItem,dlg.getSelectedItem)
        });

        this.setBackground(currentUser.theme.dialog.background);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        layeredPane.add(sidePanel, 0);
        layeredPane.add(exitPanel, 0);
        layeredPane.add(mainPanel, 0);
        layeredPane.add(dialogPanel, 0);

        layeredPane.setLayout(null);
        this.add(layeredPane);
        this.setLayout(null);
        this.setVisible(true);

    }

}
