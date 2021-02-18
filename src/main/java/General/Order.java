package General;

import java.io.Serializable;

public class Order implements Serializable {
    private static final long serialVersionUID = -1734336977709681817L;

    public static final String RECIVED = "recieved", IN_PROGRESS = "in progress";

    public String status;
    public Product[] products = new Product[0];
    public int[] count = new int[0];

    public void printData() {
        System.out.println("Order status: " + status);
        for (int i = 0; i < products.length; i++) {
            System.out.println("-- " + count[i] + " * " + products[i].name);
        }
        System.out.println("----------------------------------");
    }
}
