package Customer;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class Captcha extends JPanel {
	private static final long serialVersionUID = -5188010040036491L;

	Customer currentUser;
	String answer = "";

	public JPanel panel1 = new JPanel();
	public JPanel panel2 = new JPanel();
	public JPanel panel3 = new JPanel();
	public JPanel panel4 = new JPanel();

	public Captcha(Customer u) {
		currentUser = u;
		String[] elements = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c",
				"d", "e", "f", "g", "h", "i", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
				"x", "y", "z" };

		Random random = new Random(System.currentTimeMillis());
		String captcha1 = elements[random.nextInt(elements.length)];
		String captcha2 = elements[random.nextInt(elements.length)];
		String captcha3 = elements[random.nextInt(elements.length)];
		String captcha4 = elements[random.nextInt(elements.length)];
		answer = captcha1 + captcha2 + captcha3 + captcha4;
		setName(answer);

		JLabel label1 = new RotateLabel(captcha1);
		JLabel label2 = new RotateLabel(captcha2);
		JLabel label3 = new RotateLabel(captcha3);
		JLabel label4 = new RotateLabel(captcha4);

		label1.setHorizontalAlignment(0);
		label2.setHorizontalAlignment(0);
		label3.setHorizontalAlignment(0);
		label4.setHorizontalAlignment(0);

		Font font = label1.getFont();

		label1.setBounds(random.nextInt(10) + 1, random.nextInt(6) + 1, 24, 24);
		label2.setBounds(random.nextInt(10) + 1, random.nextInt(6) + 1, 24, 24);
		label3.setBounds(random.nextInt(10) + 1, random.nextInt(6) + 1, 24, 24);
		label4.setBounds(random.nextInt(10) + 1, random.nextInt(6) + 1, 24, 24);

		label1.setFont(new Font(font.getFamily(), font.getStyle(), random.nextInt(8) + 13));
		label2.setFont(new Font(font.getFamily(), font.getStyle(), random.nextInt(8) + 13));
		label3.setFont(new Font(font.getFamily(), font.getStyle(), random.nextInt(8) + 13));
		label4.setFont(new Font(font.getFamily(), font.getStyle(), random.nextInt(8) + 13));

		JLabel a = new Draw();
		a.setBounds(0, 0, 136, 30);
		add(a);

		panel1.setLayout(null);
		panel2.setLayout(null);
		panel3.setLayout(null);
		panel4.setLayout(null);

		panel1.setBackground(null);
		panel2.setBackground(null);
		panel3.setBackground(null);
		panel4.setBackground(null);

		panel1.setBounds(0, 0, 34, 30);
		panel2.setBounds(34, 0, 34, 30);
		panel3.setBounds(68, 0, 34, 30);
		panel4.setBounds(102, 0, 34, 30);

		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);
		panel4.add(label4);

		panel1.setVisible(true);
		panel2.setVisible(true);
		panel3.setVisible(true);
		panel4.setVisible(true);

		this.setLayout(null);
		this.setBackground(currentUser.theme.main.background);
		this.setBounds(0, 0, 136, 30);
		this.setBorder(null);
		this.setVisible(true);

		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
	}
}

class Draw extends JLabel {
	private static final long serialVersionUID = -4130955380199476900L;

	public void paintComponent(Graphics g) {
		Color[] colors = { Color.blue, Color.cyan, Color.green, Color.magenta, Color.RED, Color.yellow };
		Random rnd = new Random(System.currentTimeMillis());
		int n = rnd.nextInt(3) + 1;
		for (int i = 0; i < n; i++) {
			int x1 = rnd.nextInt(68);
			int y1 = rnd.nextInt(30);
			int x2 = rnd.nextInt(68) + 68;
			int y2 = rnd.nextInt(30);
			g.setColor(colors[rnd.nextInt(6)]);
			g.drawLine(x1, y1, x2, y2);

		}
	}

}

class RotateLabel extends JLabel {
	private static final long serialVersionUID = 6123841539184464540L;

	static Random r = new Random(System.currentTimeMillis());

	public RotateLabel(String text) {
		super(text, 0);

		Font font = new Font("Verdana", Font.ITALIC, 10);
		FontMetrics metrics = new FontMetrics(font) {
			private static final long serialVersionUID = 4274734669201611403L;
		};
		Rectangle2D bounds = metrics.getStringBounds(text, null);
		setBounds(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gx = (Graphics2D) g;
		gx.rotate((r.nextInt(19) - 9) * Math.PI * 5 / 180, getX() + getWidth() / 2, getY() + getHeight() / 2);
		super.paintComponent(g);
	}
}
