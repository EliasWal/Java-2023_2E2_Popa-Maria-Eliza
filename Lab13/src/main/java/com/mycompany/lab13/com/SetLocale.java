package com.mycompany.lab13.com;

import java.util.Locale;

/**
 *
 * @author Elias
 */
public class SetLocale {
    public static void setLocale(String locale) {
        Locale myLocale = Locale.forLanguageTag(locale);
        Locale.setDefault(myLocale);
    }
}
