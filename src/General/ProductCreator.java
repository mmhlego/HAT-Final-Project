package General;

import java.io.*;
import java.util.*;

public class ProductCreator {
    public ProductCreator() {
        writeData();
        readData();
    }

    public void writeData() {
        try {
            ObjectOutputStream x = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));

            Random r = new Random();

            int n = 20;

            Product[] c = new Product[n];

            for (int i = 0; i < n; i++) {
                c[i] = new Product("Product " + i, "Description of product " + i, (long) r.nextInt(20),
                        (long) r.nextInt(100) * 10000);
            }

            x.writeObject(c);
            x.flush();
            x.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void readData() {
        try {
            ObjectInputStream x = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));

            Product[] c = (Product[]) x.readObject();

            for (int i = 0; i < c.length; i++) {
                System.out.println(c[i].name);
                System.out.println(c[i].description);
                System.out.println(c[i].amount);
                System.out.println(c[i].price);
            }

            x.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
