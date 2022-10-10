package com.fahamin.hiltcorutingmvvmretrofit.Model.TypeConverter

import androidx.room.TypeConverter
import com.fahamin.hiltcorutingmvvmretrofit.Model.userModel.Address
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AddressTypeConverters {

    @TypeConverter
    fun storedStringToMyAddresss(data: String?): Address {
        val gson = Gson()
        if (data == null) {
        }
        val listType = object : TypeToken<Address?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun myAddresssToStoredString(myAddresss: Address?): String {
        val gson = Gson()
        return gson.toJson(myAddresss)
    }

}