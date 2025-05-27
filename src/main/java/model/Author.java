package main.java.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id",columnDefinition = "serial")
    private int id;

    @Column(name = "author_name")
    private String name;

    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;

    private String country;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private List<Book> bookList = new ArrayList<>();
}

