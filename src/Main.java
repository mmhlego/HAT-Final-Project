import Login.*;
import Manager.*;
import Customer.*;
public class Main {
    public static void main(String[] args) {
        //new MainFrame();
        new CustomerCreator();
        new ManagerFrame(new Manager("" , "" , "" , "" , ""));
    }
}
