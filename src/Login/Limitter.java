package Login;

import javax.swing.text.*;

public class Limitter extends PlainDocument {
    private static final long serialVersionUID = 548506770268423762L;

    private int limit;

    public Limitter(int Limitation) {
        this.limit = Limitation;
    }

    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
        if (str == null) {
            return;
        } else if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, set);
        }
    }
}
