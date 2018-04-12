import com.samgauck.Utilities;

/**
 * A three-letter enum representation of a month.
 */
public enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;

    /**
     * Returns the month as a string, capitalized (e.g. Jan).
     * @return A correctly capitalized string representation of a month.
     */
    @Override
    public String toString() {
        return Utilities.capitailze(super.toString());
    }
}