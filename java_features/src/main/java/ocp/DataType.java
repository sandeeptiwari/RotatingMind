package ocp;

public class DataType {

    public static void main(String[] args) {
        method2();
    }

    private static void method1() {
      //short numPets = 5L;  Not Compiled
        // int numGrains = 2.0; Not Compiled
        String name = "Scruffy";
       // int d = numPets.length(); Not Compiled
        int f = name.length();
    }

    private static void method2() {
        var blocky = """
                squirrel \s
                pigeon   \
                termite""";
        System.out.print(blocky);
    }
}
