package com.example.pointsofinterestapi.Service

import com.example.pointsofinterestapi.Exception.POINotFoundException
import com.example.pointsofinterestapi.Model.POI
import com.example.pointsofinterestapi.Repository.POIRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

import java.util.*

@Service
class POIServices constructor(
    @Autowired
    val poiRepository: POIRepository
){



    fun getPOIs(page:Int, size:Int): Page<POI> {
        return poiRepository.findAll(PageRequest.of(page,size))
    }

    fun createPOI(poi: POI): POI {
        return poiRepository.save(poi)
    }

    fun updatePOI(poi: POI, id: Long): POI {
        var poiOptional:POI? = poiRepository.findPOIById(id)
        if(poiOptional!=null){
            poiRepository.save(
                POI(
                    poiOptional.id,
                    poi.name,
                    poi.xCoordinate,
                    poi.yCoordinate,
                    poiOptional.createdAt,
                    Date(),
                    true
                )
            )
        }
        throw POINotFoundException("Não foi encontrado um POI com este id.")
    }

    fun deletePOI(id: Long): Void {
        var poiOptional:POI? = poiRepository.findPOIById(id)
        if(poiOptional!=null){
            poiOptional.isActive=false
            poiRepository.save(poiOptional)
        }
       throw POINotFoundException("Não foi encontrado um POI com este id.")
    }


}