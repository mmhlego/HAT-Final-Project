package Customer;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class CustomerCart extends JPanel {
    private static final long serialVersionUID = 5679015742552960498L;

    JPanel Info;
    int Count;
    Customer currentUser;
    CustomerFrame parent;

    public CustomerCart(Customer c, CustomerFrame p) {
        currentUser = c;
        parent = p;
        Info = new JPanel();
        Info.setLayout(null);
        Info.setBackground(new Color(242, 242, 242));

        JLabel nameLabel = new JLabel("Product name", 0);
        nameLabel.setBounds(20, 20, 250, 30);
        nameLabel.setFont(currentUser.theme.main.font);
        nameLabel.setForeground(currentUser.theme.main.fontColor);
        nameLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        Info.add(nameLabel);

        JLabel priceLabel = new JLabel("Base Price", 0);
        priceLabel.setBounds(270, 20, 120, 30);
        priceLabel.setFont(currentUser.theme.main.font);
        priceLabel.setForeground(currentUser.theme.main.fontColor);
        priceLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        Info.add(priceLabel);

        JLabel amountLabel = new JLabel("Amount", 0);
        amountLabel.setBounds(390, 20, 50, 30);
        amountLabel.setFont(currentUser.theme.main.font);
        amountLabel.setForeground(currentUser.theme.main.fontColor);
        amountLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        Info.add(amountLabel);

        JLabel discountLabel = new JLabel("Discount", 0);
        discountLabel.setBounds(440, 20, 80, 30);
        discountLabel.setFont(currentUser.theme.main.font);
        discountLabel.setForeground(currentUser.theme.main.fontColor);
        discountLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        Info.add(discountLabel);

        JLabel totalPriceLabel = new JLabel("Total Price", 0);
        totalPriceLabel.setBounds(520, 20, 120, 30);
        totalPriceLabel.setFont(currentUser.theme.main.font);
        totalPriceLabel.setForeground(currentUser.theme.main.fontColor);
        totalPriceLabel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        Info.add(totalPriceLabel);

        //Customer0

        JLabel calculatedTotalDiscountLabel = new JLabel("Total Discount:", 0);
        calculatedTotalDiscountLabel.setFont(currentUser.theme.main.font);
        calculatedTotalDiscountLabel.setBounds(400, 510, 120, 30);
        calculatedTotalDiscountLabel.setFont(currentUser.theme.main.font);
        calculatedTotalDiscountLabel.setForeground(currentUser.theme.main.fontColor);
        calculatedTotalDiscountLabel.setBorder(null);
        add(calculatedTotalDiscountLabel);

        JLabel calculatedTotalDiscount = new JLabel("0", 0);
        calculatedTotalDiscount.setFont(currentUser.theme.main.font);
        calculatedTotalDiscount.setBounds(520, 510, 120, 30);
        calculatedTotalDiscount.setFont(currentUser.theme.main.font);
        calculatedTotalDiscount.setForeground(currentUser.theme.main.fontColor);
        calculatedTotalDiscount.setBorder(null);
        add(calculatedTotalDiscount);

        JLabel calculatedTotalPriceLabel = new JLabel("Total Price:", 0);
        calculatedTotalPriceLabel.setFont(currentUser.theme.main.font);
        calculatedTotalPriceLabel.setBounds(400, 540, 120, 30);
        calculatedTotalPriceLabel.setFont(currentUser.theme.main.font);
        calculatedTotalPriceLabel.setForeground(currentUser.theme.main.fontColor);
        calculatedTotalPriceLabel.setBorder(null);
        add(calculatedTotalPriceLabel);

        JLabel calculatedTotalPrice = new JLabel("0", 0);
        calculatedTotalPrice.setFont(currentUser.theme.main.font);
        calculatedTotalPrice.setBounds(520, 540, 120, 30);
        calculatedTotalPrice.setFont(currentUser.theme.main.font);
        calculatedTotalPrice.setForeground(currentUser.theme.main.fontColor);
        calculatedTotalPrice.setBorder(null);
        add(calculatedTotalPrice);

        JButton submit = new JButton();
        submit.setEnabled(false);
        submit.setBounds(30, 620, 640, 50);
        submit.setFont(currentUser.theme.main.font);
        submit.setForeground(currentUser.theme.main.fontColor);
        submit.setBackground(new Color(111, 207, 151));
        submit.setBorder(null);
        add(submit);

        //Customer0

        long total = 0, totalDiscount = 0;
        try {
            Count = currentUser.order.products.length;

            Info.setPreferredSize(new Dimension(660, 60 + Count * 50));

            for (int i = 0; i < Count; i++) {
                nameLabel = new JLabel(currentUser.order.products[i].name, 0);
                nameLabel.setBounds(20, 60 + 50 * i, 250, 30);
                nameLabel.setBorder(null);
                Info.add(nameLabel);

                long price = currentUser.order.products[i].price;
                priceLabel = new JLabel(Long.toString(price), 0);
                priceLabel.setBounds(270, 60 + 50 * i, 120, 30);
                priceLabel.setBorder(null);
                Info.add(priceLabel);

                int amount = currentUser.order.count[i];
                amountLabel = new JLabel(Integer.toString(amount), 0);
                amountLabel.setBounds(390, 60 + 50 * i, 50, 30);
                amountLabel.setBorder(null);
                Info.add(amountLabel);

                int discount = currentUser.order.products[i].discount;
                discountLabel = new JLabel(discount + " %", 0);
                discountLabel.setBounds(440, 60 + 50 * i, 80, 30);
                discountLabel.setBorder(null);
                Info.add(discountLabel);

                long totalPrice = amount * price * (100 - discount) / 100;
                totalPriceLabel = new JLabel(Long.toString(totalPrice), 0);
                totalPriceLabel.setBounds(520, 60 + 50 * i, 120, 30);
                totalPriceLabel.setBorder(null);
                Info.add(totalPriceLabel);

                totalDiscount += amount * price * discount / 100;
                total += totalPrice;
            }

            calculatedTotalDiscount.setText(Long.toString(totalDiscount) + " ("
                    + Long.toString(totalDiscount / (totalDiscount + total)) + "%)");

            calculatedTotalPrice.setText(Long.toString(total));

            submit.setText("Purchase " + Long.toString(total) + " Rials");

            System.out.println(total);
            System.out.println(currentUser.balance);

            if (total > currentUser.balance) {
                JLabel error = new JLabel("Low account balance (" + Long.toString(currentUser.balance) + ")");
                error.setBounds(30, 670, 640, 20);
                error.setForeground(Color.RED);
                add(error);
            } else {
                submit.setEnabled(true);
            }

        } catch (NullPointerException n) {
            Info.setPreferredSize(new Dimension(660, 430));
        }

        setLayout(null);
        Info.setBackground(currentUser.theme.main.background);

        JScrollPane PanelScroll = new JScrollPane(Info);
        PanelScroll.setBorder(null);
        PanelScroll.setBounds(10, 10, 680, 500);
        PanelScroll.getVerticalScrollBar().setBackground(currentUser.theme.main.background);
        PanelScroll.getVerticalScrollBar().setBorder(null);
        PanelScroll.getVerticalScrollBar().setUnitIncrement(10);
        PanelScroll.setBackground(currentUser.theme.main.background);
        PanelScroll.setBorder(new MatteBorder(0, 0, 1, 0, Color.black));

        add(PanelScroll);

        setBackground(currentUser.theme.main.background);
        setVisible(true);
    }
}
