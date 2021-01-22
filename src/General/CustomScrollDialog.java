package General;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class CustomScrollDialog extends JDialog {
    private static final long serialVersionUID = -687295492451054876L;

    public JPanel panel = new JPanel();
    private int i = 0, w = 420;

    public CustomScrollDialog(int Count) {

        setLayout(null);
        setSize(460, 400);
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(440, 350));

        if (Count > 7) {
            w = 400;
            panel.setPreferredSize(new Dimension(440, Count * 50 + 20));
        }

        JScrollPane Scroller = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Scroller.setBounds(0, 0, 460, 350);
        Scroller.setBorder(null);
        Scroller.getVerticalScrollBar().setBorder(null);
        Scroller.getVerticalScrollBar().setUnitIncrement(10);

        JButton Return = new JButton("Return");
        Return.setBounds(10, 360, 440, 30);
        Return.addActionListener((e) -> dispose());

        getRootPane().setBorder(new LineBorder(Color.BLACK, 1));
        add(Return);
        add(Scroller);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);
    }

    public void addButton(JButton b) {
        b.setBounds(20, 20 + i * 50, w, 30);
        i++;
        panel.add(b);
    }

    public void addButton(JButton b, int row) {
        b.setBounds(20, 20 + row * 50, w, 30);
        panel.add(b);
    }

    public void addLabel(JLabel l, int row, int side) {
        l.setBounds(20 + w / 3 * side, 20 + row * 50, w / 3, 30);
        panel.add(l);
    }
}
