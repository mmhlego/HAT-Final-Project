import Login.*;
import Manager.*;

public class Main {
    public static void main(String[] args) {
        //new MainFrame();
        //new ProductCreator();
        new ManagerFrame(new Manager("", "", "", "", ""));
    }
}
