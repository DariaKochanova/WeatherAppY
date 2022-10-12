package com.hfad.weatherappy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.weatherappy.adapters.WeatherModel

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()

}