package my.periodictable;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.NonNull;

import my.periodictable.R;
import my.periodictable.Element;

import java.util.HashMap;

/**
 * Utility class for common methods relating to chemical elements.
 *
 * @author Steve Guidetti
 */
public class ElementUtils {
    /**
     * List of string resources for each element name
     */
    private static final int[] ELEMENT_NAMES = {
            R.string.el001, R.string.el002, R.string.el003, R.string.el004, R.string.el005,
            R.string.el006, R.string.el007, R.string.el008, R.string.el009, R.string.el010,
            R.string.el011, R.string.el012, R.string.el013, R.string.el014, R.string.el015,
            R.string.el016, R.string.el017, R.string.el018, R.string.el019, R.string.el020,
            R.string.el021, R.string.el022, R.string.el023, R.string.el024, R.string.el025,
            R.string.el026, R.string.el027, R.string.el028, R.string.el029, R.string.el030,
            R.string.el031, R.string.el032, R.string.el033, R.string.el034, R.string.el035,
            R.string.el036, R.string.el037, R.string.el038, R.string.el039, R.string.el040,
            R.string.el041, R.string.el042, R.string.el043, R.string.el044, R.string.el045,
            R.string.el046, R.string.el047, R.string.el048, R.string.el049, R.string.el050,
            R.string.el051, R.string.el052, R.string.el053, R.string.el054, R.string.el055,
            R.string.el056, R.string.el057, R.string.el058, R.string.el059, R.string.el060,
            R.string.el061, R.string.el062, R.string.el063, R.string.el064, R.string.el065,
            R.string.el066, R.string.el067, R.string.el068, R.string.el069, R.string.el070,
            R.string.el071, R.string.el072, R.string.el073, R.string.el074, R.string.el075,
            R.string.el076, R.string.el077, R.string.el078, R.string.el079, R.string.el080,
            R.string.el081, R.string.el082, R.string.el083, R.string.el084, R.string.el085,
            R.string.el086, R.string.el087, R.string.el088, R.string.el089, R.string.el090,
            R.string.el091, R.string.el092, R.string.el093, R.string.el094, R.string.el095,
            R.string.el096, R.string.el097, R.string.el098, R.string.el099, R.string.el100,
            R.string.el101, R.string.el102, R.string.el103, R.string.el104, R.string.el105,
            R.string.el106, R.string.el107, R.string.el108, R.string.el109, R.string.el110,
            R.string.el111, R.string.el112, R.string.el113, R.string.el114, R.string.el115,
            R.string.el116, R.string.el117, R.string.el118
    };

    /**
     * List of drawable resources for each element gif
     */
    private static final int[] ELEMENT_GIF = {
//            R.drawable.hydrogen1, R.drawable.helium2, R.drawable.lithium3, R.drawable.beryllium4, R.drawableboron5,
            R.drawable.nitrogen7, R.drawable.oxygen8 , R.drawable.argon18 , R.drawable.sodium11,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable., R.drawable., R.drawable.,
//            R.drawable., R.drawable., R.drawable.
    };





    /**
     * The map of keys to color values
     */
    @NonNull
    private final static HashMap<String, Integer> COLOR_MAP = new HashMap<>();

    /**
     * Perform initial setup.
     *
     * @param context The Context
     */
    public static void setup(@NonNull Context context) {
        final Resources res = context.getResources();

        String[] keys = res.getStringArray(R.array.ptBlocks);
        int[] colorValues = res.getIntArray(R.array.ptBlockColors);
        for(int i = 0; i < keys.length; i++) {
            COLOR_MAP.put(keys[i], colorValues[i]);
        }

        keys = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        colorValues = res.getIntArray(R.array.ptCategoryColors);
        for(int i = 0; i < keys.length; i++) {
            COLOR_MAP.put(keys[i], colorValues[i]);
        }
    }

    /**
     * Get the color value associated with a key.
     *
     * @param key The key
     * @return The color value
     */
    public static int getKeyColor(@NonNull Object key) {
        final Integer color = COLOR_MAP.get(key.toString());
        return color == null ? 0 : color;
    }

    /**
     * Get the color for an element.
     *
     * @param element The Element
     * @return The color value
     */
    public static int getElementColor(@NonNull Element element) {
        final Integer color = COLOR_MAP.get(getColorKey(element));
        return color == null ? 0 : color;
    }

    /**
     * Get the key to use for coloring an element.
     *
     * @param element The Element
     * @return The key
     */
    @NonNull
    private static String getColorKey(@NonNull Element element) {
        if(PreferenceUtils.COLOR_CAT.equals(PreferenceUtils.getPrefElementColors())) {
            return String.valueOf(element.category);
        }
        return String.valueOf(element.block);
    }

    /**
     * Get the name of an element.
     *
     * @param number The atomic number
     * @return The string resource ID for the element name
     */
    public static int getElementName(int number) {
        if(number > ELEMENT_NAMES.length) {
            return R.string.unknown;
        }

        return ELEMENT_NAMES[number - 1];
    }

    /**
     * Get the wiki link of an element.
     *
     * @param number The atomic number
     * @return The string resource ID for the wiki link
     */
    public static int getElementGif(int number) {
        if(number > ELEMENT_GIF.length) {
            return getElementName(number);
        }

        return ELEMENT_GIF[number - 1];
    }

//    /**
//     * Get the YouTube link of an element.
//     *
//     * @param number The atomic number
//     * @return The string resource ID for the YouTube link
//     */
//    public static int getElementVideo(int number) {
//        if(number > ELEMENT_WIKI.length) {
//            return 0;
//        }
//
//        return ELEMENT_VID[number - 1];
//    }



}