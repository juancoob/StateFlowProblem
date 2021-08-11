package com.architectcoders.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel : ViewModel() {

    private val _passwordState: MutableStateFlow<PasswordState> =
        MutableStateFlow(PasswordState.CHECK_PASSWORD_STATE)
    val passwordState: StateFlow<PasswordState> get() = _passwordState

    enum class PasswordState {
        CHECK_PASSWORD_STATE, SAVE_PASSWORD, REQUEST_PASSWORD, REQUEST_HINT, SUCCESSFUL
    }

    fun updatePasswordState(passwordState: PasswordState) {
        _passwordState.value = passwordState
    }
}
