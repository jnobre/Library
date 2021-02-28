package pt.uab.sm.model;

import java.time.LocalDate;

public class Book {

    private String name;
    private String id;
    private Category type;
    private String publisher;
    private LocalDate publishedDate;
    private String author;

    public Book(String name, String id, String author, Category type, String publisher, LocalDate publishedDate) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Category getType() {
        return type;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(Category type) {
        this.type = type;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type=" + type +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", author='" + author + '\'' +
                '}';
    }
}
