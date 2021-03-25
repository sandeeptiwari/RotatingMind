package decorator;

public class TChild extends TParent{

    @Override
    public void show(){
        super.show();
        System.out.println("It's child show");
    }

    public static void main(String...args){
        TChild t = new TChild();
        t.show();
    }
}
