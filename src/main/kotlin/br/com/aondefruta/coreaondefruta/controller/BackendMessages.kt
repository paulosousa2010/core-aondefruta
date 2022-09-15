package br.com.aondefruta.coreaondefruta.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Usuário não encontrado.")
class NotFoundUserException : RuntimeException()

@ResponseStatus(value = HttpStatus.OK, reason = "Usuário criado com sucesso.")
class UserCreatedMessage : RuntimeException()

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Este user name já está em uso!")
class UserAlreadyExists : RuntimeException()

@ResponseStatus(value = HttpStatus.OK, reason = "Usuário apagado com sucesso.")
class UserDeletedMessage : RuntimeException()

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Árvore não encontrada.")
class NotFoundTreeException : RuntimeException()

@ResponseStatus(value = HttpStatus.OK, reason = "Árvore adicionada com sucesso.")
class TreeAddedMessage : RuntimeException()

@ResponseStatus(value = HttpStatus.OK, reason = "Árvore apagada com sucesso.")
class TreeDeletedMessage : RuntimeException()

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Usuário não encontrado!")
class NotFoundUser : RuntimeException()
