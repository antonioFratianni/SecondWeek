package dateTime;

import utils.Logger;

import java.text.DateFormat;

public class DateTimeRunner {
    public static void main(String[] args) {
        Logger L = Logger.getInstance();
        Date date = new Date();
        L.info(date.toString());

        DateFormat format = DateFormat.getDateInstance();
        L.info(format.format(date));
    }
}
