import java.io.*;
import Customer.*;
import Employee.*;
import General.*;
import Manager.*;
import Login.*;

public class Main {
	public static void main(String[] args) {
		new ManagerCreator();
		new EmployeeCreator();
		new ProductCreator();
		new CustomerCreator();
		//new MainFrame();
		invoice();
	}

	public static void invoice() {
		try {
			ObjectInputStream re = new ObjectInputStream(
					new FileInputStream(System.getProperty("user.dir") + "\\data\\Customers.dat"));
			Customer[] all = (Customer[]) re.readObject();
			re.close();

			new InvoiceCreator(all[0].order, 973465, 2931756);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
