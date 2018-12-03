package jp.co.run.enums;

/**
 * The Enum EraNameJapan.
 */
public enum EraNameJapan {
    
    /** The heisei. */
    HEISEI("\u5E73\u6210", 1989, 2019),
    
    /** The showa. */
    SHOWA("\u662D\u548C", 1926, 1989),
    
    /** The taisho. */
    TAISHO("\u5927\u6B63", 1912, 1926),
    
    /** The meiji. */
    MEIJI("\u660E\u6CBB", 1989, 1912),
    
    /** The keio. */
    KEIO("\u6176\u5FDC", 1865, 1868),
    
    /** The genji. */
    GENJI("\u5143\u6CBB", 1864, 1865),
    
    /** The bunkyu. */
    BUNKYU("\u6587\u4E45", 1861, 1864),
    
    /** The manen. */
    MANEN("\u4E07\u5EF6", 1860, 1861),
    
    /** The ansei. */
    ANSEI("\u5B89\u653F", 1854, 1860),
    
    /** The kaei. */
    KAEI("\u5609\u6C38", 1848, 1854),
    
    /** The koka. */
    KOKA("\u5F18\u5316", 1844, 1848),
    
    /** The tenpo. */
    TENPO("\u5929\u4FDD", 1830, 1844)
    
    ;

    /** The Constant GANNEN. */
    public static final String GANNEN = "\u5143\u5E74";

    /** The name. */
    private String name;

    /** The from year. */
    private int fromYear;

    /** The to year. */
    private int toYear;

    /**
     * Instantiates a new era name japan.
     *
     * @param name the name
     * @param fromYear the from year
     * @param toYear the to year
     */
    private EraNameJapan(String name, int fromYear, int toYear) {
        this.name = name;
        this.fromYear = fromYear;
        this.toYear = toYear;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the from year.
     *
     * @return the from year
     */
    public int getFromYear() {
        return fromYear;
    }

    /**
     * Gets the to year.
     *
     * @return the to year
     */
    public int getToYear() {
        return toYear;
    }

    /**
     * Calculate.
     *
     * @param year the year
     * @return the string
     */
    public String calculate(int year) {
        if (year < this.fromYear || year > this.toYear) {
            return null;
        }
        
        if (year - this.fromYear == 0) {
            return this.name + GANNEN;
        }
        
        return this.name + " " + (year - this.fromYear + 1);
    }
}
