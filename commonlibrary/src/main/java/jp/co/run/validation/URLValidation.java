package jp.co.run.validation;

import java.util.Arrays;
import java.util.List;

/**
 * The Class URLValidation.
 * 
 * @author datnguyen
 */
public class URLValidation {

    /**
     * Checks if the url input is valid format.
     *
     * @param str the str
     * @param pattern the pattern
     * @return true if the url string input is valid, else return false.
     */
    public static boolean isURLFormat(String str, String pattern) {

        if (str == null || str.length() == 0 ||
            pattern == null || pattern.length() == 0) {
            return false;
        }
        StringBuilder regex = new StringBuilder(
            "[a-zA-Z0-9]+([\\-]?[a-zA-Z0-9]+)*(\\.)[a-zA-Z0-9]+((\\.)[a-zA-Z0-9]+)*((:)[0-9]{1,6})?((\\/)[\\S]*)?$");

        if (pattern != null && pattern.length() > 0) {
            List<String> prefixs = Arrays.asList(pattern.split("\\u007C"));
            StringBuilder builder = new StringBuilder();

            builder.append("(");
            for (int i = 0; i < prefixs.size(); i++) {
                if (prefixs.get(i).toLowerCase().endsWith("www")) {
                    prefixs.set(i, prefixs.get(i) + ".");
                }

                builder.append("(");
                char[] array = prefixs.get(i).toLowerCase().toCharArray();
                for (char c : array) {
                    builder.append("\\x{");
                    builder.append(Integer.toHexString(c));
                    builder.append("}");
                }
                builder.append(")");

                if (i != (prefixs.size() - 1)) {
                    builder.append("|");
                }
            }
            builder.append(")");

            regex.insert(0, builder.toString());
        }
        regex.insert(0, "^");
        return str.toLowerCase().matches(regex.toString());
    }
}
