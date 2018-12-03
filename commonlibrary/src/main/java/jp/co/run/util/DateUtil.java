package jp.co.run.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import jp.co.run.enums.EraNameJapan;
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
     * @param  str the string want to parse
     * @param  pattern the pattern
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
     * @param  date the date
     * @param  pattern the pattern
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
     * Returns the current date with the type return is date object.
     * 
     * <p>The default pattern is {@code yyyy/MM/dd HH:mm:ss:SSS}
     * 
     * @author datnguyen
     * @param  timeZoneID the timeZoneID
     * @return the current date
     */
    public static Date getCurrentDate(String timeZoneID) {

        String currentDateString = getCurrentDate(timeZoneID, "yyyy/MM/dd HH:mm:ss:SSS");

        if (!currentDateString.isEmpty()) {

            try {

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
                return dateFormat.parse(currentDateString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new Date();
    }

    /**
     * Returns the current date with the type return is string.
     * 
     * <p>The time return will depend on the {@code timeZoneID} and {@code pattern}.
     * 
     * <p>If the {@code timeZoneID} is null then will using default timeZone.
     * 
     * <p>If the {@code pattern} is invalid, method will return a empty string.
     * 
     * @author datnguyen
     * @param  timeZoneID the timeZoneID
     * @param  pattern the pattern
     * @return current date string, if the input params is invalid then return empty string.
     */
    public static String getCurrentDate(String timeZoneID, String pattern) {

        StringBuilder builder = new StringBuilder();

        try {

            if (pattern != null && !pattern.isEmpty()) {

                TimeZone timeZone = timeZoneID == null ? TimeZone.getDefault() : TimeZone.getTimeZone(timeZoneID);
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                sdf.setTimeZone(timeZone);
                builder.append(sdf.format(Calendar.getInstance().getTime()));
            }
        } catch (Exception e) {
        }

        return builder.toString();
    }

    /**
     * Compare date.
     * 
     * @author datnguyen
     * @param  date the date
     * @param  anotherDate the another date
     * @return 0 if the date is equal to anotherDate <br>
     *         1 if the date is greater than anotherDate <br>
     *        -1 if the date is less than anotherDate <br>
     *        -2 if the date or anotherDate is null
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
     * @param  dateStr the date string
     * @param  anotherDateStr the another date string
     * @param  pattern the pattern
     * @return 0 if the date is equal to anotherDate <br>
     *         1 if the date is greater than anotherDate <br>
     *        -1 if the date is less than anotherDate <br>
     *        -2 if the date or anotherDate is null
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
     * @param  str the date string
     * @param  oldPattern the old pattern
     * @param  newPattern the new pattern
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

    /**
     * Returns the age of humman depend on the given timeZoneID, time and pattern.
     * 
     * @author datnguyen
     * @param  timeZoneID the timeZoneID
     * @param  time the time born
     * @param  pattern the pattern
     * @return the age, return -1 if the params input is invalid.
     */
    public static int getAge(String timeZoneID, String time, String pattern) {

        Date date = parseDate(time, pattern);
        Date currentDate = getCurrentDate(timeZoneID);

        if (date != null && currentDate != null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar.setTime(date);
            calendar2.setTime(currentDate);

            return calendar2.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)
                + (calendar2.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
                    ? (calendar2.get(Calendar.DAY_OF_MONTH) < calendar.get(Calendar.DAY_OF_MONTH) ? 0 : 1)
                    : (calendar2.get(Calendar.MONTH) > calendar.get(Calendar.MONTH) ? 1 : 0));
        }

        return -1;
    }

    /**
     * Returns the number of week of year.
     * 
     * @author datnguyen
     * @param date the date
     * @return the number of week of year, return -1 of the date is null.
     */
    public static int convertDateToWeekInYear(Date date) {

        if (date == null) {
            return -1;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Returns the number of week of year.
     * 
     * @author datnguyen.
     * @param  time the time.
     * @param  pattern the pattern.
     * @return the number of week of year.
     */
    public static int convertDateToWeekInYear(String time, String pattern) {

        Date date = parseDate(time, pattern);

        return convertDateToWeekInYear(date);
    }

    public static Date[] convertWeekYearToDate(int weekOfYear, int year) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear);
        calendar.set(Calendar.YEAR, year);

        Date dateFrom = calendar.getTime();
        Date dateTo = new Date(dateFrom.getTime() + 86400000 * 6);

        return new Date[]{dateFrom, dateTo};
    }

    public static String convertWeekYearToDate(int weekOfYear, int year, String pattern) {

        StringBuilder builder = new StringBuilder();

        if (pattern == null || pattern.length() == 0) {
            pattern = "yyyy/MM/dd HH:mm:ss:SSS";
        }

        Date[] dateRange = convertWeekYearToDate(weekOfYear, year);

        try {
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            builder.append(dateFormat.format(dateRange[0]));
            builder.append(" - ");
            builder.append(dateFormat.format(dateRange[1]));
        } catch (Exception e) {
        }

        return builder.toString();
    }

    /**
     * 
     *
     */
    public static String convertDateToEraNameJapan(String time, String pattern) {

        Date date = parseDate(time, pattern);

        if (date == null) {
            return "";
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        for (EraNameJapan eraNameJapan : EraNameJapan.values()) {
            String eraName = eraNameJapan.calculate(calendar.get(Calendar.YEAR));

            if (eraName != null) {
                return eraName;
            }
        }

        return "";
    }
}
