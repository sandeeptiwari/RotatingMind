package course.intro_class;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class IfElseDemo {

    /**
     *
     * @param isStart
     */
    public static void prepareTea(boolean isStart) {
        boolean isGasIsOn = true;
        int i = 1001;
        if (isStart) {
            if (isGasIsOn) {
                System.out.println("Please on the Gas" + i);
            } else {
                System.out.println("Please on the Gas");
            }
        } else if (isGasIsOn && !isStart) {
            System.out.println("Will do it after some time");
        }else if (isGasIsOn && !isStart) {
            System.out.println("Will do it after some time");
        }else if (isGasIsOn && !isStart) {
            System.out.println("Will do it after some time");
        }else if (isGasIsOn && !isStart) {
            System.out.println("Will do it after some time");
        }else if (isGasIsOn && !isStart) {
            System.out.println("Will do it after some time");
        }else if (isGasIsOn && !isStart) {
            System.out.println("Will do it after some time");
        }else if (isGasIsOn && !isStart) {
            System.out.println("Will do it after some time");
        }else if (isGasIsOn && !isStart) {
            System.out.println("Will do it after some time");
        }else if (isGasIsOn && !isStart) {
            System.out.println("Will do it after some time");
        }
    }

    /**
     * Map<></>
     */
    public static void dayOfWeek() {
        String day = "SUNDAY";
       /* Map<String, String> byWeek = new HashMap<>();
        byWeek.put("SUNDAY", "1");
        1= byWeek.get(day);*/

        switch (day) {
            case "SUNDAY":
                System.out.println("It's sunday");
                break;
            case "MONDAY":
                System.out.println("It's monday");
                break;
            case "TUESDAY":
                System.out.println("It's tuesday");
                break;
            case "WED":
                System.out.println("It's wed");
                break;
            default:
                System.out.println("I dont know");
                break;
        }
    }

    public static void printOdd() {
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) break;
            System.out.println(i);
        }
        //121
    }

    public void instanceMethod() {
        System.out.println("Hi ! I am instance method not static");
    }

    public static void main(String[] args) {
        IfElseDemo.prepareTea(true);
       // System.out.println("After method");

        IfElseDemo obj = new IfElseDemo();
        //obj.instanceMethod();

    }



}
