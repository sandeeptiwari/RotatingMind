package builder_for_inheritance;

import static builder_for_inheritance.NyPizza.Size.SMALL;
import static builder_for_inheritance.Pizza.Topping.*;

public class TestBuilder {

    public static void main(String...args){
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSES).addTopping(ONION).build();

        /*Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();*/
    }
}
