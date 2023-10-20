package Exercises;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Readable {
    @Id
    private int ISBN;
    @Column
    private String title;
    @Column
    private LocalDate published;
    @Column
    private int pages;
    @ManyToOne
    @JoinColumn(name = "leggibile_id")
    private Readable readable;

    public Readable(){}

    public Readable(int ISBN, String title, LocalDate published, int pages) {
        this.ISBN = ISBN;
        this.title = title;
        this.published = published;
        this.pages = pages;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublished() {
        return published;
    }

    public int getPages() {
        return pages;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Readable getReadable() {
        return readable;
    }

    public void setReadable(Readable readable) {
        this.readable = readable;
    }

    @Override
    public String toString() {
        return "Readable{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", published=" + published +
                ", pages=" + pages +
                '}';
    }
}
