package com.example.pointsofinterestapi.Controller

import com.example.pointsofinterestapi.Model.POI
import com.example.pointsofinterestapi.Service.POIServices

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("pois")
class POIController constructor(
    @Autowired
    val poiServices: POIServices
){

    @GetMapping
    fun getPOIs(@RequestParam page: Int, @RequestParam size: Int): ResponseEntity<Page<POI>> {
        return ResponseEntity.ok(poiServices.getPOIs(page,size))
    }

    @PostMapping
    fun createPOIs(@RequestBody poi: POI): ResponseEntity<POI> {
        return ResponseEntity.status(201).body(poiServices.createPOI(poi))
    }
    @PutMapping("/{id}")
    fun updatePOIs(@RequestBody poi: POI, @PathVariable id: Long): ResponseEntity<POI> {
        return ResponseEntity.ok(poiServices.updatePOI(poi,id))
    }
    @DeleteMapping("/{id}")
    fun deletePOIs(@PathVariable  id: Long): ResponseEntity<Void> {
        return ResponseEntity.status(204).body(poiServices.deletePOI(id))
    }

}