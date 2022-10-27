package session_6;

import java.util.*;

public class Session7Demo {

    public static void main(String[] args) {
        mapDemo();
    }

    static void arrayListDemo() {
        List<String> al = new ArrayList<>();
        al.add("a");
        al.add("d");
        al.add("a");
        System.out.println(al);

        al.remove("a");

        System.out.println(al);

        System.out.println(al.get(0));
    }

    static void setDemo() {

        Set<String> s = new HashSet<>();

        s.add("a");
        s.add("b");
        s.add("a");
        s.add("a");

        //System.out.println(s);
        // key -> set value, value -> new Object();
        Book b1 = new Book("Let's C", "yashawant Kanetkar", 2004);
        Book b2 = new Book("Let's C", "yashawant Kanetkar", 2004);
        Set<Book> s1 = new HashSet<>();
        s1.add(b1);
        s1.add(b2);

        System.out.println(s1.size());
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
    }

    static void mapDemo() {

        Map<String, Integer> nameByAge = new HashMap<>();
        nameByAge.put("John", 34);
        nameByAge.put("Henry", 43);
        nameByAge.put("Greger", 50);
        nameByAge.put("Pinto", 18);
        nameByAge.put("John", 22);

        System.out.println(nameByAge);

        nameByAge.remove("John");

        System.out.println(nameByAge);
    }
}


class Book {

    private String title;
    private String author;
    private int publishYear;

    public Book(String title, String author, int publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publishYear == book.publishYear && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publishYear);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}
