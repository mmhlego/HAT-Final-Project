package Customer;

import General.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class receiptCreator {
    int width = 1220, height, count;

    File imageFile = new File("Sales Receipt.png");
    long discount = 0;
    long purchased = 0;

    public receiptCreator(Order currentOrder) {
        height = 150 + currentOrder.products.length * 40 + 350;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D drawer = bufferedImage.createGraphics();

        drawer.setColor(Color.white);
        drawer.fillRect(0, 0, width, height);

        drawer.setColor(Color.darkGray);
        drawer.fillRect(5, 5, width - 10, height - 10);

        drawer.setColor(Color.white);
        drawer.fillRect(10, 10, width - 20, height - 20);

        drawer.setColor(Color.black);
        drawer.setFont(new Font("Tahoma", Font.BOLD, 40));
        drawer.drawString("Sales Receipt", 480, 60);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        drawer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        drawer.drawRect(30, 30, 205, 30);
        drawer.drawString(formatter.format(LocalDateTime.now()), 40, 50);

        drawer.setFont(new Font("Tahoma", Font.BOLD, 20));
        drawer.drawString("Product name", 50, 120);
        drawer.drawString("Base price", 480, 120);
        drawer.drawString("Amount", 680, 120);
        drawer.drawString("Discount", 850, 120);
        drawer.drawString("Total price", 1020, 120);
        drawer.drawLine(30, 130, 1170, 130);

        drawer.setFont(new Font("Tahoma", Font.BOLD, 15));

        count = currentOrder.products.length;
        for (int i = 0; i < count; i++) {
            if (i % 2 == 1) {
                drawer.setColor(new Color(231, 231, 231));
                drawer.fillRect(30, 130 + i * 40, 1140, 40);
                drawer.setColor(Color.black);
            }
            drawer.drawString(currentOrder.products[i].name, 50, i * 40 + 155);
            long price = currentOrder.products[i].price;
            drawer.drawString(Long.toString(price), 485, i * 40 + 155);
            int amount = currentOrder.count[i];
            drawer.drawString(Integer.toString(amount), 715, i * 40 + 155);
            int dis = currentOrder.products[i].discount;
            if (dis == 0) {
                drawer.drawString("-", 885, i * 40 + 155);
            } else {
                discount += price * amount * dis / 100;
                drawer.drawString((Integer.toString(dis)) + " %", 875, i * 40 + 155);
            }
            purchased += price * amount * (100 - dis) / 100;
            drawer.drawString(Long.toString(price * amount * (100 - dis) / 100), 1025, i * 40 + 155);
        }

        int marginTop = 130 + count * 40;
        drawer.drawLine(30, marginTop, 1170, marginTop);
        drawer.setFont(new Font("Tahoma", Font.BOLD, 20));

        marginTop += 60;
        drawer.drawString("Total discount : ", 430, marginTop);
        long percent = discount * 100 / (discount + purchased);
        drawer.drawString(Long.toString(discount) + " Rials (" + Long.toString(percent) + "%)", 620, marginTop);

        marginTop += 50;
        drawer.drawString("Total purchased : ", 420, marginTop);
        drawer.drawString(Long.toString(purchased) + " Rials", 620, marginTop);

        drawer.setColor(new Color(231, 231, 231));
        marginTop += 40;
        drawer.fillRect(100, marginTop, width - 220, 100);

        drawer.setColor(Color.black);
        drawer.setFont(new Font("Tahoma", Font.BOLD, 30));
        marginTop += 60;
        drawer.drawString("Purchased total amount of " + Long.toString(purchased) + " Rials", 310, marginTop);

        marginTop += 90;
        drawer.setFont(new Font("Tahoma", Font.ITALIC, 30));
        drawer.drawString("Thanks for shopping", 485, marginTop);

        drawer.setFont(new Font("Tahoma", Font.ITALIC, 16));
        drawer.drawString("Powered by H.A.T.", 560, height - 20);

        try {
            ImageIO.write(bufferedImage, "png", imageFile);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        openFile();
    }

    public void openFile() {
        try {
            Desktop.getDesktop().open(imageFile);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
