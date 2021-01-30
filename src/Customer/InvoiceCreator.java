package Customer;

import General.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class InvoiceCreator {
    int width = 1220, height;

    File imageFile = new File("Sales Invoice.png");

    public InvoiceCreator(Order currentOrder, long discount, long purchased) {
        height = 150 + currentOrder.products.length * 50 + 280;

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
        drawer.drawString("Sales Invoice", 490, 60);

        drawer.setFont(new Font("Tahoma", Font.BOLD, 20));

        drawer.drawString("Product name", 60, 120);
        drawer.drawString("Base price", 320, 120);
        drawer.drawString("Amount", 580, 120);
        drawer.drawString("Discount", 800, 120);
        drawer.drawString("Total price", 1020, 120);

        for (int i = 0; i < currentOrder.products.length; i++) {

        }

        try {
            ImageIO.write(bufferedImage, "png", imageFile);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
