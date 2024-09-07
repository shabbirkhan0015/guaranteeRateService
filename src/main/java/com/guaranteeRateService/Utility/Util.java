package com.guaranteeRateService.Utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    public static LocalDate localDateFormat(String date){
        if(date!=null) {
            LocalDate localDate = LocalDate.parse(date, formatter);
            return localDate;
        }
        return null;
    }
    public static String stringDateFormat(LocalDate localDate){
        return localDate!=null ? localDate.format(formatter): null;
    }
}
