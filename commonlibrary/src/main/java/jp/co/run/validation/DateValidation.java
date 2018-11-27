package jp.co.run.validation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.run.util.DateUtil;
import jp.co.run.util.NumberUtil;

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

        if (StringValidation.isNullOrEmpty(str, pattern) || str.length() != pattern.length()) {
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
     * Checks if is date time limit.
     *
     * @param date the date
     * @param minDate the min date
     * @param maxDate the max date
     * @return true, if is date time limit
     */
    public static boolean isDateTimeLimit(Date date, Date minDate, Date maxDate) {

        if (date == null || minDate == null || maxDate == null) {
            return false;
        }

        return date.getTime() >= minDate.getTime() && date.getTime() <= maxDate.getTime();
    }

    /**
     * Checks if is date time limit.
     *
     * @param dateStr the date str
     * @param minDateStr the min date str
     * @param maxDateStr the max date str
     * @param pattern the pattern
     * @return true, if is date time limit
     */
    public static boolean isDateTimeLimit(String dateStr, String minDateStr, String maxDateStr, String pattern) {

        if (!isDateTime(dateStr, pattern) || !isDateTime(minDateStr, pattern) || !isDateTime(maxDateStr, pattern)) {
            return false;
        }

        Date date = DateUtil.parseDate(dateStr, pattern);
        Date minDate = DateUtil.parseDate(minDateStr, pattern);
        Date maxDate = DateUtil.parseDate(maxDateStr, pattern);

        return isDateTimeLimit(date, minDate, maxDate);
    }

    /**
     * Checks if is year valid.
     *
     * @author datnguyen
     * @param year the year
     * @return true, if the year is larger than zero and less than 10000
     */
    public static boolean isYear(int year) {
        return year > 0 && year < 10000;
    }

    /**
     * Checks if the string input is valid year.
     *
     * @author datnguyen
     * @param year the string input want to check
     * @param hasDoubleByteChar true if the string input have double-byte character
     * @return true, if the string input is valid year
     */
    public static boolean isYear(String year, boolean hasDoubleByteChar) {
        try {
            int yearInt = NumberUtil.parseInt(year, hasDoubleByteChar);
            return isYear(yearInt);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if is month valid.
     *
     * @author datnguyen
     * @param month the month want to check
     * @return true, if is month valid
     */
    public static boolean isMonth(int month) {
        return month >= 1 && month <= 12;
    }

    /**
     * Checks if is month.
     *
     * @author datnguyen
     * @param month the month
     * @param hasDoubleByteChar the has double byte char
     * @return true, if is month
     */
    public static boolean isMonth(String month, boolean hasDoubleByteChar) {
        try {
            int monthInt = NumberUtil.parseInt(month, hasDoubleByteChar);
            return isMonth(monthInt);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if is day valid.
     *
     * @param day the day
     * @return true, if is day
     */
    public static boolean isDay(int day) {
        return day >= 1 && day <= 31;
    }

    /**
     * Checks if the string input is valid day.
     *
     * @param str the string want to check
     * @param hasDoubleByteChar true if the string input have double-byte character
     * @return true, if the string input is valid
     */
    public static boolean isDay(String str, boolean hasDoubleByteChar) {
        try {
            int day = NumberUtil.parseInt(str, hasDoubleByteChar);
            return isDay(day);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if is hours.
     *
     * @param hour the hour
     * @param isFullHours true if want to check full hours format
     * @return true, if is hours
     */
    public static boolean isHours(int hour, boolean isFullHours) {
        return hour >= 0 && (isFullHours ? hour <= 23 : hour <= 12);
    }

    /**
     * Checks if is hours.
     *
     * @param str the str
     * @param isFullHours the is full hours
     * @param hasDoubleByteChar true if the string input have double-byte character
     * @return true, if is hours
     */
    public static boolean isHours(String str, boolean isFullHours, boolean hasDoubleByteChar) {
        try {
            int hour = NumberUtil.parseInt(str, hasDoubleByteChar);
            return isHours(hour, isFullHours);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if is minutes.
     *
     * @param minute the minute
     * @return true, if is minutes
     */
    public static boolean isMinutes(int minute) {
        return minute >= 0 && minute <= 59;
    }

    /**
     * Checks if is minutes.
     *
     * @param str the str
     * @param hasDoubleByteChar true if the string input have double-byte character
     * @return true, if is minutes
     */
    public static boolean isMinutes(String str, boolean hasDoubleByteChar) {
        try {
            int minute = NumberUtil.parseInt(str, hasDoubleByteChar);
            return isMinutes(minute);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if is seconds.
     *
     * @param second the second
     * @return true, if is seconds
     */
    public static boolean isSeconds(int second) {
        return second >= 0 && second <= 59;
    }

    /**
     * Checks if is seconds.
     *
     * @param str the str
     * @param hasDoubleByteChar true if the string input have double-byte character
     * @return true, if is seconds
     */
    public static boolean isSeconds(String str, boolean hasDoubleByteChar) {
        try {
            int second = NumberUtil.parseInt(str, hasDoubleByteChar);
            return isSeconds(second);
        } catch (Exception e) {
            return false;
        }
    }
}
