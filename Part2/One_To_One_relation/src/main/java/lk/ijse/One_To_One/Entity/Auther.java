package lk.ijse.One_To_One.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Auther {
    @Id
    private String Id;
    private String name;
    private String country;

    public Auther() {
    }

    public Auther(String id, String name, String country) {
        Id = id;
        this.name = name;
        this.country = country;
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

    @Override
    public String toString() {
        return "Auther{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
