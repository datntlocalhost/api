package jp.co.run.validation;

import jp.co.run.util.StringUtil;

/**
 * The {@code StringValidation} class provides several methods for checking validation of string input.
 * 
 * @author datnguyen
 */
public final class StringValidation {

    /**
     * Check if the string input is null.
     *
     * @param str the string input want to check.
     * @return true if the string input is null, else return false.
     */
    public static boolean isNull(String str) {
        return str == null;
    }

    /**
     * Checks if the string input is empty (the length = 0).
     * 
     * @param str the string want to check.
     * @return true if the string input is empty.
     */
    public static boolean isEmpty(String str) {

        if (str == null) {
            return false;
        }

        return str.length() == 0;
    }

    /**
     * Checks if the string input is empty (whitespace).
     * 
     * @param str the string want to check.
     * @return true if the string input is empty.
     */
    public static boolean isEmptyWithoutBlank(String str) {

        String regex = "^[\\u0020\\u3000]*$";

        if (str == null) {
            return false;
        }

        return str.matches(regex);
    }

    /**
     * Checks if the string input is null or empty.
     *
     * @param str the string input want to check
     * @return true, if the string input is null or empty
     */
    public static boolean isNullOrEmpty(String str) {
        return isNull(str) || str.isEmpty();
    }

    /**
     * Checks if array of the strings input is null or empty.
     * 
     * @param strs array of string want to check
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
     * @param str the string input want to check.
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
     * @param str the string input want to check.
     * @param maxLength the max length
     * @return true, if length of the string input is less than or equal to maxLength, else return false
     */
    public static boolean isMaxLengthValid(String str, int maxLength) {

        if (str == null || maxLength < 0) {
            return false;
        }

        return str.length() <= maxLength;
    }

    /**
     * Checks if the string input is min length.
     *
     * @author datnguyen
     * @param str the string input want to check.
     * @param minLength the min length
     * @return true, if the string input is min length
     */
    public static boolean isMinLengthValid(String str, int minLength) {

        if (str == null || minLength < 0) {
            return false;
        }

        return str.length() >= minLength;
    }

    /**
     * Checks if the string is single-byte character only.
     *
     * @author datnguyen
     * @param str the str
     * @return true, if the string input is is just contain single-byte character, else return false
     */
    public static boolean isOneByteCharacterOnly(String str) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        byte[] bytes = str.getBytes();
        int i = 0;

        while (i < bytes.length) {

            int leadBits = (bytes[i] & 0x000000FF) >> 4;

            if (leadBits >= 0xC) {
                return false;
            }

            i += 1;
        }

