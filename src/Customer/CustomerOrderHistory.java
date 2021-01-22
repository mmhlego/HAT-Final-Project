package Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerOrderHistory extends JPanel {
    private static final long serialVersionUID = 1804560967908766564L;

    JPanel Info;
    int Count = 50;
    Customer currentUser;
    JFrame parrent;

    public CustomerOrderHistory(Customer u, CustomerFrame p) {
        currentUser = u;
        parrent = p;
        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));
        Info.setPreferredSize(new Dimension(660, Count * 40));

        for (int i = 0; i < currentUser.pastOrders.length; i++) {
            currentUser.pastOrders[i].printData();
        }

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

    //private 
}
