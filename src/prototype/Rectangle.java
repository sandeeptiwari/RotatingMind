package prototype;

public class Rectangle extends Shape {
    Rectangle(){
      type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.print("This is draw rectangle");
    }
}
