package Customer;

import java.util.*;
import General.*;
import java.io.*;

public class CustomerCreator {
    public CustomerCreator() {
        writeData();
        //readData();
    }

    public void writeData() {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));
            Product[] allProducts = (Product[]) reader.readObject();
            reader.close();

            ObjectOutputStream x = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));
            Random r = new Random();

            String[] firstnames = { "Mahdi", "Arash", "Pouya", "Fatemeh", "Sanaz", "Behnam", "Kamyab", "Sahand",
                    "Shahram", "Taha", "Ali", "Hossein", "Mohammad", "Akbar", "Narges", "Fatemeh", "Nazanin" };
            String[] lastnames = { "Mohammadi", "Hosseini", "Ahmadi", "Rezaei", "Karimi", "Mousavi", "Jafari",
                    "Sadeghi", "Heidari", "Moradi", "Ebrahimi", "Rahimi", "Hashemi", "Ghasemi", "Akbari", "Kazemi",
                    "Salehi" };

            int n = 60;

            Customer[] c = new Customer[n];

            for (int i = 0; i < n; i++) {
                c[i] = new Customer(firstnames[r.nextInt(firstnames.length)], lastnames[r.nextInt(lastnames.length)],
                        "Customer" + i, "Customer" + i, randPhone(), randAdress(), (long) r.nextInt(100) * 100000);

                int count = 1 + r.nextInt(3);
                c[i].pastOrders = new Order[count];

                for (int j = 0; j < count; j++) {
                    c[i].pastOrders[j] = new Order();
                    int m = r.nextInt(3) + 1;
                    c[i].pastOrders[j].status = Order.RECIVED;
                    c[i].pastOrders[j].products = new Product[m];
                    c[i].pastOrders[j].count = new int[m];
                    for (int k = 0; k < m; k++) {
                        c[i].pastOrders[j].products[k] = allProducts[r.nextInt(allProducts.length)];
                        c[i].pastOrders[j].count[k] = 1 + r.nextInt(3);
                    }
                }

                if (r.nextInt(3) >= 0) {
                    c[i].order = new Order();
                    c[i].order.status = Order.IN_PROGRESS;
                    int m = r.nextInt(3) + 1;
                    c[i].order.products = new Product[m];
                    c[i].order.count = new int[m];
                    for (int k = 0; k < m; k++) {
                        c[i].order.products[k] = allProducts[r.nextInt(allProducts.length)];
                        c[i].order.count[k] = 1 + r.nextInt(3);
                    }
                }
            }

            x.writeObject(c);
            x.flush();
            x.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public String randAdress() {
        Random r = new Random();
        String[] regions = { "Zafaranieh", "Sahand", "Abresan", "Shahnaz", "Maralan" };
        String[] alleys = { "Shargi", "Gharbi" };

        return "Tabriz, " + regions[r.nextInt(regions.length)] + ", " + Integer.toString(r.nextInt(20)) + "om "
                + alleys[r.nextInt(2)] + ", Pelak" + Integer.toString(r.nextInt(60));
    }

    public String randPhone() {
        String ans = "0914";
        Random r = new Random();
        for (int i = 0; i < 7; i++) {
            ans += Integer.toString(r.nextInt(10));
        }
        return ans;
    }

    public void readData() {
        try {
            ObjectInputStream x = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));

            Customer[] c = (Customer[]) x.readObject();

            for (int i = 0; i < c.length; i++) {
                System.out.println(c[i].name);
                System.out.println(c[i].lastName);
                System.out.println(c[i].username);
                System.out.println(c[i].password);
                System.out.println(c[i].phoneNumber);
                System.out.println(c[i].address);
                System.out.println(c[i].balance);
            }

            x.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
