package com.example.appretrofit.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appretrofit.model.QuakeResponse
import com.example.appretrofit.service.QuakeAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class QuakeViewModel(application: Application) : BaseViewModel(application) {

    private val QuakeAPISer = QuakeAPIService()
    private val disposable = CompositeDisposable()

    private val _quakeListLiveData = MutableLiveData<QuakeResponse>()
    val quakeListLiveData : LiveData<QuakeResponse> = _quakeListLiveData

    fun quakeList(){
        disposable.add(
            QuakeAPISer.getDepremler()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<QuakeResponse>() {
                    override fun onSuccess(response: QuakeResponse) {
                        _quakeListLiveData.value = response
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }
}