        return true;
    }

    /**
     * Checks if the string input is just contain double-byte, three-byte or four-byte character.
     *
     * @author datnguyen
     * @param str the string want to check
     * @return true, if the string input is is just contain double-byte, three-byte or four-byte character, else return
     *         false
     */
    public static boolean isTwoByteCharacterOnly(String str) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        byte[] bytes = str.getBytes();
        int i = 0;

        while (i < bytes.length) {

            int leadBits = ((bytes[i] & 0x000000FF) >> 4);

            if (leadBits >= 0xC) {
                int numBitOne = (leadBits & 1) + ((leadBits >> 1) & 1) + ((leadBits >> 2) & 1) + ((leadBits >> 3) & 1);
                i += numBitOne;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if is not special character.
     *
     * @param str the str
     * @param pattern the pattern
     * @return true, if is not special character
     */
    public static boolean isNotSpecialCharacter(String str, String pattern) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String regex = StringUtil
            .stringToRegex("[^\\u0021-\\u002F\\u003A-\\u0040\\u005B-\\u0060\\u007B-\\u007E\\u00A1-\\u00BF"
                + "\\uFF01-\\uFF0F\\uFF1A-\\uFF20\\uFF3B-\\uFF40\\uFF5B-\\uFF5E" + "\\u300C\\u300D\\u201D\\u2019"
                + "\\uFFE5\\u3001\\u3002\\u30FB]+", pattern, true);

        if (regex == null || regex.length() == 0) {
            return false;
        }

        return str.matches(regex);
    }

    /**
     * Checks if the string input is just contain hiragana character.
     *
     * @param str the string want to check.
     * @param pattern the pattern contain symbol and character can put in the string input.
     * @return true, if the string input is just contain hiragana character and symbol, character in pattern.
     */
    public static boolean isHiragana(String str, String pattern, boolean isShiftJis) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String regex = StringUtil.stringToRegex(isShiftJis ? "\\u3041-\\u3093" : "\\u3040-\\u309F", pattern, true);

        return str.matches(regex);
    }

    /**
     * Checks if is kanji.
     *
     * @param str the str
     * @param pattern the pattern
     * @return true, if is kanji
     */
    public static boolean isKanji(String str, String pattern) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String regex = StringUtil.stringToRegex("\\u3400-\\u4DBF\\u4E00-\\u9FAF", pattern, true);

        return str.matches(regex);
    }

    /**
     * Checks if is katakana.
     *
     * @param str the string want to check
     * @param pattern the pattern string contain some symbol or character that can put into the string input
     * @return true, if is katakana
     */
    public static boolean isKatakana(String str, String pattern, boolean isShiftJis) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String regex = StringUtil.stringToRegex(
            isShiftJis ? "\\u30A1-\\u30F6\\uFF65-\\uFF9F" : "\\u30A0-\\u30FF\\uFF65-\\uFF9F", pattern, true);

        return str.matches(regex);
    }

    /**
     * Checks if is checks for blank valid.
     *
     * @param str the str
     * @param multiByte the multi byte, set true if want to check double-byte whitespace character within string input
     * @return true, if if there are blank (whitespace) within string input, else return false
     */
    public static boolean isHasBlankValid(String str, boolean multiByte) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String regex = multiByte ? "^[^\\u3000]*$" : "^[^\\u0020]*$";

        return !str.matches(regex);
    }

    /**
     * Checks if is checks for first blank valid.
     *
     * @param str the str
     * @param multiByte the multi byte
     * @return true, if is checks for first blank valid
     */
    public static boolean isHasFirstBlankValid(String str, boolean multiByte) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        char firstChar = str.charAt(0);

        return multiByte ? firstChar == 0x3000 : firstChar == 0x20;
    }

    /**
     * Checks if is checks for last blank valid.
     *
     * @param str the str
     * @param multiByte the multi byte
     * @return true, if is checks for last blank valid
     */
    public static boolean isHasLastBlankValid(String str, boolean multiByte) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        char lastChar = str.charAt(str.length() - 1);

        return multiByte ? lastChar == 0x3000 : lastChar == 0x20;
    }

    /**
     * Checks if the string input is valid email format.
     *
     * @param str the string want to check
     * @param pattern the pattern contain symbol or character can put in local-part
     * @return true, if the string input is valid email format
     */
    public static boolean isEmailValid(String str, String pattern) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String defaultRegex = "^[%sa-zA-Z0-9]+@[\\-a-zA-Z0-9]+((\\.)[a-zA-Z]+)+$".replaceAll("%s",
            pattern != null ? StringUtil.stringToHex(pattern) : "");

        return str.matches(defaultRegex);
    }

    /**
     * Checks if the string input is alphabet character (single-byte).
     * 
     * @param str the string input want to check.
     * @param pattern the pattern contain symble can put in the string input.
     * @param isAlphanumeric set true if the string input have numeric character.
     * @return true if the string input is alphabet character.
     */
    public static boolean isAlphabetCharacter(String str, String pattern, boolean isAlphanumeric) {

        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }

        String regex = StringUtil.stringToRegex(isAlphanumeric ? "a-zA-Z0-9" : "a-zA-Z", pattern, true);

        return str.matches(regex);
    }

    /**
     * Checks if the password is valid.
     * 
     * @param str the password want to check.
     * @param upperCase set true if the password want to check can put upper case character.
     * @param lowerCase set true if the password want to check can put lower case character.
     * @param specialChar set true if the password want to check can put special character.
     * @param number set true if the password want to check can put number character.
     * @param space set true if the password want to check can put blank (whitespace) character.
     * @return true if the password is valid, else return false.
     */
    public static boolean isPasswordValid(String str, boolean upperCase, boolean lowerCase, boolean specialChar,
        boolean number, boolean space) {

        if (StringValidation.isNullOrEmpty(str) || !StringValidation.isOneByteCharacterOnly(str)) {
            return false;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(upperCase ? "(?=.*[\\u0041-\\u005A])" : "(?!.*[\\u0041-\\u005A])");
        builder.append(lowerCase ? "(?=.*[\\u0061-\\u007A])" : "(?!.*[\\u0061-\\u007A])");
        builder
            .append(specialChar ? "(?=.*[\\u0021-\\u0029\\u002A-\\u002F\\u003A-\\u0040\\u005B-\\u0060\\u007B-\\u007E])"
                : "(?!.*[\\u0021-\\u0029\\u002A-\\u002F\\u003A-\\u0040\\u005B-\\u0060\\u007B-\\u007E])");
        builder.append(number ? "(?=.*[\\u0030-\\u0039])" : "(?!.*[\\u0030-\\u0039])");
        builder.append(space ? "(?=.*[\\u0020])" : "(?!.*[\\u0020])");
        builder.insert(0, "^");
        builder.append(".+$");

        return str.matches(builder.toString());
    }

    /**
     * Checks if the string input is half width katakana character.
     * 
     * @param str the string want to check.
     * @return true if the string input is half width katakana character.
     */
    public static boolean isHalfWidthKata(String str, String pattern) {
        if (StringValidation.isNullOrEmpty(str) || pattern == null) {
            return false;
        }
        String regex = StringUtil.stringToRegex("\\uFF65-\\uFF9F", pattern, true);
        return str.matches(regex);
    }

    /**
     * Checks if the string input is full width katakana character.
     * 
     * @param str the string want to check.
     * @param pattern the pattern that contain character or symbol that can put into string input
     * @return true if the string input is full width katakana character.
     */
    public static boolean isFullWidthKata(String str, String pattern, boolean isShiftJis) {
        if (StringValidation.isNullOrEmpty(str) || pattern == null) {
            return false;
        }
        String regex = StringUtil.stringToRegex(isShiftJis ? "\\u30A1-\\u30F6" : "\\u30A0-\\u30FF", pattern, true);
        return str.matches(regex);
    }

    /**
     * Checks if the string input is half width alphabet character.
     * 
     * @param str the string want to check.
     * @param isAlphanumeric set true if want the string contain half width numeric.
     * @return true if the string input is half width alphabet character, else return fasle.
     */
    public static boolean isHalfWidthAlphabet(String str, boolean isAlphanumeric) {
        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }
        String regex = isAlphanumeric ? "^[\\u0061-\\u007A\\u0041-\\u005A\\u0030-\\u0039]+$"
            : "^[\\u0061-\\u007A\\u0041-\\u005A]+$";
        return str.matches(regex);
    }

    /**
     * Checks if the string input is full width alphabet character.
     * 
     * @param str the string input want to check.
     * @param isAlphanumeric set true if want check the string contain full width numeric.
     * @return true if the string input is full width alphabet character.
     */
    public static boolean isFullWidthAlphabet(String str, boolean isAlphanumeric) {
        if (StringValidation.isNullOrEmpty(str)) {
            return false;
        }
        String regex = isAlphanumeric ? "^[\\uFF41-\\uFF5A\\uFF21-\\uFF3A\\uFF10-\\uFF19]+$"
                                      : "^[\\uFF41-\\uFF5A\\uFF21-\\uFF3A]+$";
        return str.matches(regex);
    }

    public static boolean isPhoneNumber(String str, String pattern) {

        if (StringValidation.isNullOrEmpty(str) || StringValidation.isNullOrEmpty(pattern)) {
            return false;
        }

        return str.matches(pattern);
    }
}
