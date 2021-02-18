package General;

import java.util.*;
import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = -1693819218165123200L;

    public static int counter = 0;
    static Random r = new Random(System.currentTimeMillis());

    public int discount = 0;
    public String name = "product";
    public String description = "description";
    public long amount = 0;
    public long price = 1000;
    public int index;

    public Product(String n, String dis, long a, long p) {
        name = n;
        description = dis;
        amount = a;
        price = p;
        index = counter++;

        if (r.nextInt(4) > 0) {
            if (amount > 100) {
                this.discount = (1 + r.nextInt(8)); //8
            } else if (amount > 50) {
                this.discount = (1 + r.nextInt(7)) * 2; //14
            } else if (amount > 30) {
                this.discount = (1 + r.nextInt(9)) * 3; //27
            } else if (amount > 20) {
                this.discount = (1 + r.nextInt(10)) * 4; //40
            } else if (amount > 10) {
                this.discount = (1 + r.nextInt(11)) * 5; //55
            } else {

            }
        }
    }

    public boolean equals(Product p) {
        if (this.index == p.index) {
            return true;
        }
        return false;
    }
}
