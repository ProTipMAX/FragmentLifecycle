package kz.meken.fragmentlifecycleexploring.some

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SomeViewModel: ViewModel() {

    val counter: MutableLiveData<Int> = MutableLiveData()
    private var initialValue = 0

    init {
        counter.postValue(initialValue)
    }

    fun incrementCounter() {
        counter.postValue(initialValue++)
    }

    fun decrementCounter() {
        counter.postValue(initialValue--)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("SomeViewModel", "onCleared: ")
    }
}