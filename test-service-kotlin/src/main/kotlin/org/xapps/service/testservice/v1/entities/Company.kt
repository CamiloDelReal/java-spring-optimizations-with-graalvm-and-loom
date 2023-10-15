package org.xapps.service.testservice.v1.entities

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "companies")
data class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value = "id")
    var id: Long = 0,

    @Column(name = "name")
    @JsonProperty(value = "name")
    var name: String = "",

    @Column(name = "bs")
    @JsonProperty(value = "bs")
    var bs: String = "",

    @Column(name = "catch_phrase")
    @JsonProperty(value = "catchPhrase")
    var catchPhrase: String = ""
)