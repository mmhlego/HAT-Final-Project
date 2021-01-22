package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import General.*;
import Manager.*;

public class ManagerLogin extends JPanel {
    private static final long serialVersionUID = -1162705529960593804L;

    int width = 900, height = 700;
    JTextField UserNameTF;
    JPasswordField PassWordPF;
    JLabel ShowPass;
    JLabel Title;
    JLabel UserText;
    JLabel Passtext;
    JButton Login;
    JButton ShowPassText;
    MainFrame parent;

    public ManagerLogin(MainFrame p) {
        ImageIcon ShowPasswords = new CustomIcon("Show_Password", 28, 28);
        ImageIcon HidePasswords = new CustomIcon("Hide_Password", 28, 28);
        parent = p;
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

        UserNameTF = new JTextField();
        UserNameTF.setBounds(195, 160, 595, 60);
        UserNameTF.setFont(new Font("Tahoma", Font.BOLD, 24));
        UserNameTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        UserNameTF.setBackground(new Color(238, 238, 238));
        UserNameTF.setDocument(new Limitter(20));
        UserNameTF.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    check();
                }
                if (key == KeyEvent.VK_ESCAPE) {
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
        PassWordPF.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    check();
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
}
