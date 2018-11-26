package jp.co.run.validation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * The Class DateValidation.
 * 
 * @author datnguyen
 */
public class DateValidation {

	/**
	 * Checks if the string input is date time.
	 *
	 * @author datnguyen
	 * @param str the string input want to check
	 * @param pattern the pattern
	 * @return true, if the string input is date time
	 */
	public static boolean isDateTime(String str, String pattern) {
		if (StringValidation.isNullOrEmpty(str, pattern)) {
			return false;
		}
		
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		dateFormat.setLenient(false);
		
		try {
			dateFormat.parse(str);
		} catch (Exception e) {
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
		System.err.println(isDateTime("29-02-2018","asdasdsad"));
	}
}
