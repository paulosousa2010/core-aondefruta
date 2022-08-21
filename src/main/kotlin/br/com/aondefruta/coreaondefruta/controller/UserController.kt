package br.com.aondefruta.coreaondefruta.controller

import br.com.aondefruta.coreaondefruta.model.User
import br.com.aondefruta.coreaondefruta.repository.TreeRepository
import br.com.aondefruta.coreaondefruta.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val repositoryTree: TreeRepository,
) {

    private val logger = LoggerFactory.getLogger(UserController::class.java)

    @Autowired
    private lateinit var repositoryUser: UserRepository

    @GetMapping("")
    fun findMany(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(repositoryUser.findAll().toList())
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable("id") id: Int): ResponseEntity<User> {
        return if (repositoryUser.existsById(id)) {
            try {
                ResponseEntity.ok(repositoryUser.findById(id).get())
            } catch (e: Exception) {
                logger.error("UserController.findOne", e)
                ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        } else throw NotFoundUserException()
    }

    @PostMapping("")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val newUser = User(
            user_id = user.user_id,
            name = user.name,
            email = user.email,
            user_name = user.user_name,
            password = user.password
        )
        repositoryUser.save(newUser)
        throw UserCreatedMessage()
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable("id") userId: Int, @RequestBody user: User): ResponseEntity<User> {
        return if (repositoryUser.existsById(userId)) {
            ResponseEntity.ok(
                repositoryUser.save(
                    User(
                        user_id = userId,
                        name = user.name,
                        email = user.email,
                        user_name = user.user_name,
                        password = user.password
                    )
                )
            )
        } else throw NotFoundUserException()
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable("id") id: Int): ResponseEntity<User> {
        val userTreesIds = repositoryUser.findById(id).map { user -> user.trees?.map { tree -> tree.id } }.get()
        if (userTreesIds.isNotEmpty()) {
            repositoryTree.deleteAllById(userTreesIds)
        }
        repositoryUser.deleteById(id)
        throw UserDeletedMessage()
    }
}
