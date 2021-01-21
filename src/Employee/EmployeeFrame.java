package Employee;

import General.*;
import javax.swing.*;
import java.awt.*;

public class EmployeeFrame extends JFrame {
    private static final long serialVersionUID = -4792928874940825362L;

    JButton Customers, Products, Settings, Exit, Change;
    JPanel sidepanel, main;
    Employee currentUser;

    int width = 900, height = 700, w = 200, h = 60;
    boolean open = true;

    public EmployeeFrame(Employee e) {
        currentUser = e;
        design();
        addPanel(new EmployeeMain(currentUser, this));
    }

    public void design() {
        setLayout(null);
        //===================================================================================
        sidepanel = new JPanel();
        sidepanel.setLayout(null);
        sidepanel.setBackground(currentUser.theme.sidePanel.background);
        sidepanel.setBounds(0, 0, w, height);
        //===================================================================================
        Change = new JButton("Toggle SidePanel");
        Change.setBounds(0, 0, w, h);
        Change.setFont(currentUser.theme.sidePanel.font);
        Change.setForeground(currentUser.theme.sidePanel.fontColor);
        Change.addActionListener((e) -> {
            if (open) {
                sidepanel.setBounds(h - w, 0, w, height);

                w -= (w - h) / 2;
                addPanel(main);

                open = false;
            } else {
                w += (w - h);
                addPanel(main);

                sidepanel.setBounds(0, 0, w, height);

                open = true;
            }
            revalidate();
            repaint();
        });
        Change.setIconTextGap(-180);
        Change.setIcon(new CustomIcon(currentUser.theme.sidePanel.icon + "menu", 40, 40));
        reDesign(Change);
        sidepanel.add(Change);
        //===================================================================================
        Customers = new JButton("Customers");
        Customers.setBounds(0, h, w, h);
        Customers.setFont(currentUser.theme.sidePanel.font);
        Customers.setForeground(currentUser.theme.sidePanel.fontColor);
        Customers.addActionListener((e) -> {
            selectButton(Customers);
            addPanel(new EmployeeCustomers(currentUser, this));
        });
        Customers.setIconTextGap(-180);
        Customers.setIcon(new CustomIcon(currentUser.theme.sidePanel.icon + "customers", 40, 40));
        reDesign(Customers);
        sidepanel.add(Customers);
        //===================================================================================
        Products = new JButton("Products");
        Products.setBounds(0, 2 * h, w, h);
        Products.setFont(currentUser.theme.sidePanel.font);
        Products.setForeground(currentUser.theme.sidePanel.fontColor);
        Products.addActionListener((e) -> {
            selectButton(Products);
            addPanel(new EmployeeProducts(currentUser, this));
        });
        Products.setIconTextGap(-180);
        Products.setIcon(new CustomIcon(currentUser.theme.sidePanel.icon + "products", 40, 40));
        reDesign(Products);
        sidepanel.add(Products);
        //===================================================================================
        Settings = new JButton("Settings");
        Settings.setBounds(0, 3 * h, w, h);
        Settings.setFont(currentUser.theme.sidePanel.font);
        Settings.setForeground(currentUser.theme.sidePanel.fontColor);
        Settings.addActionListener((e) -> {
            selectButton(Settings);
            addPanel(new SettingsFrame(this, currentUser));
        });
        Settings.setIconTextGap(-180);
        Settings.setIcon(new CustomIcon(currentUser.theme.sidePanel.icon + "settings", 40, 40));
        reDesign(Settings);
        sidepanel.add(Settings);
        //===================================================================================
        Exit = new JButton("Exit");
        Exit.setBounds(0, height - h, w, h);
        Exit.setFont(currentUser.theme.sidePanel.font);
        Exit.setForeground(currentUser.theme.sidePanel.fontColor);
        Exit.addActionListener((e) -> System.exit(0));
        Exit.setBorder(null);
        Exit.setBackground(new Color(250, 67, 67));
        Exit.setIconTextGap(-180);
        Exit.setIcon(new CustomIcon(currentUser.theme.sidePanel.icon + "exit", 40, 40));
        sidepanel.add(Exit);
        //===================================================================================
        add(sidepanel);
        setFont(currentUser.theme.main.font);
        setForeground(currentUser.theme.main.fontColor);
        getContentPane().setBackground(currentUser.theme.main.background);
        setSize(width + 13, height + 37);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void resetColors() {
        reDesign(Customers);
        reDesign(Products);
        reDesign(Settings);
    }

    public void reDesign(JButton b) {
        b.setBorder(null);
        b.setForeground(currentUser.theme.sidePanel.fontColor);
        b.setBackground(currentUser.theme.sidePanel.background);
        if (!b.getText().equals(new String("Toggle SidePanel")))
            b.setIcon(new CustomIcon(currentUser.theme.sidePanel.icon + b.getText(), 40, 40));
    }

    public void selectButton(JButton b) {
        resetColors();
        b.setForeground(currentUser.theme.main.fontColor);
        b.setBackground(currentUser.theme.main.background);
        b.setIcon(new CustomIcon(currentUser.theme.main.icon + b.getText(), 40, 40));
    }

    public void addPanel(JPanel panel) {
        if (main != null) {
            remove(main);
        }
        main = panel;
        main.setBounds(w, 0, width - w, height);
        add(main);
        revalidate();
        repaint();
    }

}