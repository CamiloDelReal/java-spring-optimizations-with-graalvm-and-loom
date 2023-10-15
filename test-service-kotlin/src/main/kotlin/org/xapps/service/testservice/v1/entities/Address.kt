package org.xapps.service.testservice.v1.entities

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "addresses")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value = "id")
    var id: Long = 0,

    @Column(name = "city")
    @JsonProperty(value = "city")
    var city: String = "",

    @OneToOne
    @JsonProperty(value = "geo")
    var geo: Geo? = null,

    @Column(name = "street")
    @JsonProperty(value = "street")
    var street: String = "",

    @Column(name = "suite")
    @JsonProperty(value = "suite")
    var suite: String = "",

    @Column(name = "zipcode")
    @JsonProperty(value = "zipcode")
    var zipcode: String = ""
)