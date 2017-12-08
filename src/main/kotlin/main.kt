import presentation.getAllBrandsPresentation
import utils.Logger
import view.FipeView

fun main(args: Array<String>) {
    val view = FipeView()
    val logger = Logger

    getAllBrandsPresentation(view, logger)
}