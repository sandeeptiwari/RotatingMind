package com.rottaingmind.ds.linklist;

public class TestLinkList {

    public static void main(String[] args) {
        LinkList<Person> names = new LinkList();
        names.insert(new Person(23, "Adam"));
        names.insert(new Person(25, "Anna"));
        names.insert(new Person(27, "Brynnan"));
        names.insert(new Person(33, "Kyle"));
        names.insert(new Person(37, "Peter"));
        names.insert(new Person(27, "Michael"));

        names.traverse();

        //names.remove(new Person(25, "Anna"));
        System.out.println("\n\n Middle Node " + names.getMiddleNode());
        names.reverse();
        System.out.println("\n");
        names.traverse();


    }
}
