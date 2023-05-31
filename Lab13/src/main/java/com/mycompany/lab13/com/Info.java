package com.mycompany.lab13.com;

import com.mycompany.lab13.util.Message;
import java.text.*;
import java.util.*;

/**
 *
 * @author Elias
 */
public class Info {
    public static void info(Locale locale, Message message) {
        System.out.println(message.getCountry() + " " + locale.getCountry());
        System.out.println(message.getLanguage() + " " + locale.getLanguage());
        System.out.println(message.getCurrency() + " " + Currency.getInstance(locale));
        var dateFormatSymbols = DateFormatSymbols.getInstance(locale);

        System.out.print(message.getWeek() + " ");
        for (var weekday : dateFormatSymbols.getWeekdays()) {
            System.out.println(weekday + ", ");
        }

        System.out.print(message.getMonths() + " ");
        for (var month : dateFormatSymbols.getMonths()) {
            System.out.println(month + ", ");
        }

        System.out.println(message.getToday() + " " + DateFormat.getDateInstance(DateFormat.MEDIUM, locale).format(new Date()));
    }
}
