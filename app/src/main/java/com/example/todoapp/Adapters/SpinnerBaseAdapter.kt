package com.example.todoapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.todoapp.R
import com.example.todoapp.ClassFolders.SpinnerClass

class SpinnerBaseAdapter(var list: List<SpinnerClass>) : BaseAdapter() {
    override fun getCount(): Int {

        return list.size

    }

    override fun getItem(position: Int): Any {

        return list[position]

    }

    override fun getItemId(position: Int): Long {

        return position.toLong()

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var spinnerItemView: View
        if (convertView == null) {

            spinnerItemView =
                LayoutInflater.from(parent!!.context).inflate(R.layout.spinner_item, parent, false)

        } else {

            spinnerItemView = convertView

        }

        spinnerItemView.findViewById<ImageView>(R.id.spinnerImageId)
            .setImageResource(list[position].imageSpinner)

        return spinnerItemView

    }
}