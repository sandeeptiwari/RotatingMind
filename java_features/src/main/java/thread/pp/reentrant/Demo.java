package thread.pp.reentrant;

/**
 * Requirting lock in same process again- 2 call re-entrant lock
 *  synchronized(lock) { -------------------> counter = 1
 *      synchronized(lock) { -------------------> counter = 2
 *
 *      }
  *  }
 *
 *  Other thread cant enter in these synchronized block until unless counter would not be zero
 */
public class Demo {
}
