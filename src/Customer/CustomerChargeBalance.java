package Customer;

import javax.swing.*;
import java.awt.*;
import General.User;
import Login.*;

public class CustomerChargeBalance extends JDialog {
    private static final long serialVersionUID = -6587387237451064081L;

    User currentUser;
    JFrame parent;

    public CustomerChargeBalance(/*User u , JFrame p*/) {
        //parent = p;
        //currentUser = u;
        setLayout(null);
        setSize(420, 390);
        setLocationRelativeTo(null);
        setTitle("Charge Balance");
        setIconImage(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Pay.png").getImage());

        JTextField CardNumber1 = new JTextField();
        CardNumber1.setBounds(130, 30, 40, 30);
        CardNumber1.setDocument(new Limitter(4));
        JTextField CardNumber2 = new JTextField();
        CardNumber2.setBounds(200, 30, 40, 30);
        CardNumber2.setDocument(new Limitter(4));
        JTextField CardNumber3 = new JTextField();
        CardNumber3.setBounds(270, 30, 40, 30);
        CardNumber3.setDocument(new Limitter(4));
        JTextField CardNumber4 = new JTextField();
        CardNumber4.setBounds(340, 30, 40, 30);
        CardNumber4.setDocument(new Limitter(4));
        JTextField CVV2TF = new JTextField();
        CVV2TF.setBounds(130, 80, 70, 30);
        CVV2TF.setDocument(new Limitter(4));
        JTextField ValidateTF = new JTextField();
        ValidateTF.setBounds(130, 130, 70, 30);
        ValidateTF.setDocument(new Limitter(5));
        JTextField CVVTF = new JTextField();
        CVVTF.setBounds(130, 180, 70, 30);
        CVVTF.setDocument(new Limitter(7));
        JTextField EmailTF = new JTextField();
        EmailTF.setBounds(130, 230, 250, 30);

        JButton SendOTP = new JButton("Request SMS OTP ");
        SendOTP.setBounds(220, 180, 160, 30);
        SendOTP.setBackground(new Color (238, 186, 11));
        SendOTP.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\OTP.png"));
        SendOTP.setBorder(null);
        JButton Proceed = new JButton("Proceed");
        Proceed.setBounds(220, 300, 160, 30);
        Proceed.setBackground(new Color(111, 207, 151));
        JButton Cancel = new JButton("Cancel");
        Cancel.setBounds(20, 300, 160, 30);
        Cancel.setBackground(new Color (250, 67, 67));
        JButton Refresh = new JButton();
        Refresh.setBounds(360, 135, 20, 20);
        Refresh.setBackground(new Color (238 , 238 , 238));
        Refresh.setBorder(null);
        Refresh.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Refresh.png"));

        JLabel CardNumber = new JLabel("Card Number");
        CardNumber.setBounds(20, 30, 90, 30);
        JLabel CVV = new JLabel("CVV2");
        CVV.setBounds(20, 80, 40, 30);
        JLabel Validate = new JLabel("Enter Captcha");
        Validate.setBounds(20, 130, 80, 30);
        JLabel CVV2 = new JLabel("CVV");
        CVV2.setBounds(20, 180, 40, 30);
        JLabel Email = new JLabel("Email (Optional) ");
        Email.setBounds(20, 230, 150, 30);

        int x = 180;
        for (int i = 0; i < 3; i++) {
            JLabel Line = new JLabel("-");
            Line.setBounds(x, 38, 10, 10);
            add(Line);
            x += 70;
        }

        Proceed.addActionListener((e) -> 
        {
            if (CardNumber1.getText().length() !=4 || CardNumber2.getText().length() !=4 || CardNumber3.getText().length() !=4 || CardNumber4.getText().length() !=4 || CVV2TF.equals("")) 
            {
                //! CHECK THE CAPTCHA //
                //! CHECK THE CVV //
                JOptionPane.showMessageDialog(null, "Check Your Card Details !", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        Cancel.addActionListener((e) -> 
        {
            dispose();
        });
        SendOTP.addActionListener((e) -> 
        {

        });


        add(Refresh);
        add(Proceed);
        add(Cancel);
        add(SendOTP);
        add(Email);
        add(EmailTF);
        add(CVV2TF);
        add(CVV2);
        add(ValidateTF);
        add(Validate);
        add(CVV);
        add(CVVTF);
        add(CardNumber1);
        add(CardNumber2);
        add(CardNumber3);
        add(CardNumber4);
        add(CardNumber);
        setVisible(true);
    }
}
