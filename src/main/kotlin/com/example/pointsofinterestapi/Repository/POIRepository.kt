package com.example.pointsofinterestapi.Repository

import com.example.pointsofinterestapi.Model.POI
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
interface POIRepository: JpaRepository<POI, Long> {

    fun findPOIById(id:Long): POI?

//    @Query(
//        "SELECT poi FROM POI poi "+
//                "WHERE (poi.xCoordinate >= :x_coordinate_min AND poi.xCoordinate <=:x_coordinate_max) "+
//                "AND (poi.yCoordinate >= :y_coordinate_min AND poi.yCoordinate <=: y_coordinate_max)"
//    )
//    fun findPOIByPOI(
//        @Param("x_coordinate_max")
//        xCoordinateMax:Int,
//        @Param("x_coordinate_min")
//        xCoordinateMin:Int,
//        @Param("y_coordinate_max")
//        yCoordinateMax:Int,
//        @Param("y_coordinate_min")
//        yCoordinateMin:Int,
//    )
}