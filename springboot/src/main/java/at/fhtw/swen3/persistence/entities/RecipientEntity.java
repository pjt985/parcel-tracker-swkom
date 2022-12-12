package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@Entity(name = "recipient_entity")
public class RecipientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Pattern(regexp = "^[A-ZÄÖÜ][a-zäöüß]+\\.?\\s?([A-ZÄÖÜ][a-zäöüß]+)*$")
    @Column
    private String name;

    @Pattern(regexp = "[A-Za-zÄÖÜäöüß]+\\s[0-9A-Za-zÄÖÜäöüß/\\s]+")
    @Column
    private String street;

    @Pattern(regexp = "^[AD]-\\d{4}$")
    @Column
    private String postalCode;
    @Pattern(regexp = "^[A-ZÄÖÜ][a-zäöüß]+\\.?\\s?([A-ZÄÖÜ][a-zäöüß]+)*$")
    @Column
    private String city;

    @Column
    private String country;


    public RecipientEntity name(String name) {
        this.name = name;
        return this;
    }

    public RecipientEntity country(String country) {
        this.country = country;
        return this;
    }

    public RecipientEntity city(String city) {
        this.city = city;
        return this;
    }

    public RecipientEntity street(String street) {
        this.street = street;
        return this;
    }

    public RecipientEntity postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

}
