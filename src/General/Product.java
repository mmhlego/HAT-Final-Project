package General;

import java.util.*;
import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = -1693819218165123200L;

    public int discount = 0;
    public String name = "product";
    public String description = "description";
    public long amount = 0;
    public long price = 1000;
    static Random r = new Random(System.currentTimeMillis());

    public Product(String n, String dis, long a, long p) {
        name = n;
        description = dis;
        amount = a;
        price = p;

        if (r.nextInt(3) == 0) {
            this.discount = (1 + r.nextInt(12)) * 5;
        }
    }
}
