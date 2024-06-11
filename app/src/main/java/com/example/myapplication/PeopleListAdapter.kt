package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleListAdapter(private val list: List<People>) : RecyclerView.Adapter<PeopleListAdapter.MyVH>() {

    class MyVH(val view: View) : RecyclerView.ViewHolder(view) {
        val name : TextView = view.findViewById(R.id.tv_name)
        val cclass : TextView = view.findViewById(R.id.tv_class)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val layout = when(viewType) {
            PEOPLE_1_TYPE -> R.layout.first_year_item
            PEOPLE_2_TYPE -> R.layout.second_year_people
            PEOPLE_3_TYPE -> R.layout.third_year_people
            PEOPLE_4_TYPE -> R.layout.four_year
            else -> {
                Log.d("test", "!!!!!")
            }
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return MyVH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        val ttype = list[position].type
        return when(ttype) {
            0 -> PEOPLE_1_TYPE
            1 -> PEOPLE_2_TYPE
            2 -> PEOPLE_3_TYPE
            3 -> PEOPLE_4_TYPE
            else -> {
                PEOPLE_UNKCNOW_TYPE}
        }
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        val elem = list[position]
        holder.cclass.text = elem.cclass
        holder.name.text = elem.name
    }
    companion object {
        private const val PEOPLE_1_TYPE = 100
        private const val PEOPLE_2_TYPE = 101
        private const val PEOPLE_3_TYPE = 102
        private const val PEOPLE_4_TYPE = 103
        private const val PEOPLE_UNKCNOW_TYPE = 104
    }
}
