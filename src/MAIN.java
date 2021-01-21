import Employee.Employee;
import Employee.EmployeeFrame;
import Manager.Manager;
import Manager.ManagerFrame;

public class MAIN 
{
    
    public static void main(String[] args) 
    {
        // Jeferjun miren party
        //new MainFrame();
        new ManagerFrame(new Manager("J.", "Tanha", "JTanha", "jtanha", "09142075023"));
        //ew EmployeeFrame(new Employee("kamyab", "tabani", "K. Tabani", "kamyabt", "09140000001", "1"));
    }
}
