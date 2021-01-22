import java.awt.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class SelectPage extends JPanel {
	private static final long serialVersionUID = -6750123727488706316L;

	JButton Manager;
	JButton Employee;
	JButton Costumer;
	MainFrame parent;

	public SelectPage(MainFrame p) {
		parent = p;
		parent.setIconImage(new ImageIcon(System.getProperty("user.dir") + "\\Images\\Frame Icons\\Select.png").getImage());
		design();
	}

	public void design() {
		
		setLayout(null);
		Manager = new JButton("Login As Manager");
		Manager.setBounds(50, 50, 800, 166);
		Manager.setFont(new Font("Tahoma", Font.BOLD, 25));

		Employee = new JButton("Login As Employee");
		Employee.setBounds(50, 266, 800, 166);
		Employee.setFont(new Font("Tahoma", Font.BOLD, 25));

		Costumer = new JButton("Login As Costumer");
		Costumer.setBounds(50, 482, 800, 166);
		Costumer.setFont(new Font("Tahoma", Font.BOLD, 25));

		Manager.addActionListener((e) -> parent.addPanel(new ManagerLogin(parent)));
		Manager.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				Manager.setFont(new Font("Tahoma", Font.BOLD, 27));
				Manager.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent arg0) {
				Manager.setFont(new Font("Tahoma", Font.BOLD, 25));
				Manager.setForeground(Color.BLACK);
			}
		});

		Employee.addActionListener((e) -> parent.addPanel(new EmployeeLogin(parent)));
		Employee.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				Employee.setFont(new Font("Tahoma", Font.BOLD, 27));
				Employee.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent arg0) {
				Employee.setFont(new Font("Tahoma", Font.BOLD, 25));
				Employee.setForeground(Color.BLACK);
			}
		});

		Costumer.addActionListener((e) -> parent.addPanel(new CustomerLogin(parent)));
		Costumer.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				Costumer.setFont(new Font("Tahoma", Font.BOLD, 27));
				Costumer.setForeground(Color.BLACK);
			}

			public void mouseExited(MouseEvent arg0) {
				Costumer.setFont(new Font("Tahoma", Font.BOLD, 25));
				Costumer.setForeground(Color.BLACK);
			}
		});

		add(Manager);
		add(Employee);
		add(Costumer);
	}

}
