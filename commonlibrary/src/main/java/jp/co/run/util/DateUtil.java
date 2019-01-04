package jp.co.run.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import jp.co.run.jperas.Wareki;
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
     * @param str the string want to parse
     * @param pattern the pattern
     * @return the date, null if the string invalid
     */
    public static Date parseDate(String str, String pattern) {
        if (DateValidation.isDateTimeValid(str, pattern)) {
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
     * Returns the current date with the type return is date object.
     * 
     * <p>
     * The default pattern is {@code yyyy/MM/dd HH:mm:ss:SSS}
     * 
     * @param timeZoneID the timeZoneID
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
     * <p>
     * The time return will depend on the {@code timeZoneID} and {@code pattern}.
     * 
     * <p>
     * If the {@code timeZoneID} is null then will using default timeZone.
     * 
     * <p>
     * If the {@code pattern} is invalid, method will return a empty string.
     * 
     * @param timeZoneID the timeZoneID
     * @param pattern the pattern
     * @return current date string, if the input params is invalid then return empty string.
     */
    public static String getCurrentDate(String timeZoneID, String pattern) {
        StringBuilder builder = new StringBuilder();
        try {
            if (!StringValidation.isNullOrEmpty(pattern)) {
                TimeZone timeZone = (timeZoneID == null || timeZoneID.length() == 0) ? TimeZone.getDefault()
                    : TimeZone.getTimeZone(timeZoneID);
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
     * @param date the date
     * @param anotherDate the another date
     * @return 0 if the date is equal to anotherDate <br>
     *         1 if the date is greater than anotherDate <br>
     *         -1 if the date is less than anotherDate <br>
     *         -2 if the date or anotherDate is null
     */
    public static int compareDate(Date date, Date anotherDate) {
        if (date == null || anotherDate == null) {
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

    /**
     * Returns the age of humman depend on the given timeZoneID, time and pattern.
     * 
     * @param timeZoneID the timeZoneID
     * @param time the time born
     * @param pattern the pattern
     * @return the age, return -1 if the params input is invalid.
     */
    public static int getCurrentYearOld(String time, String format, String timeZoneID) {
        Date date = parseDate(time, format);
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
     * @param date the date
     * @param isMondayStart the is monday start
     * @return the number of week of year, return -1 of the date is null.
     */
    public static int convertDateToWeek(Date date, boolean isMondayStart) {

        if (date == null) {
            return -1;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(isMondayStart ? Calendar.MONDAY : Calendar.SUNDAY);
        return calendar.get(Calendar.WEEK_OF_YEAR);

    }

    /**
     * Convert date to week.
     *
     * @param time the time
     * @param format the format date time (ex: yyyy/MM/dd)
     * @param isMondayStart the is monday start
     * @return the number of week of year, return -1 of the date is null.
     */
    public static int convertDateToWeek(String time, String format, boolean isMondayStart) {

        Date date = parseDate(time, format);

        return convertDateToWeek(date, isMondayStart);
    }

    /**
     * Convert week of year to range of date object.
     * 
     * @param weekOfYear the number of week of year.
     * @param year the year
     * @return the range of date of that week of year.
     */
    public static Date[] convertWeekToDate(int weekOfYear, int year, boolean isMondayStart) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_WEEK, isMondayStart ? Calendar.MONDAY : Calendar.SUNDAY);

        Date dateFrom = calendar.getTime();
        Date dateTo = new Date(dateFrom.getTime() + 86400000 * 6);

        return new Date[]{dateFrom, dateTo};
    }

    /**
     * Convert week of year to range of date string.
     * 
     * @param weekOfYear the number of week of year.
     * @param year the year.
     * @param format the format date time of result string want to get.
     * @return the string range of date.
     */
    public static String convertWeekToDate(int weekOfYear, int year, String format, boolean isMondayStart) {

        StringBuilder builder = new StringBuilder();

        if (weekOfYear <= 0 || year < 1 || year > 9999) {
            return builder.toString();
        }

        if (format == null || format.length() == 0) {
            format = "yyyyMMdd";
        }

        Date[] dateRange = convertWeekToDate(weekOfYear, year, isMondayStart);

        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            builder.append(dateFormat.format(dateRange[0]));
            builder.append(" - ");
            builder.append(dateFormat.format(dateRange[1]));
        } catch (Exception e) {
        }

        return builder.toString();
    }

    /**
     * Returns number of the day between date from to date to.
     * 
     * @param dateFrom the date from.
     * @param dateTo the date to.
     * @return the number of days.
     */
    public static int getDays(Date dateFrom, Date dateTo) {
        if (dateFrom == null || dateTo == null) {
            return -1;
        }
        long time = dateTo.getTime() - dateFrom.getTime();
        return time >= 0 ? (int) (time / (1000 * 60 * 60 * 24)) : -1;
    }

    /**
     * Add days.
     * 
     * @param date the date
     * @param days the day amount want to add.
     * @return the date after add.
     */
    public static Date addDate(Date date, int days) {
        if (date == null) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * Convert time into japanese era year.
     *
     * @param time the time
     * @param pattern the pattern
     * @return the string
     */
    public static String convertTimeToJpCalandar(String time, String format) {
        Date date = parseDate(time, format);
        StringBuilder builder = new StringBuilder();
        if (date == null) {
            return builder.toString();
        }
        Wareki wareki = Wareki.getInstance();
        wareki.setResultFieldType(Wareki.ERA);
        List<String> results = wareki.convert(date);
        if (results.size() >= 1) {
            builder.append(results.get(0));
        }
        return builder.toString();
    }
}
