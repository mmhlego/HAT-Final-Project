package General;

import java.awt.*;
import java.io.Serializable;

public class Theme implements Serializable {

    /*private Color[] mainBackgrounds = { Hex("f2f2f2"), Hex("393e46"), Hex("363333"), Hex("393e46"), Hex("393e46") };
    
    private Color[] sideBackgrounds = { Hex("ffffff"), Hex("222831"), Hex("272121"), Hex("00adb5"), Hex("79d70f") };
    
    private Color[] fontColors = { Hex("000000"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("000000") };
    
    private Font[] fonts = { new Font("Dialog", 0, 14), new Font("Dialog", 0, 16), new Font("Dialog", 0, 16),
            new Font("Dialog", 0, 16), new Font("Dialog", 0, 16) };
    
    private String[] icons = { "dark", "light", "light", "light", "dark" };
    
    //=======================================================================================================================
    
    public Color background;
    public Color sidepanel;
    public Font font;
    public Color fontColor;
    public String icon;*/

    private static final long serialVersionUID = -4097480035409892164L;

    public MainTheme main = new MainTheme();
    public SidePanelTheme sidePanel = new SidePanelTheme();
    public DialogTheme dialog = new DialogTheme();

    public static final int LIGHT = 0, DARK = 1, CLASSIC = 2, MODERN = 3;

    public Theme() {
        //setAll(1);
        setTheme("modern");
    }

    public void setTheme(String type) {
        switch (type) {
            case "light":
            case "default":
                setAll(0);
                break;
            case "dark":
                setAll(1);
                break;
            case "classic":
                setAll(2);
                break;
            case "modern":
                main.set(0);
                sidePanel.set(1);
                dialog.set(0);
                //setAll(3);
                break;
        }
    }

    public void setAll(int i) {
        /*background = mainBackgrounds[i];
        sidepanel = sideBackgrounds[i];
        font = fonts[i];
        fontColor = fontColors[i];
        icon = icons[i];*/

        main.set(i);
        sidePanel.set(i);
        dialog.set(i);
    }

    public Color Hex(String s) {

        if (s.length() == 7) {
            s = s.substring(1);
        }

        int r = val(s, 0) * 16 + val(s, 1);
        int g = val(s, 2) * 16 + val(s, 3);
        int b = val(s, 4) * 16 + val(s, 5);

        return new Color(r, g, b);
    }

    public int val(String s, int index) {
        s = s.toUpperCase();
        int num = (int) s.charAt(index);
        if (num <= 57) {
            num -= 48;
        } else if (num <= 70) {
            num -= 55;
        }
        return num;
    }

    public class SidePanelTheme implements Serializable {
        private static final long serialVersionUID = 6949296710053557788L;

        private Color[] backgrounds = { Hex("ffffff"), Hex("222831"), Hex("272121"), Hex("00adb5"), Hex("79d70f") };
        private Color[] fontColors = { Hex("000000"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("000000") };
        private Font[] fonts = { new Font("Dialog", 0, 14), new Font("Dialog", 0, 16), new Font("Dialog", 0, 16),
                new Font("Dialog", 0, 16), new Font("Dialog", 0, 16) };
        private String[] icons = { "dark", "light", "light", "light", "dark" };

        public Color background, fontColor, textField, exit;
        public Font font;
        public String icon;

        public void set(int i) {
            this.background = backgrounds[i];
            this.fontColor = fontColors[i];
            // this.textField = textFields[i];
            // this.exit = exits[i];
            this.font = fonts[i];
            this.icon = icons[i];
        }
    }

    public class MainTheme implements Serializable {
        private static final long serialVersionUID = -7064679101758987269L;

        private Color[] backgrounds = { Hex("f2f2f2"), Hex("393e46"), Hex("363333"), Hex("393e46"), Hex("393e46") };
        private Color[] fontColors = { Hex("000000"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("000000") };
        private Font[] fonts = { new Font("Dialog", 0, 14), new Font("Dialog", 0, 16), new Font("Dialog", 0, 16),
                new Font("Dialog", 0, 16), new Font("Dialog", 0, 16) };
        private String[] icons = { "dark", "light", "light", "light", "dark" };

        public Color background, fontColor, textField;
        public Font font;
        public String icon;

        public void set(int i) {
            this.background = backgrounds[i];
            this.fontColor = fontColors[i];
            // this.textField = textFields[i];
            this.font = fonts[i];
            this.icon = icons[i];
        }
    }

    public class DialogTheme implements Serializable {
        private static final long serialVersionUID = -7640849422464760478L;

        private Color[] backgrounds = { Hex("f2f2f2"), Hex("393e46"), Hex("363333"), Hex("393e46"), Hex("393e46") };
        private Color[] fontColors = { Hex("000000"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("000000") };
        private Font[] fonts = { new Font("Dialog", 0, 14), new Font("Dialog", 0, 16), new Font("Dialog", 0, 16),
                new Font("Dialog", 0, 16), new Font("Dialog", 0, 16) };
        //private String[] icons = { "dark", "light", "light", "light", "dark" };

        public Color background, fontColor, textField;
        public Font font;
        //public String icon;

        public void set(int i) {
            this.background = backgrounds[i];
            this.fontColor = fontColors[i];
            // this.textField = textFields[i];
            this.font = fonts[i];
            //this.icon = icons[i];
        }
    }
}