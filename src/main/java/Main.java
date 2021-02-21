import Customer.CustomerCreator;
import Employee.EmployeeCreator;
import General.ProductCreator;
import Login.*;
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