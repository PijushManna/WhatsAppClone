package api

sealed class APIResponse {
    data class  Success(val response: Any? = null): APIResponse()
    data class  Error(val exception: Exception?): APIResponse()
    object InProgress: APIResponse()
}