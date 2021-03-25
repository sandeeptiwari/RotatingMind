package stream_advance;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;


public class Service {

    private boolean isSetPrimaryHomeNumber(List<HomeNumber> homeNumbers) {

        Predicate<HomeNumber> isPrimary = HomeNumber::isPrimary;
        Predicate<HomeNumber> isHomeNumberNotNull = homeNumber -> Objects.nonNull(homeNumber.getNumber());

        return homeNumbers.stream()
                .filter(isPrimary.and(isHomeNumberNotNull))
                .findFirst().orElse(null) != null;
    }

    private boolean isIdValid(String name, String id){
        return false;
    }

    public static void main(String[] args) {

    }
}

class HomeNumber {
    private boolean isPrimary;
    private String number;

    public HomeNumber(boolean isPrimary, String number) {
        this.isPrimary = isPrimary;
        this.number = number;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
