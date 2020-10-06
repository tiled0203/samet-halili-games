package domain;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Borrow {
    @Id @GeneratedValue
    private int id;
    private int gameId;
    private int borrowerId;
    @Column(nullable = false)
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Borrow(Builder builder) {
        this.id = builder.id;
        this.gameId = builder.gameId;
        this.borrowerId = builder.borrowerId;
        this.borrowDate = builder.borrowDate;
        this.returnDate = builder.returnDate;
    }

    public Borrow(){}

    public int getId() {
        return id;
    }

    public int getGameId() {
        return gameId;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public static class Builder {
        private int id;
        private int gameId;
        private int borrowerId;
        private LocalDate borrowDate;
        private LocalDate returnDate;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withGameId(int gameId) {
            this.gameId = gameId;
            return this;
        }

        public Builder withBorrowId(int borrowerId) {
            this.borrowerId = borrowerId;
            return this;
        }

        public Builder withBorrowDate(LocalDate borrowDate) {
            this.borrowDate = borrowDate;
            return this;
        }

        public Builder withReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Borrow build() {
            return new Borrow(this);
        }

    }
}
