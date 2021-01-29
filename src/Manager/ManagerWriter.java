package Manager;

import java.io.*;

public class ManagerWriter {
    ManagerWriter(Manager currentManager) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Manager.dat"));
            writer.writeObject(currentManager);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
