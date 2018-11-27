package jp.co.run.validation;

/**
 * The Class NumberValidation.
 * 
 * @author datnguyen
 */
public class NumberValidation {

    /**
     * Checks if the string input is number.
     *
     * @author datnguyen
     * @param str the string input want to check
     * @param hasDoubleByteNumber true if the string input have double-byte character
     * @return true, if the string input is number
     */
    public static boolean isNumber(String str, boolean hasDoubleByteNumber) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String regex = hasDoubleByteNumber
            ? "^((\\u002D)|(\\uFF0D))?[\\u0030-\\u0039\\uff10-\\uff19]*(((\\u002E)|(\\uFF0E))[\\u0030-\\u0039\\uff10-\\uff19]+)?$"
            : "^\\u002D?[\\u0030-\\u0039]*(\\u002E[\\u0030-\\u0039]*)?$";

        return str.matches(regex);
    }

    /**
     * Checks if the string input is integer number.
     *
     * @author datnguyen
     * @param str the string input want to check
     * @param hasDoubleByteNumber true if the string input have double-byte character
     * @return true, if the string input is integer number
     */
    public static boolean isIntegerNumber(String str, boolean hasDoubleByteNumber) {

        if (!isNumber(str, hasDoubleByteNumber)) {
            return false;
        }

        if (hasDoubleByteNumber && str.indexOf(0xFF0E) != -1) {
            return false;
        }

        return str.indexOf(0x2E) == -1;
    }

    /**
     * Checks if the string input is float number.
     *
     * @author datnguyen
     * @param str the string input want to check
     * @param hasDoubleByteNumber true if the string input have double-byte character
     * @return true, if the string input is float number
     */
    public static boolean isFloatNumber(String str, boolean hasDoubleByteNumber) {
        return isNumber(str, hasDoubleByteNumber);
    }
}
