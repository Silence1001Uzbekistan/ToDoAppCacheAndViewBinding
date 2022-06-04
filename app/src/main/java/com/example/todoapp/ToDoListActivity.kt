package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.Adapters.ExpandableAdapter
import com.example.todoapp.Cache.MySharedPreferenceTwo
import com.example.todoapp.ClassFolders.UserClass
import com.example.todoapp.databinding.ActivityToDoListBinding

class ToDoListActivity : AppCompatActivity() {

    private lateinit var bindingTD: ActivityToDoListBinding

    lateinit var hashMap: HashMap<String, List<String>>
    lateinit var titleList: ArrayList<String>

    lateinit var arrayList: ArrayList<UserClass>
    lateinit var arrayListTwo: ArrayList<String>

    lateinit var expandableAdapter: ExpandableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        bindingTD = ActivityToDoListBinding.inflate(layoutInflater)
        setContentView(bindingTD.root)

        supportActionBar?.title = "To do list"

        loadData()

        expandableAdapter = ExpandableAdapter(titleList, hashMap)

        bindingTD.expandableListId.setAdapter(expandableAdapter)


    }

    private fun loadData() {

        MySharedPreferenceTwo.init(this)


        hashMap = HashMap()
        titleList = ArrayList()
        arrayList = ArrayList()

        arrayListTwo = ArrayList()


        for (i in 0 until MySharedPreferenceTwo.obyekString.size) {

            arrayListTwo.add(MySharedPreferenceTwo.obyekString[i].name!!)

        }



        hashMap["Open"] = arrayListTwo
        hashMap["Development"] = arrayListOf("")
        hashMap["Uploading"] = arrayListOf("")
        hashMap["Reject"] = arrayListOf("")
        hashMap["Closed"] = arrayListOf("")

        titleList = ArrayList()
        titleList.add("Open")
        titleList.add("Development")
        titleList.add("Uploading")
        titleList.add("Reject")
        titleList.add("Closed")

        childView()

    }

    private fun childView() {

        bindingTD.expandableListId.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->

            Toast.makeText(this, titleList[groupPosition], Toast.LENGTH_SHORT).show()

            Toast.makeText(
                this,
                hashMap[titleList[groupPosition]]!![childPosition],
                Toast.LENGTH_SHORT
            ).show()

            val s: String = hashMap[titleList[groupPosition]]!![childPosition]

            val intent = Intent(this, DataActivity::class.java)



            intent.putExtra("a", groupPosition)

            intent.putExtra("b", s)

            intent.putExtra("c", childPosition)

            startActivity(intent)

            true

        }

    }
}