import java.awt.Color;

import javax.swing.JFrame;

import General.Captcha;
import General.User;
import Login.*;
import Manager.*;

public class Main {
    public static void main(String[] args) {
        //new ManagerFrame(new Manager("", "", "", "", ""));
    	//new MainFrame();
    	JFrame f = new JFrame();
    	Captcha c = new Captcha(new User(),f);
    	//c
    	f.getContentPane().setBackground(Color.yellow);
    	//c.setBounds(0, 0, 136,34);
    	f.add(c);
    	f.setVisible(true);
    	c.setBounds(50,50,136,30);
    	f.setLayout(null);
    }
}
