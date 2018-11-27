package jp.co.run.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.run.validation.DateValidation;
import jp.co.run.validation.StringValidation;

/**
 * The Class DateUtil.
 * 
 * @author datnguyen
 */
public class DateUtil {

    /**
     * Parses the string to date object.
     *
     * @author datnguyen
     * @param str the string want to parse
     * @param pattern the pattern
     * @return the date, null if the string invalid
     */
    public static Date parseDate(String str, String pattern) {

        if (DateValidation.isDateTime(str, pattern)) {

            try {
                DateFormat dateFormat = new SimpleDateFormat(pattern);
                return dateFormat.parse(str);
            } catch (Exception e) {
            }
        }

        return null;
    }

    /**
     * Date to string.
     *
     * @param date the date
     * @param pattern the pattern
     * @return the date string, return empty string if date is null or pattern is incorrect
     */
    public static String dateToString(Date date, String pattern) {

        StringBuilder builder = new StringBuilder();

        if (date == null || StringValidation.isNullOrEmpty(pattern)) {
            return builder.toString();
        }

        try {
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            String dateStr = dateFormat.format(date);
            if (dateStr != null) {
                builder.append(dateStr);
            }
        } catch (Exception e) {
        }

        return builder.toString();
    }

    /**
     * Compare date.
     * 
     * @author datnguyen
     * @param date the date
     * @param anotherDate the another date
     * @return 0 if the date is equal to anotherDate <br>
     *         1 if the date is greater than anotherDate <br>
     *         -1 if the date is less than anotherDate <br>
     *         -2 if the date or anotherDate is null
     */
    public static int compareDate(Date date, Date anotherDate) {
        if (Util.isObjNull(date, anotherDate)) {
            return -2;
        }

        if (date.getTime() == anotherDate.getTime()) {
            return 0;
        } else if (date.getTime() > anotherDate.getTime()) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Compare date.
     * 
     * @author datnguyen
     * @param dateStr the date string
     * @param anotherDateStr the another date string
     * @param pattern the pattern
     * @return 0 if the date is equal to anotherDate <br>
     *         1 if the date is greater than anotherDate <br>
     *         -1 if the date is less than anotherDate <br>
     *         -2 if the date or anotherDate is null
     */
    public static int compareDate(String dateStr, String anotherDateStr, String pattern) {

        Date date = parseDate(dateStr, pattern);
        Date anotherDate = parseDate(anotherDateStr, pattern);

        return compareDate(date, anotherDate);
    }

    /**
     * Change date format.
     * 
     * @author datnguyen
     * @param str the date string
     * @param oldPattern the old pattern
     * @param newPattern the new pattern
     * @return the new date format string, return empty string if parameter is invalid
     */
    public static String changeDateFormat(String str, String oldPattern, String newPattern) {

        StringBuilder builder = new StringBuilder();

        Date date = parseDate(str, oldPattern);

        if (date != null) {
            builder.append(dateToString(date, newPattern));
        }

        return builder.toString();
    }
}
