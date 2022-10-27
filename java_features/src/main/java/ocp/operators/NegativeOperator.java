package ocp.operators;

public class NegativeOperator {

    public static void main(String[] args) {
        double zooTemperature = 1.21;
        System.out.println(zooTemperature);  // 1.21
        zooTemperature = -zooTemperature;
        System.out.println(zooTemperature);  // -1.21
        zooTemperature = -(-zooTemperature);
        System.out.println(zooTemperature);  // -1.21

        short val = (short)4 + 10;
        System.out.println("val " + val);

        //float egg = 2.0 / 9;        // DOES NOT COMPILE
        //int tadpole = (int)5 * 2L;  // DOES NOT COMPILE
        //short frog = 3 - 2.0;       // DOES NOT COMPILE

        System.out.print(2147483647 + 1);  // -2147483648

        short mouse = 10;
        short hamster = 3;
        // short capybara = mouse * hamster;  // DOES NOT COMPILE

        byte hat = 1;
        byte gloves = 7 * 10;
        short scarf = 5;
        short boots = 2 + 1;
    }
}
