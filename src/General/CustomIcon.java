package General;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class CustomIcon extends ImageIcon {
    private static final long serialVersionUID = -1883807594813343773L;

    public CustomIcon(String name, int w, int h) {
        try {
            BufferedImage img = ImageIO
                    .read(new File(System.getProperty("user.dir") + "\\Images\\Icons\\" + name + ".png"));
            //BufferedImage img = ImageIO.read(new File("Images\\Icons\\" + name + ".png"));
            setImage(img.getScaledInstance(w, h, 4));
        } catch (Exception e) {
            System.out.println("\'" + name + ".png\' Not Found");
        }
    }
}
