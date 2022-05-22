package br.com.aondefruta.coreaondefruta.controller

import br.com.aondefruta.coreaondefruta.model.Tree
import br.com.aondefruta.coreaondefruta.model.User
import br.com.aondefruta.coreaondefruta.repository.TreeRepository
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
@RequestMapping("/tree")
class TreeController {

    @Autowired
    private lateinit var repository: TreeRepository

    @GetMapping("")
    fun findMany(): ResponseEntity<List<Tree>> {
        return ResponseEntity.ok(repository.findAll().toList())
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable("id") id: Int): ResponseEntity<Optional<Tree>> {
        return ResponseEntity.ok(repository.findById(id))
    }

    @PostMapping("")
    fun saveTree(@RequestBody tree: Tree): ResponseEntity<Tree> {
        val newTree = Tree(
            id = tree.id,
            name = tree.name,
            id_user = tree.id_user,
            latitude = tree.latitude,
            longitude = tree.longitude,
            description = tree.description
        )
        return ResponseEntity.ok(repository.save(newTree))
    }
}