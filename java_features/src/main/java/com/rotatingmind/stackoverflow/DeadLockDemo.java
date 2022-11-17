package com.rotatingmind.stackoverflow;

public class DeadLockDemo {

    public static void main(String[] args) {
       // Resource1 r1 = new Resource1(resource2);

        Thread t1 = new Thread(() -> {
            while (true) {

            }
        });

        Thread t2 = new Thread(() -> {

        });
    }
}

class Resource1 {

    final Resource2 resource2;

    Resource1(Resource2 resource2) {
        this.resource2 = resource2;
    }

    public void foo() {
        resource2.bar();
    }

}


class Resource2 {
    final Resource1 resource1;

    Resource2(Resource1 resource1) {
        this.resource1 = resource1;
    }

     public void bar() {
         resource1.foo();
     }

}
