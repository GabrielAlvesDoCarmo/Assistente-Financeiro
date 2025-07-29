package br.com.gds.assistentefinanceiro.utils.state


sealed interface UiState<out T> {
    data object Idle : UiState<Nothing>
    data object Loading : UiState<Nothing>
    data class Success<out T>(val data: T) : UiState<T>
    data class Error(val message: String? = null, val cause: Throwable? = null) : UiState<Nothing>
}