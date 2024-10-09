package com.example.mvvmthy.Repository

import com.example.mvvmthy.Data.ApiService
import com.example.mvvmthy.Model.Product


class ProductRepository(private val productApi: ApiService){
    suspend fun getProducts(): List<Product> {
        return productApi.getProducts()
    }
}