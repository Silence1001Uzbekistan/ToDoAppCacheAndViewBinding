package com.example.todoapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.Cache.*
import com.example.todoapp.ClassFolders.UserClass
import com.example.todoapp.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    private lateinit var bindingD: ActivityDataBinding

    lateinit var arrayList: ArrayList<UserClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingD = ActivityDataBinding.inflate(layoutInflater)
        setContentView(bindingD.root)

        MySharedPreferenceColour.init(this)

        MySharedPreferenceTwo.init(this)

        MySharedPreferencePosition.init(this)

        MySharedPreferenceUserClass.init(this)


        arrayList = MySharedPreferenceUserClass.obyekString

        val a = intent.getIntExtra("a", -1)
        val c = intent.getIntExtra("c", -1)

        val b = intent.getStringExtra("b")



        Toast.makeText(this, "${c}", Toast.LENGTH_SHORT).show()

        supportActionBar!!.title = "$b"

        bindingD.descriptionId.text = arrayList[c].description
        bindingD.createDateId.text = arrayList[c].createDate
        bindingD.dedlineID.text = arrayList[c].toDo


        val number = MySharedPreferenceColour.user

        when (number) {
            0 -> bindingD.imageId.setImageResource(R.color.red)
            1 -> bindingD.imageId.setImageResource(R.color.yellow)
            2 -> bindingD.imageId.setImageResource(R.color.blue)
            3 -> bindingD.imageId.setImageResource(R.color.gray)
        }

        for (i in 0 until arrayList.size){
            Toast.makeText(this, "${arrayList[i].name}", Toast.LENGTH_SHORT).show()
        }


    }
}