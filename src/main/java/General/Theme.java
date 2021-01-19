package General;

import java.awt.*;
import java.io.Serializable;

public class Theme implements Serializable {
    public Color background;
    public Color sidepanel;
    public Font font;
    public Color fontColor;
    public String icon;

    private Color[] backgrounds = { new Color(242, 242, 242), new Color(57, 62, 70), new Color(54, 51, 51),
            new Color(57, 62, 70), new Color(57, 62, 70) };
    private Color[] sidepanels = { new Color(255, 255, 255), new Color(34, 40, 49), new Color(39, 33, 33),
            new Color(0, 173, 181), new Color(121, 215, 15) };
    private Font[] fonts = { new Font("Dialog", 0, 14), new Font("Dialog", 0, 16), new Font("Dialog", 0, 16),
            new Font("Dialog", 0, 16), new Font("Dialog", 0, 16) };
    private Color[] fontColors = { Color.black, new Color(200, 200, 200), new Color(200, 200, 200),
            new Color(200, 200, 200), new Color(0, 0, 0) };
    private String[] icons = { "dark", "light", "light", "light", "dark" };

    public Theme() {
        set(1);
    }

    public void setTheme(String type) {
        switch (type) {
            case "light":
            case "default":
                set(0);
                break;
            case "dark":
                set(1);
                break;
            case "classic":
                set(2);
                break;
            case "modern":
                set(2);
                break;
        }
    }

    public void set(int i) {
        background = backgrounds[i];
        sidepanel = sidepanels[i];
        font = fonts[i];
        fontColor = fontColors[i];
        icon = icons[i];
    }

    public Color HexColor(String s) {

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
}