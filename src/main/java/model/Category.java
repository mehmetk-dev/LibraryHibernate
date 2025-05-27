package main.java.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id",columnDefinition = "serial")
    private int id;

    @Column(name = "category_name")
    private String name;

    private String description;

    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Book> bookList;

    public Category(int id, String name, String description, List<Book> bookList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.bookList = bookList;
    }

    public Category() {
    }
}
