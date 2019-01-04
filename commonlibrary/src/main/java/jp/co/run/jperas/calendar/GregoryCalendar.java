package jp.co.run.jperas.calendar;

import jp.co.run.jperas.enums.Eras;

/**
 * The Class GregoryCalendar.
 * 
 * @author datnguyen
 */
public class GregoryCalendar extends JuliusCalendar {

    /* (non-Javadoc)
     * @see jp.co.run.jperas.JuliusCalendar#getIndexFromYear(jp.co.run.jperas.Eras, int)
     */
    @Override
    protected int getIndexFromYear(Eras eras, int year) {
        int y = year + eras.getDelta() - 2;
        int result = (int) (y * 365 + Math.floor(y / 4)
                                    - Math.floor(y / 100)
                                    + Math.floor(y / 400)
                                    - Eras.START_POSITION);
        return result;
    }

    /* (non-Javadoc)
     * @see jp.co.run.jperas.JuliusCalendar#getYearFromIndex(jp.co.run.jperas.Eras, int)
     */
    @Override
    protected int getYearFromIndex(Eras eras, int index) {
        int p = Eras.START_POSITION + index;
        int a = 365 * 400 + 97;
        int b = 365 * 100 + 24;
        int c = 365 * 4 + 1;
        return (int) (Math.floor(p / a) * 400
                    + Math.floor((p % a) / b) * 100
                    + Math.floor((p % a % b) / c) * 4
                    + Math.floor((p % a % b % c) / 365)
                    - eras.getDelta()
                    + 2);
    }

    /**
     * Checks if is leap year.
     *
     * @param eras the eras
     * @param year the year
     * @return true, if is leap year
     */
    @SuppressWarnings("unused")
    private boolean isLeapYear(Eras eras, int year) {
        int y = year + eras.getDelta() - 1;
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}
