package org.zlasu.libs.validation;

public class Validator {

    private StringBuffer errorMessage;

    public Validator() {
        errorMessage = new StringBuffer();
    }

    public boolean isEmpty(String string) {
        if (string == null || string.isEmpty()) {
            return true;
        }

        return false;
    }

    public boolean isEmpty(String string, String key) {
        if (isEmpty(string)) {
            errorMessage.append(key).append(" - is EMPTY.</br>");
            return true;
        }

        return false;
    }

    public boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public boolean isNotEmpty(String string, String key) {
        return !isEmpty(string, key);
    }

    public boolean isDouble(String string) {
        if (isEmpty(string)) {
            return false;
        }

        try {
            double d = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println(nfe);
        }

        return false;
    }

    public boolean isDouble(String string, String key) {
        if (isDouble(string)) {
            return true;
        }

        errorMessage.append(key).append(" - is not DOUBLE.</br>");
        return false;
    }

    public boolean isNotDouble(String string) {
        return !isDouble(string);
    }

    public boolean isNotDouble(String string, String key) {
        return !isDouble(string, key);
    }

    public boolean isInt(String string) {
        if (isEmpty(string)) {
            return false;
        }

        try {
            double d = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException | NullPointerException nfe) {
            System.err.println(nfe);
        }

        return false;
    }

    public boolean isInt(String string, String key) {
        if (isInt(string)) {
            return true;
        }

        errorMessage.append(key).append(" - is not INT.</br>");
        return false;
    }

    public boolean isNotInt(String string) {
        return !isInt(string);
    }

    public boolean isNotInt(String string, String key) {
        return !isInt(string, key);
    }

    public String getErrorMessage() {
        return errorMessage.toString();
    }
}
