package com.example.testproject.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    var name: String,

    var description: String,

    var rating: Int,

    var date: LocalDate
)