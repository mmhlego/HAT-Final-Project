package Manager;

import java.io.*;

public class ManagerCreator {
    ManagerCreator() {
        try {
            ObjectOutputStream x = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Manager.dat"));

            x.writeObject(new Manager("J.", "Tanha", "JTanha", "jtanha", "09142075023"));

            x.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
