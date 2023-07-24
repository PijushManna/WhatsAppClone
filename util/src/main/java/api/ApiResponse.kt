package api

sealed class ApiResponse {
    data class  Success(val response: Any? = null): ApiResponse()
    data class  Error(val exception: Exception?): ApiResponse()
    object InProgress: ApiResponse()
}