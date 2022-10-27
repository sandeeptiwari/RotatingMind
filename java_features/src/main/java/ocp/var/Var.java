package ocp.var;
public class Var {
   int Public;
    public void var() {
        var var = "var";
    }
    public void Var() {
        Var var = new Var();
    }

    public static final void main(String[] args){

    }
    //public static void main(String[] args){}

    private static void method1() {
        // var spring = null;  No compiled
        var fall = "leaves";
        //var evening = 2; evening = null;
        var night = Integer.valueOf(3);
        var day = 1/0;
       // var winter = 12, cold; Not compiled
       // var fall1 = 2, autumn1 = 2; //Not compiled ->

        var morning = ""; morning = null;
    }
}
