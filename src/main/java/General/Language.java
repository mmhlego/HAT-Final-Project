package General;

import java.io.Serializable;

public class Language implements Serializable {
    private static final long serialVersionUID = -4434878878801701341L;

    public static int ENGLISH = 0, PERSIAN = 1;

    public settingsLanguage settings;
    public sidePanelLanguage side;
    public productsLanguage products;
    public customersLanguage customers;
    public EmployeeLanguage employee;
    public CustomTheme theme;
    public int mode;

    public String save, cancel, back, yes, no, exit, logOut;

    public Language(User currentUser) {
        set(PERSIAN);
    }

    String[] currencyList = { " Rials", " ريال" };
    public String currency;

    public void set(int mode) {
        this.mode = mode;

        settings = new settingsLanguage(mode);
        side = new sidePanelLanguage(mode);
        products = new productsLanguage(mode);
        customers = new customersLanguage(mode);
        currency = currencyList[mode];
        theme = new CustomTheme(mode);
        setIndivs(mode);
    }

    public void setIndivs(int mode) {
        String[] saveList = { "Save", "ذخیره" };
        String[] cancelList = { "Cancel", "لغو" };
        String[] backList = { "Back", "بازگشت" };
        String[] yesList = { "Yes", "بلی" };
        String[] noList = { "No", "خیر" };
        String[] exitList = { "Exit", "بستن" };
        String[] logOutList = { "Log out", "خروج" };

        save = saveList[mode];
        cancel = cancelList[mode];
        back = backList[mode];
        yes = yesList[mode];
        no = noList[mode];
        exit = exitList[mode];
        logOut = logOutList[mode];

        employee = new EmployeeLanguage(mode);
    }

    public class settingsLanguage implements Serializable {
        private static final long serialVersionUID = -139851199553956768L;

        String[] informationList = { "Informations", "اطلاعات" };
        String[] usernameList = { "Username", "نام کاربری" };
        String[] passwordList = { "Password", "رمز عبور" };
        String[] firstNameList = { "First Name", "نام" };
        String[] lastNameList = { "Last Name", "نام خانوادگی" };
        String[] phoneList = { "Phone Number", "شماره تلفن" };
        String[] addressList = { "Address", "ادرس" };
        String[] balanceList = { "Balance", "موجودی" };
        String[] idList = { "ID", "شماره شناسایی" };
        String[] editList = { "Edit Information", "تغییر اطلاعات" };
        String[] saveList = { "Save Information", "اطلاعات را ذخیره کن" };

        String[] themeList = { "Theme", "پوسته ها" };
        String[] lightThemeList = { "Light Theme", "پوسته روشن" };
        String[] darkThemeList = { "Dark Theme", "پوسته تیره" };
        String[] classicThemeList = { "Classic Theme", "پوسته کلاسیک" };
        String[] modernThemeList = { "Modern Theme", "پوسته مدرن" };
        String[] customThemeList = { "Custom Theme", "شخصی سازی پوسته" };
        String[] previewList = { "Preview", "پیش نمایش" };
        String[] applySelectedList = { "Apply", "اعمال" };
        public String[] sampleTextList = { "sample text", "نوشته نمونه" };

        public String information, useername, password, firstName, lastName, phone, addreess, balance, edit, save,
                theme, lightTheme, darkTheme, classicTheme, modernTheme, customTheme, preview, applySelected, id,
                sampleText;

