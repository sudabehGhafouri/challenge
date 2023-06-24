package com.mersana.androidtest.database


import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


@TypeConverters
class DataConverter {

    @TypeConverter
    fun convertToString(obj : JsonObject) : String {
        return Gson().fromJson(obj, String::class.java)
    }

    @TypeConverter
    fun convertToJsonObject(value : String) : JsonObject {
        return Gson().toJson(value) as JsonObject
    }

    @TypeConverter
    fun convertDateToString(date : Date) : String {
        return date.toString()
    }

    //--------------------------------
    @TypeConverter
    fun fromString(value: String?): ArrayList<String> {
        val listType: Type = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}