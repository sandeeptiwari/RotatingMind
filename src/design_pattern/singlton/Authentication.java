package design_pattern.singlton;

import java.io.Serializable;

public class Authentication implements Serializable {

    private Authentication() {};
    private static final Authentication INSTANCE = new Authentication();

    public static Authentication getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
