package edu.unito.it.application.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class UserController(private val userModel: UserModel) {

    @GetMapping("/users")
    fun getAllUsers(): List<UserEntity> =
        userModel.findAllUsers()

    @GetMapping("/users/")
    fun getArticleByUser(@Valid @RequestParam id: Long) : ResponseEntity<UserEntity> =
        userModel.getUserById(id)

    @PostMapping("/users")
    fun createNewUser(@Valid @RequestParam mailAddress: String, @Valid @RequestParam password: String): UserEntity =
        userModel.createNewUser(mailAddress, password)

    @PutMapping("/users/{id}")
    fun updateUserById(@PathVariable(value = "id") id: Long,
                       @Valid @RequestBody newUserEntity: UserEntity) =
        userModel.updateUserById(id, newUserEntity)

    @DeleteMapping("/users/{id}")
    fun deleteUserById(@PathVariable(value = "id") id: Long) =
        userModel.deleteUserById(id)

}