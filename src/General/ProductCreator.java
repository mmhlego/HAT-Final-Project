package General;

import java.io.*;
//import java.util.*;

public class ProductCreator {
    public ProductCreator() {
        writeData();
        //readData();
    }

    public void writeData() {
        try {
            ObjectOutputStream x = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Products.dat"));

            //Random r = new Random();

            int n = 30;

            Product[] c = new Product[n];

            /*for (int i = 0; i < n; i++) {
                c[i] = new Product("Product " + i, "Description of product " + i, (long) r.nextInt(20),
                        (long) r.nextInt(100) * 10000);
            }*/

            final int dollar = 220000;
            c[0] = new Product("Asus ROG Gaming Phone 3",
                    "Dual-SIM 512 ROM ,16 GB RAM Factory Unlocked 5G Smartphone\n(BLACK)", 5, 2799 * dollar);
            c[1] = new Product("Samsung Galaxy Z Flip 5G",
                    "US version Smartphone \n256 GB Storage\nMystic Gray with Samsung Galaxy Buds live,True Wireless Earbuds",
                    10, 1390 * dollar);
            c[2] = new Product("Samsung Galaxy Note 9", "128 GB SM-N960F\n(Midnight BLACK)", 12, 1106 * dollar);
            c[3] = new Product("Samsung Electronics Galaxy Note 20 Ultra 5G",
                    "US Version, 128 GB of Storage \nMobile Gaming Smartphone ,long-Lasting Battery\n(Mystic Bronze",
                    30, 900 * dollar);
            c[4] = new Product("Nokia 8.3 5G", "128 GB Memory,Quad Camera,Dual SIM,and 6.81-Inch Screen\n(Polar Night)",
                    17, 575 * dollar);
            c[5] = new Product("Samsung Galaxy S10+", "128 GB+8GB RAM SM-G975F/DS Dual SIM 6.4 LTE\n(Prism Black)", 33,
                    609 * dollar);
            c[6] = new Product("Sony Headphones",
                    "Lightweight and Comfortable on ear design\n30 millimeter drivers for rich, full frequency response\n(Black)",
                    49, 11 * dollar);
            c[7] = new Product("Apple EarPods with Lightning Connector",
                    "The speakers inside the EarPods have been engineered to maximize sound output and minimize sound loss, which means you get high-quality audio\n(White)",
                    100, 23 * dollar);
            c[8] = new Product("ULAK Galaxy Note 10 plus case",
                    "Heavy Duty Shockproof Rugged Protection case Transparent Soft TPU Protective Cover for Samsung Galaxy Note 10 Plus\n(Crystal Clear)",
                    200, 11 * dollar);
            c[9] = new Product("Samsung Galaxy Note 20 Ultra Case",
                    "Control with ease. it's simple to answer the calls\n(Black)", 150, 29 * dollar);
            c[10] = new Product("Microsoft Surface Book 3",
                    "13.5\"touch Screen, 10th Gen Intel Core i7-16 GB Memory-256 Gb SSD\n(Silver)", 7, 1600 * dollar);
            c[11] = new Product("Amazon Computer Mouse",
                    "All the basic function of a mouse in a comfortable design that works for left or right handed users\n(Black)",
                    100, 15 * dollar);
            c[12] = new Product("USB mouse", "Mini Cute USB mouse for Laptop, Durable\n(Black)", 100, 3 * dollar);
            c[13] = new Product("Gaming keyboard", "Corsair K55 RGB Gaming Keyboard-IP42 Dust and water Resistance", 50,
                    13 * dollar);
            c[14] = new Product("USB C to HDMI Adapter", "nonda USB type-C to HDMI Adapter for Macbook Pro 2017/2016",
                    60, 6 * dollar);
            c[15] = new Product("PNY Attache USB 2.0 Flash Drive",
                    "Compatible with PC and Mac laptop and desktop computers.16 GB\n(Silver)", 300, dollar);
            c[16] = new Product("Sandisk USB Flash Drive", "16 GB ,USB 2.0 Enabled \n(Red)", 100, 2 * dollar - 5000);
            c[17] = new Product("32 GB memory card",
                    "New 32 GB micro SDHC TF memory card class 10w/SD \nadapter for smartphones tablet", 150,
                    dollar + 30000);
            c[18] = new Product("USB lamp light", "Plastic USB lamp light w/metal flux", 90, 2 * dollar + 50000);
            c[19] = new Product("Light bulb",
                    "Emart full spectrum light bulb,2 x 45 W 55000k CFL daylight for photography photo video studio lighting",
                    140, dollar - 50000);
            c[20] = new Product("Solimo hand sanitizer", "62% Ethyl Alcohol\nkill more than 99.99%  of common germs",
                    1000, dollar / 2);
            c[21] = new Product("Hand sanitizer gel", "Wave hand sanitizer gel ,75% Ethyl Alcohol", 500,
                    dollar - 70000);
            c[22] = new Product("Men masks", "Men masks for coronavirus protection\ncomfortable and washable", 1000,
                    dollar / 12);
            c[23] = new Product("Cotton mask", "Cotton mask for coronavirus protection\nWashable", 300, dollar / 6);
            c[24] = new Product("Java how to program book", "Author:Deitel\n", 100, 35 * dollar);
            c[25] = new Product("Introduction to java programming", "Author:DR.Y.Daniel Liang", 100, 42 * dollar);
            c[26] = new Product("Windows 10", "Windows 10 home edition", 400, 29 * dollar);
            c[27] = new Product("Microsoft office",
                    "For students and families who want classic office 2019\nversions of Word, Excel, Powerpoint and OneNote",
                    100, 20 * dollar);
            c[28] = new Product("Micro SD to SD adapter", "Kingston SD adapter\nmicro SD to a full sized SD adapter",
                    100, dollar - 200000);
            c[29] = new Product("This shop program", "This a HAT team Project programming basics class", 1000, 10000);

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
