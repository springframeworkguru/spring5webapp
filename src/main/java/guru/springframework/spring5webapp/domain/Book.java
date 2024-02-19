package guru.springframework.spring5webapp.domain;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table
@Builder
public class Book {
    @Id
    @SequenceGenerator(name = "pk_book_id", sequenceName = "book_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_book_id")
    private Long id;

    private String title;
    private String isbn;
    private String publisher;
    private Long authorId;

}
