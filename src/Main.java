import Customer.*;
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
		//new CustomerFrame(
		//		new Customer("firstName", "lastNameField", "user", "passwordLabel", "phone", "ad", 999999999));
	}
}
