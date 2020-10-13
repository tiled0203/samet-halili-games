package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Borrower {
    @Id @GeneratedValue
    private int id;
    @Column(nullable = false)
    @Size(min = 1, max = 40)
    private String borrowerName;

    //TRAINER: An optional improvement could be that you can create a separate Address entity with address fields in it.
    // and have a OneToOne or ManyToOne relationship with it, many borrowers can live on one address
    @Column(nullable = false)
    @Size(min = 1, max = 30)
    private String street;
    @Column(nullable = false)
    @Size(min = 1, max = 5)
    private String houseNumber;
    @Size(min = 1, max = 5)
    private String busNumber;
    @Column(nullable = false)
    private int postCode;
    @Column(nullable = false)
    @Size(min = 1, max = 30)
    private String city;
    @Size(min = 1, max = 10)
    private String telephone;
    @Column(nullable = false)
    @Size(min = 1, max = 40)
    private String email;

    public Borrower(Builder builder) {
        this.id = builder.id;
        this.borrowerName = builder.borrowerName;
        this.street = builder.street;
        this.houseNumber = builder.houseNumber;
        this.busNumber = builder.busNumber;
        this.postCode = builder.postCode;
        this.city = builder.city;
        this.telephone = builder.telephone;
        this.email = builder.email;
    }

    public Borrower() {

    }

    public int getId() {
        return id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "id=" + id +
                ", borrowerName='" + borrowerName + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", postCode=" + postCode +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //TRAINER: Very good!
    public static class Builder {
        private int id;
        private String borrowerName;
        private String street;
        private String houseNumber;
        private String busNumber;
        private int postCode;
        private String city;
        private String telephone;
        private String email;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withBorrowerName(String borrowerName) {
            this.borrowerName = borrowerName;
            return this;
        }

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder withBusNumber(String busNumber) {
            this.busNumber = busNumber;
            return this;
        }

        public Builder withPostCode(int postCode) {
            this.postCode = postCode;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Borrower build() {
            return new Borrower(this);
        }
    }
}
