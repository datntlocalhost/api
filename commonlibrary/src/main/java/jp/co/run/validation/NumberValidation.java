package jp.co.run.validation;

// TODO: Auto-generated Javadoc
/**
 * The Class NumberValidation.
 */
public class NumberValidation {

    /**
     * Checks if is number.
     *
     * @param str the str
     * @param multiByteCheck the multi byte check
     * @return true, if is number
     */
    public static boolean isNumber(String str, boolean multiByteCheck) {
        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }
        String regex = multiByteCheck
            ? "^((-)|(－))?[\\u0030-\\u0039\\uff10-\\uff19]*(((.)|(．))[\\u0030-\\u0039\\uff10-\\uff19]*)?$"
            : "^-?[\\u0030-\\u0039]*(\\.[\\u0030-\\u0039]*)?$";
        return str.matches(regex);
    }
    
    public static boolean isIntegerNumber(String str, boolean isDoubleByteNumber) {
        if (!isNumber(str, isDoubleByteNumber)) {
            return false;
        }
        return str.indexOf(".") != -1 || (isDoubleByteNumber && str.indexOf("．") != -1);
    }
    
    public static boolean isFloatNumber(String str) {
        if (!isNumber(str, true)) {
            return false;
        }
        
        return true;
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        System.err.println(isIntegerNumber("123456", true));
    }
}
