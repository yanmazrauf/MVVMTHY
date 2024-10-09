package com.example.mvvmthy.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmthy.Repository.ProductRepository
import com.example.mvvmthy.Data.RetrofitClient
import com.example.mvvmthy.Model.Product
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val repository = ProductRepository(RetrofitClient.api)

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        fetchProducts()
    }

     fun fetchProducts() {
        viewModelScope.launch {
            try {
                val result = repository.getProducts()
                _products.value = result
            } catch (e: Exception) {
                _error.value = "Error fetching products: ${e.message}"
            }
        }
    }


}