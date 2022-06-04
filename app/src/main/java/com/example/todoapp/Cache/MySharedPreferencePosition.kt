package com.example.todoapp.Cache

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.todoapp.ClassFolders.NameClass
import com.example.todoapp.ClassFolders.UserClass
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

object MySharedPreferencePosition {

    private const val NAME = "registration"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context){
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    @SuppressLint("CommitPrefEdits")
    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    var user: Int?
        get() =  sharedPreferences.getInt("user",-1)
        set(value) = sharedPreferences.edit {
            if (value != null){
                it.putInt("user", value)
            }
        }

/*    var obyekString: ArrayList<NameClass>
        get() = gsonStringToArray(sharedPreferences.getString("obekt", "[]")!!)
        set(value) = sharedPreferences.edit {
            if (value != null) {
                it.putString("obekt", arrayToGsonString(value))
            }
        }

    private fun gsonStringToArray(gsonString: String): ArrayList<NameClass> {
        val type = object : TypeToken<ArrayList<NameClass>>() {}.type
        return Gson().fromJson(gsonString, type)
    }

    fun arrayToGsonString(arrayList: ArrayList<NameClass>): String? {
        return Gson().toJson(arrayList)
    }*/

}