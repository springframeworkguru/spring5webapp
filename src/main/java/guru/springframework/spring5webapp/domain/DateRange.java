package guru.springframework.spring5webapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
public class DateRange {
    private LocalDate startDate;
    private LocalDate endDate;
}
