package rxapp;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class ObservableTuteOne {

    public static void main(String...args){
        //Observable.interval(300, TimeUnit.MILLISECONDS);
        //Observable.just("Alpha", "Beta", "Gamma", "Delta",
          //      "Epsilon")
        Observable.interval(1, TimeUnit.SECONDS).subscribe(next -> {
            System.out.println(" first element "+next);
        }, error -> {
            System.out.print(" error");
        }, () -> {
            System.out.print(" done");
        },  ele ->{
            //System.out.print(" fount "+ele);
        } );

        sleep(10000);

        //Observable.just("RED", "GREEN", "BLUE", "YELLOW",
           //     "PINK").subscribe(new TestObserver());


    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testNumber(){

    }

}




class TestObserver implements Observer<String> {


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(String s) {
        System.out.print(" receive -> "+s);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}