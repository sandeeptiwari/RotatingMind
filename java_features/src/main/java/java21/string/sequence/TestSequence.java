package java21.string.sequence;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class TestSequence {


    public static void main(String[] args) {
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();
        sequencedSet.add("quick");
        sequencedSet.add("brown");
        sequencedSet.add("fox");
        sequencedSet.add("jumps");
        sequencedSet.add("over");
        sequencedSet.add("the");
        sequencedSet.add("lazy");
        sequencedSet.add("dogs");
        sequencedSet.add("back");
        System.out.println(sequencedSet);

        SequencedSet<String> reversedSequencedSet = sequencedSet.reversed();

        System.out.println(reversedSequencedSet);
    }
}
