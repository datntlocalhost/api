package jp.co.run.util;

import jp.co.run.validation.StringValidation;

/**
 * The Class StringUtil.
 * 
 * @author datnguyen
 */
public class StringUtil {

    /**
     * String to regex.
     *
     * @author datnguyen
     * @param str the str
     * @param isInclude the is include
     * @return the string
     */
    public static String stringToRegex(String originalRegex, String extendRegex, boolean isInclude) {

        StringBuilder builder = new StringBuilder();

        if (StringValidation.isNullOrEmpty(extendRegex)) {
            return builder.toString();
        }

        builder.append(isInclude ? "^[" : "^[^");
        builder.append(originalRegex != null ? originalRegex : "");
        char[] charArray = extendRegex.toCharArray();

        for (char c : charArray) {
            builder.append("\\x{" + Integer.toHexString(c) + "}");
        }

        builder.append("]*$");

        return builder.toString();
    }
}
