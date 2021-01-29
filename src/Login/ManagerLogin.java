package Login;

import javax.swing.*;
import General.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import Manager.*;

public class ManagerLogin extends JPanel {
    private static final long serialVersionUID = -1162705529960593804L;

    int width = 900, height = 700;
    CustomTextField UserNameTF;
    JPasswordField PassWordPF;
    JLabel ShowPass;
    JLabel Title;
    JLabel UserText;
    JLabel Passtext;
    JButton Login;
    JButton ShowPassText;
    MainFrame parent;

    public ManagerLogin(MainFrame p) {
        ImageIcon ShowPasswords = new ImageIcon(
                System.getProperty("user.dir") + "\\Images\\Icons\\Login\\Show_Password.png");
        ImageIcon HidePasswords = new ImageIcon(
                System.getProperty("user.dir") + "\\Images\\Icons\\Login\\Hide_Password.png");
        parent = p;
        RightClick();
        parent.setIconImage(
                new ImageIcon(System.getProperty("user.dir") + "\\Images\\Frame Icons\\Manager.png").getImage());
        parent.setTitle("Manager");
        setLayout(null);
        Title = new JLabel("Manager");
        Title.setBackground(new Color(238, 238, 238));
        Title.setFont(new Font("Tahoma", Font.BOLD, 48));
        Title.setOpaque(true);
        Title.setBounds(320, 15, 344, 80);
        add(Title);

        UserText = new JLabel("Username");
        UserText.setBounds(50, 160, 135, 68);
        UserText.setFont(new Font("Tahoam", Font.BOLD, 24));
        UserText.setBackground(new Color(238, 238, 238));
        UserText.setOpaque(true);

        Passtext = new JLabel("Password");
        Passtext.setBounds(50, 270, 135, 68);
        Passtext.setFont(new Font("Tahoma", Font.BOLD, 24));
        Passtext.setBackground(new Color(238, 238, 238));
        Passtext.setOpaque(true);

        UserNameTF = new CustomTextField(195, 160, 595, 60, new Font("Tahoma", Font.BOLD, 24), new Color(238, 238, 238),
                Color.black, "");
        UserNameTF.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    check();
                } else if (key == KeyEvent.VK_ESCAPE) {
                    parent.addPanel(new SelectPage(parent));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        PassWordPF = new JPasswordField();
        PassWordPF.setBounds(195, 270, 595, 60);
        PassWordPF.setFont(new Font("Tahoma", Font.BOLD, 24));
        PassWordPF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        PassWordPF.setBackground(new Color(238, 238, 238));
        PassWordPF.setDocument(new Limitter(16));
        PassWordPF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                PassWordPF.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 116, 232)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                PassWordPF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            }
        });
        PassWordPF.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    check();
                } else if (key == KeyEvent.VK_ESCAPE) {
                    parent.addPanel(new SelectPage(parent));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        ShowPass = new JLabel();
        ShowPass.setBounds(195, 343, 595, 30);

        Login = new JButton("Login");
        Login.setBounds(50, 585, 800, 62);
        Login.setBackground(new Color(111, 207, 151));
        Login.setFont(new Font("Tahoma", Font.BOLD, 24));
        Login.addActionListener((e) -> check());
        Login.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    check();
                } else if (key == KeyEvent.VK_ESCAPE) {
                    parent.addPanel(new SelectPage(parent));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        ShowPassText = new JButton();
        ShowPassText.setIcon(ShowPasswords);
        ShowPassText.setBorder(null);
        ShowPassText.setFocusable(false);
        ShowPassText.setBounds(805, 285, 30, 30);
        ShowPassText.setBackground(new Color(238, 238, 238));
        ShowPass.setFont(new Font("Tahoma", Font.ITALIC, 16));

        ShowPassText.addActionListener((e) -> {
            if (ShowPassText.getIcon().equals(ShowPasswords)) {
                PassWordPF.setEchoChar((char) 0);
                ShowPassText.setIcon(HidePasswords);
            } else {
                PassWordPF.setEchoChar('\u2022');
                ShowPassText.setIcon(ShowPasswords);
            }
        });

        add(UserText);
        add(Passtext);
        add(UserNameTF);
        add(PassWordPF);
        add(Login);
        add(ShowPass);
        add(ShowPassText);
    }

    public void check() {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Manager.dat"));
            Manager m = (Manager) reader.readObject();
            reader.close();

            if (m.password.equals(new String(PassWordPF.getPassword())) && m.username.equals(UserNameTF.getText())) {
                parent.dispose();
                new ManagerFrame(m);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Username/Password.", "Error", 0);
                return;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void RightClick() {
        JPopupMenu RightClicked = new JPopupMenu();
        JMenuItem RightItemReturn = new JMenuItem("Return To Previous Page");
        RightItemReturn.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Return.png"));
        JMenuItem RightItemExit = new JMenuItem("Exit                  ");
        RightItemExit.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Logout.png"));
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent ME) {
                if (SwingUtilities.isRightMouseButton(ME)) {
                    RightClicked.show(ME.getComponent(), ME.getX(), ME.getY());
                }
            }
        });
        RightItemExit.addActionListener((e) -> System.exit(0));
        RightItemReturn.addActionListener((e) -> parent.addPanel(new SelectPage(parent)));
        RightClicked.add(RightItemReturn);
        RightClicked.add(RightItemExit);
        this.add(RightClicked);
    }
}