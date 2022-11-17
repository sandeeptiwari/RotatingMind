package interview.jvm;

//On CD-ROM in file jvm/ex2/Lava.java
class Lava {
    private int speed = 5; // 5 kilometer per hour
    void flow() {
    }
}

// On CD-ROM in file jvm/ex2/Volcano.java
public class Volcano {

    public static void main(String[] args) {
        Lava lava = new Lava();
        lava.flow();
    }
}
