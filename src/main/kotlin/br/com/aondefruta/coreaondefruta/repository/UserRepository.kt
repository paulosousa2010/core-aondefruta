package br.com.aondefruta.coreaondefruta.repository

import br.com.aondefruta.coreaondefruta.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {

    //fun findByUserName(user_name: String): User //Metodo personalizada

}
