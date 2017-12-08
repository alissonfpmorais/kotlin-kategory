package data.service

import data.api.FIPEApi
import domain.models.ApiError
import domain.models.Brand
import kategory.Either
import java.io.IOException

fun getAllBrands() : Either<ApiError, List<Brand>> =
        try {
            val retrofit = FIPEApi.getRetrofit(FIPEApi.BASE_URL)
            val fipeApi = retrofit.create(FIPEApi::class.java)
            val callable = fipeApi.getCarBrands()
            val response = callable.execute()

            if (response != null) {
                val brands = response.body()

                if (brands != null) {
                    Either.Right(brands)
                } else {
                    Either.Left(ApiError.UnavailableDataError)
                }
            } else {
                Either.Left(ApiError.ResponseError)
            }
        } catch (e : RuntimeException) {
            Either.Left(ApiError.CommunicationError)
        } catch (e : IOException) {
            Either.Left(ApiError.ServerUnreachableError)
        }