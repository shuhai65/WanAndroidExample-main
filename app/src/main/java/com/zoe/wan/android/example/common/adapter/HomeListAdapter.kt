package com.zoe.wan.android.example.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zoe.wan.android.example.R
import com.zoe.wan.android.example.databinding.ItemHomeListBinding
import com.zoe.wan.android.example.repository.data.HomeListData
import com.zoe.wan.android.example.repository.data.HomeListItemData

class HomeListAdapter : RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {
    private var dataList: List<HomeListItemData?> = mutableListOf()
    fun setData(list: List<HomeListItemData>) {
        if (list != null && list.isNotEmpty()) {
            dataList = list
            notifyDataSetChanged()
        }
    }

    class HomeListViewHolder(binding: ItemHomeListBinding) : RecyclerView.ViewHolder(binding.root) {
        var itemBinding: ItemHomeListBinding

        init {
            itemBinding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        return HomeListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        val item = dataList[position]
        holder.itemBinding.item = item
        if (item != null) {
            if (item.collect) {
                holder.itemBinding.homeItemCollect.setBackgroundResource(R.drawable.img_collect)
            } else
                holder.itemBinding.homeItemCollect.setBackgroundResource(R.drawable.img_collect_grey)
        }
    }
}