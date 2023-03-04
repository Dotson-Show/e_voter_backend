package com.evoter.party.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @author showunmioludotun
 */
@Entity
@Table(
        name = "parties",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "party_name_unique",
                        columnNames = {"name"}
                )
        }
)
public class Party {

    @Id
    @SequenceGenerator(
            name = "party_sequence",
            sequenceName = "party_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "party_sequence"
    )

    @Column(
        name = "id",
        updatable = false
    )
    private Long id;

    @Column(
        name = "name",
        nullable = false
    )
    private String name;
    private String logo;

    public Party() {

    }
    public Party(Long id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Party party = (Party) o;
        return Objects.equals(id, party.id) && Objects.equals(name, party.name) && Objects.equals(logo, party.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, logo);
    }

    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
