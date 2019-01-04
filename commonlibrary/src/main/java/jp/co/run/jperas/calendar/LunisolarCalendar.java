package jp.co.run.jperas.calendar;

import java.util.LinkedHashMap;
import java.util.Map;

import jp.co.run.jperas.enums.Eras;
import jp.co.run.jperas.enums.LunisolarYears;

/**
 * The Class LunisolarCalendar.
 * 
 * @author datnguyen
 */
public class LunisolarCalendar extends AbstractCalendar {

    /* (non-Javadoc)
     * @see jp.co.run.jperas.AbstractCalendar#getMonths(jp.co.run.jperas.Eras, int)
     */
    @Override
    protected Map<String, Integer> getMonths(Eras eras, int year) {
        LinkedHashMap<String, Integer> months = new LinkedHashMap<>();
        int y = this.getYearIndex(eras, year);
        LunisolarYears luni = LunisolarYears.values()[y];
        int flag = luni.getFlag();
        int j = 0;
        int i = 0;
        while (i < (luni.getUru() < 0 ? 12 : 13)) {
            int d = (flag & (int) Math.pow(2, i)) != 0 ? 30 : 29;
            if (luni.getUru() != i) {
                j++;
            }
            months.put(luni.getUru() == i ? "閏" + j : String.valueOf(j), d);
            i++;
        }
        return months;
    }

    /* (non-Javadoc)
     * @see jp.co.run.jperas.AbstractCalendar#getIndexFromYear(jp.co.run.jperas.Eras, int)
     */
    @Override
    protected int getIndexFromYear(Eras eras, int year) {
        int y = this.getYearIndex(eras, year);
        return LunisolarYears.values()[y].getIndex();
    }

    /* (non-Javadoc)
     * @see jp.co.run.jperas.AbstractCalendar#getYearFromIndex(jp.co.run.jperas.Eras, int)
     */
    @Override
    protected int getYearFromIndex(Eras eras, int index) {
        return this.findYear(index) - this.findYear(eras.getStart()) + eras.getDelta();
    }

    /**
     * Gets the year index.
     *
     * @param eras the eras
     * @param year the year
     * @return the year index
     */
    private int getYearIndex(Eras eras, int year) {
        LunisolarYears[] years = LunisolarYears.values();
        int i = years.length - 1;
        while (i >= 0) {
            if (years[i].getIndex() <= eras.getStart()) {
                int result = i + year - (eras.getDelta() >= 0 ? eras.getDelta() : 1);
                if (result >= 0 && result < years.length) {
                    return result;
                }
                break;
            }
            i--;
        }
        return -1;
    }

    /**
     * Find year.
     *
     * @param index the index
     * @return the int
     */
    private int findYear(int index) {
        LunisolarYears[] lunis = LunisolarYears.values();
        int i = lunis.length - 1;
        while (i >= 0) {
            if (lunis[i].getIndex() <= index) {
                return i;
            }
            i--;
        }
        return -1;
    }
}
