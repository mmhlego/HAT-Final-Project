import javax.swing.*;
import java.awt.*;
import java.io.*;
import General.*;
import Employee.*;

public class EmployeeLogin extends JPanel {
    private static final long serialVersionUID = 6637516719468314848L;

    JTextField UserNameTF;
    JPasswordField PassWordPF;
    MainFrame parent;

    public EmployeeLogin(MainFrame p) {
        ImageIcon ShowPasswords = new CustomIcon("Show_Password", 28, 28);
        ImageIcon HidePasswords = new CustomIcon("Hide_Password", 28, 28);
        parent = p;
        parent.setIconImage(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Frame Icons\\Employee.png").getImage());
        parent.setTitle("Employee");
        setLayout(null);
        JLabel Title = new JLabel("Employee");
        Title.setBackground(new Color(238, 238, 238));
        Title.setFont(new Font("Tahoma", Font.BOLD, 48));
        Title.setOpaque(true);
        Title.setBounds(320, 15, 344, 80);
        this.add(Title);

        JLabel UserText = new JLabel("Username");
        UserText.setBounds(50, 160, 135, 68);
        UserText.setFont(new Font("Tahoam", Font.BOLD, 24));
        UserText.setBackground(new Color(238, 238, 238));
        UserText.setOpaque(true);

        JLabel Passtext = new JLabel("Password");
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

        PassWordPF = new JPasswordField();
        PassWordPF.setBounds(195, 270, 595, 60);
        PassWordPF.setFont(new Font("Tahoma", Font.BOLD, 24));
        PassWordPF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        PassWordPF.setBackground(new Color(238, 238, 238));
        PassWordPF.setDocument(new Limitter(16));

        JLabel ShowPass = new JLabel();
        ShowPass.setBounds(195, 343, 595, 30);

        JButton Login = new JButton("Login");
        Login.setBounds(50, 585, 800, 62);
        Login.setBackground(new Color(111, 207, 151));
        Login.setFont(new Font("Tahoma", Font.BOLD, 24));
        Login.addActionListener((e) -> check());

        JButton ShowPassText = new JButton();
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

        this.add(UserText);
        this.add(Passtext);
        this.add(UserNameTF);
        this.add(PassWordPF);
        this.add(Login);
        this.add(ShowPass);
        this.add(ShowPassText);
    }

    public void check() {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Employees.dat"));
            Employee[] allEmployees = (Employee[]) reader.readObject();
            reader.close();

            String username = UserNameTF.getText();
            String password = new String(PassWordPF.getPassword());
            boolean hasAccount = false;

            int length = allEmployees.length;
            for (int i = 0; i < length; i++) {
                if (allEmployees[i].username.equals(username)) {
                    hasAccount = true;
                    if (allEmployees[i].password.equals(password)) {
                        parent.dispose();
                        new EmployeeFrame(allEmployees[i]);
                        return;
                    }
                }
            }

            if (hasAccount) {
                JOptionPane.showMessageDialog(this, "Wrong password.", "Error", 0);
            } else {
                JOptionPane.showMessageDialog(this, "No account has been found.", "Error", 0);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
