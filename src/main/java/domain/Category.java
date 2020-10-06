package domain;

import javax.persistence.*;

@Entity
public class Category {
    @Id @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String categoryName;

    public Category(Builder builder) {
        this.id = builder.id;
        this.categoryName = builder.categoryName;
    }

    public Category(){}

    public String getCategoryName() {
        return categoryName;
    }

    public int getId() {
        return id;
    }

    public static class Builder {
        private int id;
        private String categoryName;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Category build() {
            return new Category(this);
        }

    }
}
