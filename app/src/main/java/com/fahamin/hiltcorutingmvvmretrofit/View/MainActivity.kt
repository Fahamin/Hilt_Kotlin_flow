package com.fahamin.hiltcorutingmvvmretrofit.View

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fahamin.hiltcorutingmvvmretrofit.Model.NetworkResult
import com.fahamin.hiltcorutingmvvmretrofit.databinding.ActivityMainBinding
import com.fahamin.hiltcorutingmvvmretrofit.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.imageList.observe(this) {
            var progressDialog = ProgressDialog(this)

            when (it) {
                is NetworkResult.Loading -> {
                    progressDialog.setMessage("Loading")
                    progressDialog.show()
                }
                is NetworkResult.Success -> {
                    Log.e("json", "" + it.data.body().toString())
                    progressDialog.dismiss()
                }
                is NetworkResult.Failure -> {
                    Log.e("json", "failed data ")
                    progressDialog.dismiss()
                }
            }
        }
    }
}