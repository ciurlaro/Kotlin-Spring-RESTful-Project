package edu.unito.it.application.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class UserEntity (
        @Id @NotBlank @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0,

        @get: NotBlank
        val mailAddress: String = "",

        @get: NotBlank
        val password: String = ""
)

