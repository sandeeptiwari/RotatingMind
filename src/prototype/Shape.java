package prototype;

/**
 * the java.lang.Object  class contains a clone() method that returns a bitwise copy of  the current onject.
 * It particular only instances of classes that implemented  the cloneable interface can be cloned
 * trying to clone an object  that does not implement the cloneable interface throws a cloneNotSupportedException
 */
public abstract class Shape implements Cloneable {

    private String id;
    protected String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}
