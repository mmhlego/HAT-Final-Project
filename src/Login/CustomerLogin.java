package Login;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import Customer.*;
import General.*;
import java.awt.event.*;

public class CustomerLogin extends JPanel {
    private static final long serialVersionUID = 8713185903009843822L;

    JTextField UserNameTF;
    JPasswordField PassWordPF;
    JButton Login;
    MainFrame parent;
    ImageIcon ShowPasswords = new CustomIcon("Show_Password", 28, 28);
    ImageIcon HidePasswords = new CustomIcon("Hide_Password", 28, 28);

    public CustomerLogin(MainFrame p) {
        parent = p;
        parent.setIconImage(
                new ImageIcon(System.getProperty("user.dir") + "\\Images\\Frame Icons\\Customer.png").getImage());
        parent.setTitle("Customer");
        setLayout(null);

        JLabel Title = new JLabel("Customer");
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
        UserNameTF.setDocument(new Limitter(20));
        UserNameTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        UserNameTF.setBackground(new Color(238, 238, 238));
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
        PassWordPF.setDocument(new Limitter(16));
        PassWordPF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        PassWordPF.setBackground(new Color(238, 238, 238));
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

        JLabel Createnew = new JLabel("Don’t have An Account ?");
        Createnew.setBounds(50, 524, 320, 51);
        Createnew.setFont(new Font("Tahoma", Font.BOLD, 17));

        JButton NewCustomer = new JButton("Create One !");
        NewCustomer.setBounds(260, 535, 120, 30);
        NewCustomer.setFocusable(false);
        NewCustomer.setBorder(null);
        NewCustomer.setFont(new Font("Tahoma", Font.BOLD, 17));
        NewCustomer.setForeground(new Color(47, 128, 237));
        NewCustomer.setBackground(new Color(238, 238, 238));
        NewCustomer.addActionListener((e) -> {
            UserNameTF.setEditable(false);
            PassWordPF.setEditable(false);
            Login.setEnabled(false);
            addNew();
        });

        Login = new JButton("Login");
        Login.setBounds(50, 585, 800, 62);
        Login.setBackground(new Color(111, 207, 151));
        Login.setFont(new Font("Tahoma", Font.BOLD, 24));
        Login.setEnabled(true);
        Login.addActionListener((e) -> check());

        JButton ShowPassText = new JButton();
        ShowPassText.setIcon(ShowPasswords);
        ShowPassText.setBorder(null);
        ShowPassText.setFocusable(false);
        ShowPassText.setBounds(805, 285, 30, 30);
        ShowPassText.setBackground(new Color(238, 238, 238));

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
        this.add(Createnew);
        this.add(NewCustomer);
        this.add(Login);
        this.add(ShowPassText);

    }

