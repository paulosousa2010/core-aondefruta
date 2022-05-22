package br.com.aondefruta.coreaondefruta.model

import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "tree")
class Tree(

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Int,
    var name: String,
    var id_user: Int,
    var latitude: Double,
    var longitude: Double,
    var description: String? = "",
) {}