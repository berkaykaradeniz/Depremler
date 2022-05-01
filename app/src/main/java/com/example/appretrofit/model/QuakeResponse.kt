package com.example.appretrofit.model


import com.google.gson.annotations.SerializedName

data class QuakeResponse(
    @SerializedName("desc")
    val desc: String, // OK
    @SerializedName("result")
    val result: List<Result>,
    @SerializedName("status")
    val status: Boolean // true
) {
    data class Result(
        @SerializedName("coordinates")
        val coordinates: List<Double>,
        @SerializedName("date")
        val date: String, // 2020.01.02 05:39:25
        @SerializedName("date_stamp")
        val dateStamp: String, // 2020-01-01
        @SerializedName("depth")
        val depth: Double, // 17.5
        @SerializedName("hash")
        val hash: String, // 369c8cc4c8ac297a67e63528b38a5333
        @SerializedName("hash2")
        val hash2: String, // 0cd994685cc81c66b3e771d70821fbcb
        @SerializedName("_id")
        val id: İd,
        @SerializedName("lat")
        val lat: Double, // 39.7588
        @SerializedName("lng")
        val lng: Double, // 27.526
        @SerializedName("lokasyon")
        val lokasyon: String, // MUSTECAP-BALYA (BALIKESIR)
        @SerializedName("mag")
        val mag: Double, // 1.8
        @SerializedName("rev")
        val rev: Any, // null
        @SerializedName("timestamp")
        val timestamp: Int, // 1577932765
        @SerializedName("title")
        val title: String // MUSTECAP-BALYA (BALIKESIR)
    ) {
        data class İd(
            @SerializedName("oid")
            val oid: String // 5e0d77925c2b9124d84d4d32
        )
    }
}