package stackoverflow;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.WeakHashMap;

public class StackOverflowQuestions {

    private void question60584806() throws InterruptedException {
        Map<String, int[]> hm = new WeakHashMap<>();
        int i = 0;
        while (true) {
            Thread.sleep(1000);
            i++;
            String key = "" + i;
            System.out.println(String.format("add new element %d", i));
            hm.put(key, new int[1024 * 1024 * 1]); // <--- 1 MB allocation
        }
    }

    private void question60591187(String schedCallTime, String tz) throws Exception {
        ZonedDateTime scheduledCallTime = LocalDateTime
                .parse(schedCallTime, DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss"))
                .atZone(ZoneId.of(tz));

        ZonedDateTime localSystemTime = ZonedDateTime.now();

        System.out.println("Scheduled Call Time: " + scheduledCallTime);
        System.out.println("Local System Time: " + localSystemTime);
        System.out.println("You're late: " + localSystemTime.isAfter(scheduledCallTime));
    }

    public static void main(String[] args) {
        StackOverflowQuestions stackOverflowQuestions = new StackOverflowQuestions();
         String testTime = "06-03-2020 19:00:10";
         String testTimeZone = "Canada/Newfoundland";

        try {
            stackOverflowQuestions.question60591187(testTime, testTimeZone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
