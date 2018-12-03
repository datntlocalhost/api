package jp.co.run.util;

import jp.co.run.validation.NumberValidation;

/**
 * The Class NumberUtil.
 * 
 * @author datnguyen
 */
public class NumberUtil {

    /**
     * Parses the string input to integer number.
     *
     * @author datnguyen
     * @param  str the string input want to parse
     * @param  hasDoubleByteNumber true if the string input have double-byte character number
     * @return the integer
     * @throws NumberFormatException if the string input is invalid integer number format
     */
    public static Integer parseInt(String str, boolean hasDoubleByteNumber) {

        if (!NumberValidation.isIntegerNumber(str, hasDoubleByteNumber)) {
            throw new NumberFormatException(str);
        }

        boolean negative = false;
        int startDigit = 0;
        Integer number = 0;
        char[] charArray = str.toCharArray();

        if (charArray[0] == 0x2D || (charArray[0] == 0xFF0D && hasDoubleByteNumber)) {
            startDigit = 1;
            negative = true;
        }

        for (int i = startDigit; i < charArray.length; i++) {
            int digit = charArray[i] - 0x30 >= 0 && charArray[i] - 0x30 <= 9 ? charArray[i] - 0x30
                : charArray[i] - 0xFF10;
            number = number * 10 + digit;
        }

        return negative ? -number : number;
    }

    /**
     * Parses the string input to the long number.
     * 
     * @author datnguyen
     * @param  str the string input want to parse
     * @param  hasDoubleByteNumber true if the string input have double-byte character
     * @return the long
     * @throws NumberFormatException if the string input is invalid number format
     */
    public static Long parseLong(String str, boolean hasDoubleByteNumber) {

        if (!NumberValidation.isIntegerNumber(str, hasDoubleByteNumber)) {
            throw new NumberFormatException(str);
        }

        boolean negative = false;
        int startDigit = 0;
        Long number = 0L;
        char[] charArray = str.toCharArray();

        if (charArray[0] == 0x2D || (charArray[0] == 0xFF0D && hasDoubleByteNumber)) {
            startDigit = 1;
            negative = true;
        }

        for (int i = startDigit; i < charArray.length; i++) {
            int digit = charArray[i] - 0x30 >= 0 && charArray[i] - 0x30 <= 9 ? charArray[i] - 0x30
                : charArray[i] - 0xFF10;
            number = number * 10 + digit;
        }

        return negative ? -number : number;
    }

    /**
     * Parses the string input to the float number.
     * 
     * @author datnguyen
     * @param  str the string input want to parse
     * @param  hasDoubleByteNumber true if the string input have double-byte character
     * @return the float
     * @throws NumberFormatException if the string input is invalid number format
     */
    public static Float parseFloat(String str, boolean hasDoubleByteNumber) {

        if (!NumberValidation.isFloatNumber(str, hasDoubleByteNumber)) {
            throw new NumberFormatException(str);
        }

        boolean negative = false;
        int startDigit = 0;

        float div = 0F;
        float mod = 0F;
        float toDiv = 1F;

        char[] charArray = str.toCharArray();
        int lenght = charArray.length;

        if (charArray[0] == 0x2D || (charArray[0] == 0xFF0D && hasDoubleByteNumber)) {
            startDigit = 1;
            negative = true;
        }

        int i = startDigit;

        for (; i < lenght; i++) {

            if (charArray[i] == 0x2E || charArray[i] == 0xFF0E) {
                i++;
                break;
            }

            float digit = charArray[i] - 0x30 >= 0 && charArray[i] - 0x30 <= 9 ? charArray[i] - 0x30
                : charArray[i] - 0xFF10;
            div = (float) (div * 10.0 + digit);
        }

        if (i < lenght) {
            for (; i < lenght; i++) {
                float digit = charArray[i] - 0x30 >= 0 && charArray[i] - 0x30 <= 9 ? charArray[i] - 0x30
                    : charArray[i] - 0xFF10;
                mod = (float) (mod * 10.0 + digit);
                toDiv *= 10;
            }
            mod /= toDiv;
        }

        return negative ? -(div + mod) : div + mod;
    }
}
