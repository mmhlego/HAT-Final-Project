package General;

import java.io.Serializable;

public class Language implements Serializable {
    private static final long serialVersionUID = -4434878878801701341L;

    public static int ENGLISH = 0, PERSIAN = 1;

    public settingsLanguage settings;
    public sidePanelLanguage side;
    //public dialogLanguage dialog;

    public Language() {
        set(1);
    }

    public void set(int mode) {
        settings = new settingsLanguage(mode);
        side = new sidePanelLanguage(mode);
        //dialog = new dialogLanguage(mode);
    }

    public class settingsLanguage implements Serializable {
        private static final long serialVersionUID = -139851199553956768L;

        String[] informationList = { "Informations", "اطلاعات" };
        String[] usernameList = { "Username", "نام کاربری" };
        String[] passwordList = { "Password", "رمز عبور" };
        String[] firstNameList = { "First Name;", "نام" };
        String[] lastNameList = { "Last Name", "نام خانوادگی" };
        String[] phoneList = { "Phone Number", "شماره تلفن" };
        String[] addressList = { "Address", "ادرس" };
        String[] balanceList = { "Balance", "موجودی" };
        String[] editList = { "Edit Information", "تغییر اطلاعات" };
        String[] saveList = { "Save Information", "اطلاعات را ذخیره کن" };

        String[] themeList = { "Theme", "پوسته ها" };
        String[] lightThemeList = { "Light Theme", "پوسته روشن" };
        String[] darkThemeList = { "Dark Theme", "پوسته تیره" };
        String[] classicThemeList = { "Classic Theme", "پوسته کلاسیک" };
        String[] modernThemeList = { "Modern Theme", "پوسته مدرن" };
        String[] customThemeList = { "Custom Theme", "شخصی سازی پوسته" };
        String[] previewList = { "Preview", "پیش نمایش" };
        String[] applySelectedList = { "Apply Selected Theme", "پوسته انتخاب شده را اعمال کن" };

        public String information, useername, password, firstName, lastName, phone, addreess, balance, edit, save,
                theme, lightTheme, darkTheme, classicTheme, moderTheme, customTheme, preview, applySelected;

        public settingsLanguage(int mode) {
            information = informationList[mode];
            useername = usernameList[mode];
            password = passwordList[mode];
            firstName = firstNameList[mode];
            lastName = lastNameList[mode];
            phone = phoneList[mode];
            addreess = addressList[mode];
            balance = balanceList[mode];
            edit = editList[mode];
            save = saveList[mode];
            theme = themeList[mode];
            lightTheme = lightThemeList[mode];
            darkTheme = darkThemeList[mode];
            classicTheme = classicThemeList[mode];
            moderTheme = modernThemeList[mode];
            customTheme = customThemeList[mode];
            preview = previewList[mode];
            applySelected = applySelectedList[mode];
        }
    }

    public class sidePanelLanguage implements Serializable {
        private static final long serialVersionUID = 7880294057504229045L;
        String[] toggleList = { "Toggle Side Panel", "پیشخوان" };
        String[] customersList = { "Customers", "مشتری ها" };
        String[] employeesList = { "Employees", "کارکنان" };
        String[] productsList = { "Products", "محصولات" };
        String[] settingsList = { "Settings", "تنظیمات" };
        String[] cartList = { "Cart", "سبد خرید" };
        String[] historyList = { "Order History", "تاریخچه خرید" };
        String[] exitList = { "Log Out/Exit", "خروج" };
        String[] balanceList = { "Balance", "موجودی" };

        public String customers, employees, products, cart, settings, toggle, history, exit, balance;

        public sidePanelLanguage(int mode) {
            customers = customersList[mode];
            employees = employeesList[mode];
            products = productsList[mode];
            cart = cartList[mode];
            settings = settingsList[mode];
            toggle = toggleList[mode];
            history = historyList[mode];
            exit = exitList[mode];
            balance = balanceList[mode];
        }
    }

    /*class dialogLanguage implements Serializable {
    private static final long serialVersionUID = 2545373340792459048L;
    
    public dialogLanguage(int mode) {
    
    }
    }*/
}