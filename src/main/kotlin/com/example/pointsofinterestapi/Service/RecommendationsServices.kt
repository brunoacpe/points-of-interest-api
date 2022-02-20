package com.example.pointsofinterestapi.Service

import com.example.pointsofinterestapi.Model.POI
import com.example.pointsofinterestapi.Repository.POIRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RecommendationsServices constructor(
    @Autowired
    val poiRepository: POIRepository
) {

    fun getRecommendations(xCoordinate:Int, yCoordinate:Int, radius:Int): List<POI>{
        var xCoordinateMax:Int = xCoordinate + radius
        val xCoordinateMin:Int = xCoordinate - radius

        val yCoordinateMax:Int = yCoordinate + radius
        val yCoordinateMin:Int = yCoordinate - radius

        var recommendationsList:List<POI> = poiRepository.findAll()
        var recommendationListReturn = ArrayList<POI>()
        recommendationsList
            .forEach {
                recommendation -> kotlin.run {
                    val x = recommendation.xCoordinate
                    val y = recommendation.yCoordinate
                    if(x in xCoordinateMin..xCoordinateMax&& y in yCoordinateMin .. yCoordinateMax){
                        recommendationListReturn.add(recommendation)
                    }
            }
            }
        return recommendationListReturn
    }
}