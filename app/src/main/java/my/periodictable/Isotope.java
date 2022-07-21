package my.periodictable;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Locale;

/**
 * Represents an isotope of an element.
 *
 * @author Steve Guidetti
 */
public class Isotope {
    /**
     * The mass number of the isotope
     */
    private final int number;

    /**
     * The symbol for the isotope
     */
    @NonNull
    private final String symbol;

    /**
     * The relative atomic mass of the isotope
     */
    public final double mass;

    /**
     * The isotopic composition of the isotope
     */
    @Nullable
    public final Double ic;

    /**
     * @param number The mass number of the isotope
     * @param symbol The symbol for the isotope
     * @param mass   The relative atomic mass of the isotope
     * @param ic     The isotopic composition of the isotope
     */
    Isotope(int number, @NonNull String symbol, double mass, @Nullable Double ic) {
        this.number = number;
        this.symbol = symbol;
        this.mass = mass;
        this.ic = ic;
    }

    /**
     * Get the symbol representing the isotope, which is the mass number in superscript followed by
     * the symbol.
     *
     * @return The symbol representing the isotope
     */
    @NonNull
    public Spanned getSymbol() {
        final String html =
                String.format(Locale.US, "<sup><small>%d</small></sup>%s", number, symbol);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, 0);
        }
        //noinspection deprecation
        return Html.fromHtml(html);
    }
}
