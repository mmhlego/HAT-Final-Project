import Customer.CustomerCreator;
import Employee.EmployeeCreator;
import General.ProductCreator;
import Manager.ManagerCreator;
import Login.*;

public class Main {
	public static void main(String[] args) {
		new ManagerCreator();
		new EmployeeCreator();
		new ProductCreator();
		new CustomerCreator();
		new MainFrame();
	}
}
