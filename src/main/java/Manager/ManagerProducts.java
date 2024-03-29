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

        JButton addNew = new JButton(currentUser.language.products.addNew);
        addNew.setBounds(10, 640, 680, 50);
        addNew.setBackground(currentUser.theme.submitColor);
        addNew.setForeground(currentUser.theme.dialog.fontColor);
        addNew.setFont(currentUser.theme.dialog.font);
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

        String data = "\n" + "  " + currentUser.language.products.name + " :  " + allProducts[index].name + "\n" + "  "
                + currentUser.language.products.description + " :  " + allProducts[index].description + "\n" + "  "
                + currentUser.language.products.amount + " :  " + allProducts[index].amount + "\n" + "  "
                + currentUser.language.products.price + " :  " + allProducts[index].price;
        int ans = JOptionPane.showConfirmDialog(this, currentUser.language.products.areYouSureDescription + data,
                currentUser.language.products.areYouSureTitle, JOptionPane.YES_NO_OPTION);

        if (ans == 0) {
            writeData(index);

            JOptionPane.showMessageDialog(this, currentUser.language.products.removeSuccessDescription,
                    currentUser.language.products.removeSuccessTitle, 1);

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

        JLabel nameLabel = new JLabel(currentUser.language.products.name, 4);
        nameLabel.setForeground(currentUser.theme.dialog.fontColor);
        nameLabel.setFont(currentUser.theme.dialog.font);
        nameLabel.setBounds(margin, margin, w, h);
        editPanel.add(nameLabel);

        JLabel descriptionLabel = new JLabel(currentUser.language.products.description, 4);
        descriptionLabel.setForeground(currentUser.theme.dialog.fontColor);
        descriptionLabel.setFont(currentUser.theme.dialog.font);
        descriptionLabel.setBounds(margin, 2 * margin + h, w, h);
        editPanel.add(descriptionLabel);

        JLabel amountLabel = new JLabel(currentUser.language.products.amount, 4);
        amountLabel.setForeground(currentUser.theme.dialog.fontColor);
        amountLabel.setFont(currentUser.theme.dialog.font);
        amountLabel.setBounds(margin, 3 * margin + 4 * h, w, h);
        editPanel.add(amountLabel);

        JLabel pricaLabel = new JLabel(currentUser.language.products.price, 4);
        pricaLabel.setBackground(currentUser.theme.dialog.background);
        pricaLabel.setForeground(currentUser.theme.dialog.fontColor);
        pricaLabel.setFont(currentUser.theme.dialog.font);
        pricaLabel.setBounds(margin, 4 * margin + 5 * h, w, h);
        editPanel.add(pricaLabel);

        JTextField nameField = new JTextField(allProducts[index].name);
        nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        nameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        nameField.setForeground(currentUser.theme.dialog.fontColor);
        nameField.setFont(currentUser.theme.dialog.font);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextArea descriptionField = new JTextArea(allProducts[index].description);
        descriptionField.setBackground(currentUser.theme.dialog.textFieldBackground);
        descriptionField.setForeground(currentUser.theme.dialog.fontColor);
        descriptionField.setFont(currentUser.theme.dialog.font);
        descriptionField.setLineWrap(true);
        descriptionField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        descriptionField.setBounds(2 * margin + w, 2 * margin + h, w, 3 * h);
        editPanel.add(descriptionField);

        JTextField amountField = new JTextField(Long.toString(allProducts[index].amount));
        amountField.setForeground(currentUser.theme.dialog.fontColor);
        amountField.setFont(currentUser.theme.dialog.font);
        amountField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        amountField.setBackground(currentUser.theme.dialog.textFieldBackground);
        amountField.setBounds(2 * margin + w, 3 * margin + 4 * h, w, h);
        editPanel.add(amountField);

        JTextField priceField = new JTextField(Long.toString(allProducts[index].price));
        priceField.setForeground(currentUser.theme.dialog.fontColor);
        priceField.setFont(currentUser.theme.dialog.font);
        priceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        priceField.setBackground(currentUser.theme.dialog.textFieldBackground);
        priceField.setBounds(2 * margin + w, 4 * margin + 5 * h, w, h);
        editPanel.add(priceField);

        JButton save = new JButton(currentUser.language.products.save);
        save.setBackground(currentUser.theme.dialog.buttonBackground);
        save.setForeground(currentUser.theme.dialog.fontColor);
        save.setFont(currentUser.theme.dialog.font);
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

                JOptionPane.showMessageDialog(dialog, currentUser.language.products.updateDescription,
                        currentUser.language.products.updateTitle, 1);

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

        JButton cancel = new JButton(currentUser.language.products.cancel);
        cancel.setBackground(currentUser.theme.dialog.buttonBackground);
        cancel.setBounds(2 * margin + w, 5 * margin + 6 * h, w, h);
        cancel.setForeground(currentUser.theme.dialog.fontColor);
        cancel.setFont(currentUser.theme.dialog.font);
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
        editPanel.setBackground(currentUser.theme.dialog.background);

        JLabel nameLabel = new JLabel(currentUser.language.products.name, 4);
        nameLabel.setBounds(margin, margin, w, h);
        nameLabel.setFont(currentUser.theme.dialog.font);
        nameLabel.setForeground(currentUser.theme.dialog.fontColor);
        editPanel.add(nameLabel);

        JLabel descriptionLabel = new JLabel(currentUser.language.products.description, 4);
        descriptionLabel.setBounds(margin, 2 * margin + h, w, h);
        descriptionLabel.setFont(currentUser.theme.dialog.font);
        descriptionLabel.setForeground(currentUser.theme.dialog.fontColor);
        editPanel.add(descriptionLabel);

        JLabel amountLabel = new JLabel(currentUser.language.products.amount, 4);
        amountLabel.setBounds(margin, 3 * margin + 4 * h, w, h);
        amountLabel.setFont(currentUser.theme.dialog.font);
        amountLabel.setForeground(currentUser.theme.dialog.fontColor);
        editPanel.add(amountLabel);

        JLabel pricaLabel = new JLabel(currentUser.language.products.price, 4);
        pricaLabel.setBounds(margin, 4 * margin + 5 * h, w, h);
        pricaLabel.setFont(currentUser.theme.dialog.font);
        pricaLabel.setForeground(currentUser.theme.dialog.fontColor);
        editPanel.add(pricaLabel);

        JTextField nameField = new JTextField("");
        nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        nameField.setBackground(currentUser.theme.dialog.textFieldBackground);
        nameField.setFont(currentUser.theme.dialog.font);
        nameField.setForeground(currentUser.theme.dialog.fontColor);
        nameField.setBounds(2 * margin + w, margin, w, h);
        editPanel.add(nameField);

        JTextArea descriptionField = new JTextArea("");
        descriptionField.setBackground(currentUser.theme.dialog.textFieldBackground);
        descriptionField.setLineWrap(true);
        descriptionField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        descriptionField.setFont(currentUser.theme.dialog.font);
        descriptionField.setForeground(currentUser.theme.dialog.fontColor);
        descriptionField.setBounds(2 * margin + w, 2 * margin + h, w, 3 * h);
        editPanel.add(descriptionField);

        JTextField amountField = new JTextField("");
        amountField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        amountField.setFont(currentUser.theme.dialog.font);
        amountField.setForeground(currentUser.theme.dialog.fontColor);
        amountField.setBackground(currentUser.theme.dialog.textFieldBackground);
        amountField.setBounds(2 * margin + w, 3 * margin + 4 * h, w, h);
        editPanel.add(amountField);

        JTextField priceField = new JTextField("");
        priceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, currentUser.theme.dialog.fontColor));
        priceField.setFont(currentUser.theme.dialog.font);
        priceField.setForeground(currentUser.theme.dialog.fontColor);
        priceField.setBackground(currentUser.theme.dialog.textFieldBackground);
        priceField.setBounds(2 * margin + w, 4 * margin + 5 * h, w, h);
        editPanel.add(priceField);

        JButton save = new JButton(currentUser.language.products.save);
        save.setBackground(currentUser.theme.dialog.buttonBackground);
        save.setForeground(currentUser.theme.dialog.fontColor);
        save.setFont(currentUser.theme.dialog.font);
        save.setBounds(margin, 5 * margin + 6 * h, w, h);
        save.addActionListener((e) -> {
            try {
                Product newProduct = new Product(nameField.getText(), descriptionField.getText(),
                        Long.parseLong(amountField.getText()), Long.parseLong(priceField.getText()));

                readData();

                addToFile(newProduct);

                dialog.dispose();
                reloadPage();
            } catch (Exception error) {
                JOptionPane.showMessageDialog(parent, "Wrong format has been entered.", "Wrong Format", 0);
            }
        });
        editPanel.add(save);

        JButton cancel = new JButton(currentUser.language.products.cancel);
        cancel.setBackground(currentUser.theme.dialog.buttonBackground);
        cancel.setForeground(currentUser.theme.dialog.fontColor);
        cancel.setFont(currentUser.theme.dialog.font);
        cancel.setBounds(2 * margin + w, 5 * margin + 6 * h, w, h);
        cancel.addActionListener((e) -> {
            dialog.dispose();
        });
        editPanel.add(cancel);
        editPanel.setBorder(new LineBorder(Color.BLACK, 1));
        dialog.setUndecorated(true);
        dialog.add(editPanel);
        dialog.setSize(3 * margin + 2 * w, 6 * margin + 7 * h);
        dialog.setBackground(currentUser.theme.dialog.background);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    public void addAmount(JButton b) {
        int index = (b.getY() - 5) / 40;

        String ans = JOptionPane.showInputDialog(parent,
                currentUser.language.products.howManyItemsDescription + " " + allProducts[index].name,
                currentUser.language.products.howManyItemsTitle, JOptionPane.QUESTION_MESSAGE);

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

            JOptionPane.showMessageDialog(parent, currentUser.language.products.amountAddedDescription,
                    currentUser.language.products.amountAddedTitle, JOptionPane.INFORMATION_MESSAGE);

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