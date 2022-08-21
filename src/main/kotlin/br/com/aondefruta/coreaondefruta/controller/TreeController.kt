package br.com.aondefruta.coreaondefruta.controller

import br.com.aondefruta.coreaondefruta.model.Tree
import br.com.aondefruta.coreaondefruta.repository.TreeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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

  @PutMapping("/{id}")
  fun updateTree(@PathVariable("id") treeId: Int, @RequestBody tree: Tree): ResponseEntity<Tree> {
    return if (repository.existsById(treeId)) {
      ResponseEntity.ok(
        repository.save(
          Tree(
            id = treeId,
            name = tree.name,
            id_user = tree.id_user,
            latitude = tree.latitude,
            longitude = tree.longitude,
            description = tree.description
          )
        )
      )
    } else throw NotFoundTreeException()
  }

  @DeleteMapping("/delete/{id}")
  fun deleteTree(@PathVariable("id") treeId: Int): ResponseEntity<Tree> {
    try {
      repository.deleteById(treeId)
      throw TreeDeletedMessage()
    } catch (e: Exception) {
      throw NotFoundTreeException()
    }
  }
}
