package jp.co.run.jperas.calendar;

import java.util.LinkedHashMap;
import java.util.Map;

import jp.co.run.jperas.enums.Eras;

/**
 * The Class JuliusCalendar.
 * 
 * @author datnguyen
 */
public class JuliusCalendar extends AbstractCalendar {

    /* (non-Javadoc)
     * @see jp.co.run.jperas.AbstractCalendar#getMonths(jp.co.run.jperas.Eras, int)
     */
    @Override
    protected Map<String, Integer> getMonths(Eras eras, int year) {
        LinkedHashMap<String, Integer> months = new LinkedHashMap<>();
        months.put("1", 31);
        months.put("2", this.isLeapYear(eras, year) ? 29 : 28);
        months.put("3", 31);
        months.put("4", 30);
        months.put("5", 31);
        months.put("6", 30);
        months.put("7", 31);
        months.put("8", 31);
        months.put("9", 30);
        months.put("10", 31);
        months.put("11", 30);
        months.put("12", 31);
        return months;
    }

    /* (non-Javadoc)
     * @see jp.co.run.jperas.AbstractCalendar#getIndexFromYear(jp.co.run.jperas.Eras, int)
     */
    @Override
    protected int getIndexFromYear(Eras eras, int year) {
        int y = year + eras.getDelta() - 2;
        int result = (int) (y * 365 + Math.floor(y / 4) - Eras.START_POSITION - 2);
        if (result < eras.getStart() || result > eras.getEnd()) {
            return -1;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see jp.co.run.jperas.AbstractCalendar#getYearFromIndex(jp.co.run.jperas.Eras, int)
     */
    @Override
    protected int getYearFromIndex(Eras eras, int index) {
        int p = Eras.START_POSITION + index + 2;
        int a = 365 * 4 + 1;
        return (int) (Math.floor(p / a) * 4
                    + Math.floor((p % a) / 365)
                    - eras.getDelta() + 2);
    }
    
    /**
     * Checks if is leap year.
     *
     * @param eras the eras
     * @param year the year
     * @return true, if is leap year
     */
    private boolean isLeapYear(Eras eras, int year) {
        int y = year + eras.getDelta() - 1;
        return (y % 4) == 0;
    }

}
