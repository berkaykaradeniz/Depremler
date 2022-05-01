package com.example.appretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appretrofit.adapter.DepremlerAdapter
import com.example.appretrofit.databinding.ActivityMainBinding
import com.example.appretrofit.model.QuakeResponse
import com.example.appretrofit.viewmodel.QuakeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val depremlerAdapter = DepremlerAdapter()
    private lateinit var binding: ActivityMainBinding
    private var depremList: ArrayList<QuakeResponse.Result> = arrayListOf()
    private lateinit var quakeViewModel: QuakeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quakeViewModel = ViewModelProvider(this).get(QuakeViewModel::class.java)

        quakeViewModel.quakeList()
        observableLiveData()

        rv_multitype_list.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rv_multitype_list.adapter = depremlerAdapter
    }
    private fun observableLiveData(){
        quakeViewModel.quakeListLiveData.observe(this) {
            it.result.forEach {res ->
                depremList.add(res)
            }
            depremlerAdapter.setDepremNameList(depremList.filter { item -> item.mag > 2.5} as ArrayList<QuakeResponse.Result>)

        }

    }
}