import Login.*;
import Customer.CustomerCreator;
import Employee.EmployeeCreator;
import General.ProductCreator;
import Manager.ManagerCreator;

public class Main {
	public static void main(String[] args) {
		new ProductCreator();
		new CustomerCreator();
		new EmployeeCreator();
		new ManagerCreator();
		new MainFrame();
	}
}
