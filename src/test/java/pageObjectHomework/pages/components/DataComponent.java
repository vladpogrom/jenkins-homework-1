package pageObjectHomework.pages.components;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class DataComponent {
    // It's okay
    public int day;
    public int month;
    public String year;
    static Random rnd;
    static Date dt;
    static long ms;
    static String pattern;
    static String assertPattern;
    public String parseDate;
    public String assertDate;
    public String[] splitDate;
    public String userMonthAssert;

    public void dataComponentSet() {
        // Random description
        rnd = new Random();
        ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        dt = new Date(ms);

        // Pattern for type
        pattern = "dd/MM/yyyy";
        Format formatter = new SimpleDateFormat(pattern);
        parseDate = formatter.format(dt);
        day = parseInt(parseDate.substring(0, 2));
        month = parseInt(parseDate.substring(3, 5));
        year = parseDate.substring(6, 10);

        // Pattern for assert (month)
        assertPattern = "dd/MMMM/yyyy";
        Format formatterAssert = new SimpleDateFormat(assertPattern);
        assertDate = formatterAssert.format(dt);
        splitDate = assertDate.split("/");
        userMonthAssert = splitDate[1];
    }
}
