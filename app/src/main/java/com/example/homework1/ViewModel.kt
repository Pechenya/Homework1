package com.example.homework1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModel {

        var data: MutableLiveData<String>? = null

        open fun getData(): LiveData<String>? {
            if (data == null) {
                data = MutableLiveData()
                loadData()
            }
            return data
        }

        private open fun loadData() {
            dataRepository.loadData(object : Callback<String?>() {
                fun onLoad(s: String) {
                    data!!.postValue(s)
                }
            }
        }