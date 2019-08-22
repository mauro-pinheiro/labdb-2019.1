package lab5.xyzrentalcars.util;

import java.time.LocalDate;

public class AuxMethods {
    public static boolean betweenDates(LocalDate date, LocalDate inicio, LocalDate fim){
        return date.isAfter(inicio) && (date.isBefore(fim) || date.isEqual(fim));
    }
}
