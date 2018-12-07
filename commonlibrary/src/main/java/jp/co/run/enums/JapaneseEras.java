package jp.co.run.enums;

/**
 * The Enum EraNameJapan.
 */
public enum JapaneseEras {

    
    ;

    /** The Constant GANNEN. */
    public static final String GANNEN = "\u5143\u5E74";

    private String romanizedName;

    private String kanjiName;

    private String kanaName;

    private int startYear;

    private int startMonth;

    private int startDay;

    private int endYear;

    private int endMonth;

    private int endDay;

    private JapaneseEras(String romanizedName, String kanjiName, String kanaName, int startYear, int startMonth,
        int startDay, int endYear, int endMonth, int endDay) {
        this.romanizedName = romanizedName;
        this.kanjiName = kanjiName;
        this.kanaName = kanaName;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.endDay = endDay;
    }

    public String getRomanizedName() {
        return romanizedName;
    }

    public void setRomanizedName(String romanizedName) {
        this.romanizedName = romanizedName;
    }

    public String getKanjiName() {
        return kanjiName;
    }

    public void setKanjiName(String kanjiName) {
        this.kanjiName = kanjiName;
    }

    public String getKanaName() {
        return kanaName;
    }

    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public static String getGannen() {
        return GANNEN;
    }

}
