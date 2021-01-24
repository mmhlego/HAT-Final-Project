package General;

import java.awt.*;
import java.io.Serializable;

public class Theme implements Serializable {
    private static final long serialVersionUID = -4097480035409892164L;

    public static final int DEFAULT = 0, LIGHT = 0, DARK = 1, CLASSIC = 2, MODERN = 3, CYAN = 4, SILVER = 5, LIME = 6,
            ORANGE = 7, BROWN = 8, MAGENTA = 9;

    public MainTheme main = new MainTheme();
    public SidePanelTheme sidePanel = new SidePanelTheme();
    public DialogTheme dialog = new DialogTheme();
    public Color submitColor = new Color(111, 207, 151), cancelColor = Hex("fa4e00");

    public Theme() {
        setTheme("modern");
    }

    public void setTheme(int a, int b, int c) {
        sidePanel.set(a);
        main.set(b);
        dialog.set(c);
    }

    public void setTheme(String type) {
        switch (type.toLowerCase()) {
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
                setAll(3);
                break;
            case "cyan":
                setAll(4);
                break;
            case "silver":
                setAll(5);
                break;
            case "lime":
                setAll(6);
                break;
            case "orange":
                setAll(7);
                break;
            case "brown":
                setAll(8);
                break;
            case "magenta":
                setAll(9);
                break;
            default:
                setAll(0);
        }
    }

    public void setAll(int i) {
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

        private Color[] backgrounds = { Hex("ffffff"), Hex("222831"), Hex("272121"), Hex("222831"), Hex("3ae7ec"),
                Hex("c0c0c0"), Hex("32cd32"), Hex("ffa500"), Hex("a0522d"), Hex("ff00ff") };

        private Color[] fontColors = { Hex("000000"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("000000"),
                Hex("000000"), Hex("000000"), Hex("000000"), Hex("000000"), Hex("c8c8c8") };

        private String[] icons = { "dark", "light", "light", "light", "dark", "dark", "dark", "dark", "dark", "light" };

        public Color background, fontColor, exitColor = Hex("fa4343");
        public Font font;
        public String icon;
        public int mode = 0;

        public void set(int i) {
            this.background = backgrounds[i];
            this.fontColor = fontColors[i];
            this.font = new Font("Dialog", 0, 16);
            this.icon = icons[i];
            this.mode = i;
        }
    }

    public class MainTheme implements Serializable {
        private static final long serialVersionUID = -7064679101758987269L;

        private Color[] backgrounds = { Hex("f2f2f2"), Hex("393e46"), Hex("363333"), Hex("f2f2f2"), Hex("00ffff"),
                Hex("8f8f8f"), Hex("3bf53b"), Hex("ffb900"), Hex("c76538"), Hex("FF6BFF") };

        private Color[] fontColors = { Hex("000000"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("000000"), Hex("000000"),
                Hex("000000"), Hex("000000"), Hex("000000"), Hex("000000"), Hex("000000") };

        private String[] icons = { "dark", "light", "light", "dark", "dark", "dark", "dark", "dark", "dark", "dark" };

        private Color[] buttonColors = { Hex("E0E0E0"), Hex("E0E0E0"), Hex("E0E0E0"), Hex("E0E0E0"), Hex("20b2aa"),
                Hex("a9a9a9"), Hex("58c743"), Hex("ff8C00"), Hex("8b4513"), Hex("c300e3") };

        public Color background, fontColor, buttonColor;
        public Font font = new Font("Dialog", 0, 16);
        public String icon;
        public int mode = 0;

        public void set(int i) {
            this.background = backgrounds[i];
            this.fontColor = fontColors[i];
            this.buttonColor = buttonColors[i];
            this.icon = icons[i];
            this.mode = i;
        }
    }

    public class DialogTheme implements Serializable {
        private static final long serialVersionUID = -7640849422464760478L;

        private Color[] backgrounds = { Hex("ffffff"), Hex("222831"), Hex("272121"), Hex("222831"), Hex("3ae7ec"),
                Hex("c0c0c0"), Hex("32cd32"), Hex("ffa500"), Hex("a0522d"), Hex("ff00ff") };

        private Color[] fontColors = { Hex("000000"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("c8c8c8"), Hex("000000"),
                Hex("000000"), Hex("000000"), Hex("000000"), Hex("000000"), Hex("c8c8c8") };

        private Color[] buttonBackgrounds = { Hex("E0E0E0"), Hex("E0E0E0"), Hex("E0E0E0"), Hex("E0E0E0"), Hex("20b2aa"),
                Hex("a9a9a9"), Hex("58c743"), Hex("ff8C00"), Hex("8b4513"), Hex("c300e3") };

        private Color[] textFieldBackgrounds = { Hex("E0E0E0"), Hex("E0E0E0"), Hex("E0E0E0"), Hex("E0E0E0"),
                Hex("20b2aa"), Hex("a9a9a9"), Hex("58c743"), Hex("ff8C00"), Hex("8b4513"), Hex("c300e3") };

        public Color background, fontColor, buttonBackground, textFieldBackground;
        public Font font = new Font("Dialog", 0, 14);
        public int mode = 0;

        public void set(int i) {
            this.textFieldBackground = textFieldBackgrounds[i];
            this.background = backgrounds[i];
            this.fontColor = fontColors[i];
            this.buttonBackground = buttonBackgrounds[i];
            this.mode = i;
        }
    }
}