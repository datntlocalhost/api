package jp.co.run.jperas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jp.co.run.jperas.calendar.AbstractCalendar;
import jp.co.run.jperas.calendar.GregoryCalendar;
import jp.co.run.jperas.calendar.JuliusCalendar;
import jp.co.run.jperas.calendar.LunisolarCalendar;
import jp.co.run.jperas.enums.Eras;

/**
 * The Class Wareki.
 * 
 * @author datnguyen
 */
public class Wareki {

    /** The Constant DEFAULT. */
    public final static int DEFAULT = 0;

    /** The Constant GREGORY. */
    public final static int GREGORY = 1;

    /** The Constant ERA. */
    public final static int ERA = 2;

    /** The Constant LUNISOLAR. */
    public final static int LUNISOLAR = 3;

    /** The Constant JULIUS. */
    public final static int JULIUS = 4;

    /** The instance. */
    private static Wareki instance;

    /** The eras. */
    private Eras eras;

    /** The calendar. */
    private AbstractCalendar calendar;

    private int resultFieldType;

    /**
     * Instantiates a new wareki.
     *
     * @param eras the eras
     */
    private Wareki(Eras eras) {
        this.eras = eras;
        this.calendar = createCalendar(eras);
        this.resultFieldType = Wareki.DEFAULT;
    }

    /**
     * Gets the single instance of Wareki.
     *
     * @return single instance of Wareki
     */
    public static Wareki getInstance() {
        if (instance == null) {
            instance = new Wareki(Eras.GREGORY);
        }
        return instance;
    }

    /**
     * Convert.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     * @return the list
     */
    public List<String> convert(int year, int month, int day) {
        List<String> results = new ArrayList<String>();
        Eras[] erasArray = Eras.values();
        int index = this.calendar.getIndex(eras, year, month - 1, day);
        int i = 0;
        while (i < erasArray.length) {
            if (erasArray[i].getStart() <= index && erasArray[i].getEnd() >= index) {
                if (resultFieldType == Wareki.GREGORY && erasArray[i].equals(Eras.GREGORY)) {
                    results.add(createCalendar(erasArray[i]).convert(erasArray[i], index));
                } else if (resultFieldType == Wareki.LUNISOLAR && erasArray[i].equals(Eras.JULIAN)) {
                    results.add(createCalendar(erasArray[i]).convert(erasArray[i], index));
                } else if (resultFieldType == Wareki.JULIUS && erasArray[i].equals(Eras.JULIUS)) {
                    results.add(createCalendar(erasArray[i]).convert(erasArray[i], index));
                } else if (resultFieldType == Wareki.ERA && !erasArray[i].equals(Eras.GREGORY)
                    && !erasArray[i].equals(Eras.JULIAN) && !erasArray[i].equals(Eras.JULIUS)) {
                    results.add(createCalendar(erasArray[i]).convert(erasArray[i], index));
                } else if (resultFieldType == Wareki.DEFAULT) {
                    results.add(createCalendar(erasArray[i]).convert(erasArray[i], index));
                }
            }
            i++;
        }
        return results;
    }

    /**
     * Convert.
     *
     * @param date the date
     * @return the list
     */
    public List<String> convert(Date date) {
        if (date == null) {
            return new ArrayList<String>();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return convert(calendar.get(Calendar.YEAR),
                       calendar.get(Calendar.MONTH) + 1,
                       calendar.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * Creates the calendar.
     *
     * @param eras the eras
     * @return the abstract calendar
     */
    private AbstractCalendar createCalendar(Eras eras) {
        switch (eras.getCalendar()) {
        case 1:
            return new GregoryCalendar();
        case -1:
            return new LunisolarCalendar();
        default:
            return new JuliusCalendar();
        }
    }

    public int getResultFieldType() {
        return resultFieldType;
    }

    public void setResultFieldType(int resultFieldType) {
        if (resultFieldType < 0 || resultFieldType > 4) {
            resultFieldType = 0;
        }
        this.resultFieldType = resultFieldType;
    }
}
