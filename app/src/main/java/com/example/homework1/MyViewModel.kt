package com.example.homework1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework.FragmentData
import com.example.homework.MyFragment


open class MyViewModel: ViewModel() {
    var fragmentList : MutableLiveData<ArrayList<MyFragment>> = MutableLiveData()
    init{
        fragmentList.value = FragmentData.getList()
    }
    public fun updateModel() = fragmentList
}