package jp.co.run;

// TODO: Auto-generated Javadoc
/**
 * The Enum MultiByte.
 * 
 * @author datnguyen
 */
public enum MultiByte {

    /** The single. */
    SINGLE (1, 7, 0x0),
    
    /** The double. */
    DOUBLE (2, 5, 0x6),
    
    /** The three. */
    THREE  (3, 4, 0xE),
    
    /** The four. */
    FOUR   (4, 3, 0xF);

    /** The num of byte. */
    private int numOfByte;
    
    /** The num of place to shift. */
    private int numOfPlaceToShift;

    /** The byte to compare. */
    private int byteToCompare;
    
    /**
     * Instantiates a new multi byte.
     *
     * @param numOfByte the num of byte
     * @param numOfPlaceToShift the num of place to shift
     * @param byteToCompare the byte to compare
     */
    private MultiByte(int numOfByte, int numOfPlaceToShift, int byteToCompare) {
        this.numOfByte = numOfByte;
        this.numOfPlaceToShift = numOfPlaceToShift;
        this.byteToCompare = byteToCompare;
    }

    /**
     * Gets the num of byte.
     *
     * @return the num of byte
     */
    public int getNumOfByte() {
        return numOfByte;
    }

    /**
     * Gets the num of place to shift.
     *
     * @return the num of place to shift
     */
    public int getNumOfPlaceToShift() {
        return numOfPlaceToShift;
    }

    /**
     * Gets the byte to compare.
     *
     * @return the byte to compare
     */
    public int getByteToCompare() {
        return byteToCompare;
    }
}