    public void addNew() {
        int h = 40, w = 200, margin = 40;
        //ImageIcon ShowPasswords = new CustomIcon("Show_Password", 20, 20);
        //ImageIcon HidePasswords = new CustomIcon("Hide_Password", 20, 20);

        JDialog dialog = new JDialog(parent, "Edit Information");

        JPanel editPanel = new JPanel();
        editPanel.setLayout(null);
        editPanel.setSize(3 * margin + 2 * w, 8 * margin + 7 * h);

        JLabel nameLabel = new JLabel("Name:", 4);
        nameLabel.setBounds(margin, margin, w, h);
        editPanel.add(nameLabel);

        JLabel lastNameLabel = new JLabel("Last Name:", 4);
        lastNameLabel.setBounds(margin, 2 * margin + h, w, h);
        editPanel.add(lastNameLabel);

        JLabel usernameLabel = new JLabel("Username:", 4);
        usernameLabel.setBounds(margin, 3 * margin + 2 * h, w, h);
        editPanel.add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password:", 4);
        passwordLabel.setBounds(margin, 4 * margin + 3 * h, w, h);
        editPanel.add(passwordLabel);

        JLabel AddresslLabel = new JLabel("Address :", 4);
        AddresslLabel.setBounds(margin, 5 * margin + 4 * h, w, h);
        editPanel.add(AddresslLabel);

        JLabel phoneLabel = new JLabel("Phone Number:", 4);
        phoneLabel.setBounds(margin, 6 * margin + 6 * h, w, h);
        editPanel.add(phoneLabel);

        JTextField nameField = new JTextField("", 4);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextField lastNameField = new JTextField("", 4);
        lastNameField.setBounds(2 * margin + w, 2 * margin + h, w, h);
        editPanel.add(lastNameField);

        JTextField usernameField = new JTextField("", 4);
        usernameField.setBounds(2 * margin + w, 3 * margin + 2 * h, w, h);
        usernameField.setDocument(new Limitter(20));
        editPanel.add(usernameField);

        JPasswordField passwordField = new JPasswordField("", 4);
        passwordField.setBounds(2 * margin + w, 4 * margin + 3 * h, w, h);
        passwordField.setDocument(new Limitter(16));
        editPanel.add(passwordField);

        JButton ShowPassText = new JButton();
        ShowPassText.setIcon(ShowPasswords);
        ShowPassText.setBorder(null);
        ShowPassText.setFocusable(false);
        ShowPassText.setBounds(2 * w + 2 * margin, 4 * margin + 3 * h + margin / 4, margin / 2, margin / 2);
        ShowPassText.setBackground(new Color(238, 238, 238));
        editPanel.add(ShowPassText);

        JTextArea AddressField = new JTextArea("");
        AddressField.setLineWrap(true);
        AddressField.setBounds(2 * margin + w, 5 * margin + 4 * h, w, 2 * h);
        AddressField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        editPanel.add(AddressField);

        JTextField phoneField = new JTextField("", 4);
        phoneField.setBounds(2 * margin + w, 6 * margin + 6 * h, w, h);
        editPanel.add(phoneField);

        JButton save = new JButton("Save");
        save.setBounds(margin, 7 * margin + 7 * h, w, h);
        save.addActionListener((e) -> {
            if (nameField.getText().equals("") || lastNameField.getText().equals("")
                    || usernameField.getText().equals("") || new String(passwordField.getPassword()).equals("")
                    || AddressField.getText().equals("") || phoneField.getText().equals("")) {
                JOptionPane.showMessageDialog(dialog, "Some Of The Fields Are Empty !", "Incomplete Credentials",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    ObjectInputStream reader = new ObjectInputStream(
                            new FileInputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));

                    Customer[] allCustomers = (Customer[]) reader.readObject();
                    int length = allCustomers.length;
                    reader.close();

                    Customer[] newList = new Customer[length + 1];
                    for (int i = 0; i < length; i++) {
                        newList[i] = allCustomers[i];
                    }
                    newList[length] = new Customer(nameField.getText(), lastNameField.getText(),
                            usernameField.getText(), new String(passwordField.getPassword()), phoneField.getText(),
                            AddressField.getText(), 0);

                    ObjectOutputStream writer = new ObjectOutputStream(
                            new FileOutputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));
                    writer.writeObject(newList);
                    writer.flush();
                    writer.close();

                } catch (Exception er) {
                    System.out.println(er.toString());
                }

                UserNameTF.setEditable(true);
                PassWordPF.setEditable(true);
                Login.setEnabled(true);
                dialog.dispose();
                parent.revalidate();
                parent.repaint();
            }

        });
        editPanel.add(save);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(2 * margin + w, 8 * margin + 6 * h, w, h);
        cancel.addActionListener((e) -> {
            dialog.dispose();
            UserNameTF.setEditable(true);
            PassWordPF.setEditable(true);
            Login.setEnabled(true);
        });

        ShowPassText.addActionListener((e) -> {
            if (ShowPassText.getIcon().equals(ShowPasswords)) {
                passwordField.setEchoChar((char) 0);
                ShowPassText.setIcon(HidePasswords);
            } else {
                passwordField.setEchoChar('\u2022');
                ShowPassText.setIcon(ShowPasswords);
            }
        });

        editPanel.add(cancel);
        dialog.setUndecorated(true);
        editPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        dialog.add(editPanel);
        dialog.setSize(3 * margin + 2 * w, 8 * margin + 8 * h);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    public void check() {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));
            Customer[] allCustomers = (Customer[]) reader.readObject();
            reader.close();

            String username = UserNameTF.getText();
            String password = new String(PassWordPF.getPassword());
            boolean hasAccount = false;

            int length = allCustomers.length;
            for (int i = 0; i < length; i++) {
                if (allCustomers[i].username.equals(username)) {
                    hasAccount = true;
                    if (allCustomers[i].password.equals(password)) {
                        parent.dispose();
                        new CustomerFrame(allCustomers[i]);
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
