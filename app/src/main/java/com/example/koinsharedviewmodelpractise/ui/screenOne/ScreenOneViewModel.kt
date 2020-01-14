package com.example.koinsharedviewmodelpractise.ui.screenOne

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScreenOneViewModel : ViewModel() {

    //Variable to store first & last name
    var firstName = "hello"
    var lastName = ""

    //LiveData variable to store change state of fragment
    private val _gotoNextScreen = MutableLiveData<Boolean>()
    //This variable will be observed in the fragment
    val gotoNextScreen: LiveData<Boolean>
        get() = _gotoNextScreen

    //Method to call on click of save button
    fun onClickSaveNextBtn() {
        _gotoNextScreen.value = true
    }

    fun gotoNextScreenComplete() {
        _gotoNextScreen.value = false
    }


}
