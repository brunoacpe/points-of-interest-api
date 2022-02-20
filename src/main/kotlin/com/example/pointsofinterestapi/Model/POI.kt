package com.example.pointsofinterestapi.Model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*
import javax.print.attribute.standard.MediaSize

@Entity
@Table(name = "points_of_interest")
data class POI(
    @Id
    @GeneratedValue
    val id: Long,

    @Column(name= "name")
    val name: String,

    @Column(name= "x_coordinate")
    @JsonProperty("x_coordinate")
    val xCoordinate: Int,

    @Column(name= "y_coordinate")
    @JsonProperty("y_coordinate")
    val yCoordinate: Int,

    @Column(name= "created_at")
    @JsonProperty("created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    val createdAt: Date,

    @Column(name= "updated_at")
    @JsonProperty("updated_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    val updatedAt: Date,

    @Column(name= "is_active")
    @JsonProperty("is_active")
    var isActive: Boolean
)
