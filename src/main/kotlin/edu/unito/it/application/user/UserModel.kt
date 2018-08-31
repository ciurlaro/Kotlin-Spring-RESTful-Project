package edu.unito.it.application.user

import edu.unito.it.application.exceptionHandler.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@Service
data class UserModel (
        @Id @NotBlank @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0,

        @get: NotBlank
        val mailAddress: String = "",

        @get: NotBlank
        val password: String = "") {

    @Autowired
    private lateinit var userRepository: UserRepository

    internal fun findAllUsers(): List<UserEntity> = userRepository.findAll()

    internal fun getUserById(@Valid @RequestParam id: Long): ResponseEntity<UserEntity> {
        if (!userRepository.findById(id).isPresent) throw UserNotFoundException()
        return userRepository.findById(id).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    internal fun createNewUser(@Valid @RequestParam mailAddress: String,
                               @Valid @RequestParam password: String): UserEntity =
            userRepository.save(UserEntity(null, mailAddress, password))

    internal fun updateUserById(@Valid @RequestParam id: Long,
                                @Valid @RequestBody newUserEntity: UserEntity): ResponseEntity<UserEntity> {

        return userRepository.findById(id).map { existingArticle ->
            val updatedUserEntity: UserEntity =
                existingArticle.copy(mailAddress = newUserEntity.mailAddress, password = newUserEntity.password)
        ResponseEntity.ok().body(userRepository.save(updatedUserEntity))
        }.orElse(ResponseEntity.notFound().build())
    }

    internal fun deleteUserById(@Valid @RequestParam id: Long): ResponseEntity<Void> {

        return userRepository.findById(id).map { article  ->
            userRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}