package ocp.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class AnimalEnrichment {

    public static void main(String[] args) {
        var start = LocalDate.of(2022, Month.JANUARY, 01);
        var end = LocalDate.of(2022, Month.MARCH, 30);
        //second
        var period = Period.ofMonths(1);

        /*not allowed
        Period period1 = Period.ofYears(1);
        period1 = Period.ofWeeks(1);*/

        performAnimalEnrichmentV1(start, end, period);
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        while (start.isBefore(end)) {
            System.out.println("Give mew toy: " + start);
            start = start.plusMonths(1);
        }
    }

    private static void performAnimalEnrichmentV1(LocalDate start, LocalDate end, Period period) {
        while (start.isBefore(end)) {
            System.out.println("Give mew toy: " + start);
            start = start.plus(period); //add the period
        }
    }
}
