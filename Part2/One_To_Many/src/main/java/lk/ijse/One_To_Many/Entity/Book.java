package lk.ijse.One_To_Many.Entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    private String id;
    private String name;
    private Double price;

    @ManyToOne()
    private Auther auther;
    public Book() {
    }

    public Book(String id, String name, Double price, Auther auther) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.auther = auther;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Auther getAuther() {
        return auther;
    }

    public void setAuther(Auther auther) {
        this.auther = auther;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", auther=" + auther +
                '}';
    }

}
