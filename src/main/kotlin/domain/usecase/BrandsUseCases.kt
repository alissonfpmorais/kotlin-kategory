package domain.usecase

import data.service.getAllBrands
import domain.models.ApiError
import domain.models.Brand
import kategory.Either
import utils.Logger

fun getAllBrandsUseCase(logger : Logger) : Either<ApiError, List<Brand>> =
        getAllBrands().fold(
                {
                    logger.error(it.toString())
                    Either.Left(it)
                },
                {
                    logger.debug(it.toString())
                    Either.Right(it.filter { it.nome.length > 3 })
                }
        )