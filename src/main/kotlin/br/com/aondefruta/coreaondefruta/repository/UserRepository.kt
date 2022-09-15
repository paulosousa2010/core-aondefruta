package br.com.aondefruta.coreaondefruta.repository

import br.com.aondefruta.coreaondefruta.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, Int> {

  @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
  fun validateUser(email: String, password: String): User

  @Query("SELECT count(u) = 1 from User u where u.user_name = ?1")
  fun hasUserByUserName(userName: String): Boolean
}
