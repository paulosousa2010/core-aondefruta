package br.com.aondefruta.coreaondefruta.model


import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    var id: Int,
    var name: String,
    var email: String,
    @Column(name = "user_name")
    var userName: String,
    var password: String,
    @OneToMany(mappedBy = "idUsuario")
    var trees: List<Tree>? = null
) {}