package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingM: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        bindingM = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingM.root)

        bindingM.addId.setOnClickListener {

            val intent = Intent(this, AddActivity::class.java)

            startActivity(intent)

        }

        bindingM.listId.setOnClickListener {

            val intent = Intent(this, ToDoListActivity::class.java)
            startActivity(intent)


        }

    }
}