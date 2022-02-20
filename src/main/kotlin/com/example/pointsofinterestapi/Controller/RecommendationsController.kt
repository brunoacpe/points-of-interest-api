package com.example.pointsofinterestapi.Controller

import com.example.pointsofinterestapi.Model.POI
import com.example.pointsofinterestapi.Service.RecommendationsServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("recommendations")
class RecommendationsController constructor(
    @Autowired
    val recommendationsServices: RecommendationsServices
) {

    @PostMapping
    fun getRecommendations(@RequestParam xCoordinate:Int, @RequestParam yCoordinate:Int, @RequestParam radius:Int): ResponseEntity<List<POI>> {
        return ResponseEntity.ok(recommendationsServices.getRecommendations(xCoordinate,yCoordinate,radius))
    }
}