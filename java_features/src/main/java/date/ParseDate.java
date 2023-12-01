package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ParseDate {

    public static void main(String[] args) throws ParseException {
        String dateStr = "2023-01-15 08:05:41";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

        Date parsed = format.parse(dateStr);
        System.out.println("Parse Date -> " + parsed.toString());
    }
}
