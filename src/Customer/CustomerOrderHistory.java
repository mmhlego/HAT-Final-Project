package Customer;

import javax.swing.*;
import javax.swing.border.*;
import General.*;
import java.awt.*;

public class CustomerOrderHistory extends JPanel {
    private static final long serialVersionUID = 1804560967908766564L;

    JPanel Info;
    int Count;
    Customer currentUser;
    CustomerFrame parent;

    public CustomerOrderHistory(Customer c, CustomerFrame p) {
        currentUser = c;
        parent = p;
        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));

        Count = currentUser.pastOrders.length;
        System.out.println(Count);

        for (int i = 0; i < Count; i++) {
            JButton button = new JButton("Order #" + (Count - i));
            button.setBorder(null);
            button.setBounds(50, 50 + i * 60, 560, 40);
            button.addActionListener((e) -> show(button));
            button.setBackground(currentUser.theme.sidePanel.background);
            button.setFont(currentUser.theme.main.font);
            add(button);
        }

        Info.setPreferredSize(new Dimension(660, 130 + Count * 60));

        setLayout(null);
        Info.setBackground(currentUser.theme.main.background);

        JScrollPane PanelScroll = new JScrollPane(Info);
        PanelScroll.setBorder(null);
        PanelScroll.setBounds(10, 10, 680, 680);
        PanelScroll.getVerticalScrollBar().setBackground(currentUser.theme.main.background);
        PanelScroll.getVerticalScrollBar().setBorder(null);
        PanelScroll.getVerticalScrollBar().setUnitIncrement(10);
        PanelScroll.setBackground(currentUser.theme.main.background);

        add(PanelScroll);

        setBackground(currentUser.theme.main.background);
        setVisible(true);
    }

    public void show(JButton b) {
        int index = (b.getY() - 50) / 60;
        showOrder(currentUser.pastOrders[index]);
    }

    public void showOrder(Order o) {
        try {
            int length = o.products.length + 2;
            long totalPrice = 0;
            CustomScrollDialog dialog = new CustomScrollDialog(length);

            JLabel productLabel = new JLabel("Product", 0);
            productLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.gray));
            dialog.addLabel(productLabel, 0, 0);

            JLabel amountLabel = new JLabel("Amount", 0);
            amountLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.gray));
            dialog.addLabel(amountLabel, 0, 1);

            JLabel priceLabel = new JLabel("Price", 0);
            priceLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.gray));
            dialog.addLabel(priceLabel, 0, 2);

            for (int i = 0; i < length - 2; i++) {
                long p = o.products[i].price;
                int c = o.count[i];
                dialog.addLabel(new JLabel(o.products[i].name, 0), 1 + i, 0);
                dialog.addLabel(new JLabel(Integer.toString(c), 0), 1 + i, 1);
                if (o.products[i].discount > 0) {
                    int dis = 100 - o.products[i].discount;
                    dialog.addLabel(new JLabel(c + "*" + Long.toString(p) + "*" + dis + "%", 0), 1 + i, 2);
                    totalPrice += c * p * dis / 100;
                } else {
                    dialog.addLabel(new JLabel(c + "*" + Long.toString(p), 0), 1 + i, 2);
                    totalPrice += c * p;
                }
            }
            JLabel empty = new JLabel("", 0);
            empty.setBorder(new MatteBorder(1, 0, 0, 0, Color.gray));
            dialog.addLabel(empty, length - 1, 0);

            JLabel tpl = new JLabel("Total price: ", 0);
            tpl.setBorder(new MatteBorder(1, 0, 0, 0, Color.gray));
            dialog.addLabel(tpl, length - 1, 1);

            JLabel tp = new JLabel(Long.toString(totalPrice), 0);
            tp.setBorder(new MatteBorder(1, 0, 0, 0, Color.gray));
            dialog.addLabel(tp, length - 1, 2);

        } catch (NullPointerException n) {
            System.out.println("null");
            CustomScrollDialog dialog = new CustomScrollDialog(1);
            dialog.addLabel(new JLabel("Cart is empty.", 0), 0, 1);
        }
    }
}
