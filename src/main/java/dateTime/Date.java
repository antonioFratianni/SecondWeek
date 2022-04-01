package dateTime;



import utils.Logger;

import java.util.GregorianCalendar;

public class Date {
    public static void main(String[] args) {
        Logger L = Logger.getInstance();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);
        int month = gregorianCalendar.get(GregorianCalendar.MONTH);
        int year = gregorianCalendar.get(GregorianCalendar.YEAR);


        GregorianCalendar data1 = new GregorianCalendar(1998,12,8);


    }
}
