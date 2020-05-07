package utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;

public class GenerateDate {

    public static String generateDateXpath(int quantityOfDays) {
        Formatter form = new Formatter();
        LocalDate today = LocalDate.now();
        String date = "//*[@id='frm']//descendant::td[@data-date='%s']";
        return form.format(date, today.plus(quantityOfDays, ChronoUnit.DAYS)).toString();
    }
}
