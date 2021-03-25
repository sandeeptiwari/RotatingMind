package functional.query;

/*
* The interface has one method String toString() which every class already implements, inheriting it from Object.
* I.e. the declared interface method already has an implementation, similar to a default method. Hence, there is no
* compile error and Normal.
 */
@FunctionalInterface
public interface Normal {
    String move();
    String toString();
}
