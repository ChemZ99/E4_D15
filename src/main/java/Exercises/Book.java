package Exercises;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "libro")
public class Book extends Readable{
    @Column
   private String author;
    @Column
   private String genre;

    public Book (){}
    public Book(int ISBN, String title, LocalDate published, int pages, String author, String genre) {
        super(ISBN, title, published, pages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                "} " + super.toString();
    }
}
