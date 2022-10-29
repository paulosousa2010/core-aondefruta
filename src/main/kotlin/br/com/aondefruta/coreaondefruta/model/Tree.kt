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
    @Column(name = "id_user")
    var idUsuario: Int,
    @Column(name = "user_creator")
    var userCreator: String,
    var latitude: Double,
    var longitude: Double,
    var description: String? = "",
) {}