package com.example.pointsofinterestapi.Exception

class POINotFoundException constructor(
    override val message: String
): RuntimeException() {

}