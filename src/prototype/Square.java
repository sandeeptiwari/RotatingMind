package prototype;

public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    void draw() {
        System.out.print("This is draw squre");
    }
}
