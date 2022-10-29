package br.com.aondefruta.coreaondefruta.repository

import br.com.aondefruta.coreaondefruta.model.Tree
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TreeRepository : JpaRepository<Tree, Int> {

    @Query("SELECT t FROM Tree t WHERE t.idUsuario = ?1 ORDER BY t.id desc")
    fun findAllByUser(idUser: Int): List<Tree>
}
