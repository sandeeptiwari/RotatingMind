public class Book {
    private Long id;
    private String isbn;
    private String title;
    private int publisherid;

    public Book(Long id, String isbn, String title, int publisherid) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.publisherid = publisherid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisherid=" + publisherid +
                '}';
    }
}
