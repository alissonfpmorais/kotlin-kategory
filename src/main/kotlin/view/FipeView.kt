package view

import domain.models.ApiError
import domain.models.Brand
import utils.Logger

class FipeView : BaseView {
    override fun showBrands(brands: List<Brand>, logger: Logger) {
        brands.sortedBy { it.codigo }
                .forEach {
                    logger.verbose(" Code: ${it.codigo}")
                    logger.verbose(" Name: ${it.nome}")
                }
    }

    override fun showError(error: ApiError, logger: Logger) {
        when(error) {
            is ApiError.UnavailableDataError -> logger.error("Nenhuma marca encontrada!")
            is ApiError.ResponseError -> logger.error("Resposta inválida do servidor!")
            is ApiError.CommunicationError -> logger.error("Falha na comunicação!")
            is ApiError.ServerUnreachableError -> logger.error("Não foi possível conectar ao servidor!")
        }
    }
}