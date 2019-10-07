package org.zlasu.validation;

public class Validator {

    public static boolean isEmpty(String string) {
        if (string == null || string.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isPositiveNumber(String string) {
        if (isEmpty(string)) {
            return false;
        }

        if (string.matches("^[0-9]+\\.?[0-9]*$")) {
            try {
                double d = Double.parseDouble(string);
            } catch (NumberFormatException | NullPointerException nfe) {
                return false;
            }
            return true;
        }
        return false;
    }
}
