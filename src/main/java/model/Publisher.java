package main.java.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id",columnDefinition = "serial")
    private int id;

    @Column(name = "publisher_name")
    private String name;

    private int establishmentYear;
    private String address;

    @OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Book> bookList;


}
