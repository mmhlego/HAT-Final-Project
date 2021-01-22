package Login;

import javax.swing.*;

public class MainFrame extends JFrame {
        private static final long serialVersionUID = 7805359497555580409L;

        int width = 900, height = 700;
        JPanel main;

        public MainFrame() {
                setTitle("Select Role");
                setSize(width + 13, height + 37);
                setLocationRelativeTo(null);
                addPanel(new SelectPage(this));
                setDefaultCloseOperation(3);
                setResizable(false);
                setVisible(true);
        }

        public void addPanel(JPanel x) {
                if (main != null) {
                        remove(main);
                }
                main = x;
                add(main);
                revalidate();
                repaint();
        }

}
