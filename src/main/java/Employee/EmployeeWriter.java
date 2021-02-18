package Employee;

import java.io.*;

public class EmployeeWriter {
    EmployeeWriter(Employee currentEmployee) {
        try {
            ObjectInputStream reader = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "\\data\\Employees.dat"));
            Employee[] allEmployees = (Employee[]) reader.readObject();
            reader.close();

            allEmployees[currentEmployee.index] = currentEmployee;

            ObjectOutputStream writer = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "\\data\\Employees.dat"));
            writer.writeObject(allEmployees);
            writer.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
