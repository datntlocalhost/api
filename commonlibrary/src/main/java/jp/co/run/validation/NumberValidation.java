package jp.co.run.validation;

import jp.co.run.util.NumberUtil;

/**
 * The {@code NumberValidation} class provides several methods for checking validation of number
 * 
 * @author datnguyen
 */
public final class NumberValidation {

    /**
     * Checks if the string input is number.
     *
     * @param str the string input want to check
     * @param hasDoubleByteNumber true if the string input have double-byte character
     * @return true, if the string input is number
     */
    public static boolean isNumber(String str, boolean hasDoubleByteNumber) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String regex = hasDoubleByteNumber
            ? "^((\\u002D)|(\\u002B)|(\\uFF0D)(\\uFF0B))?[\\u0030-\\u0039\\uFF10-\\uFF19]*(((\\u002E)|(\\uFF0E))[\\u0030-\\u0039\\uFF10-\\uFF19]+)?$"
            : "^((\\u002D)|(\\u002B))?[\\u0030-\\u0039]*(\\u002E[\\u0030-\\u0039]*)?$";

        return str.matches(regex);
    }

    /**
     * Checks if the string input is double-byte number format.
     * 
     * @param  str the string input want to check.
     * @return true if the string input is double-byte number format,
     *         else return false.
     */
    public static boolean isTwoByteNumber(String str) {
        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String regex = "^[\\uFF10-\\uFF19\\uFF0B\\uFF0D\\uFF0E\\uFF45]+$";

        try {
            if (str.matches(regex)) {
                NumberUtil.parseFloat(str, true);
                return true;
            }
        } catch (Exception e) {
        }

        return false;
    }

    /**
     * Checks if the string input is integer.
     * 
     * @param str the string input want to check.
     * @return true if the string input is integer.
     */
    public static boolean isIntegerNumber(String str) {
        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }
        String regex = "^((\\u002D)|(\\u002B))?[0-9]+$";
        try {

            Integer.parseInt(str);
            return str.matches(regex);
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * Checks if the string input is integer number.
     *
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
     * <p>Just accept float number with #.#0 or -#.#0 format.
     * 
     * @param str the string input want to check.
     * @return true if the string input is float number
     */
    public static boolean isFloatNumber(String str) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String regex = "((\\u002D)|(\\u002B))?[\\u0030-\\u0039]*(\\u002E[\\u0030-\\u0039]+)$";

        try {
            
            Float.parseFloat(str);
            return str.matches(regex);
        } catch (Exception e) {
        }

        return false;
    }

    /**
     * Checks if the string input is float number.
     *
     * @param str the string input want to check
     * @param hasDoubleByteNumber true if the string input have double-byte character
     * @return true, if the string input is float number
     */
    public static boolean isFloatNumber(String str, boolean hasDoubleByteNumber) {
        return isNumber(str, hasDoubleByteNumber);
    }
}
