package br.com.aondefruta.coreaondefruta.repository

import br.com.aondefruta.coreaondefruta.model.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class UsersRepositoryTest {

    @Autowired
    private lateinit var repository: UserRepository




}