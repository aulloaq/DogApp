package cl.aulloa.dogapp.network

import cl.aulloa.dogapp.network.response.DogResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("breeds/list")
    fun searchDogList(): Call<DogResponse>
    @GET("breed/{breed_name}/images")
    fun searchDogImages(@Path("breed_name") breedName: String): Call<DogResponse>
}