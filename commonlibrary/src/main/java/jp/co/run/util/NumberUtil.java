package jp.co.run.util;

/**
 * The Class NumberUtil.
 * 
 * @author datnguyen
 */
public class NumberUtil {

    /**
     * Checks if char input is single-byte digit.
     * 
     * @param c the char want to check.
     * @return true if the char is single-byte digit, else return false.
     */
    public static boolean isSingleByteDigit(char c) {
        return c >= 0x30 && c <= 0x39;
    }

    /**
     * Checks if char input is double-byte digit.
     * 
     * @param c the char want to check.
     * @return true if the char is double-byte digit, else return false.
     */
    public static boolean isDoubleByteDigit(char c) {
        return c >= 0xFF10 && c <= 0xFF19;
    }

    /**
     * Parses the string input to integer number.
     *
     * @param str the string input want to parse
     * @param hasDoubleByteNumber true if the string input have double-byte character number
     * @return the integer
     * @throws NumberFormatException if the string input is invalid integer number format
     */
    public static int parseInt(String str, boolean hasDoubleByteNumber) {

        if (str == null) {
            throw new NumberFormatException("null");
        } else if (str.length() == 0) {
            throw new NumberFormatException("empty");
        }

        boolean negative = false;
        int startDigit = 0;
        int result = 0;
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int radix = 10;
        char[] charArray = str.toCharArray();

        if ((charArray[startDigit] == 0x2D) || ((charArray[startDigit] == 0xFF0D) && hasDoubleByteNumber)) {
            negative = true;
            limit = Integer.MIN_VALUE;
            startDigit += 1;
        } else if ((charArray[startDigit] == 0x2B) || ((charArray[startDigit] == 0xFF0B) && hasDoubleByteNumber)) {
            startDigit += 1;
        }

        if (startDigit == charArray.length) {
            throw new NumberFormatException(str);
        }

        multmin = limit / 10;
        for (int i = startDigit; i < charArray.length; i++) {

            if (isSingleByteDigit(charArray[i]) || (isDoubleByteDigit(charArray[i]) && hasDoubleByteNumber)) {

                int digit = charArray[i] - 0x30 <= 9 ? charArray[i] - 0x30 : charArray[i] - 0xFF10;
                if (result < multmin) {
                    throw new NumberFormatException(str);
                }

                result *= radix;

                if (result < limit + digit) {
                    throw new NumberFormatException(str);
                }

                result -= digit;
            } else {
                throw new NumberFormatException(str);
            }
        }

        return negative ? result : -result;
    }

    /**
     * Parses the string input to the long number.
     * 
     * @param str the string input want to parse
     * @param hasDoubleByteNumber true if the string input have double-byte character
     * @return the long
     * @throws NumberFormatException if the string input is invalid number format
     */
    public static long parseLong(String str, boolean hasDoubleByteNumber) {

        if (str == null) {
            throw new NumberFormatException("null");
        } else if (str.length() == 0) {
            throw new NumberFormatException("empty");
        }

        boolean negative = false;
        int startDigit = 0;
        int radix = 10;
        long limit = -Long.MAX_VALUE;
        long result = 0L;
        long multmin;
        char[] charArray = str.toCharArray();

        if ((charArray[startDigit] == 0x2D) || ((charArray[startDigit] == 0xFF0D) && hasDoubleByteNumber)) {
            negative = true;
            limit = Long.MIN_VALUE;
            startDigit += 1;
        } else if ((charArray[startDigit] == 0x2B) || ((charArray[startDigit] == 0xFF0B) && hasDoubleByteNumber)) {
            startDigit += 1;
        }

        if (startDigit == charArray.length) {
            throw new NumberFormatException(str);
        }
        multmin = limit / radix;
        for (int i = startDigit; i < charArray.length; i++) {
            if (isSingleByteDigit(charArray[i]) || (isDoubleByteDigit(charArray[i]) && hasDoubleByteNumber)) {

                int digit = charArray[i] - 0x30 <= 9 ? charArray[i] - 0x30 : charArray[i] - 0xFF10;
                if (result < multmin) {
                    throw new NumberFormatException(str);
                }

                result *= radix;

                if (result < limit + digit) {
                    throw new NumberFormatException(str);
                }

                result -= digit;
            } else {
                throw new NumberFormatException(str);
            }
        }

        return negative ? result : -result;
    }

    /**
     * Parses the string input to the float number.
     * 
     * @param str the string input want to parse
     * @param hasDoubleByteNumber true if the string input have double-byte character
     * @return the float
     * @throws NumberFormatException if the string input is invalid number format
     */
    public static float parseFloat(String str, boolean hasDoubleByteNumber) {
        if (str == null) {
            throw new NumberFormatException("null");
        } else if (str.length() == 0) {
            throw new NumberFormatException("empty");
        }
        StringBuilder builder = new StringBuilder();
        if (hasDoubleByteNumber) {
            char[] array = str.toCharArray();
            int index = 0;
            while (index < array.length) {
                char c = array[index++];
                builder.append(convertNumberChar(c));
            }
            return Float.parseFloat(builder.toString());
        }
        return Float.parseFloat(str);
    }

    public static double parseDouble(String str, boolean hasDoubleByteNumber) {
        if (str == null) {
            throw new NumberFormatException("null");
        } else if (str.length() == 0) {
            throw new NumberFormatException("empty");
        }
        StringBuilder builder = new StringBuilder();
        if (hasDoubleByteNumber) {
            char[] array = str.toCharArray();
            int index = 0;
            while (index < array.length) {
                char c = array[index++];
                builder.append(convertNumberChar(c));
            }
            return Double.parseDouble(builder.toString());
        }
        return Double.parseDouble(str);
    }

    /**
     * Convert double-byte digit, sign, euler to single-byte.
     * 
     * @param c the char want to convert.
     * @return the char.
     */
    public static char convertNumberChar(char c) {
        switch (c) {
        // 0 - 9
        case 0xFF10:
        case 0xFF11:
        case 0xFF12:
        case 0xFF13:
        case 0xFF14:
        case 0xFF15:
        case 0xFF16:
        case 0xFF17:
        case 0xFF18:
        case 0xFF19:
            return (char) (c - 0xFF10 + 48);
        // +
        case 0xFF0B:
            return (char) (0x2B);
        // -
        case 0xFF0D:
            return (char) (0x2D);
        // .
        case 0xFF0E:
            return (char) (0x2E);
        // E
        case 0xFF25:
            return (char) (0x45);
        // e
        case 0xFF45:
            return (char) (0x65);
        default:
            return c;
        }
    }
}
