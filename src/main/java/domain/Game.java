package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Game {
    @Id @GeneratedValue
    private int id;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "difficulty_id")
    private int difficultyId;
    @Column(nullable = false)
    @Size(min = 1, max = 50)
    private String gameName;
    @Column(nullable = false)
    @Size(min = 1, max = 50)
    private String editor;
    @Column(nullable = false)
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

    public Game(Builder builder) {
        this.id = builder.id;
        this.categoryId = builder.categoryId;
        this.difficultyId = builder.difficultyId;
        this.gameName = builder.gameName;
        this.editor = builder.editor;
        this.author = builder.author;
        this.yearEdition = builder.yearEdition;
        this.age = builder.age;
        this.minPlayers = builder.minPlayers;
        this.maxPlayers = builder.maxPlayers;
        this.playDuration = builder.playDuration;
        this.price = builder.price;
        this.image = builder.image;
    }

    public Game() {

    }

    public int getId() {
        return id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getDifficultyId() {
        return difficultyId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getEditor() {
        return editor;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearEdition() {
        return yearEdition;
    }

    public String getAge() {
        return age;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public String getPlayDuration() {
        return playDuration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

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

    public static class Builder {
        private int id;
        private int categoryId;
        private int difficultyId;
        private String gameName;
        private String editor;
        private String author;
        private int yearEdition;
        private String age;
        private int minPlayers;
        private int maxPlayers;
        private String playDuration;
        private BigDecimal price;
        private String image;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withCategoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder withDifficultyId(int difficultyId) {
            this.difficultyId = difficultyId;
            return this;
        }

        public Builder withGameName(String gameName) {
            this.gameName = gameName;
            return this;
        }

        public Builder withEditor(String editor) {
            this.editor = editor;
            return this;
        }

        public Builder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder withYearEdition(int yearEdition) {
            this.yearEdition = yearEdition;
            return this;
        }

        public Builder withAge(String age) {
            this.age = age;
            return this;
        }

        public Builder withMinPlayers(int minPlayers) {
            this.minPlayers = minPlayers;
            return this;
        }

        public Builder withMaxPlayers(int maxPlayers) {
            this.maxPlayers = maxPlayers;
            return this;
        }

        public Builder withPlayDuration(String playDuration) {
            this.playDuration = playDuration;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder withImage(String image) {
            this.image = image;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
