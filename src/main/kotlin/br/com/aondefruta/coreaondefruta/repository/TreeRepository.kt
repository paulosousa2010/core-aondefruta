package br.com.aondefruta.coreaondefruta.repository

import br.com.aondefruta.coreaondefruta.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface TreeRepository : JpaRepository<User, Int> {

}
