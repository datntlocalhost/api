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
     * @param originalRegex the original regex
     * @param extendRegex the extend regex
     * @param isInclude the is include
     * @return the string
     */
    public static String stringToRegex(String originalRegex, String extendRegex, boolean isInclude) {

        StringBuilder builder = new StringBuilder();

        if (StringValidation.isNull(extendRegex)) {
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

    /**
     * Convert the characters within the string input to hex.
     * 
     * @param str the string input.
     * @return the string hex.
     */
    public static String stringToHex(String str) {

        StringBuilder builder = new StringBuilder();

        if (StringValidation.isNullOrEmpty(str)) {
            return builder.toString();
        }

        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            builder.append("\\\\x{" + Integer.toHexString(c) + "}");
        }

        return builder.toString();
    }

    /**
     * Returns total byte of the string input.
     * 
     * @param str the string
     * @return total byte of the string input.
     */
    public static int countByte(String str) {

        if (StringValidation.isNullOrEmpty(str)) {
            return 0;
        }

        byte[] bytes = str.getBytes();

        return bytes.length;
    }

    /**
     * Count total characters of the string input.
     * 
     * @param str the string
     * @return the long, return total character of the string, -1 if the string input is null
     */
    public static int countCharacterMultiByte(String str) {

        if (str == null) {
            return -1;
        }

        int count = 0;
        int index = 0;
        byte[] bytes = str.getBytes();

        while (index < bytes.length) {
            int leadBitss = (bytes[index] & 0x000000FF) >> 4;
            if (leadBitss >= 0xC) {
                int numBitOne = (leadBitss & 1) + ((leadBitss >> 1) & 1) + ((leadBitss >> 2) & 1)
                    + ((leadBitss >> 3) & 1);
                index += numBitOne;
            } else {
                index += 1;
            }
            count += 1;
        }

        return count;
    }

    /**
     * Returns number single-byte character within the string input.
     * 
     * @param str the string input.
     * @return number of single-byte character, return -1 if the string input is null.
     */
    public static int countCharacter1Byte(String str) {

        if (str == null) {
            return -1;
        }

        int count = 0;
        int index = 0;
        byte[] bytes = str.getBytes();

        while (index < bytes.length) {
            int leadBits = (bytes[index] & 0x000000FF) >> 4;
            if (leadBits >= 0xC) {
                int numBitOne = (leadBits & 1) + ((leadBits >> 1) & 1) + ((leadBits >> 2) & 1) + ((leadBits >> 3) & 1);
                index += numBitOne;
            } else {
                index += 1;
                count += 1;
            }
        }

        return count;
    }

    /**
     * Returns number multi-byte character (double, three or four byte) within the string input.
     * 
     * @param str the string input.
     * @return number of single-byte character, return -1 if the string input is null.
     */
    public static int countCharacterNon1Byte(String str) {

        if (str == null) {
            return -1;
        }

        int count = 0;
        int index = 0;
        byte[] bytes = str.getBytes();

        while (index < bytes.length) {
            int leadBits = (bytes[index] & 0x000000FF) >> 4;
            if (leadBits >= 0xC) {

                int numBitOne = (leadBits & 1) + ((leadBits >> 1) & 1) + ((leadBits >> 2) & 1) + ((leadBits >> 3) & 1);
                index += numBitOne;
                count += 1;
            } else {
                index += 1;
            }
        }

        return count;
    }

    /**
     * Converts hiragana string to katakana string.
     * 
     * @param str the hiragana string.
     * @return the katakana string.
     */
    public static String convertHiraToKata(String str) {

        StringBuilder builder = new StringBuilder();

        if (StringValidation.isNullOrEmpty(str)) {
            return builder.toString();
        }

        char[] charArray = str.toCharArray();

        for (char c : charArray) {

            if (c >= 0x3041 && c <= 0x3093) {
                builder.append((char) (c + 96));
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    /**
     * Convert katakana string to hiragana string.
     * 
     * @param str the katakana string.
     * @return the hiragana string.
     */
    public static String convertKataToHira(String str) {

        StringBuilder builder = new StringBuilder();

        if (StringValidation.isNullOrEmpty(str)) {
            return builder.toString();
        }

        char[] charArray = str.toCharArray();

        for (char c : charArray) {

            if (c >= 0x30A1 && c <= 0x30F3) {
                builder.append((char) (c - 96));
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
