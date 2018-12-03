package jp.co.run.validation;

import jp.co.run.enums.MultiByte;
import jp.co.run.util.StringUtil;

/**
 * The {@code StringValidation} class provides several methods for checking 
 * validation of string input.
 * 
 * @author datnguyen
 */
public final class StringValidation {

    /**
     * Check if the string input is null.
     *
     * @author datnguyen
     * @param  str the string input want to check.
     * @return true if the string input is null, else return false.
     */
    public static boolean isNull(String str) {
        return str == null;
    }
    
    public static boolean isEmpty(String str) {
        
        String regex = "^[\\]+$";
        if (str == null) {
            return false;
        }
        
        return str.matches(regex);
    }
    
    public static boolean isEmptyWithoutBlank(String str) {
        String regex = "";
        
        if (str == null) {
            return false;
        }
        
        
    }

    /**
     * Checks if the string input is null or empty.
     *
     * @param  str the string input want to check
     * @return true, if the string input is null or empty
     */
    public static boolean isNullOrEmpty(String str) {
        return isNull(str) || str.isEmpty();
    }

    /**
     * Checks if array of the strings input is null or empty.
     * 
     * @author datnguyen
     * @param  strs array of string want to check
     * @return true, if if have one or more element of string array is null or empty, else return false.
     */
    public static boolean isNullOrEmpty(String... strs) {

        if (strs == null) {
            return true;
        }

        for (String str : strs) {
            if (isNullOrEmpty(str)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if the string input is blank (single-byte or double-byte whitespace).
     * 
     * @author datnguyen
     * @param  str the string input want to check.
     * @return true if the string input is blank (whitespace), else return false.
     */
    public static boolean isBlank(String str) {

        String regex = "^[\\u0020\\u3000]*$";
        return isNull(str) || str.matches(regex);
    }

    /**
     * Checks if the string input is max length.
     *
     * @author datnguyen
     * @param  str the string input want to check.
     * @param  maxLength the max length
     * @return true, if length of the string input is less than or equal to maxLength, else return false
     */
    public static boolean isMaxLengthValid(String str, int maxLength) {

        if (isNull(str) || maxLength < 0) {
            return false;
        }

        return str.length() <= maxLength;
    }

    /**
     * Checks if the string input is min length.
     *
     * @author datnguyen
     * @param  str the string input want to check.
     * @param  minLength the min length
     * @return true, if the string input is min length
     */
    public static boolean isMinLengthValid(String str, int minLength) {

        if (isNull(str) || minLength < 0) {
            return false;
        }

        return str.length() >= minLength;
    }

    /**
     * Checks if the string is single-byte character only.
     *
     * @author datnguyen
     * @param  str the str
     * @return true, if the string input is is just contain single-byte character, else return false
     */
    public static boolean isByteCharacterOnly(String str) {
        return checkMultiByteCharacterString(str, MultiByte.SINGLE);
    }

    /**
     * Checks if the string input is just contain double-byte character.
     *
     * @author datnguyen
     * @param  str the string want to check
     * @return true, if the string input is is just contain double-byte character, else return false
     */
    public static boolean isTwoByteCharacterOnly(String str) {
        return checkMultiByteCharacterString(str, MultiByte.DOUBLE);
    }

    /**
     * Checks if the string input is just contain three-byte character.
     *
     * @author datnguyen
     * @param  str the string input want to check
     * @return true, if the string input is is just contain three-byte character, else return false
     */
    public static boolean isThreeByteCharacterOnly(String str) {
        return checkMultiByteCharacterString(str, MultiByte.THREE);
    }

    /**
     * Checks if the string input is just contain four-byte character.
     *
     * @author datnguyen
     * @param  str the string input want to check
     * @return true, if the string input is is just contain four-byte character, else return false
     */
    public static boolean isFourByteCharacterOnly(String str) {
        return checkMultiByteCharacterString(str, MultiByte.FOUR);
    }

//    /**
//     * Checks if is not special character.
//     *
//     * @param str the str
//     * @param pattern the pattern
//     * @return true, if is not special character
//     */
//    public static boolean isNotSpecialCharacter(String str, String pattern) {
//
//        if (isNull(str) || isNull(pattern)) {
//            return false;
//        }
//
//        String regex = StringUtil.stringToRegex("", str, true);
//
//        if (isNullOrEmpty(regex)) {
//            return false;
//        }
//
//        return str.matches(regex);
//    }

    /**
     * Check multi byte character string.
     *
     * @author datnguyen
     * @param  str the str
     * @param  type the type
     * @return true, if successful
     */
    public static boolean checkMultiByteCharacterString(String str, MultiByte type) {

        if (isNullOrEmpty(str) || type == null) {
            return false;
        }

        byte[] bytes = str.getBytes();

        for (int i = 0; i < bytes.length; i += type.getNumOfByte()) {
            if (((bytes[i] & 0x000000FF) >> type.getNumOfPlaceToShift()) != type.getByteToCompare()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the string input is just contain hiragana character.
     *
     * @param  str the string want to check.
     * @param  pattern the pattern contain symbol and character can put 
     *         in the string input.
     * @return true, if the string input is just contain hiragana character and 
     *         symbol, character in pattern.
     */
    public static boolean isHiragana(String str, String pattern) {

        if (isNullOrEmpty(str)) {
            return false;
        }

        String regex = StringUtil.stringToRegex("\\u3040-\\u309F", pattern, true);

        return str.matches(regex);
    }

    /**
     * Checks if is kanji.
     *
     * @param  str the str
     * @param  pattern the pattern
     * @return true, if is kanji
     */
    public static boolean isKanji(String str, String pattern) {

        if (isNullOrEmpty(str)) {
            return false;
        }

        String regex = StringUtil.stringToRegex("\\u3400-\\u4DBF\\u4E00-\\u9FAF", pattern, true);

        return str.matches(regex);
    }

    /**
     * Checks if is katakana.
     *
     * @param  str the string want to check
     * @param  pattern the pattern string contain some symbol or character that 
     *         can put into the string input
     * @return true, if is katakana
     */
    public static boolean isKatakana(String str, String pattern) {

        if (isNullOrEmpty(str)) {
            return false;
        }

        String regex = StringUtil.stringToRegex("\\u30A0-\\u30FF\\uFF00-\\uFFEF", pattern, true);

        return str.matches(regex);
    }

    /**
     * Checks if is checks for blank valid.
     *
     * @param  str the str
     * @param  multiByte the multi byte, set true if want to check double-byte 
     *         whitespace character within string input
     * @return true, if if there are blank (whitespace) within string input,
     *         else return false
     */
    public static boolean isHasBlank(String str, boolean multiByte) {

        if (isNull(str)) {
            return false;
        }

        String regex = multiByte ? "^[^\\u0020\\u3000]*$" : "^[^\\u0020]*$";

        return !str.matches(regex);
    }

    /**
     * Checks if is checks for first blank valid.
     *
     * @param  str the str
     * @param  multiByte the multi byte
     * @return true, if is checks for first blank valid
     */
    public static boolean isHasFirstBlank(String str, boolean multiByte) {

        if (isNullOrEmpty(str)) {
            return false;
        }

        char firstChar = str.charAt(0);

        return multiByte ? firstChar == 0x20 || firstChar == 0x3000 : firstChar == 0x20;
    }

    /**
     * Checks if is checks for last blank valid.
     *
     * @param  str the str
     * @param  multiByte the multi byte
     * @return true, if is checks for last blank valid
     */
    public static boolean isHasLastBlank(String str, boolean multiByte) {

        if (isNullOrEmpty(str)) {
            return false;
        }

        char lastChar = str.charAt(str.length() - 1);

        return multiByte ? lastChar == 0x20 || lastChar == 0x3000 : lastChar == 0x20;
    }

    /**
     * Checks if the string input is valid email format.
     *
     * @author datnguyen
     * @param  str the string want to check
     * @param  pattern the pattern contain symbol or character can put in local-part
     * @return true, if the string input is valid email format
     */
    public static boolean isEmailValid(String str, String pattern) {

        if (isNullOrEmpty(str)) {
            return false;
        }

        String defaultRegex = "^[%sa-zA-Z0-9]+@[\\-a-zA-Z0-9]+((\\.)[a-zA-Z]+)+$".replaceAll("%s",
            pattern != null ? pattern : "");

        return str.matches(defaultRegex);
    }
}
