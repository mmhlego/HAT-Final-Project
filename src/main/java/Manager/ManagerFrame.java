package Manager;

import General.*;
import javax.swing.*;
import java.awt.*;

public class ManagerFrame extends JFrame {

    JButton Customers, Employees, Products, Settings, Exit, Change;
    JPanel sidepanel, main;
    Manager currentUser;

    int width = 900, height = 700, w = 200, h = 60;
    boolean open = true;

    public ManagerFrame(Manager m) {
        currentUser = m;
        design();
        addPanel(new ManagerMain(currentUser, this));
    }

    public void design() {
        setLayout(null);
        //===================================================================================
        sidepanel = new JPanel();
        sidepanel.setLayout(null);
        sidepanel.setBackground(currentUser.theme.sidepanel);
        sidepanel.setBounds(0, 0, w, height);
        //===================================================================================
        Change = new JButton("Toggle SidePanel");
        Change.setBounds(0, 0, w, h);
        Change.setFont(currentUser.theme.font);
        Change.setForeground(currentUser.theme.fontColor);
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
        Change.setIcon(new CustomIcon(currentUser.theme.icon + "menu", 40, 40));
        reDesign(Change);
        sidepanel.add(Change);
        //===================================================================================
        Customers = new JButton("Customers");
        Customers.setBounds(0, h, w, h);
        Customers.setFont(currentUser.theme.font);
        Customers.setForeground(currentUser.theme.fontColor);
        Customers.addActionListener((e) -> {
            resetColors();
            Customers.setBackground(currentUser.theme.background);

            addPanel(new ManagerCustomers(currentUser, this));
        });
        Customers.setIconTextGap(-180);
        Customers.setIcon(new CustomIcon(currentUser.theme.icon + "customers", 40, 40));
        reDesign(Customers);
        sidepanel.add(Customers);
        //===================================================================================
        Employees = new JButton("Employees");
        Employees.setBounds(0, 2 * h, w, h);
        Employees.setFont(currentUser.theme.font);
        Employees.setForeground(currentUser.theme.fontColor);
        Employees.addActionListener((e) -> {
            resetColors();
            Employees.setBackground(currentUser.theme.background);

            addPanel(new ManagerEmployees(currentUser, this));
        });
        Employees.setIconTextGap(-180);
        Employees.setIcon(new CustomIcon(currentUser.theme.icon + "employees", 40, 40));
        reDesign(Employees);
        sidepanel.add(Employees);
        //===================================================================================
        Products = new JButton("Products");
        Products.setBounds(0, 3 * h, w, h);
        Products.setFont(currentUser.theme.font);
        Products.setForeground(currentUser.theme.fontColor);
        Products.addActionListener((e) -> {
            resetColors();
            Products.setBackground(currentUser.theme.background);

            addPanel(new ManagerProducts(currentUser, this));
        });
        Products.setIconTextGap(-180);
        Products.setIcon(new CustomIcon(currentUser.theme.icon + "products", 40, 40));
        reDesign(Products);
        sidepanel.add(Products);
        //===================================================================================
        Settings = new JButton("Settings");
        Settings.setBounds(0, 4 * h, w, h);
        Settings.setFont(currentUser.theme.font);
        Settings.setForeground(currentUser.theme.fontColor);
        Settings.addActionListener((e) -> {
            resetColors();
            Settings.setBackground(currentUser.theme.background);

            addPanel(new SettingsFrame(currentUser));
        });
        Settings.setIconTextGap(-180);
        Settings.setIcon(new CustomIcon(currentUser.theme.icon + "settings", 40, 40));
        reDesign(Settings);
        sidepanel.add(Settings);
        //===================================================================================
        Exit = new JButton("Exit");
        Exit.setBounds(0, height - h, w, h);
        Exit.setFont(currentUser.theme.font);
        Exit.setForeground(currentUser.theme.fontColor);
        Exit.addActionListener((e) -> System.exit(0));
        Exit.setBorder(null);
        Exit.setBackground(new Color(250, 67, 67));
        Exit.setIconTextGap(-180);
        Exit.setIcon(new CustomIcon(currentUser.theme.icon + "exit", 40, 40));
        sidepanel.add(Exit);
        //===================================================================================

        add(sidepanel);
        setFont(currentUser.theme.font);
        setForeground(currentUser.theme.fontColor);
        getContentPane().setBackground(currentUser.theme.background);
        System.out.println(getBackground());
        setBounds(300, 100, width + 5, height + 33);
        setDefaultCloseOperation(3);
        setResizable(false);
        setVisible(true);
    }

    public void resetColors() {
        reDesign(Customers);
        reDesign(Employees);
        reDesign(Products);
        reDesign(Settings);
    }

    public void reDesign(JButton b) {
        b.setBorder(null);
        b.setBackground(currentUser.theme.sidepanel);
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
