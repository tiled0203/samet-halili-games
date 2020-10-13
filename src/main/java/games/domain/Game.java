package games.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id @GeneratedValue
    private Integer id;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "difficulty_id")
    private Integer difficultyId;
    @Column(nullable = false)
    @Size(min = 1, max = 50)
    private String gameName;
    @Column(nullable = false)
    @Size(min = 1, max = 50)
    private String editor;
    @Size(min = 1, max = 50)
    private String author;
    @Column(nullable = false)
    private int yearEdition;
    @Column(nullable = false)
    @Size(min = 1, max = 20)
    private String age;
    @Column(nullable = false)
    private int minPlayers;
    @Column(nullable = false)
    private int maxPlayers;
    @Size(min = 1, max = 20)
    private String playDuration;
    @Column(nullable = false)
    private BigDecimal price;
    private String image;

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", difficultyId=" + difficultyId +
                ", gameName='" + gameName + '\'' +
                ", editor='" + editor + '\'' +
                ", author='" + author + '\'' +
                ", yearEdition=" + yearEdition +
                ", age='" + age + '\'' +
                ", minPlayers=" + minPlayers +
                ", maxPlayers=" + maxPlayers +
                ", playDuration='" + playDuration + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
