package Customer;

import java.io.*;

public class CustomerWriter {
    CustomerWriter(Customer currentCustomer) {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));
            Customer[] allCustomers = (Customer[]) reader.readObject();
            reader.close();

            allCustomers[currentCustomer.index] = currentCustomer;

            ObjectOutputStream writer = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));
            writer.writeObject(allCustomers);
            writer.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
