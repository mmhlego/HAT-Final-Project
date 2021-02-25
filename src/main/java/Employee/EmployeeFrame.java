package Employee;

import javax.swing.*;
import java.awt.*;
import Login.*;
import java.awt.event.*;

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
        RightClick();
    }

    public void design() {
        setLayout(null);
        // ===================================================================================
        sidepanel = new JPanel();
        sidepanel.setLayout(null);
        sidepanel.setBackground(currentUser.theme.sidePanel.background);
        sidepanel.setBounds(0, 0, w, height);
        // ===================================================================================
        Change = new JButton(currentUser.language.side.toggle);
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
        Change.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Side\\"
                + currentUser.theme.sidePanel.icon + "Menu.png"));
        reDesign(Change);
        sidepanel.add(Change);
        // ===================================================================================
        Customers = new JButton(currentUser.language.side.customers);
        Customers.setBounds(0, h, w, h);
        Customers.setFont(currentUser.theme.sidePanel.font);
        Customers.setForeground(currentUser.theme.sidePanel.fontColor);
        Customers.addActionListener((e) -> {
            selectButton(Customers);
            addPanel(new EmployeeCustomers(currentUser, this));
        });
        Customers.setIconTextGap(-180);
        Customers.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Side\\"
                + currentUser.theme.sidePanel.icon + "Customers.png"));
        reDesign(Customers);
        sidepanel.add(Customers);
        // ===================================================================================
        Products = new JButton(currentUser.language.side.products);
        Products.setBounds(0, 2 * h, w, h);
        Products.setFont(currentUser.theme.sidePanel.font);
        Products.setForeground(currentUser.theme.sidePanel.fontColor);
        Products.addActionListener((e) -> {
            selectButton(Products);
            addPanel(new EmployeeProducts(currentUser, this));
        });
        Products.setIconTextGap(-180);
        Products.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Side\\"
                + currentUser.theme.sidePanel.icon + "Products.png"));
        reDesign(Products);
        sidepanel.add(Products);
        // ===================================================================================
        Settings = new JButton(currentUser.language.side.settings);
        Settings.setBounds(0, 3 * h, w, h);
        Settings.setFont(currentUser.theme.sidePanel.font);
        Settings.setForeground(currentUser.theme.sidePanel.fontColor);
        Settings.addActionListener((e) -> {
            selectButton(Settings);
            addPanel(new EmployeeSetting(this, currentUser));
        });
        Settings.setIconTextGap(-180);
        Settings.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Side\\"
                + currentUser.theme.sidePanel.icon + "Settings.png"));
        reDesign(Settings);
        sidepanel.add(Settings);
        // ===================================================================================
        Exit = new JButton(currentUser.language.side.exit);
        Exit.setBounds(0, height - h, w, h);
        Exit.setFont(currentUser.theme.sidePanel.font);
        Exit.setForeground(currentUser.theme.sidePanel.fontColor);
        Exit.addActionListener((e) -> selectExit());
        Exit.setBorder(null);
        Exit.setBackground(new Color(250, 67, 67));
        Exit.setIconTextGap(-180);
        Exit.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Side\\"
                + currentUser.theme.sidePanel.icon + "Exit.png"));
        sidepanel.add(Exit);
        // ===================================================================================
        add(sidepanel);
        setFont(currentUser.theme.main.font);
        setForeground(currentUser.theme.main.fontColor);
        getContentPane().setBackground(currentUser.theme.main.background);
        setSize(width + 5, height + 33);
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
        b.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Side\\"
                + currentUser.theme.sidePanel.icon + b.getText() + ".png"));
    }

    public void selectButton(JButton b) {
        resetColors();
        b.setForeground(currentUser.theme.main.fontColor);
        b.setBackground(currentUser.theme.main.background);
        b.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Side\\" + currentUser.theme.main.icon
                + b.getText() + ".png"));
    }

    public void addPanel(JPanel panel) {
        if (main != null) {
            remove(main);
        }
        main = panel;
        main.setBounds(w, 0, 700, height);
        // main.setBounds(w, 0, width - w, height);
        add(main);
        revalidate();
        repaint();
    }

    public void selectExit() {
        JDialog dialog = new JDialog();
        dialog.setTitle(currentUser.language.side.exit);
        dialog.setSize(250, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setLayout(new GridLayout(1, 0));

        JButton Exit = new JButton(currentUser.language.exit);
        Exit.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Exit.png"));
        Exit.setBackground(new Color(215, 38, 61));
        Exit.setFont(new Font("Arial", Font.BOLD, 13));
        Exit.setFocusable(false);
        JButton LogOut = new JButton(currentUser.language.logOut);
        LogOut.setBackground(new Color(255, 177, 61));
        LogOut.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\LogOut.png"));
        LogOut.setFont(new Font("Arial", Font.BOLD, 13));
        LogOut.setFocusable(false);
        Exit.addActionListener((e) -> {
            dialog.dispose();
            System.exit(0);
        });
        LogOut.addActionListener((e) -> {
            dialog.dispose();
            dispose();
            new MainFrame();
        });

        dialog.add(Exit);
        dialog.add(LogOut);
        dialog.setVisible(true);
    }

    public void RightClick() {
        JPopupMenu RightClicked = new JPopupMenu();
        JMenuItem RightItemCustomers = new JMenuItem(currentUser.language.side.customers);
        RightItemCustomers.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Customer.png"));
        JMenuItem RightItemProducts = new JMenuItem(currentUser.language.side.products);
        RightItemProducts.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Product.png"));
        JMenuItem RightItemSettings = new JMenuItem(currentUser.language.side.settings);
        RightItemSettings.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Settings.png"));
        JMenuItem RightItemLogOutExit = new JMenuItem(currentUser.language.side.exit + "                  ");
        RightItemLogOutExit.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Logout.png"));
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent ME) {
                if (SwingUtilities.isRightMouseButton(ME)) {
                    RightClicked.show(ME.getComponent(), ME.getX(), ME.getY());
                }
            }
        });
        RightItemCustomers.addActionListener((e) -> {
            selectButton(Customers);
            addPanel(new EmployeeCustomers(currentUser, this));
        });
        RightItemProducts.addActionListener((e) -> {
            selectButton(Products);
            addPanel(new EmployeeProducts(currentUser, this));
        });
        RightItemSettings.addActionListener((e) -> {
            selectButton(Settings);
            addPanel(new EmployeeSetting(this, currentUser));
        });
        RightItemLogOutExit.addActionListener((e) -> selectExit());
        RightClicked.add(RightItemCustomers);
        RightClicked.add(RightItemProducts);
        RightClicked.add(RightItemSettings);
        RightClicked.add(RightItemLogOutExit);
        this.add(RightClicked);
    }

}