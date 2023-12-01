package thread.pp.fifth;


public class NumStore {
    private int x, y, z, w;

    public NumStore() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }


    //Synchronize
    public void incr() {
        x++;
        y++;
        z++;
        w++;
    }

    //Synchronize
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    //Synchronize

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
