package com.kpa.gotostudymvp.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kpa.gotostudymvp.R
import com.kpa.gotostudymvp.data.Subject

/**
 *author: mr.kong
 *Date:2018/9/19
 *description:
 *project name:gotoStudyMvp
 **/
class HomeCustomAdapter(private var mContext: Context, private var data: MutableList<Subject>) : RecyclerView.Adapter<HomeCustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.home_recycle_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val subject = data[position]
        Glide.with(mContext).load(subject.images.medium).into(holder.imageTv)
        holder.nameTv.text = subject.title
        holder.originalTv.text = subject.original_title
        holder.timeTv.text = "${subject.year}年"
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var imageTv: ImageView = itemView.findViewById(R.id.home_recycle_iv)
        internal var nameTv: TextView = itemView.findViewById(R.id.home_recycle_name_tv)
        internal var originalTv: TextView = itemView.findViewById(R.id.home_recycle_original_title_tv)
        internal var timeTv: TextView = itemView.findViewById(R.id.home_recycle_time_tv)
    }
}