package jp.co.run.validation;

public class URLValidation {
    
    public static boolean isURLFormat(String str) {
        
        if (str == null || str.length() == 0) {
            return false;
        }
        
        String regex = "^((http|https)(://))?(www)(\\.)[]*$";
        
        return str.matches(regex);
    }

}
