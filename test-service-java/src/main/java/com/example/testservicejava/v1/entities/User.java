package com.example.testservicejava.v1.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value = "id")
    private Long id;

    @Column(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Column(name = "email")
    @JsonProperty(value = "email")
    private String email;

    @Column(name = "phone")
    @JsonProperty(value = "phone")
    private String phone;

    @Column(name = "website")
    @JsonProperty(value = "website")
    private String website;

    @OneToOne
    @JsonProperty(value = "address")
    private Address address;

    @OneToOne
    @JsonProperty(value = "company")
    private Company company;

    @Column(name = "username")
    @JsonProperty(value = "username")
    private String username;

    @Column(name = "password")
    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
