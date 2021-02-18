package General;

import java.io.Serializable;

public class Language implements Serializable {
    private static final long serialVersionUID = -4434878878801701341L;

    public static int ENGLISH = 0, PERSIAN = 1;

    mainPanelLanguage main;
    sidePanelLanguage side;
    dialogLanguage dialog;

    public Language() {
        set(0);
    }

    public void set(int mode) {
        main = new mainPanelLanguage(mode);
        side = new sidePanelLanguage(mode);
        dialog = new dialogLanguage(mode);
    }
}

class mainPanelLanguage implements Serializable {
    private static final long serialVersionUID = -139851199553956768L;

    public mainPanelLanguage(int mode) {

    }
}

class sidePanelLanguage implements Serializable {
    private static final long serialVersionUID = 7880294057504229045L;
    String[] toggleList = { "Toggle Side Panel", "پیشخوان" };
    String[] customersList = { "Customers", "مشتری ها" };
    String[] employeesList = { "Employees", "کارکنان" };
    String[] productsList = { "Products", "محصولات" };
    String[] settingsList = { "Settings", "تنظیمات" };
    String[] cartList = { "Cart", "سبد خرید" };
    String[] historyList = { "Order History", "تاریخچه خرید" };
    String[] exitList = { "Log Out/Exit", "خروج" };

    String customers, employees, products, cart, settings, toggle, history, exit;

    public sidePanelLanguage(int mode) {
        customers = customersList[mode];
        employees = employeesList[mode];
        products = productsList[mode];
        cart = cartList[mode];
        settings = settingsList[mode];
        toggle = toggleList[mode];
        history = historyList[mode];
        exit = exitList[mode];
    }
}

class dialogLanguage implements Serializable {
    private static final long serialVersionUID = 2545373340792459048L;

    public dialogLanguage(int mode) {

    }
}