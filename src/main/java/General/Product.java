package General;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = -1693819218165123200L;

    public String name = "product";
    public String description = "description";
    public long amount = 0;
    public long price = 1000;

    public Product(String n, String dis, long a, long p) {
        name = n;
        description = dis;
        amount = a;
        price = p;
    }
}
