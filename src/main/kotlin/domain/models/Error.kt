package domain.models

sealed class ApiError {
    object ServerUnreachableError : ApiError()
    object CommunicationError : ApiError()
    object UnavailableDataError : ApiError()
    object ResponseError : ApiError()
}

typealias ServerUnreachableError = ApiError.ServerUnreachableError
typealias CommunicationError = ApiError.CommunicationError
typealias UnavailableDataError = ApiError.UnavailableDataError
typealias ResponseError = ApiError.ResponseError