package General;

import java.io.*;

public class ProductWriter {
    public ProductWriter(Product currentProduct) {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));
            Product[] allProducts = (Product[]) reader.readObject();
            reader.close();

            allProducts[currentProduct.index] = currentProduct;

            ObjectOutputStream writer = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));
            writer.writeObject(allProducts);
            writer.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
