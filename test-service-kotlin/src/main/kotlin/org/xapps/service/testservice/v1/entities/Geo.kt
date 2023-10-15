package org.xapps.service.testservice.v1.entities

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "geos")
open class Geo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value = "id")
    var id: Long = 0,

    @Column(name = "lat")
    @JsonProperty(value = "lat")
    var lat: Float = 0.0f,

    @Column(name = "lng")
    @JsonProperty(value = "lng")
    var lng: Float = 0.0f
)