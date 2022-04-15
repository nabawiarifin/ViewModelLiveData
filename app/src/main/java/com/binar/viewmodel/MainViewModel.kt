package com.binar.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _mCount : MutableLiveData<Int> = MutableLiveData(0) //Data that will be changed in viewmodel
    val mCount: LiveData<Int> = _mCount // Data that will be sent

    fun incrementCount() {
        _mCount.value = mCount.value?.plus(1)
    }

    fun decrementCount() {
        _mCount.value?.let {
            if (it > 0) {
                _mCount.value = mCount.value?.minus(1)
            }
        }
    }
}