package com.example.testservicejava.v1.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value = "id")
    private Long id;

    @Column(name = "city")
    @JsonProperty(value = "city")
    private String city;

    @OneToOne
    @JsonProperty(value = "geo")
    private Geo geo;

    @Column(name = "street")
    @JsonProperty(value = "street")
    private String street;

    @Column(name = "suite")
    @JsonProperty(value = "suite")
    private String suite;

    @Column(name = "zipcode")
    @JsonProperty(value = "zipcode")
    private String zipcode;

}
