package presentation

import domain.usecase.getAllBrandsUseCase
import utils.Logger
import view.BaseView

fun getAllBrandsPresentation(view : BaseView, logger: Logger) {
    getAllBrandsUseCase(logger).fold(
            { view.showError(it, logger) },
            { view.showBrands(it, logger) }
    )
}