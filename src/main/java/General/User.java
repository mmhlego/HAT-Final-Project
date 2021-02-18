package General;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -3756741987571374368L;

    public String username;
    public String password;
    public String name;
    public String lastName;
    public String phoneNumber;
    public Theme theme = new Theme();
}
