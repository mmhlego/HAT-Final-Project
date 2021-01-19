package Employee;

import java.awt.*;
import javax.swing.*;
import General.*;

public class ProductsList extends JPanel {
    JPanel Info;
    int Count = 50;
    Employee currentUser;

    public ProductsList(Employee u) {
        currentUser = u;
        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));
        Info.setPreferredSize(new Dimension(660, Count * 40));

        setLayout(null);

        JScrollPane PanelScroll = new JScrollPane(Info);
        PanelScroll.setBounds(10, 10, 680, 610);
        PanelScroll.setBorder(null);

        add(PanelScroll);

        ImageIcon deleteIcon = new CustomIcon(currentUser.theme.icon + "Delete", 28, 28);
        ImageIcon editIcon = new CustomIcon(currentUser.theme.icon + "Edit", 28, 28);
        ImageIcon addIcon = new CustomIcon(currentUser.theme.icon + "Add", 28, 28);

        for (int i = 0; i < Count; i++) {
            int m = 660 - 45;
            JButton Delete = new JButton();
            Delete.setBounds(m, i * 40 + 5, 30, 30);
            Delete.setIcon(deleteIcon);
            Delete.setBackground(null);
            Delete.setBorder(null);
            m -= 40;
            Delete.addActionListener((e) -> {
                System.out.println((Delete.getY() - 5) / 40);
            });
            Info.add(Delete);

            JButton Edit = new JButton();
            Edit.setBounds(m, i * 40 + 5, 30, 30);
            Edit.setIcon(editIcon);
            Edit.setBackground(null);
            Edit.setBorder(null);
            m -= 40;
            Edit.addActionListener((e) -> {
                System.out.println((Edit.getY() - 5) / 40);
            });
            Info.add(Edit);

            JButton Add = new JButton();
            Add.setBounds(m, i * 40 + 5, 30, 30);
            Add.setIcon(addIcon);
            Add.setBackground(null);
            Add.setBorder(null);
            m -= 15;
            Add.addActionListener((e) -> {
                System.out.println((Add.getY() - 5) / 40);
            });
            Info.add(Add);

            JLabel Employee = new JLabel("User" + " " + i, SwingConstants.LEFT);
            Employee.setBounds(5, i * 40 + 5, m, 30);
            Info.add(Employee);
        }

        JButton addNew = new JButton("Add New Employee");
        addNew.setBounds(10, 640, 680, 50);
        addNew.setBackground(new Color(111, 207, 151));
        addNew.setBorder(null);
        addNew.addActionListener((e) -> {
            // add new employee
        });
        add(addNew);

        setVisible(true);
    }
}
