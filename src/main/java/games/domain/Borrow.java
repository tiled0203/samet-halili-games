package games.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    @Id @GeneratedValue
    private Integer id;
    private Integer gameId;
    private Integer borrowerId;
    @Column(nullable = false)
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
