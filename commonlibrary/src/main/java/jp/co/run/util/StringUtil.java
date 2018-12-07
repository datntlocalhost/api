package jp.co.run.util;

import jp.co.run.enums.MultiByte;
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
     *  @author datnguyen
     *  @param str the string input.
     *  @return the string hex.
     */
    public static String stringToHex(String str) {
        
        StringBuilder builder = new StringBuilder();
        
        if (str == null || str.length() == 0) {
            return builder.toString();
        }
        
        char[] charArray = str.toCharArray();
        
        for (char c : charArray) {
            builder.append("\\\\x{" + Integer.toHexString(c) + "}");
        }
        
        return builder.toString();
    }

    /**
     * Returns length byte of the string input.
     * 
     * @author datnguyen
     * @param str the string
     * @return length of byte of the string input.
     */
    public static int countByteOfString(String str) {

        if (str == null) {
            return 0;
        }

        byte[] bytes = str.getBytes();

        return bytes.length;
    }

    /**
     * Count characters of the string input.
     * 
     * @param str the string
     * @return the long, return number character of the string, -1 if the string input is null
     */
    public static int countCharacters(String str) {

        if (StringValidation.isNull(str)) {
            return -1;
        }

        int count = 0;

        byte[] bytes = str.getBytes();

        for (int i = 0; i < bytes.length;) {
            int byteCompare = (bytes[i] & 0x000000FF) >> 4;
            if (byteCompare == 0xF) {
                i += MultiByte.FOUR.getNumOfByte();
            } else if (byteCompare == 0xE) {
                i += MultiByte.THREE.getNumOfByte();
            } else if (byteCompare == 0xC) {
                i += MultiByte.DOUBLE.getNumOfByte();
            } else {
                i += MultiByte.SINGLE.getNumOfByte();
            }
            count += 1;
        }

        return count;
    }

    /**
     * Returns number single-byte character within the string input.
     * 
     * @author datnguyen
     * @param str the string input.
     * @return number of single-byte character, return -1 if the string input is null.
     */
    public static int countSingleByteCharacters(String str) {

        if (StringValidation.isNull(str)) {
            return -1;
        }

        int count = 0;

        byte[] bytes = str.getBytes();

        for (int i = 0; i < bytes.length;) {
            int byteCompare = (bytes[i] & 0x000000FF) >> 4;
            if (byteCompare == 0xF) {
                i += MultiByte.FOUR.getNumOfByte();
            } else if (byteCompare == 0xE) {
                i += MultiByte.THREE.getNumOfByte();
            } else if (byteCompare == 0xC) {
                i += MultiByte.DOUBLE.getNumOfByte();
            } else {
                i += MultiByte.SINGLE.getNumOfByte();
                count += 1;
            }
        }

        return count;
    }

    /**
     * Returns number multi-byte character (double, three or four byte) within the string input.
     * 
     * @author datnguyen
     * @param str the string input.
     * @return number of single-byte character, return -1 if the string input is null.
     */
    public static int countMultiByteCharacters(String str) {

        if (StringValidation.isNull(str)) {
            return -1;
        }

        int count = 0;

        byte[] bytes = str.getBytes();

        for (int i = 0; i < bytes.length;) {
            int byteCompare = (bytes[i] & 0x000000FF) >> 4;
            if (byteCompare == 0xF) {
                i += MultiByte.FOUR.getNumOfByte();
                count += 1;
            } else if (byteCompare == 0xE) {
                i += MultiByte.THREE.getNumOfByte();
                count += 1;
            } else if (byteCompare == 0xC) {
                i += MultiByte.DOUBLE.getNumOfByte();
                count += 1;
            } else {
                i += MultiByte.SINGLE.getNumOfByte();
            }
        }

        return count;
    }

    public static String convertHiraToKata(String str) {

        StringBuilder builder = new StringBuilder();

        if (str == null) {
            return builder.toString();
        }

        char[] charArray = str.toCharArray();

        for (char c : charArray) {

            if (c >= 0x3040 && c <= 0x309F) {
                builder.append((char) (c + 96));
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    public static String convertKataToHira(String str) {

        StringBuilder builder = new StringBuilder();

        if (str == null) {
            return builder.toString();
        }

        char[] charArray = str.toCharArray();

        for (char c : charArray) {

            if (c >= 0x30A0 && c <= 0x30FF) {
                builder.append((char) (c - 96));
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
