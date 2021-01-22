import Customer.*;
import General.ProductCreator;

public class Main {
    public static void main(String[] args) {
        new ProductCreator();
        new CustomerCreator();
        new MainFrame();
        //new ManagerFrame(new Manager("J.", "Tanha", "JTanha", "jtanha", "09142075023"));
    }
}