package Customer;

import javax.swing.*;
import javax.swing.border.*;
import General.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import Login.*;

public class CustomerChargeBalance extends JDialog {
    private static final long serialVersionUID = -6587387237451064081L;

    CustomerFrame parent;
    Customer currentUser;
    JPanel captchaPanel;
    String captchaAnswer;
    String OTPAnswer;
    int min, sec;
    Timer TimeToCancel;
    boolean flag = true;

    public CustomerChargeBalance(CustomerFrame p, Customer c) {
        setUndecorated(true);
        getRootPane().setBorder(new LineBorder(Color.BLACK, 1));
        parent = p;
        currentUser = c;
        setLayout(null);
        setSize(400, 420);
        setLocationRelativeTo(null);
        setTitle("Charge Balance");
        setIconImage(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Pay.png").getImage());

        String[] ChargeData = { " -Amounts- ", "10000", "20000", "50000", "100000" };

        JTextField CardNumber1 = new JTextField();
        CardNumber1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (CardNumber1.getText().length() == 4) {
                    try {
                        Robot Switcher = new Robot();
                        Switcher.keyPress(KeyEvent.VK_TAB);
                        Switcher.keyRelease(KeyEvent.VK_TAB);
                    } catch (AWTException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        CardNumber1.setBounds(130, 80, 40, 30);
        CardNumber1.setDocument(new Limitter(4));
        JTextField CardNumber2 = new JTextField();
        CardNumber2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (CardNumber2.getText().length() == 4) {
                    try {
                        Robot Switcher = new Robot();
                        Switcher.keyPress(KeyEvent.VK_TAB);
                        Switcher.keyRelease(KeyEvent.VK_TAB);
                    } catch (AWTException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        CardNumber2.setBounds(200, 80, 40, 30);
        CardNumber2.setDocument(new Limitter(4));
        JTextField CardNumber3 = new JTextField();
        CardNumber3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (CardNumber3.getText().length() == 4) {
                    try {
                        Robot Switcher = new Robot();
                        Switcher.keyPress(KeyEvent.VK_TAB);
                        Switcher.keyRelease(KeyEvent.VK_TAB);
                    } catch (AWTException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        CardNumber3.setBounds(270, 80, 40, 30);
        CardNumber3.setDocument(new Limitter(4));
        JTextField CardNumber4 = new JTextField();
        CardNumber4.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (CardNumber4.getText().length() == 4) {
                    try {
                        Robot Switcher = new Robot();
                        Switcher.keyPress(KeyEvent.VK_TAB);
                        Switcher.keyRelease(KeyEvent.VK_TAB);
                    } catch (AWTException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        CardNumber4.setBounds(340, 80, 40, 30);
        CardNumber4.setDocument(new Limitter(4));
        JPasswordField CVV2TF = new JPasswordField();
        CVV2TF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((new String(CVV2TF.getPassword())).length() == 4) {
                    try {
                        Robot Switcher = new Robot();
                        Switcher.keyPress(KeyEvent.VK_TAB);
                        Switcher.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(100);
                        Switcher.keyPress(KeyEvent.VK_TAB);
                        Switcher.keyRelease(KeyEvent.VK_TAB);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        CVV2TF.setBounds(130, 130, 70, 30);
        CVV2TF.setDocument(new Limitter(4));
        JTextField ValidateTF = new JTextField();
        ValidateTF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (ValidateTF.getText().length() == 4) {
                    try {
                        Robot Switcher = new Robot();
                        Switcher.keyPress(KeyEvent.VK_TAB);
                        Switcher.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(100);
                        Switcher.keyPress(KeyEvent.VK_TAB);
                        Switcher.keyRelease(KeyEvent.VK_TAB);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        ValidateTF.setBounds(130, 180, 70, 30);
        ValidateTF.setDocument(new Limitter(4));
        JPasswordField CVVTF = new JPasswordField();
        CVVTF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((new String(CVVTF.getPassword())).length() == 7) {
                    try {
                        Robot Switcher = new Robot();
                        Switcher.keyPress(KeyEvent.VK_TAB);
                        Switcher.keyRelease(KeyEvent.VK_TAB);
                        Thread.sleep(100);
                        Switcher.keyPress(KeyEvent.VK_TAB);
                        Switcher.keyRelease(KeyEvent.VK_TAB);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        CVVTF.setBounds(130, 230, 70, 30);
        CVVTF.setDocument(new Limitter(7));
        CVVTF.setEnabled(false);
        JTextField EmailTF = new JTextField();
        EmailTF.setBounds(130, 280, 250, 30);
        JTextField CustomChargeAmount = new JTextField();
        CustomChargeAmount.setBounds(130, 30, 110, 30);
        CustomChargeAmount.setDocument(new Limitter(9));

        JButton SendOTP = new JButton("Request SMS OTP ");
        SendOTP.setBounds(220, 230, 160, 30);
        SendOTP.setBackground(new Color(238, 186, 11));
        SendOTP.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\OTP.png"));
        SendOTP.setBorder(null);
        JButton Proceed = new JButton("Proceed");
        Proceed.setBounds(220, 350, 160, 30);
        Proceed.setBackground(new Color(111, 207, 151));
        JButton Cancel = new JButton("Cancel");
        Cancel.setBounds(20, 350, 160, 30);
        Cancel.setBackground(new Color(250, 67, 67));
        JButton Refresh = new JButton();
        Refresh.setBounds(360, 185, 20, 20);
        Refresh.setBackground(new Color(238, 238, 238));
        Refresh.setBorder(null);
        Refresh.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Refresh.png"));
        Refresh.addActionListener((e) -> createCaptcha());
        JButton SecureKeyBoard = new JButton("Secure Num Pad");
        SecureKeyBoard.setBounds(220, 130, 160, 30);
        SecureKeyBoard.setBorder(null);
        SecureKeyBoard.setBackground(new Color(87, 184, 255));
        SecureKeyBoard.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Keyboard.png"));
        SecureKeyBoard.addActionListener((e) -> {
            if (getHeight() == 420) {
                setSize(400, 600);
            } else {
                setSize(400, 420);
            }
        });

        JLabel CardNumber = new JLabel("Card Number");
        CardNumber.setBounds(20, 80, 90, 30);
        JLabel CVV = new JLabel("CVV2");
        CVV.setBounds(20, 130, 40, 30);
        JLabel Validate = new JLabel("Enter Captcha");
        Validate.setBounds(20, 180, 80, 30);
        JLabel CVV2 = new JLabel("CVV");
        CVV2.setBounds(20, 230, 40, 30);
        JLabel Email = new JLabel("Email (Optional) ");
        Email.setBounds(20, 280, 150, 30);
        JLabel ChargeText = new JLabel("Charge");
        ChargeText.setBounds(20, 30, 50, 30);
        JLabel ShowChoosedCharge = new JLabel("", 2);
        ShowChoosedCharge.setBounds(315, 320, 65, 30);
        JLabel ChargeBalanceShow = new JLabel("Charge Balance :");
        ChargeBalanceShow.setBounds(220, 320, 110, 30);
        JLabel SecureIcon = new JLabel();
        SecureIcon.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Secure.png"));
        SecureIcon.setBounds(310, 395, 20, 20);
        JLabel SecuredBy = new JLabel(" All Purchases Are Secured By H. A. T. ", 0);
        SecuredBy.setBounds(90, 390, 220, 30);
        SecuredBy.setForeground(new Color(85, 40, 111));
        CustomChargeAmount.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                ShowChoosedCharge.setText(CustomChargeAmount.getText());
            }
        });
        JLabel Minute = new JLabel("05", 0);
        Minute.setBounds(0, 0, 20, 20);
        Minute.setForeground(Color.BLACK);
        Minute.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        JLabel Doubledot = new JLabel(":", 0);
        Doubledot.setBounds(15, 0, 10, 20);
        Doubledot.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        JLabel Second = new JLabel("00", 0);
        Second.setBounds(22, 0, 20, 20);
        Second.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
        Second.setForeground(Color.BLACK);
        min = Integer.parseInt(Minute.getText());
        sec = Integer.parseInt(Second.getText());
        TimeToCancel = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sec == 0) {
                    sec = 60;
                    min--;
                }

                if (min == 0) {
                    Minute.setForeground(Color.RED);
                    Second.setForeground(Color.RED);
                }
                if (min < 0) {
                    JOptionPane.showMessageDialog(null, "Operation Cancelled", "Time Out", JOptionPane.ERROR_MESSAGE);
                    min = 0;
                    sec = 0;
                    dispose();
                    TimeToCancel.stop();
                } else {
                    sec--;
                    if (sec < 10) {
                        Second.setText("0" + sec);
                        flag = false;
                    }
                    if (min < 10) {
                        Minute.setText("0" + min);
                        if (sec < 10) {
                            Second.setText("0" + sec);
                        } else {
                            Second.setText("" + sec);
                            flag = false;
                        }
                    }
                    if (flag) {
                        Minute.setText("" + min);
                        Second.setText("" + sec);
                    }
                }
            }

        });
        TimeToCancel.start();

        JComboBox<String> ChargeAmount = new JComboBox<String>(ChargeData);
        ChargeAmount.setBounds(270, 30, 110, 30);
        ((JLabel) ChargeAmount.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ChargeAmount.addItemListener((e) -> {
            String Value = (String) ChargeAmount.getSelectedItem();
            if (Value.equals(" -Amounts- ")) {
                CustomChargeAmount.setText("");
                ShowChoosedCharge.setText("");
            } else {
                CustomChargeAmount.setText(Value);
                ShowChoosedCharge.setText(Value);
            }
        });

        int x = 180;
        for (int i = 0; i < 3; i++) {
            JLabel Line = new JLabel("-");
            Line.setBounds(x, 88, 10, 10);
            add(Line);
            x += 70;
        }

        Proceed.addActionListener((e) -> {
            if (CardNumber1.getText().length() != 4 || CardNumber2.getText().length() != 4
                    || CardNumber3.getText().length() != 4 || CardNumber4.getText().length() != 4) {
                JOptionPane.showMessageDialog(null, "Check Your Card Details !", "Warning", 2);
            } else if (new String(CVV2TF.getPassword()).length() == 0) {
                JOptionPane.showMessageDialog(null, "CVV2 Field is empty !", "Warning", 2);
            } else if (ValidateTF.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Captch Field is empty !", "Warning", 2);
            } else if (new String(CVVTF.getPassword()).length() == 0) {
                JOptionPane.showMessageDialog(null, "CVV Field is empty !", "Warning", 2);
            } else if (!ValidateTF.getText().equals(captchaAnswer)) {
                JOptionPane.showMessageDialog(null, "Captcha is wrong !", "Warning", 2);
            } else if (CustomChargeAmount.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "\'Charge amount\' field is empty !", "Warning", 2);
            } else if (!new String(CVVTF.getPassword()).equals(OTPAnswer)) {
                JOptionPane.showMessageDialog(null, "Wrong CVV !", "Warning", 2);
            } else {
                try {
                    long amount = Long.parseLong(CustomChargeAmount.getText());

                    TimeToCancel.stop();
                    currentUser.balance += amount;
                    new CustomerWriter(currentUser);
                    parent.dispose();
                    dispose();
                    new CustomerFrame(currentUser);

                } catch (Exception er) {
                    JOptionPane.showMessageDialog(null, "Wrong format in \'charge amount\' field !", "Warning", 2);
                }
            }
        });
        Cancel.addActionListener((e) -> {
            dispose();
            TimeToCancel.stop();
        });
        SendOTP.addActionListener((e) -> {
            /*if (currentUser.phoneNumber.length() != 11) {
                JOptionPane.showMessageDialog(null, "Wrong phone number !", "Warning", 2);
                return;
            }*/

            CVVTF.setEnabled(true);
            try {
                createOTP();

                System.out.println(OTPAnswer);

            } catch (Exception er) {
                System.out.print(er.toString());
            }
        });

        JPanel keyboard = new RandomKeyboard(65, 420);

        add(keyboard);
        add(SecuredBy);
        add(SecureKeyBoard);
        add(SecureIcon);
        add(ChargeBalanceShow);
        add(ShowChoosedCharge);
        add(Minute);
        add(Second);
        add(Doubledot);
        add(ChargeText);
        add(CustomChargeAmount);
        add(ChargeAmount);
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
        setResizable(false);
        createCaptcha();
    }

    public void createOTP() {
        Random r = new Random(System.currentTimeMillis());
        OTPAnswer = "";
        for (int i = 0; i < 7; i++) {
            OTPAnswer += Integer.toString(r.nextInt(10));
        }
    }

    public void createCaptcha() {
        if (captchaPanel != null) {
            remove(captchaPanel);
        }

        captchaPanel = new Captcha(currentUser);
        captchaAnswer = captchaPanel.getName();
        captchaPanel.setBounds(220, 180, 136, 30);
        add(captchaPanel);
        captchaPanel.revalidate();
        captchaPanel.repaint();
        revalidate();
        repaint();
    }
}
