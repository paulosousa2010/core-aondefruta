package br.com.aondefruta.coreaondefruta.model


import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var user_id: Int,
    var name: String,
    var email: String,
    var user_name: String,
    var password: String,
    @OneToMany(mappedBy = "id_user")
    var trees: List<Tree>? = null
) {}