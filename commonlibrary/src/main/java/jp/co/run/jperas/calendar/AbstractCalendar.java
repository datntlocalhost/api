package jp.co.run.jperas.calendar;

import java.util.LinkedList;
import java.util.Map;

import jp.co.run.jperas.enums.Eras;

/**
 * The Class AbstractCalendar.
 * 
 * @author datnguyen
 */
public abstract class AbstractCalendar {

    /**
     * Gets the months.
     *
     * @param eras the eras
     * @param year the year
     * @return the months
     */
    protected abstract Map<String, Integer> getMonths(Eras eras, int year);

    /**
     * Gets the index from year.
     *
     * @param eras the eras
     * @param year the year
     * @return the index from year
     */
    protected abstract int getIndexFromYear(Eras eras, int year);

    /**
     * Gets the year from index.
     *
     * @param eras the eras
     * @param index the index
     * @return the year from index
     */
    protected abstract int getYearFromIndex(Eras eras, int index);

    /**
     * Gets the index.
     *
     * @param eras the eras
     * @param year the year
     * @param month the month
     * @param day the day
     * @return the index
     */
    public int getIndex(Eras eras, int year, int month, int day) {
        int index = getIndexFromYear(eras, year);
        Map<String, Integer> months = this.getMonths(eras, year);
        for (int i = 0; i < month; i++) {
            index += months.get(String.valueOf(i + 1)).intValue();
        }
        return (index + day - 1);
    }

    public String convert(Eras eras, int index) {
        int year = this.getYearFromIndex(eras, index);
        int remainder = index - this.getIndexFromYear(eras, year);
        int b = 0;
        Map<String, Integer> months = this.getMonths(eras, year);
        LinkedList<Integer> a = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        if (months == null) {
            return builder.toString();
        }
        for (String key : months.keySet()) {
            a.addFirst(b);
            b += months.get(key).intValue();
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) <= remainder) {
                builder.append(eras.getCaption());
                builder.append(year != 1 ? year : "元");
                builder.append("年");
                builder.append(months.size() - i);
                builder.append("月");
                builder.append(remainder - a.get(i) + 1);
                builder.append("日");
                break;
            }
        }
        return builder.toString();
    }
}
