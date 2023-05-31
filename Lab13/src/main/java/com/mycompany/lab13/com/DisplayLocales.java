package com.mycompany.lab13.com;
import java.util.Locale;


/**
 *
 * @author Elias
 */
public class DisplayLocales {
    public static void displayLocales() {
        var locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            System.out.println(locale);
        }
    }
}
