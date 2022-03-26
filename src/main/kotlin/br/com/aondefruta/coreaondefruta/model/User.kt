package br.com.aondefruta.coreaondefruta.model


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Int,
    var name: String,
    var email: String,
    var discoveres: Long? = null,
    var user_name: String,
    var password: String,

    ) {

}


// TODO: 13/03/2022 um user para muitas trees criar relação oneToMany

