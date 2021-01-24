import Customer.CustomerCreator;
import Employee.EmployeeCreator;
import General.ProductCreator;
import Login.*;
import Manager.ManagerCreator;

public class Main {
    public static void main(String[] args) {
        new ProductCreator();
        new ManagerCreator();
        new EmployeeCreator();
        new CustomerCreator();

        new MainFrame();
        //new ManagerFrame(new Manager("", "", "", "", ""));
    }
}
