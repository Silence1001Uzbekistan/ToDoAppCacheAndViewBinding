package com.example.todoapp

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.Adapters.SpinnerBaseAdapter
import com.example.todoapp.Cache.MySharedPreferenceColour
import com.example.todoapp.Cache.MySharedPreferenceUserClass
import com.example.todoapp.Cache.MySharedPreferenceTwo
import com.example.todoapp.ClassFolders.NameClass
import com.example.todoapp.ClassFolders.SpinnerClass
import com.example.todoapp.ClassFolders.UserClass
import com.example.todoapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private lateinit var bindingA: ActivityAddBinding

    lateinit var listSpinner: ArrayList<SpinnerClass>
    lateinit var listExpandable:ArrayList<UserClass>

    lateinit var listExpaString:ArrayList<NameClass>

    lateinit var spinnerBaseAdapter: SpinnerBaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        bindingA = ActivityAddBinding.inflate(layoutInflater)
        setContentView(bindingA.root)

        supportActionBar?.title = "Add todo"

        bindingA.editDegreeId.isEnabled = false


        MySharedPreferenceTwo.init(this)

        MySharedPreferenceColour.init(this)

        MySharedPreferenceUserClass.init(this)

        loadData()

        listExpandable = ArrayList()
        listExpaString = ArrayList()

       // listExpandable = MySharedPreference.obyekString
        listExpandable = MySharedPreferenceUserClass.obyekString
        listExpaString = MySharedPreferenceTwo.obyekString

        spinnerBaseAdapter = SpinnerBaseAdapter(listSpinner)

        bindingA.editDegreeSpinnerId.adapter = spinnerBaseAdapter

        //Toast.makeText(this, "${MySharedPreference.obyekString.size}", Toast.LENGTH_SHORT).show()

        bindingA.saveId.setOnClickListener {

            val itemPosition = bindingA.editDegreeSpinnerId.selectedItemPosition

            Toast.makeText(this, "$itemPosition bosildi", Toast.LENGTH_SHORT).show()

            MySharedPreferenceColour.user = itemPosition


            if (bindingA.editNameID.text.trim().isNotEmpty() && bindingA.editDescriptionId.text.trim().isNotEmpty() && bindingA.editCreateDataId.text.trim().isNotEmpty() && bindingA.editCreateDataId.text.trim().isNotEmpty()){

                val userClass = UserClass(
                    0,
                    bindingA.editNameID.text.toString(),
                    itemPosition,
                    bindingA.editCreateDataId.text.toString(),
                    bindingA.editDedlineId.text.toString(),
                    bindingA.editDedlineId.text.toString()
                )

                val nameClass = NameClass(bindingA.editNameID.text.toString())

                listExpandable.add(userClass)
                listExpaString.add(nameClass)


          //      MySharedPreference.obyekString = listExpandable
                MySharedPreferenceTwo.obyekString = listExpaString

                MySharedPreferenceUserClass.obyekString = listExpandable

/*                for (i in 0 until MySharedPreference.obyekString.size){
                    Toast.makeText(this, "${listExpandable[i].name}", Toast.LENGTH_SHORT).show()
                }*/

            }else{
                Toast.makeText(this, "To'g'ri kiriting", Toast.LENGTH_SHORT).show()
            }

        }



    }

    private fun loadData() {


        listSpinner = ArrayList()

        listSpinner.add(SpinnerClass(R.color.red))
        listSpinner.add(SpinnerClass(R.color.yellow))
        listSpinner.add(SpinnerClass(R.color.blue))
        listSpinner.add(SpinnerClass(R.color.gray))

    }
}