package main.java.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id",columnDefinition = "serial")
    private int id;

    @Column(name = "borrow_name")
    private String borrow_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_date")
    private LocalDate borrowingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private LocalDate returnDate;

    @OneToMany(mappedBy = "bookBorrowing",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
