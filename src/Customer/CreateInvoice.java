package Customer;

import General.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class CreateInvoice {
    int width = 900, height;

    File imageFile = new File("Sales Invoice.png");

    public CreateInvoice(Order currentOrder, long discount, long purchased) {
        height = 150 + currentOrder.products.length * 50 + 280;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D drawer = bufferedImage.createGraphics();

        drawer.setColor(Color.white);
        drawer.fillRect(0, 0, width, height);

        drawer.setColor(Color.black);
        drawer.setFont(new Font("Tahoma", Font.BOLD, 25));
        drawer.drawString("Sales Invoice", 380, 50);

        for (int i = 0; i < currentOrder.products.length; i++) {

        }

        try {
            ImageIO.write(bufferedImage, "png", imageFile);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
