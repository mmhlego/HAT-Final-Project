package General;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RandomKeyboard extends JPanel {
    private static final long serialVersionUID = -8368940200296613630L;

    int w = 80, h = 60;
    int x, y;
    ArrayList<Integer> nums = new ArrayList<>();
    Robot robot;

    public RandomKeyboard(int x, int y) {
        this.x = x;
        this.y = y;
        createNew();
    }

    public void createNew() {
        try {
            robot = new Robot();
        } catch (Exception er) {
            System.out.println(er.toString());
        }

        fillNums();
        design();
    }

    public void fillNums() {
        if (!nums.isEmpty()) {
            nums.clear();
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            temp.add(i);
        }

        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            int n = r.nextInt(temp.size());
            nums.add(temp.get(n));
            temp.remove(n);
        }
    }

    public void design() {
        setLayout(null);
        for (int i = 0; i < 9; i++) {
            JButton b = new JButton(Integer.toString(nums.get(i)));
            b.setBounds((i % 3) * w, (i / 3) * h, w, h);
            b.addActionListener((e) -> {
                robot.keyPress(48 + (Integer.parseInt(b.getText())));
                robot.keyRelease(48 + (Integer.parseInt(b.getText())));
            });
            add(b);
        }
        JButton b = new JButton(Integer.toString(nums.get(9)));
        b.setBounds(w, 3 * h, w, h);
        b.addActionListener((e) -> {
            robot.keyPress(48 + (Integer.parseInt(b.getText())));
            robot.keyRelease(48 + (Integer.parseInt(b.getText())));
        });
        add(b);

        JButton next = new JButton("Next");
        next.setBounds(0, 3 * h, w, h);
        next.addActionListener((e) -> {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        });
        add(next);

        JButton backspace = new JButton("Backspace");
        backspace.setBounds(2 * w, 3 * h, w, h);
        backspace.addActionListener((e) -> {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        });
        add(backspace);

        setBounds(x, y, 3 * w, 4 * h);
        setVisible(true);
    }
}