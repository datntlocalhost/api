package jp.co.run.validation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.run.util.DateUtil;
import jp.co.run.util.NumberUtil;

/**
 * The {@code DateValidation} class provides several methods for checking validation of date time.
 * 
 * @author datnguyen
 */
public final class DateValidation {

    /**
     * Checks if the string input is valid date time format
     *
     * @param str the string input want to check
     * @param pattern the pattern
     * @return true, if the string input is valid date time format
     */
    public static boolean isDateTimeValid(String str, String pattern) {

        if (StringValidation.isNullOrEmpty(str, pattern) ||
            str.length() != pattern.length() ||
            !StringValidation.isOneByteCharacterOnly(str) ||
            !StringValidation.isOneByteCharacterOnly(pattern)) {
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
     * Checks if the date input is between the given date range.
     * 
     * @param date the date want to check.
     * @param minDate the min date.
     * @param maxDate the max date.
     * @return true, if the date input is between the given date range, that mean the date input have to greater than or
     *         equal to min date and less than or equal to max date.
     */
    public static boolean isDateTimeLimit(Date date, Date minDate, Date maxDate) {

        if (date == null || minDate == null || maxDate == null) {
            return false;
        }

        return date.getTime() >= minDate.getTime() && date.getTime() <= maxDate.getTime();
    }

    /**
     * Checks if the date input is between the given date range
     * 
     * @param dateStr the date string input want to check
     * @param minDateStr the min date string
     * @param maxDateStr the max date string
     * @param pattern the pattern
     * @return true, if the date input is between the given date range, that mean the date input have to greater than or
     *         equal to min date and less than or equal to max date
     */
    public static boolean isDateTimeLimit(String dateStr, String minDateStr, String maxDateStr, String pattern) {

        if (!isDateTimeValid(dateStr, pattern) || !isDateTimeValid(minDateStr, pattern)
            || !isDateTimeValid(maxDateStr, pattern)) {
            return false;
        }

        Date date = DateUtil.parseDate(dateStr, pattern);
        Date minDate = DateUtil.parseDate(minDateStr, pattern);
        Date maxDate = DateUtil.parseDate(maxDateStr, pattern);

        return isDateTimeLimit(date, minDate, maxDate);
    }

    /**
     * Checks if the date from is less than or equal to the date to.
     *
     * @param dateFrom the date from
     * @param dateTo the date to
     * @param format the format
     * @return true, if the date from is less than or equal to the date to, false if parameter input is invalid or the
     *         date from is greater than the date to
     */
    public static boolean isFromLessOrEqualTo(String dateFrom, String dateTo, boolean isEqual, String format) {

        if (!isDateTimeValid(dateFrom, format) || !isDateTimeValid(dateTo, format)) {
            return false;
        }

        Date from = DateUtil.parseDate(dateFrom, format);
        Date to = DateUtil.parseDate(dateTo, format);

        return from != null && to != null && (isEqual ? from.getTime() <= to.getTime() : from.getTime() < to.getTime());
    }

    /**
     * Checks if is year valid.
     * 
     * <p>
     * The {@code year} just between 0 to 9999
     * 
     * @param year the year
     * @return true, if the year is larger than zero and less than 10000
     */
    public static boolean isYearValid(int year) {
        return year > 0 && year < 10000;
    }

    /**
     * Checks if the string input is valid year.
     * 
     * <p>
     * The {@code year} just between 0 to 9999
     * <p>
     * The value of the argument str can be double-byte character
     *
     * @param year the string input want to check
     * @param hasDoubleByteChar true if the string input have double-byte character
     * @return true, if the string input is valid year
     */
    public static boolean isYearValid(String year, boolean hasDoubleByteChar) {

        String regex = hasDoubleByteChar ? "^[0-9\\uFF10-\\uFF19]{1,4}$" : "^[0-9]{1,4}$";
        
        if (year == null || !year.matches(regex)) {
            return false;
        }
        
        try {
            int yearInt = NumberUtil.parseInt(year, hasDoubleByteChar);
            return yearInt > 0 && yearInt < 10000;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if is month valid.
     * 
     * <p>
     * The {@code month} just between 1 to 12
     *
     * @param month the month want to check
     * @return true, if is month valid
     */
    public static boolean isMonthValid(int month) {
        return month > 0 && month < 13;
    }

    /**
     * Checks if is month.
     *
     * <p>
     * The {@code month} just between 1 to 12
     * <p>
     * The value of the argument str can be double-byte character
     * 
     * @param month the month
     * @param hasDoubleByteChar the has double byte char
     * @return true, if is month
     */
    public static boolean isMonthValid(String month, boolean hasDoubleByteChar) {

        String regex = hasDoubleByteChar ? "^[0-9\\uFF10-\\uFF19]{1,2}$" : "^[0-9]{1,2}$";

        if (month == null || !month.matches(regex)) {
            return false;
        }

        try {
            int monthInt = NumberUtil.parseInt(month, hasDoubleByteChar);
            return monthInt >= 1 && monthInt <= 12;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if is day valid.
     * 
     * <p>
     * The {@code day} just between 1 to 31
     * 
     * @param day the day want to check
     * @return true, if is day is valid
     */
    public static boolean isDayValid(int day) {
        return day > 0 && day < 32;
    }

    /**
     * Checks if the string input is valid day.
     * 
     * <p>
     * The {@code month} just between 1 to 31
     * <p>
     * The value of the argument str can be double-byte character
     *
     * @param str the string want to check
     * @param hasDoubleByteChar true if the string input have double-byte character
     * @return true, if the string input is valid
     */
    public static boolean isDayValid(String str, boolean hasDoubleByteChar) {

        String regex = hasDoubleByteChar ? "^[0-9\\uFF10-\\uFF19]{1,2}$" : "^[0-9]{1,2}$";

        if (str == null || !str.matches(regex)) {
            return false;
        }

        try {
            int day = NumberUtil.parseInt(str, hasDoubleByteChar);
            return day >= 1 && day <= 31;
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
    public static boolean isHourValid(int hour, boolean is24h) {
        return hour >= 0 && (is24h ? hour < 24 : hour < 13);
    }

    /**
     * Checks if is hours.
     *
     * @param str the str
     * @param isFullHours the is full hours
     * @param hasDoubleByteChar true if the string input have double-byte character
     * @return true, if is hours
     */
    public static boolean isHourValid(String str, boolean isFullHours, boolean hasDoubleByteChar) {

        String regex = hasDoubleByteChar ? "^[0-9\\uFF10-\\uFF19]{1,2}$" : "^[0-9]{1,2}$";

        if (str == null || !str.matches(regex)) {
            return false;
        }

        try {
            int hour = NumberUtil.parseInt(str, hasDoubleByteChar);
            return (isFullHours ? hour >= 0 && hour <= 23 : hour >= 1 && hour <= 12);
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
    public static boolean isMinuteValid(int minute) {
        return minute >= 0 && minute < 60;
    }

    /**
     * Checks if is minutes.
     *
     * @param str the str
     * @param hasDoubleByteChar true if the string input have double-byte character
     * @return true, if is minutes
     */
    public static boolean isMinuteValid(String str, boolean hasDoubleByteChar) {

        String regex = hasDoubleByteChar ? "^[0-9\\uFF10-\\uFF19]{1,2}$" : "^[0-9]{1,2}$";
        
        if (str == null || !str.matches(regex)) {
            return false;
        }

        try {
            int minute = NumberUtil.parseInt(str, hasDoubleByteChar);
            return minute >= 0 && minute <= 59;
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
    public static boolean isSecondValid(int second) {
        return second >= 0 && second < 60;
    }

    /**
     * Checks if is seconds.
     *
     * @param str the str
     * @param hasDoubleByteChar true if the string input have double-byte character
     * @return true, if is seconds
     */
    public static boolean isSecondValid(String str, boolean hasDoubleByteChar) {

        String regex = hasDoubleByteChar ? "^[0-9\\uFF10-\\uFF19]{1,2}$" : "^[0-9]{1,2}$";

        if (str == null || !str.matches(regex)) {
            return false;
        }

        try {
            int second = NumberUtil.parseInt(str, hasDoubleByteChar);
            return second >= 0 && second <= 59;
        } catch (Exception e) {
            return false;
        }
    }
}
