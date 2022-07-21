package my.periodictable;

import androidx.annotation.NonNull;

/**
 * Utility to convert values between different units.
 *
 * @author Steve Guidetti
 */
public class UnitUtils {
    /**
     * Convert temperature value from Kelvin to degrees Celsius.
     *
     * @param k Value in Kelvin
     * @return Value in degrees Celsius
     */
    @NonNull
    public static Double KtoC(@NonNull Double k) {
        return k - 273.15;
    }

    /**
     * Convert temperature value from Kelvin to degrees Fahrenheit.
     *
     * @param k Value in Kelvin
     * @return Value in degrees Fahrenheit
     */
    @NonNull
    public static Double KtoF(@NonNull Double k) {
        return k * 9.0 / 5 - 459.67;
    }
}