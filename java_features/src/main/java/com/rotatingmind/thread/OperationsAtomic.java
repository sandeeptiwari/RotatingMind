package com.rotatingmind.thread;

/**
 * We dont know which operation is atomic and which is not
 * Atomic Operations:
 * ->Most operations are not atomic
 * -> All reference assignments are atomic
 * -> e.g.
 *  Object o1 = new Object();
 *  Object o2 = new Object();
 *  o1 = o2; // atomic, so no need to synchronized it
 *  -> all assignment setter/getter are atomic if the set refrences
 *  -> All assignment to primitive type are safe except long and double
 *  i- int
 *  ii- short
 *  iii - byte
 *  iV- float
 *  v- char
 *  vi - boolean
 *  so we can read/write  above without any synchronized
 *
 *  Solution is for long and double use volatile
 *
 */
public class OperationsAtomic {
}
