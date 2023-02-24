package com.utad.ud6_eltiempo.data.models
/*
{
    "data": [
        {
            "latitude": 40.763841,
            "longitude": -73.972972,
            "type": "venue",
            "distance": 0,
            "name": "Apple Store",
            "number": "767",
            "postal_code": "10153",
            "street": "5th Avenue",
            "confidence": 1,
            "region": "New York",
            "region_code": "NY",
            "county": "New York County",
            "locality": "New York",
            "administrative_area": null,
            "neighbourhood": "Midtown East",
            "country": "United States",
            "country_code": "USA",
            "continent": "North America",
            "label": "Apple Store, New York, NY, USA"
        }
    ]
}
*/

data class LocationData(

    val data: List<LocationD>
)

data class LocationD(
    val latitude : String,
    val longitude : String,
    val type: String,
    val distance: String,
    val name: String,
    val number:String,
    val postal_code:String,
    val street:String,
    val confidence:String,
    val region:String,
    val region_code:String,
    val county:String,
    val locality:String,
    val administrative_area:String,
    val neighbourhood :String,
    val country:String,
    val country_code:String,
    val continent:String,
    val label:String
)