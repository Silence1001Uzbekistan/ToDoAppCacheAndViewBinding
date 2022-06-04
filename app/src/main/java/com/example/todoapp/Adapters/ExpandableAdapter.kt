package com.example.todoapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.todoapp.R
import com.example.todoapp.ClassFolders.UserClass

class ExpandableAdapter(
    var titleList: List<String>,
    var hashMap: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {

        return titleList.size

    }

    override fun getChildrenCount(groupPosition: Int): Int {

        return hashMap[titleList[groupPosition]]!!.size


    }

    override fun getGroup(groupPosition: Int): Any {

        return titleList[groupPosition]

    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {

        return hashMap[titleList[groupPosition]]!![childPosition]


    }

    override fun getGroupId(groupPosition: Int): Long {

        return groupPosition.toLong()

    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {

        return childPosition.toLong()

    }

    override fun hasStableIds(): Boolean {

        return true

    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        var groupItemView: View

        if (convertView == null) {

            groupItemView =
                LayoutInflater.from(parent!!.context).inflate(R.layout.group_item, parent, false)

        } else {

            groupItemView = convertView

        }

        groupItemView.findViewById<TextView>(R.id.textGroupId).text = titleList[groupPosition]

        return groupItemView

    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        var childItemView: View

        if (convertView == null) {

            childItemView =
                LayoutInflater.from(parent!!.context).inflate(R.layout.child_item, parent, false)

        } else {

            childItemView = convertView

        }

        childItemView.findViewById<TextView>(R.id.textChildId).text =
            hashMap[titleList[groupPosition]]!![childPosition].toString()

        return childItemView

    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}