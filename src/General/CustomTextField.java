package General;

import javax.swing.*;
import javax.swing.border.*;
import General.Theme.*;
import java.awt.*;
import java.awt.event.*;

public class CustomTextField extends JTextField {
    private static final long serialVersionUID = -2613758805041637665L;

    public CustomTextField(int x, int y, int w, int h, Font font, Color bgColor, Color fontColor, String text) {
        setBounds(x, y, w, h);
        setBackground(bgColor);
        setFont(font);
        setForeground(fontColor);
        setBorder(new MatteBorder(0, 0, 1, 0, fontColor));
        setText(text);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 116, 232)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, fontColor));
            }
        });
        setVisible(true);
    }

    public CustomTextField(int x, int y, int w, int h, MainTheme m, String text) {
        setBounds(x, y, w, h);
        setBackground(m.textFieldBackground);
        setFont(m.font);
        setForeground(m.fontColor);
        setBorder(new MatteBorder(0, 0, 1, 0, m.fontColor));
        setText(text);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 116, 232)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, m.fontColor));
            }
        });
        setVisible(true);
    }

    public CustomTextField(int x, int y, int w, int h, MainTheme m) {
        setBounds(x, y, w, h);
        setBackground(m.textFieldBackground);
        setFont(m.font);
        setForeground(m.fontColor);
        setBorder(new MatteBorder(0, 0, 1, 0, m.fontColor));
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 116, 232)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, m.fontColor));
            }
        });
        setVisible(true);
    }

    public CustomTextField(int x, int y, int w, int h, DialogTheme d, String text) {
        setText(text);
        setBounds(x, y, w, h);
        setBackground(d.textFieldBackground);
        setFont(d.font);
        setForeground(d.fontColor);
        setBorder(new MatteBorder(0, 0, 1, 0, d.fontColor));
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 116, 232)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, d.fontColor));
            }
        });
        setVisible(true);
    }

    public CustomTextField(int x, int y, int w, int h, DialogTheme d) {
        setBounds(x, y, w, h);
        setBackground(d.textFieldBackground);
        setFont(d.font);
        setForeground(d.fontColor);
        setBorder(new MatteBorder(0, 0, 1, 0, d.fontColor));
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 116, 232)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, d.fontColor));
            }
        });
        setVisible(true);
    }

    public static final int CENTER = 0, LEFT = 2, RIGHT = 4;

    public void setTextDirection(int x) {
        setAlignmentX(x);
    }
}