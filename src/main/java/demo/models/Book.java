package demo.models;

public class Book {

    private Long id;
    private String title;
    private String description;

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Book(Long id, String title, String description) {
        this(title, description);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
