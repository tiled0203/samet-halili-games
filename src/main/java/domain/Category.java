package domain;

public class Category {
    private int id;
    private String categoryName;

    public Category(Builder builder) {
        this.id = builder.id;
        this.categoryName = builder.categoryName;
    }

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
