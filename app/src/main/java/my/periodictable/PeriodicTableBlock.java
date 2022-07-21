package my.periodictable;

import androidx.annotation.NonNull;

import my.periodictable.Element;

/**
 * Stores data for a single block on a PeriodicTableView.
 *
 * @author Steve Guidetti
 */
public class PeriodicTableBlock {
    /**
     * The Element
     */
    @NonNull
    public final Element element;

    /**
     * Text to display below the symbol
     */
    public String subtext;

    /**
     * Block background color
     */
    public int color = 0xFFCCCCCC;

    /**
     * Grid position
     */
    int row;
    int col;

    /**
     * @param element The Element
     */
    public PeriodicTableBlock(@NonNull Element element) {
        this.element = element;
    }
}
