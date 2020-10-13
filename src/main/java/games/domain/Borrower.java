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

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Borrower {
    @Id @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    @Size(min = 1, max = 40)
    private String borrowerName;
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
}
