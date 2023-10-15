package org.xapps.service.testservice.v1.entities

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty(value = "id")
    var id: Long = 0,

    @Column(name = "name")
    @JsonProperty(value = "name")
    var name: String = "",

    @Column(name = "email")
    @JsonProperty(value = "email")
    var email: String = "",

    @Column(name = "phone")
    @JsonProperty(value = "phone")
    var phone: String = "",

    @Column(name = "website")
    @JsonProperty(value = "website")
    var website: String = "",

    @OneToOne
    @JsonProperty(value = "address")
    var address: Address? = null,

    @OneToOne
    @JsonProperty(value = "company")
    var company: Company? = null,

    @Column(name = "username")
    @JsonProperty(value = "username")
    var username: String = "",

    @Column(name = "password")
    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    var password: String = ""
)