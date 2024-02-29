package guru.springframework.spring5webapp.domain;

import jakarta.persistence.Entity;
import lombok.*;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table
@Builder
@NamedQueries({
        @NamedQuery(name = "Book.getById", query = "SELECT b FROM Book b WHERE b.id = :id")
})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;
    private String publisher;
    private Long authorId;
}
