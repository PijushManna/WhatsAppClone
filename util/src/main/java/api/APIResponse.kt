package api

sealed class APIResponse {
    data class  Success(val response: Any?): APIResponse()
    data class  Error(val exception: Exception?): APIResponse()
    object InProgress: APIResponse()
}