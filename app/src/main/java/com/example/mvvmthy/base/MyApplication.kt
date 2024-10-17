package com.example.mvvmthy.base

import android.app.Application
import android.util.Log
import com.example.mvvmthy.Model.Product

class MyApplication : Application() {

    companion object {
        var instance: MyApplication? = null
            private set
    }

    // Burada name değişkenini tanımlıyoruz.
    var name: String? = null
    var mProduct : List<Product>? = null
    var error : String = null.toString()

    override fun onCreate() {
        super.onCreate()
        Log.d("başladı", "uygulama başlatıldı")
        instance = this

        // Uygulama başlatıldığında name değeri set ediliyor
        name = "Varsayılan Uygulama Adı"
    }

    // App adını döndüren metod
    fun getAppName(): String {
        return "uygulama adi"
    }
}
