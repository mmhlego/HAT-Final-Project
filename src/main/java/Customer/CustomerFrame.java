package Customer;

import General.*;
import javax.swing.*;
import java.awt.*;

public class CustomerFrame extends JFrame {

    JButton History, Cart, Products, Settings, Exit, Change;
    JPanel sidepanel, main;
    Customer currentUser;
    boolean open = true;

    int width = 900, height = 700;
    int w = 200, h = 60;

    public CustomerFrame(Customer c) {
        currentUser = c;
        design();
        addPanel(new CustomerMain(currentUser, this));
    }

    public void design() {
        setLayout(null);

        sidepanel = new JPanel();
        sidepanel.setLayout(null);
        sidepanel.setBackground(currentUser.theme.sidepanel);
        sidepanel.setBounds(0, 0, w, height);
        //===================================================================================
        Change = new JButton("Toggle SidePanel");
        Change.setBounds(0, 0, w, h);
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
        History = new JButton("Order History");
        History.setBounds(0, h, w, h);
        History.addActionListener((e) -> {
            resetColors();
            History.setBackground(currentUser.theme.background);

            //addPanel(new ManagerCostumers());
        });
        History.setIconTextGap(-180);
        History.setIcon(new CustomIcon(currentUser.theme.icon + "history", 40, 40));
        reDesign(History);
        sidepanel.add(History);
        //===================================================================================
        Cart = new JButton("Cart");
        Cart.setBounds(0, 2 * h, w, h);
        Cart.addActionListener((e) -> {
            resetColors();
            Cart.setBackground(currentUser.theme.background);

            //addPanel(new ManagerEmployees());
        });
        Cart.setIconTextGap(-180);
        Cart.setIcon(new CustomIcon(currentUser.theme.icon + "cart", 40, 40));
        reDesign(Cart);
        sidepanel.add(Cart);
        //===================================================================================
        Products = new JButton("Products");
        Products.setBounds(0, 3 * h, w, h);
        Products.addActionListener((e) -> {
            resetColors();
            Products.setBackground(currentUser.theme.background);

            //addPanel(new ManagerProducts());
        });
        Products.setIconTextGap(-180);
        Products.setIcon(new CustomIcon(currentUser.theme.icon + "products", 40, 40));
        reDesign(Products);
        sidepanel.add(Products);
        //===================================================================================
        Settings = new JButton("Settings");
        Settings.setBounds(0, 4 * h, w, h);
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
        Exit.addActionListener((e) -> System.exit(0));
        Exit.setBorder(null);
        Exit.setBackground(new Color(250, 67, 67));
        Exit.setIconTextGap(-180);
        Exit.setIcon(new CustomIcon(currentUser.theme.icon + "exit", 40, 40));
        sidepanel.add(Exit);
        //===================================================================================
        add(sidepanel);
        setFont(currentUser.theme.font);
        setBackground(currentUser.theme.background);
        setSize(width + 13, height + 37);
        setDefaultCloseOperation(3);
        setResizable(false);
        setVisible(true);
    }

    public void resetColors() {
        reDesign(History);
        reDesign(Cart);
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
