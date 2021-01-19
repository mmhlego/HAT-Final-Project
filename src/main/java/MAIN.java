import Customer.*;
import Manager.*;
import Employee.*;
import General.*;

import java.io.*;

public class MAIN {
    public static void main(String[] args) {

        //new CustomerCreator();
        //new ProductCreator();
        //writeData();

        new MainFrame();

        //new ManagerFrame(new Manager());
        //new EmployeeFrame(new Employee());
    }

    public static void writeData() {
        try {
            ObjectOutputStream x = new ObjectOutputStream(new FileOutputStream("data\\Employees.dat"));

            Employee[] stus = new Employee[3];

            stus[0] = new Employee("kamyab", "tabani", "K. Tabani", "kamyabt", "09140000001", "1");
            stus[1] = new Employee("mohammad mahdi", "hejazi", "M. M. Hejazi", "mmhlego", "09140000002", "2");
            stus[2] = new Employee("pouya", "afraz", "P. Afraz", "pouyaa", "09140000003", "3");

            x.writeObject(stus);

            x.flush();
            x.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void readData() {
        try {
            ObjectInputStream x = new ObjectInputStream(new FileInputStream("data\\Employees.dat"));

            Employee[] stus = (Employee[]) x.readObject();

            for (int i = 0; i < stus.length; i++) {
                System.out.println(stus[i].username);
                System.out.println(stus[i].password);
                System.out.println(stus[i].name);
                System.out.println(stus[i].lastName);
                System.out.println(stus[i].ID);
                System.out.println(stus[i].phoneNumber);

            }

            x.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
