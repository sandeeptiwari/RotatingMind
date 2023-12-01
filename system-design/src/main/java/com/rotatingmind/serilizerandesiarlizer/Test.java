package com.rotatingmind.serilizerandesiarlizer;

import com.rotatingmind.serilizerandesiarlizer.domain.ArtsMarks;
import com.rotatingmind.serilizerandesiarlizer.domain.ReportCard;
import com.rotatingmind.serilizerandesiarlizer.domain.ScienceMark;

public class Test {

    // load classes at runtime
    // compile time classpath
    // runtime classpath
    public static void main(String[] args) {
     //   ReportCard reportCard =
              //  new ReportCard(101, new ScienceMark(50,50,50, 50.0),
               //         new ArtsMarks(100, 100, 100, 99, 99.9), 75.0);
      //  System.out.println(reportCard);//new Serializer().serialize(reportCard));

        try {
           // String serializer = new Serializer().serialize(reportCard);
            //System.out.println(serializer);
        } catch (Exception e) {

        }

        // {id:101,scienceMark:{
        //  phyMarks:50,chemMarks:50,mathsMarks:50,sciPercent:50.0
        // },
        // artMarks:{
        //  socialScienceMarks:100,literatureMarks:100,homeScienceMarks:100,englishMarks:99,artPercentage:99.9
        // },
        //  totalPercentage:75.0
        // }

        try {
            String reportCardStr = "{id:101,scienceMark:{phyMarks:50,chemMarks:50,mathsMarks:50,sciPercent:50.0},artMarks:{socialScienceMarks:100,literatureMarks:100,homeScienceMarks:100,englishMarks:99,artPercentage:99.9},totalPercentage:75.0}";

            ReportCard reportCard1 = new DeSerializer().deSerialize(reportCardStr, ReportCard.class);
            System.out.println(reportCard1);
        } catch (Exception e) {
         e.printStackTrace();
        }
    }
}
