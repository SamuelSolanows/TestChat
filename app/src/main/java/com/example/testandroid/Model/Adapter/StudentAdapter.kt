package com.example.testandroid.Model.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.testandroid.Model.Models.Students
import com.example.testandroid.databinding.ItemStudentsBinding

class StudentAdapter(var list: MutableList<Students>) :
    RecyclerView.Adapter<StudentAdapter.Holder>() {
    inner class Holder(var binding: ItemStudentsBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemStudentsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var student = list[position]
        var bind = holder.binding
        student.apply {
            bind.apply {
                txtNombre.text = FirstName
                txtApellido.text = LastName

            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}