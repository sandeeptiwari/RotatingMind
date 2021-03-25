import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableDemo {

    public static void main(String...args){
        Observable.interval(10, TimeUnit.MILLISECONDS).subscribe(next -> {
            System.out.print(" first ele ment ");
        }, error -> {
            System.out.print(" error");
        }, () -> {
            System.out.print(" action");
        },  ele ->{
            System.out.print(" fount "+ele);
        } );
    }
}
