package Customer;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import General.*;

public class CustomerProducts extends JPanel {
    private static final long serialVersionUID = -5041356023670838909L;

    Product[] allProducts;
    int Count;
    Customer currentUser;
    CustomerFrame parent;

    CustomerProducts(Customer user, CustomerFrame p) {
        parent = p;
        currentUser = user;
        readData();

        JPanel data = new JPanel();
        data.setLayout(null);

        for (int i = 0; i < allProducts.length; i++) {
            int height = 20 + (i / 2) * 120;
            int width = 40 + (i % 2) * 320;

            JButton productButton = new JButton();
            productButton.setText(allProducts[i].name);
            productButton.setBounds(width, height, 265, 100);
            productButton.addActionListener(e -> openProduct(productButton));

            data.add(productButton);
        }

        data.setPreferredSize(new Dimension(660, (Count + 1) / 2 * 120 + 20));
        data.setBackground(currentUser.theme.main.background);

        JScrollPane PanelScroll = new JScrollPane(data);
        PanelScroll.setBounds(10, 10, 680, 680);
        PanelScroll.setBorder(null);
        PanelScroll.getVerticalScrollBar().setBackground(currentUser.theme.main.background);
        PanelScroll.getVerticalScrollBar().setBorder(null);
        PanelScroll.getVerticalScrollBar().setUnitIncrement(10);
        PanelScroll.setBackground(currentUser.theme.main.background);

        add(PanelScroll);
        setLayout(null);
        setBackground(currentUser.theme.main.background);
        setBorder(null);
        setVisible(true);
        revalidate();
        repaint();
    }

    public void readData() {
        try {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));
            allProducts = (Product[]) input.readObject();
            Count = allProducts.length;
            input.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void openProduct(JButton b) {
        int index = (b.getX() / 325) + 2 * (b.getY() / 120);
        new CustomerBuyPanel(currentUser, allProducts[index]);
    }
}
