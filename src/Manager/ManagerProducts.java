package Manager;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import General.*;

public class ManagerProducts extends JPanel {
    private static final long serialVersionUID = 2252334754594356747L;

    JPanel Info;
    int Count;
    Manager currentUser;
    ManagerFrame parent;
    Product[] allProducts;

    public ManagerProducts(Manager u, ManagerFrame p) {
        parent = p;
        currentUser = u;

        setLayout(null);

        showData();

        setBackground(currentUser.theme.main.background);
        setVisible(true);
    }

    public void readData() {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));

            allProducts = (Product[]) reader.readObject();
            Count = allProducts.length;

            reader.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void showData() {
        readData();

        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));
        Info.setPreferredSize(new Dimension(660, Count * 40));

        ImageIcon deleteIcon = new ImageIcon(System.getProperty("user.dir") + "\\Images\\Icons\\Main\\"
                + currentUser.theme.main.icon + "Delete.png");
        ImageIcon editIcon = new ImageIcon(
                System.getProperty("user.dir") + "\\Images\\Icons\\Main\\" + currentUser.theme.main.icon + "Edit.png");
        ImageIcon addIcon = new ImageIcon(
                System.getProperty("user.dir") + "\\Images\\Icons\\Main\\" + currentUser.theme.main.icon + "Add.png");

        for (int i = 0; i < Count; i++) {
            int m = 660 - 45;
            JButton Delete = new JButton();
            Delete.setBounds(m, i * 40 + 5, 30, 30);
            Delete.setIcon(deleteIcon);
            Delete.setBackground(null);
            Delete.setBorder(null);
            m -= 40;
            Delete.addActionListener((e) -> {
                sure(Delete);
            });
            Info.add(Delete);

            JButton Edit = new JButton();
            Edit.setBounds(m, i * 40 + 5, 30, 30);
            Edit.setIcon(editIcon);
            Edit.setBackground(null);
            Edit.setBorder(null);
            m -= 40;
            Edit.addActionListener((e) -> {
                edit(Edit);
            });
            Info.add(Edit);

            JButton Add = new JButton();
            Add.setBounds(m, i * 40 + 5, 30, 30);
            Add.setIcon(addIcon);
            Add.setBackground(null);
            Add.setBorder(null);
            m -= 15;
            Add.addActionListener((e) -> {
                addAmount(Add);
            });
            Info.add(Add);

            JLabel Product = new JLabel(allProducts[i].name);
            Product.setFont(currentUser.theme.main.font);
            Product.setForeground(currentUser.theme.main.fontColor);
            Product.setBounds(5, i * 40 + 5, m, 30);
            Info.add(Product);
        }

        JButton addNew = new JButton("Add New Product");
        addNew.setBounds(10, 640, 680, 50);
        addNew.setBackground(currentUser.theme.submitColor);
        addNew.setBorder(null);
        addNew.addActionListener((e) -> {
            addNewProduct();
        });
        add(addNew);

        Info.setBackground(currentUser.theme.main.background);

        JScrollPane PanelScroll = new JScrollPane(Info);
        PanelScroll.setBounds(10, 10, 680, 610);
        PanelScroll.setBorder(null);
        PanelScroll.getVerticalScrollBar().setBackground(currentUser.theme.main.background);
        PanelScroll.getVerticalScrollBar().setBorder(null);
        PanelScroll.getVerticalScrollBar().setUnitIncrement(10);
        PanelScroll.setBackground(currentUser.theme.main.background);

        add(PanelScroll);

        revalidate();
        repaint();
    }

    public void sure(JButton b) {
        int index = (b.getY() - 5) / 40;

        String data = "\nName: " + allProducts[index].name + "\nDescription: " + allProducts[index].description
                + "\nAmount: " + allProducts[index].amount + "\nPrice: " + allProducts[index].price;
        int ans = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete product with these information?" + data, "Are you sure",
                JOptionPane.YES_NO_OPTION);

        if (ans == 0) {
            writeData(index);

            JOptionPane.showMessageDialog(this, "Product removed successfully.", "Product Rmoved", 1);

            reloadPage();
        }
    }

    public void edit(JButton b) {
        int index = (b.getY() - 5) / 40;

        int h = 30, w = 200, margin = 20;

        JDialog dialog = new JDialog(parent, "Edit Information");

        JPanel editPanel = new JPanel();
        editPanel.setBackground(currentUser.theme.dialog.background);
        editPanel.setForeground(currentUser.theme.dialog.fontColor);
        editPanel.setFont(currentUser.theme.dialog.font);
        editPanel.setLayout(null);
        editPanel.setSize(3 * margin + 2 * w, 8 * margin + 7 * h);

        JLabel nameLabel = new JLabel("Name:", 4);
        nameLabel.setBackground(currentUser.theme.dialog.background);
        nameLabel.setForeground(currentUser.theme.dialog.fontColor);
        nameLabel.setFont(currentUser.theme.dialog.font);
        nameLabel.setBounds(margin, margin, w, h);
        editPanel.add(nameLabel);

        JLabel descriptionLabel = new JLabel("Description:", 4);
        descriptionLabel.setBackground(currentUser.theme.dialog.background);
        descriptionLabel.setForeground(currentUser.theme.dialog.fontColor);
        descriptionLabel.setFont(currentUser.theme.dialog.font);
        descriptionLabel.setBounds(margin, 2 * margin + h, w, h);
        editPanel.add(descriptionLabel);

        JLabel amountLabel = new JLabel("Amount:", 4);
        amountLabel.setBackground(currentUser.theme.dialog.background);
        amountLabel.setForeground(currentUser.theme.dialog.fontColor);
        amountLabel.setFont(currentUser.theme.dialog.font);
        amountLabel.setBounds(margin, 3 * margin + 4 * h, w, h);
        editPanel.add(amountLabel);

        JLabel pricaLabel = new JLabel("Price:", 4);
        pricaLabel.setBackground(currentUser.theme.dialog.background);
        pricaLabel.setForeground(currentUser.theme.dialog.fontColor);
        pricaLabel.setFont(currentUser.theme.dialog.font);
        pricaLabel.setBounds(margin, 4 * margin + 5 * h, w, h);
        editPanel.add(pricaLabel);

        JTextField nameField = new JTextField(allProducts[index].name);
        nameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextArea descriptionField = new JTextArea(allProducts[index].description);
        descriptionField.setBackground(currentUser.theme.dialog.textFieldBackground);
        descriptionField.setLineWrap(true);
        descriptionField.setBorder(new LineBorder(Color.GRAY, 1));
        descriptionField.setBounds(2 * margin + w, 2 * margin + h, w, 3 * h);
        editPanel.add(descriptionField);

        JTextField amountField = new JTextField(Long.toString(allProducts[index].amount));
        amountField.setBackground(currentUser.theme.dialog.textFieldBackground);
        amountField.setBounds(2 * margin + w, 3 * margin + 4 * h, w, h);
        editPanel.add(amountField);

        JTextField priceField = new JTextField(Long.toString(allProducts[index].price));
        priceField.setBackground(currentUser.theme.dialog.textFieldBackground);
        priceField.setBounds(2 * margin + w, 4 * margin + 5 * h, w, h);
        editPanel.add(priceField);

        JButton save = new JButton("Save");
        save.setBackground(currentUser.theme.dialog.buttonBackground);
        save.setBounds(margin, 5 * margin + 6 * h, w, h);
        save.addActionListener((e) -> {

            try {
                allProducts[index].name = nameField.getText();
                allProducts[index].description = descriptionField.getText();
                allProducts[index].amount = Long.parseLong(amountField.getText());
                allProducts[index].price = Long.parseLong(priceField.getText());

                ObjectOutputStream writer = new ObjectOutputStream(
                        new FileOutputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));
                writer.writeObject(allProducts);
                writer.close();

                JOptionPane.showMessageDialog(dialog, "Product information updated successfully.", "Product Updated",
                        1);

                dialog.dispose();
                reloadPage();

            } catch (Exception error) {
                JOptionPane.showMessageDialog(dialog, "Wrong format has been entered.", "Wrong Format", 0);
            }
            readData();

            dialog.dispose();
            reloadPage();

        });
        editPanel.add(save);

        JButton cancel = new JButton("Cancel");
        cancel.setBackground(currentUser.theme.dialog.buttonBackground);
        cancel.setBounds(2 * margin + w, 5 * margin + 6 * h, w, h);
        cancel.addActionListener((e) -> {
            dialog.dispose();
        });
        editPanel.add(cancel);
        editPanel.setBorder(new LineBorder(Color.BLACK, 1));
        dialog.add(editPanel);
        dialog.setUndecorated(true);
        dialog.setSize(3 * margin + 2 * w, 6 * margin + 7 * h);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    public void addNewProduct() {
        int h = 30, w = 200, margin = 20;

        JDialog dialog = new JDialog(parent, "Edit Information");

        JPanel editPanel = new JPanel();
        editPanel.setLayout(null);
        editPanel.setSize(3 * margin + 2 * w, 8 * margin + 7 * h);

        JLabel nameLabel = new JLabel("Name:", 4);
        nameLabel.setBounds(margin, margin, w, h);
        editPanel.add(nameLabel);

        JLabel descriptionLabel = new JLabel("Description:", 4);
        descriptionLabel.setBounds(margin, 2 * margin + h, w, h);
        editPanel.add(descriptionLabel);

        JLabel amountLabel = new JLabel("Amount:", 4);
        amountLabel.setBounds(margin, 3 * margin + 4 * h, w, h);
        editPanel.add(amountLabel);

        JLabel pricaLabel = new JLabel("Price:", 4);
        pricaLabel.setBounds(margin, 4 * margin + 5 * h, w, h);
        editPanel.add(pricaLabel);

        JTextField nameField = new JTextField("");
        nameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextArea descriptionField = new JTextArea("");
        descriptionField.setBackground(currentUser.theme.dialog.textFieldBackground);
        descriptionField.setLineWrap(true);
        descriptionField.setBorder(new LineBorder(Color.GRAY, 1));
        descriptionField.setBounds(2 * margin + w, 2 * margin + h, w, 3 * h);
        editPanel.add(descriptionField);

        JTextField amoutField = new JTextField("");
        amoutField.setBackground(currentUser.theme.dialog.textFieldBackground);
        amoutField.setBounds(2 * margin + w, 3 * margin + 4 * h, w, h);
        editPanel.add(amoutField);

        JTextField priceField = new JTextField("");
        priceField.setBackground(currentUser.theme.dialog.textFieldBackground);
        priceField.setBounds(2 * margin + w, 4 * margin + 5 * h, w, h);
        editPanel.add(priceField);

        JButton save = new JButton("Save");
        save.setBackground(currentUser.theme.dialog.buttonBackground);
        save.setBounds(margin, 5 * margin + 6 * h, w, h);
        save.addActionListener((e) -> {

            try {
                Product newProduct = new Product(nameField.getText(), descriptionField.getText(),
                        Long.parseLong(amoutField.getText()), Long.parseLong(priceField.getText()));

                readData();

                addToFile(newProduct);

                dialog.dispose();
                reloadPage();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(parent, "Wrong format has been entered.", "Wrong Format", 0);
            }
        });
        editPanel.add(save);

        JButton cancel = new JButton("Cancel");
        cancel.setBackground(currentUser.theme.dialog.buttonBackground);
        cancel.setBounds(2 * margin + w, 5 * margin + 6 * h, w, h);
        cancel.addActionListener((e) -> {
            dialog.dispose();
        });
        editPanel.add(cancel);
        editPanel.setBorder(new LineBorder(Color.BLACK, 1));
        dialog.setUndecorated(true);
        dialog.add(editPanel);
        dialog.setSize(3 * margin + 2 * w, 6 * margin + 7 * h);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    public void addAmount(JButton b) {
        int index = (b.getY() - 5) / 40;

        String ans = JOptionPane.showInputDialog(parent,
                "How many items do you want to add to " + allProducts[index].name + "?", "Add Amount",
                JOptionPane.QUESTION_MESSAGE);

        if (ans == null) {
            return;
        }

        try {
            long amount = Long.parseLong(ans);

            allProducts[index].amount += amount;

            ObjectOutputStream writer = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));
            writer.writeObject(allProducts);
            writer.close();

            JOptionPane.showMessageDialog(parent, "Amount added successfully.", "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            reloadPage();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(parent, "Wrong format has been entered.", "Wrong Format", 0);
            addAmount(b);
        }
    }

    public void addToFile(Product em) {
        try {
            ObjectOutputStream reader = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));

            Product[] temp = new Product[Count + 1];

            for (int i = 0; i < Count; i++) {
                temp[i] = allProducts[i];
            }

            temp[Count] = em;

            reader.writeObject(temp);

            reader.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void writeData(int remove) {
        try {
            ObjectOutputStream reader = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));

            Product[] temp = new Product[Count - 1];

            for (int i = 0; i < remove; i++) {
                temp[i] = allProducts[i];
            }

            for (int i = remove + 1; i < Count; i++) {
                temp[i - 1] = allProducts[i];
            }

            reader.writeObject(temp);

            reader.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void reloadPage() {
        parent.addPanel(new ManagerProducts(currentUser, parent));
    }

}
