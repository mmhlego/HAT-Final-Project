import Customer.CustomerCreator;
import Employee.EmployeeCreator;
import General.ProductCreator;
import Login.*;
import Manager.ManagerCreator;

public class Main {
	public static void main(String[] args) {
		new ManagerCreator();
		new EmployeeCreator();
		new ProductCreator();
		new CustomerCreator();
		new MainFrame();
	}
}
