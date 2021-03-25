package stream.designpattern;

import stream.designpattern.model.Meteo;

public class PlayWithFunction {

    public static void main(String[] args) {
        Meteo meteo = new Meteo(37);
        Function<Meteo, Integer> readCelcius = m -> m.getTemperature();
        Function<Integer, Double> celciusToFahreinheit = c -> c *9d/5d + 32d;

        Function<Meteo, Double> readFahrenheit = readCelcius.andThen(celciusToFahreinheit);

        Function<Meteo, Double> compose = celciusToFahreinheit.compose(readCelcius);

        System.out.println("Meteo is F "+ readFahrenheit.apply(meteo));

        System.out.println("Meteo is F using compose "+ compose.apply(meteo));


        Function<String, String> identity = Function.identity();

        System.out.println("idetity "+identity.apply("Sandeep"));

    }
}
