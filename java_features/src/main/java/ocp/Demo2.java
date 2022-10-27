package ocp;

interface HasTail { int getTailLength(); }

abstract class Puma implements HasTail {
   // protected int getTailLength() { return 4; };
}
public class Demo2 implements HasTail {
    public static void main(String[] args) {
        // var puma = new Puma();
        // System.out.println(puma.getTailLength());
    }

    @Override
    public int getTailLength() {
        return 2;
    }
}


