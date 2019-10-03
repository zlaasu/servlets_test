package org.zlasu.validation;

public class Validator {

    public static boolean isEmpty(String string) {
        if (string == null || string.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String string) {
        if (string.matches("^[0-9]+\\.?[0-9]*$")) {
            return false;
        }
        return true;
    }
}
