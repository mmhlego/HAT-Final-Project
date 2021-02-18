package Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectPage extends JPanel {
	private static final long serialVersionUID = -6750123727488706316L;

	JButton Manager;
	JButton Employee;
	JButton Costumer;
	MainFrame parent;

	public SelectPage(MainFrame p) {
		parent = p;
		parent.setTitle("Select Role");
		parent.setIconImage(
				new ImageIcon(System.getProperty("user.dir") + "\\Images\\Frame Icons\\Select.png").getImage());
		RightClick();
		design();
	}

	public void design() {
		JLabel back = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\Images\\login back.jpg"));
		back.setBounds(0, 0, 900, 700);
		setLayout(null);
		Manager = new JButton("Login As Manager");
		Manager.setBounds(50, 50, 800, 166);

		Manager.setBorder(null);
		Manager.setForeground(Color.WHITE);
		Manager.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\login button.png"));
		Manager.setHorizontalTextPosition(SwingConstants.CENTER);
		Manager.setVerticalTextPosition(SwingConstants.CENTER);
		Manager.setBackground(new Color(238, 238, 237));
		Manager.setFont(new Font("Tahoma", Font.BOLD, 25));
		Manager.setOpaque(false);
		Manager.setContentAreaFilled(false);
		Manager.setBorderPainted(false);

		Employee = new JButton("Login As Employee");
		Employee.setBounds(50, 266, 800, 166);
		Employee.setBorder(null);
		Employee.setForeground(Color.WHITE);
		Employee.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\login button.png"));
		Employee.setHorizontalTextPosition(SwingConstants.CENTER);
		Employee.setVerticalTextPosition(SwingConstants.CENTER);
		Employee.setBackground(new Color(238, 238, 238));
		Employee.setFont(new Font("Tahoma", Font.BOLD, 25));
		Employee.setOpaque(false);
		Employee.setContentAreaFilled(false);
		Employee.setBorderPainted(false);

		Costumer = new JButton("Login As Costumer");
		Costumer.setBounds(50, 482, 800, 166);
		Costumer.setFont(new Font("Tahoma", Font.BOLD, 25));
		Costumer.setBorder(null);
		Costumer.setForeground(Color.WHITE);
		Costumer.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\login button.png"));
		Costumer.setHorizontalTextPosition(SwingConstants.CENTER);
		Costumer.setVerticalTextPosition(SwingConstants.CENTER);
		Costumer.setBackground(new Color(238, 238, 238));
		Costumer.setOpaque(false);
		Costumer.setContentAreaFilled(false);
		Costumer.setBorderPainted(false);

		Manager.addActionListener((e) -> parent.addPanel(new ManagerLogin(parent)));
		Manager.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				Manager.setFont(new Font("Tahoma", Font.BOLD, 27));
				Manager.setForeground(Color.WHITE);
			}

			public void mouseExited(MouseEvent arg0) {
				Manager.setFont(new Font("Tahoma", Font.BOLD, 25));
				Manager.setForeground(Color.WHITE);
			}
		});

		Employee.addActionListener((e) -> parent.addPanel(new EmployeeLogin(parent)));
		Employee.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				Employee.setFont(new Font("Tahoma", Font.BOLD, 27));
				Employee.setForeground(Color.WHITE);
			}

			public void mouseExited(MouseEvent arg0) {
				Employee.setFont(new Font("Tahoma", Font.BOLD, 25));
				Employee.setForeground(Color.WHITE);
			}
		});

		Costumer.addActionListener((e) -> parent.addPanel(new CustomerLogin(parent)));
		Costumer.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				Costumer.setFont(new Font("Tahoma", Font.BOLD, 27));
				Costumer.setForeground(Color.WHITE);
			}

			public void mouseExited(MouseEvent arg0) {
				Costumer.setFont(new Font("Tahoma", Font.BOLD, 25));
				Costumer.setForeground(Color.WHITE);
			}
		});
		//this.setBackground(new Color(226, 255, 255));

		add(Manager);
		add(Employee);
		add(Costumer);
		add(back);
	}

	public void RightClick() {
		JPopupMenu RightClicked = new JPopupMenu();
		JMenuItem RightItemLoginManager = new JMenuItem("Login As Manager");
		RightItemLoginManager
				.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Manager.png"));
		JMenuItem RightItemLoginEmployee = new JMenuItem("Login As Employee");
		RightItemLoginEmployee
				.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Employee.png"));
		JMenuItem RightItemLoginCustomer = new JMenuItem("Login As Customer");
		RightItemLoginCustomer
				.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Customer.png"));
		JMenuItem RightItemExit = new JMenuItem("Exit                           ");
		RightItemExit.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\Images\\MenuItems\\Logout.png"));
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent ME) {
				if (SwingUtilities.isRightMouseButton(ME)) {
					RightClicked.show(ME.getComponent(), ME.getX(), ME.getY());
				}
			}
		});
		RightItemExit.addActionListener((e) -> parent.dispose());
		RightItemLoginManager.addActionListener((e) -> parent.addPanel(new ManagerLogin(parent)));
		RightItemLoginEmployee.addActionListener((e) -> parent.addPanel(new EmployeeLogin(parent)));
		RightItemLoginCustomer.addActionListener((e) -> parent.addPanel(new CustomerLogin(parent)));

		RightClicked.add(RightItemLoginManager);
		RightClicked.add(RightItemLoginEmployee);
		RightClicked.add(RightItemLoginCustomer);
		RightClicked.add(RightItemExit);
		this.add(RightClicked);
	}
}