        public settingsLanguage(int mode) {
            information = informationList[mode];
            useername = usernameList[mode];
            password = passwordList[mode];
            firstName = firstNameList[mode];
            lastName = lastNameList[mode];
            phone = phoneList[mode];
            addreess = addressList[mode];
            balance = balanceList[mode];
            id = idList[mode];
            edit = editList[mode];
            save = saveList[mode];
            theme = themeList[mode];
            lightTheme = lightThemeList[mode];
            darkTheme = darkThemeList[mode];
            classicTheme = classicThemeList[mode];
            modernTheme = modernThemeList[mode];
            customTheme = customThemeList[mode];
            preview = previewList[mode];
            applySelected = applySelectedList[mode];
            sampleText = sampleTextList[mode];
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
        String[] exitList = { "Log Out / Exit                  ", "                 بستن / خروج" };
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

    public class productsLanguage implements Serializable {
        private static final long serialVersionUID = -784625214019987888L;

        String[] backList = { "Back", "بازگشت" };
        String[] nameList = { "Name", "نام" };
        String[] descriptionList = { "Description", "توضیحات" };
        String[] amountList = { "Amount", "تعداد" };
        String[] basePriceList = { "Base Price", "قیمت پایه" };
        String[] priceList = { "Price", "قیمت" };
        String[] addToCartList = { "Add to Cart", "افزودن به سبد خرید" };
        String[] specialOfferList = { "Special Offer!", "فروش ویژه!" };
        String[] onlyList = { "Only ", "تنها " };
        String[] LeftList = { " Left!", " عدد باقیست!" };
        String[] outOfStockList = { "Out Of Stock!", "کالا موجود نیست!" };
        String[] saveList = { "Save", "ذخیره" };
        String[] cancelList = { "Cancel", "لغو" };
        String[] discountList = { "Discount", "تخفیف" };
        String[] totalPriceList = { "Total Price", "قیمت تمام شده" };
        String[] totalDiscountList = { "Total Discount", "کل تخفیف ها" };
        String[] emptyCartList = { "Cart is Empty", "سبد خرید خالیست" };
        String[] orderList = { "Order", "سفارش" };
        String[] productList = { "Product", "کالا" };
        String[] addNewList = { "Add New Product", "افزودن کالای جدید" };

        String[] areYouSureTitleList = { "Are you sure?", "آیا مطمئن هستید؟" };
        String[] areYouSureDescriptionList = { "Are you sure you want to delete product with these information?",
                "آیا مطمئن هستید که میخواهید کالا با اطلاعات زیر را پاک کنید؟" };
        String[] removeSuccessTitleList = { "Product Removed", "کالا حذف شد" };
        String[] wrongFormatTitleList = { "Wrong Format", "فرمت نادرست" };
        String[] removeSuccessDescriptionList = { "Product removed successfully.", "کالا با موفقیت حذف شد." };
        String[] wrongFormatDescriptionList = { "Wrong format has been entered.", "فرمت اشتباهی وارد شده است." };
        String[] howManyItemsTitleList = { "Add Amount", "مقداری که اضافه خواهد شد" };
        String[] howManyItemsDescriptionList = { "How many items do you want to add to ",
                "چه تعدادی را میخواهید اضافه کنید به " };
        String[] updateTitleList = { "Product Updated", "کالا بروز شد" };
        String[] updateDescriptionList = { "Product information updaated successfully.",
                "اطلاعات کالا با موفقیت بروزرسانی شد." };
        String[] amountAddedTitleList = { "Success", "موفقیت آمیز" };
        String[] amountAddedDescriptionList = { "Amount added successfully.", "تعداد با موفقیت اضافه شد" };
        String[] receiptTitleList = { "Successful", "موفقیت" };
        String[] receiptDescriptionList = { "     Purchased Successfully ! \n\nDo You Want To Print Receipt ? \n\n",
                "     پرداخت با موفقیت انجام شد ! \n\nآیا مایل هستید که رسید چاپ شود ؟ \n\n" };

        public String back, name, description, amount, basePrice, price, addToCart, specialOffer, only, left,
                outOfStock, save, cancel, discount, totalPrice, totalDiscount, emptyCart, order, product, addNew,
                areYouSureTitle, areYouSureDescription, removeSuccessTitle, removeSuccessDescription, wrongFormatTitle,
                wrongFormatDescription, howManyItemsTitle, howManyItemsDescription, updateTitle, updateDescription,
                amountAddedTitle, amountAddedDescription, receiptTitle, receiptDescription;

        public productsLanguage(int mode) {
            back = backList[mode];
            name = nameList[mode];
            description = descriptionList[mode];
            amount = amountList[mode];
            basePrice = basePriceList[mode];
            price = priceList[mode];
            addToCart = addToCartList[mode];
            specialOffer = specialOfferList[mode];
            only = onlyList[mode];
            left = LeftList[mode];
            outOfStock = outOfStockList[mode];
            save = saveList[mode];
            cancel = cancelList[mode];
            discount = discountList[mode];
            totalPrice = totalPriceList[mode];
            totalDiscount = totalDiscountList[mode];
            emptyCart = emptyCartList[mode];
            order = orderList[mode];
            product = productList[mode];
            areYouSureTitle = areYouSureTitleList[mode];
            areYouSureDescription = areYouSureDescriptionList[mode];
            removeSuccessTitle = removeSuccessTitleList[mode];
            removeSuccessDescription = removeSuccessDescriptionList[mode];
            wrongFormatTitle = wrongFormatTitleList[mode];
            wrongFormatDescription = wrongFormatDescriptionList[mode];
            howManyItemsTitle = howManyItemsTitleList[mode];
            howManyItemsDescription = howManyItemsDescriptionList[mode];
            updateTitle = updateTitleList[mode];
            addNew = addNewList[mode];
            updateDescription = updateDescriptionList[mode];
            amountAddedTitle = amountAddedTitleList[mode];
            amountAddedDescription = amountAddedDescriptionList[mode];
            receiptTitle = receiptTitleList[mode];
            receiptDescription = receiptDescriptionList[mode];
        }
    }

    public class customersLanguage implements Serializable {
        private static final long serialVersionUID = 1L;

        String[] editInfoList = { "Edit Information", "تغییر اطلاعات" };
        String[] nameList = { "Name", "نام" };
        String[] passwordList = { "Password", "گذرواژه" };
        String[] lastNameList = { "Last Name", "نام خانوادگی" };
        String[] userNameList = { "Username", "نام کاربری" };
        String[] balanceList = { "Balance", "موجودی" };
        String[] addressList = { "Address", "ادرس" };
        String[] phoneList = { "Phone number", "شماره تلفن" };
        String[] saveList = { "Save", "ذخیره" };
        String[] updateTitleList = { "Customer Updated", "اطلاعات بروز شد" };
        String[] updateDescriptionList = { "Customer information updated successfully",
                "اطلاعات مشتری با موفقیت بروزرسانی شد" };
        String[] cancelList = { "Cancel", "لغو" };
        String[] orderHistoryList = { "Order ", "سفارش شماره ی" };
        String[] areYouSureTitleList = { "Are you sure?", "آیا مطمئن هستید؟" };
        String[] areYouSureDescriptionList = { "Are you sure you want to delete customer with this information?",
                "آیا مطمئن هستید که میخواهید مشتری با اطلاعات زیر را پاک کنید؟" };
        String[] removeSuccessTitleList = { "Customer Removed", "مشتری حذف شد" };
        String[] removeSuccessDescriptionList = { "Customer removed sucessfully.", "اطلاعات مشتری با موفقیت حذف شد" };
        String[] lowBalanceList = { "Low account balance", "موجودی کافی نیست" };
        String[] purchaseList = { "Purchase", "پرداخت" };
        String[] onlineList = { "online", "اینترنتی" };
        String[] fromBalanceList = { "from balance", "از موجودی" };

        public String editInfo, name, password, lastName, userName, balance, address, phone, save, updateTitle,
                updateDescription, cancel, orderHistory, areYouSureTitle, areYouSureDescription, removeSuccessTitle,
                removeSuccessDescription, lowBalance, purchase, online, fromBalance;

        public customersLanguage(int mode) {
            editInfo = editInfoList[mode];
            name = nameList[mode];
            password = passwordList[mode];
            lastName = lastNameList[mode];
            address = addressList[mode];
            userName = userNameList[mode];
            balance = balanceList[mode];
            phone = phoneList[mode];
            save = saveList[mode];
            updateTitle = updateTitleList[mode];
            updateDescription = updateDescriptionList[mode];
            cancel = cancelList[mode];
            orderHistory = orderHistoryList[mode];
            areYouSureDescription = areYouSureDescriptionList[mode];
            areYouSureTitle = areYouSureTitleList[mode];
            removeSuccessTitle = removeSuccessTitleList[mode];
            removeSuccessDescription = removeSuccessDescriptionList[mode];
            lowBalance = lowBalanceList[mode];
            purchase = purchaseList[mode];
            online = onlineList[mode];
            fromBalance = fromBalanceList[mode];
        }
    }

    public class EmployeeLanguage implements Serializable {
        private static final long serialVersionUID = 7433904027520906022L;
        String[] addList = { "Add New Employees", "افزودن کارمند جدید" };
        String[] editList = { "Edit Information", "ویرایش اطلاعات" };
        String[] nameList = { "Name", "نام" };
        String[] lastNameList = { "Last Name", "نام خانوادگی" };
        String[] userNameList = { "Username", "نام کاربری" };
        String[] IDList = { "ID", "شناسه" };
        String[] phoneList = { "Phone Number", "شماره تلفن" };
        String[] saveList = { "Save", "ذخیره" };
        String[] updateDescriptionList = { "Employee information updated successfully.",
                "اطلاعات کارمند با موفقیت بروز رسانی شد" };
        String[] updateTitleList = { "Employee Updated", "اطلاعات بروزرسانی شد" };
        String[] cancelList = { "Cancel", "لغو" };
        String[] passwordList = { "Password", "رمز عبور" };
        String[] areYouSureDescriptionList = { "Are you sure you want to delete employee with these information?",
                "آیا مطمئن هستید که میخواهید کارمندی با اطلاعات زیر را حذف کنید ؟ " };
        String[] areYouSureTitleList = { "Are you sure", "آیا مطمئنید" };
        String[] removeDescriptionList = { "Employee removed successfully.", "کارمند با موفقیت حذف شد" };
        String[] removeTitleList = { "Employee Removed", "کارمند حذف شد" };
        String[] firstNameList = { "First Name", "نام" };
        String[] employeeList = { "Employee", "کارمند" };

        public String add, edit, name, lastName, userName, ID, phone, save, updateDescription, updateTitle, cancel,
                password, areYouSureDescription, areYouSureTitle, removeDescription, removeTitle, firstName, employee;

        public EmployeeLanguage(int mode) {
            add = addList[mode];
            edit = editList[mode];
            name = nameList[mode];
            lastName = lastNameList[mode];
            userName = userNameList[mode];
            ID = IDList[mode];
            phone = phoneList[mode];
            save = saveList[mode];
            updateDescription = updateDescriptionList[mode];
            updateTitle = updateTitleList[mode];
            cancel = cancelList[mode];
            password = passwordList[mode];
            areYouSureDescription = areYouSureDescriptionList[mode];
            areYouSureTitle = areYouSureTitleList[mode];
            removeDescription = removeDescriptionList[mode];
            removeTitle = removeTitleList[mode];
            firstName = firstNameList[mode];
            employee = employeeList[mode];

        }

    }

    public class CustomTheme implements Serializable {
        private static final long serialVersionUID = 5171766047251248796L;

        String[] sidePreviewList = { "Side Panel Preview", "پیش نمایش پنل کناری" };
        String[] exitPreviewList = { "Exit Preview", "پیش نمایش خروج" };
        String[] mainPreviewList = { "Main Panel Preview", "پیش نمایش پنل اصلی" };
        String[] dialogPreviewList = { "Dialog Preview", "پیش نمایش پنل اطلاعات" };
        String[] sideThemeList = { "Side Panel Theme", "پوسته پنل کناری" };
        String[] mainThemeList = { "Main Panel Theme", "پوسته پنل اصلی" };
        String[] dialogThemeList = { "Dialog Theme", "پوسته پنل اطلاعات" };
        String[] previewList = { "Preview", "پیش نمایش" };
        String[] themeCreatorList = { "Custom Theme Creator", "سازنده پوسته شخصی" };
        String[] applyList = { "Apply", "اعمال" };

        public String sidePreview, exitPreview, mainPreview, dialogPreview, sideTheme, mainTheme, dialogTheme, preview,
                themeCreator, apply;

        public CustomTheme(int mode) {
            sidePreview = sidePreviewList[mode];
            exitPreview = exitPreviewList[mode];
            mainPreview = mainPreviewList[mode];
            dialogPreview = dialogPreviewList[mode];
            sideTheme = sideThemeList[mode];
            mainTheme = mainThemeList[mode];
            dialogTheme = dialogThemeList[mode];
            preview = previewList[mode];
            themeCreator = themeCreatorList[mode];
            apply = applyList[mode];

        }
    }

    /*
     * public class dialogLanguage implements Serializable { private static final
     * long serialVersionUID = 2545373340792459048L;
     * 
     * public dialogLanguage(int mode) {
     * 
     * } }
     */
}