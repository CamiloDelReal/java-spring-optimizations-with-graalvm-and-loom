package com.example.testservicejava.v1.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value = "id")
    private Long id;

    @Column(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Column(name = "bs")
    @JsonProperty(value = "bs")
    private String bs;

    @Column(name = "catch_phrase")
    @JsonProperty(value = "catchPhrase")
    private String catchPhrase;

}
