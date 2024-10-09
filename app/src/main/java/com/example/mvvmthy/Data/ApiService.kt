package com.example.mvvmthy.Data

import com.example.mvvmthy.Model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}