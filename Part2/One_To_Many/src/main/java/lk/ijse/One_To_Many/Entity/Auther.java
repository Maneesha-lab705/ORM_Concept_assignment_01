package lk.ijse.One_To_Many.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Auther {
    @Id
    private String Id;
    private String name;
    private String country;

   @OneToMany(mappedBy = "auther",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> book = new ArrayList<>();

    public Auther() {
    }

    public Auther(String id, String name, String country, List<Book> book) {
        Id = id;
        this.name = name;
        this.country = country;
        this.book = book;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Auther{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", book=" + book +
                '}';
    }



    public void addBook(Book book) {
        this.book.add(book);
        book.setAuther(this);
    }
}
