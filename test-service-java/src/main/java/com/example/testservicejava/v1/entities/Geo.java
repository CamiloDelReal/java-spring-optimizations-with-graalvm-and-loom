package com.example.testservicejava.v1.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "geos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Geo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value = "id")
    private Long id;

    @Column(name = "lat")
    @JsonProperty(value = "lat")
    private float lat;

    @Column(name = "lng")
    @JsonProperty(value = "lng")
    private float lng;

}
