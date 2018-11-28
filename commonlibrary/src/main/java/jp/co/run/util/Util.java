package jp.co.run.util;

/**
 * The Class Util.
 * 
 * @author datnguyen
 */
public class Util {

    /**
     * Checks if is obj null.
     *
     * @param  obj the obj
     * @return true, if is obj null
     */
    public static boolean isObjNull(Object obj) {
        return obj == null;
    }

    /**
     * Checks if is obj null.
     *
     * @param  objs the objs
     * @return true, if is obj null
     */
    public static boolean isObjNull(Object... objs) {

        if (objs == null) {
            return true;
        }

        for (Object obj : objs) {
            if (isObjNull(obj)) {
                return true;
            }
        }

        return false;
    }
}
