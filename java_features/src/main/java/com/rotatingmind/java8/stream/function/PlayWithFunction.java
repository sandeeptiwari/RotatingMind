package com.rotatingmind.java8.stream.function;

public class PlayWithFunction {

    public static void main(String[] args) {
        Meter meter = new Meter(20);

        Function<Meter, Integer> readCelsius = m -> m.getTemperature();
        Function<Integer, Double> celsiusToFahrenheit = t -> t * 9d/5d + 32d;

         Function<Meter, Double>  readFahrenheit = readCelsius.andThen(celsiusToFahrenheit);

         System.out.println("Meter in F " + readFahrenheit.apply(meter));

       // Function<Meter, Double>  readFahrenheit = celsiusToFahrenheit.compose(readCelsius);

       // System.out.println("Meter in F " + readFahrenheit.apply(meter));
    }
}
