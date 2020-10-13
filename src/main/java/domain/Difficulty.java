package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Difficulty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //TRAINER: you could use an enum for this
    @Column(nullable = false)
    private String difficultyName;

    public Difficulty(Builder builder) {
        this.id = builder.id;
        this.difficultyName = builder.difficultyName;
    }

    public Difficulty(){}

    public String getDifficultyName() {
        return difficultyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Builder {
        private int id;
        private String difficultyName;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withDifficultyName(String difficultyName) {
            this.difficultyName = difficultyName;
            return this;
        }

        public Difficulty build() {
            return new Difficulty(this);
        }

    }
}
