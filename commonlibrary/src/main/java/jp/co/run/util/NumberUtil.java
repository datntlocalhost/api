package jp.co.run.util;

import jp.co.run.validation.NumberValidation;

/**
 * The Class NumberUtil.
 * 
 * @author datnguyen
 */
public class NumberUtil {

    public static Integer parseInt(String str, boolean isDoubleByteNumber) {
        if (!NumberValidation.isIntegerNumber(str, isDoubleByteNumber)) {
            return null;
        }
        
        boolean negative = false;
        int startDigit = 0;
        Integer number = 0;
        char[] charArray = str.toCharArray();
        if (charArray[0] == '-' || (charArray[0] == '－' && isDoubleByteNumber)) {
            startDigit = 1;
            negative = true;
        }
        
        for (int i = startDigit; i < charArray.length; i++) {
            int digit = Character.digit(charArray[i], 10);
            number = number * 10 + digit;
        }
        
        return negative ? -number : number;
    }
    
    public static void main(String[] args) {
        System.err.println(parseInt("12345", true));
    }
}
