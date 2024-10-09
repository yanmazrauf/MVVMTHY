package com.example.mvvmthy.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmthy.Adapters.ProductAdapter
import com.example.mvvmthy.R
import com.example.mvvmthy.ViewModel.ProductViewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: ProductViewModel by viewModels()
    private lateinit var adapter: ProductAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        listener()


    }

    private fun setupViews() {
        recyclerView = findViewById(R.id.MainRecycler)

        recyclerView.layoutManager = LinearLayoutManager(this
        )
        adapter = ProductAdapter()
        recyclerView.adapter = adapter
    }

    private fun listener() {
        viewModel.products.observe(this) { products ->
            adapter.submitList(products)
        }
    }

}