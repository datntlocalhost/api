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
     * @param str the string input want to parse
     * @param hasDoubleByteNumber true if the string input have double-byte character number
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
            int digit = charArray[i] - 0x30 >= 0 && charArray[i] - 0x30 <= 9 ? charArray[i] - 0x30 : charArray[i] - 0xFF10;
            number = number * 10 + digit;
        }
        return negative ? -number : number;
    }
    
    /**
     * Parses the string input to the long number.
     * 
     * @author datnguyen
     * @param str the string input want to parse
     * @param hasDoubleByteNumber true if the string input have double-byte character
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
            int digit = charArray[i] - 0x30 >= 0 && charArray[i] - 0x30 <= 9 ? charArray[i] - 0x30 : charArray[i] - 0xFF10;
            number = number * 10 + digit;
        }
        return negative ? -number : number;
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
		System.err.println(parseLong("12365456465456",false));
	}
}
