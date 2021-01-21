package Customer;

import javax.swing.*;
import java.awt.*;
import General.*;

public class CustomerOrderHistory extends JPanel {
    JPanel Info;
    int Count = 50;
    User currentUser;
    JFrame parrent;

    public CustomerOrderHistory(Customer u, CustomerFrame p) {
        currentUser = u;
        parrent = p;
        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));
        Info.setPreferredSize(new Dimension(660, Count * 40));

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
