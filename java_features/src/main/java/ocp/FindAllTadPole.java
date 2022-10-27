package ocp;

import java.util.ArrayList;

interface CanSwim {}
class Amphibian implements CanSwim {}

abstract class Tadpole extends  Amphibian {
}

public class FindAllTadPole {

    public static void main(String[] args) {
       var tadPoles = new ArrayList<Tadpole>();
       for (Amphibian amphibian: tadPoles) {
           CanSwim tadPole = amphibian;
       }

       // int monday = 3 + 2.0;
        double tuesday = 5_6L;
        //boolean wednesday = 1 > 2 ? !true;
        short thursday = (short)Integer.MAX_VALUE;
        //long friday = 8.0L;
        //var saturday = 2_.0;

        feedingSchedule();
    }

    private static void feedingSchedule() {
        var x = 5;
        var j = 0;
        OUTER: for (var i = 0; i < 3;)
              INNER: do {
                          i++;
                          x++;
                          if (x> 10) break INNER;
                         x += 4;
                         j++;
                      } while (j <= 2);
        System.out.println(x);
    }
}
