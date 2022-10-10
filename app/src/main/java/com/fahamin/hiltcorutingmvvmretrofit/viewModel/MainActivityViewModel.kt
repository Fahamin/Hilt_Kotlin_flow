package com.fahamin.hiltcorutingmvvmretrofit.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahamin.hiltcorutingmvvmretrofit.Model.NetworkResult
import com.fahamin.hiltcorutingmvvmretrofit.Repository.UserRepository
import com.fahamin.unplashapi_jetpack.UnsplashModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private var repository: UserRepository) :
    ViewModel() {

    var imageList = MutableLiveData<NetworkResult<Response<List<UnsplashModel>>>>()

    init {
        viewModelScope.launch {
            repository.getImageList().collect() { it ->
                it?.let {
                    imageList.postValue(it)
                }
            }
        }

    }
}


