package Customer;

import javax.swing.*;
import java.awt.*;
import General.*;

public class CustomerTheme extends JDialog {
    private static final long serialVersionUID = -7114970084885205201L;

    CustomerFrame parent;
    Customer currentUser;
    CustomerSetting root;
    Color bcgc, spc, dlgc;
    Theme currentTheme = new Theme();

    public CustomerTheme(CustomerFrame p, CustomerSetting r, Customer u) {
        parent = p;
        currentUser = u;
        root = r;

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

        String[] sidePanelCombos = { "Light(default)", "Dark", "Classic", "Modern", "Cyan", "Silver", "Lime", "Orange",
                "Brown", "Magenta" };
        String[] backgroundCombos = { "Light(default)", "Dark", "Classic", "Modern", "Cyan", "Silver", "Lime", "Orange",
                "Brown", "Magenta" };
        String[] dialogCombos = { "Light(default)", "Dark", "Classic", "Modern", "Cyan", "Silver", "Lime", "Orange",
                "Brown", "Magenta" };

        JComboBox<String> sidePanelTheme = new JComboBox<>(sidePanelCombos);
        JComboBox<String> backgroundTheme = new JComboBox<>(backgroundCombos);
        JComboBox<String> dialogTheme = new JComboBox<>(dialogCombos);
        sidePanelTheme.setBounds(20, 350, 140, 25);
        backgroundTheme.setBounds(180, 350, 140, 25);
        dialogTheme.setBounds(340, 350, 140, 25);
        sidePanelTheme.setSelectedIndex(currentUser.theme.sidePanel.mode);
        backgroundTheme.setSelectedIndex(currentUser.theme.main.mode);
        dialogTheme.setSelectedIndex(currentUser.theme.dialog.mode);

        JButton apply = new JButton("Preview");
        apply.setBounds(50, 400, 200, 25);
        add(apply);

        JButton save = new JButton("Apply");
        save.setBounds(250, 400, 200, 25);
        add(save);
        add(sidePanelTheme);
        add(backgroundTheme);
        add(dialogTheme);

        apply.addActionListener(e -> {

            int siedPanelIndex = sidePanelTheme.getSelectedIndex();
            int backgroundPanelIndex = backgroundTheme.getSelectedIndex();
            int dialogPanelIndex = dialogTheme.getSelectedIndex();

            currentTheme.setTheme(siedPanelIndex, backgroundPanelIndex, dialogPanelIndex);

            sidePanel.setBackground(currentTheme.sidePanel.background);
            exitPanel.setBackground(currentTheme.sidePanel.exitColor);
            mainPanel.setBackground(currentTheme.main.background);
            dialogPanel.setBackground(currentTheme.dialog.background);
            repaint();
            revalidate();

        });
        save.addActionListener(e -> {
            int siedPanelIndex = sidePanelTheme.getSelectedIndex();
            int backgroundPanelIndex = backgroundTheme.getSelectedIndex();
            int dialogPanelIndex = dialogTheme.getSelectedIndex();

            currentUser.theme.setTheme(siedPanelIndex, backgroundPanelIndex, dialogPanelIndex);
            root.openAndSaveData(currentUser);
            dispose();
            parent.dispose();
            new CustomerFrame(currentUser);
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
