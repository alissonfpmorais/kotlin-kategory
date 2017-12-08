package data.api

import domain.models.Brand
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface FIPEApi {
    companion object {
        val BASE_URL = "https://fipe.parallelum.com.br/api/v1/"

        fun getRetrofit(url: String) = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    @GET("carros/marcas")
    fun getCarBrands() : Call<List<Brand>>
}