package br.com.aondefruta.coreaondefruta.controller

import br.com.aondefruta.coreaondefruta.model.User
import br.com.aondefruta.coreaondefruta.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/user")
class TreeController {

    @Autowired
    private lateinit var repository: UserRepository

    @GetMapping("/")
    fun findMany(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(repository.findAll().toList())
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable("id") id: Int): ResponseEntity<Optional<User>> {
        return ResponseEntity.ok(repository.findById(id))
    }

    @PostMapping("/")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val newUser = User(
            user_id = user.user_id,
            name = user.name,
            email = user.email,
            user_name = user.user_name,
            password = user.password
        )
        return ResponseEntity.ok(repository.save(newUser))
    }

    @DeleteMapping("/delete/{id}") // TODO: 24/03/2022 Não consegue deletar se tiver especies cadastradas
    fun deleteUser(@PathVariable("id") id: Int) {
        return repository.deleteById(id)
        // TODO: 20/03/2022 O que fazer quando deletar usuario com especies cadastradas???
    }
}