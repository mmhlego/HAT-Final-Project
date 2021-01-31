import java.io.*;

public class RandomInvoice {
    public static void RandomReceipt() {
        try {
            ObjectInputStream re = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));
            Customer[] all = (Customer[]) re.readObject();
            re.close();

            new InvoiceCreator(all[0].order, 975454541346l, 293451571756L);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
