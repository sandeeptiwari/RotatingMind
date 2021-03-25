import java.util.Comparator;

public class MergeIntervals {

    //{[1, 4], [3, 6], [8, 10]} output : {[1, 6], [8, 10]}



}

class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

class IntervalComperator implements Comparator<Interval> {

    @Override
    public int compare(Interval i1, Interval i2) {
        return i1.getStart() - i2.getStart();
    }
}
