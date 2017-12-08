package view

import domain.models.ApiError
import domain.models.Brand
import utils.Logger

interface BaseView {
    fun showBrands(brands: List<Brand>, logger: Logger)
    fun showError(error: ApiError, logger: Logger)
}