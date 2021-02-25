package Employee;

import javax.swing.*;
import java.awt.*;
import General.*;

public class EmployeeTheme extends JDialog {
    private static final long serialVersionUID = -7114970084885205201L;

    EmployeeFrame parent;
    Employee currentUser;
    EmployeeSetting root;
    Color bcgc, spc, dlgc;
    Theme currentTheme = new Theme();
    int width = 500, height = 500;

    public EmployeeTheme(EmployeeFrame p, EmployeeSetting r, Employee u) {
        parent = p;
        currentUser = u;
        root = r;

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(100, 20, 300, 300);
        layeredPane.setLayout(null);
        setSize(width + 18, height);
        setLocationRelativeTo(null);

        JPanel sidePanel = new JPanel();
        sidePanel.setToolTipText(currentUser.language.theme.sidePreview);
        JPanel exitPanel = new JPanel();
        exitPanel.setToolTipText(currentUser.language.theme.exitPreview);
        JPanel mainPanel = new JPanel();
        mainPanel.setToolTipText(currentUser.language.theme.mainPreview);
        JPanel dialogPanel = new JPanel();
        dialogPanel.setToolTipText(currentUser.language.theme.dialogPreview);

        sidePanel.setBounds(0, 0, 50, 280);
        sidePanel.setBackground(currentUser.theme.sidePanel.background);
        exitPanel.setBackground(currentTheme.sidePanel.exitColor);
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

        JLabel sideColorLabel = new JLabel(currentUser.language.theme.sideTheme, 0);
        sideColorLabel.setBounds(20, 320, 140, 30);
        add(sideColorLabel);
        JLabel mainColorLabel = new JLabel(currentUser.language.theme.mainTheme, 0);
        mainColorLabel.setBounds(180, 320, 140, 30);
        add(mainColorLabel);
        JLabel dialogColorLabel = new JLabel(currentUser.language.theme.dialogTheme, 0);
        dialogColorLabel.setBounds(340, 320, 140, 30);
        add(dialogColorLabel);

        JComboBox<String> sidePanelTheme = new JComboBox<>(sidePanelCombos);
        JComboBox<String> backgroundTheme = new JComboBox<>(backgroundCombos);
        JComboBox<String> dialogTheme = new JComboBox<>(dialogCombos);
        sidePanelTheme.setBounds(20, 350, 140, 25);
        backgroundTheme.setBounds(180, 350, 140, 25);
        dialogTheme.setBounds(340, 350, 140, 25);
        sidePanelTheme.setSelectedIndex(currentUser.theme.sidePanel.mode);
        backgroundTheme.setSelectedIndex(currentUser.theme.main.mode);
        dialogTheme.setSelectedIndex(currentUser.theme.dialog.mode);

        setIconImage(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Frame Icons\\Theme.png").getImage());
        setTitle(currentUser.language.theme.themeCreator);

        JButton apply = new JButton(currentUser.language.theme.preview);
        apply.setBounds(20, 400, 210, 35);
        add(apply);

        JButton save = new JButton(currentUser.language.theme.apply);
        save.setBackground(currentUser.theme.submitColor);
        save.setBounds(270, 400, 210, 35);

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
            new EmployeeWriter(currentUser);
            dispose();
            parent.dispose();
            new EmployeeFrame(currentUser);
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
