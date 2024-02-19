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
public class Author {
    @Id
    @SequenceGenerator(name = "pk_author_id", sequenceName = "author_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_author_id")
    private Long id;

    private String firstName;
    private String lastName;
}
