package ocp.other;

public class PoliceBox {
    String color;
    long age;

    public void policyBox() {
        color = "blue";
        age = 120;
    }

    public static void main(String[] args) {
        //float temp = 50.0;
        var p = new PoliceBox();
        var q = new PoliceBox();

        p.color = "green";
        p.age = 1400;
        p = q;

        System.out.println("Q1="+q.color);
        System.out.println("Q2="+q.age);
        System.out.println("P1="+p.color);
        System.out.println("P2="+p.age);
    }
}
