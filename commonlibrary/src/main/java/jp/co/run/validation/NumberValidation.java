package jp.co.run.validation;

import jp.co.run.util.StringUtil;

/**
 * The {@code NumberValidation} class provides several methods for checking validation of number
 * 
 * @author datnguyen
 */
public final class NumberValidation {

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
            ? "^((\\u002D)|(\\uFF0D))?[\\u0030-\\u0039\\uFF10-\\uFF19]*(((\\u002E)|(\\uFF0E))[\\u0030-\\u0039\\uFF10-\\uFF19]+)?$"
            : "^\\u002D?[\\u0030-\\u0039]*(\\u002E[\\u0030-\\u0039]*)?$";

        return str.matches(regex);
    }

    /**
     * Checks if the string input is double-byte number.
     * 
     * <p>The {@code pattern} is the string that contain character can put in 
     * the head, middle and tail of the number and separate by space character.
     * 
     *  <p>Ex: the number input is "+123.123E" 
     *  <p>The pattern have to "+ . E"
     * 
     * @author datnguyen
     * @param str the string input want to check.
     * @param pattern the pattern
     * @return true if the string input is double-byte number, else return false.
     * */
    public static boolean isTwoByteNumber(String str, String pattern) {

        if (str == null || str.length() == 0) {
            return false;
        }

        String regex = "^%l[\\uFF10-\\uFF19]+(%m[\\uFF10-\\uFF19]+)+%r$";

        if (pattern != null && pattern.length() != 0) {

            String[] patterns = pattern.split("\\u0020");

            if (patterns.length == 3) {

                regex = regex.replaceAll("%l", "[" + StringUtil.stringToHex(patterns[0]) + "]?")
                    .replaceAll("%m", "[" + StringUtil.stringToHex(patterns[1]) + "]?")
                    .replaceAll("%r", "(" + StringUtil.stringToHex(patterns[2]) + ")?");
            } else if (patterns.length == 2) {

                regex = regex.replaceAll("%l", "[" + StringUtil.stringToHex(patterns[0]) + "]?")
                    .replaceAll("%m", "[" + StringUtil.stringToHex(patterns[1]) + "]?").replaceAll("%r", "");
            } else {

                regex = regex.replaceAll("%l", "[" + StringUtil.stringToHex(patterns[0]) + "]?").replaceAll("%m", "")
                    .replaceAll("%r", "");
            }
        } else {
            regex = regex.replaceAll("%l", "").replaceAll("%m", "").replaceAll("%r", "");
        }

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
