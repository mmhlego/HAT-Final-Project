import javax.swing.*;

public class MainFrame extends JFrame {
        int width = 900, height = 700;
        JPanel main;

        public MainFrame() {
                setSize(width + 13, height + 37);
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
        }

}
