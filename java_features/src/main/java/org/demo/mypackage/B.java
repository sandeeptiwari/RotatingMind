package org.demo.mypackage;

import org.demo.A;

public class B {

    C c1 = new C();  // (1)

    C c2 = new org.demo.mypackage.C(); // (2)

   // mypackage.C c3 = new org.demo.mypackage.C(); // (3)

    org.demo.A a = new org.demo.A(); // (4)

    A a1 = new A(); // (5)
}
