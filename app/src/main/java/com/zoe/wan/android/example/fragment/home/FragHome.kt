package com.zoe.wan.android.example.fragment.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.zoe.wan.android.example.BR
import com.zoe.wan.android.example.R
import com.zoe.wan.android.example.common.adapter.HomeListAdapter
import com.zoe.wan.android.example.databinding.FragmentHomeBinding
import com.zoe.wan.base.BaseFragment

class FragHome : BaseFragment<FragmentHomeBinding, FragHomeViewModel>() {

    private val adapter: HomeListAdapter = HomeListAdapter()
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun getViewModelId(): Int {
        return BR.homeVm
    }

    override fun initViewData() {
        binding?.homeListView?.layoutManager = LinearLayoutManager(context)
        binding?.homeListView?.adapter = adapter
        viewModel?.list?.observe(viewLifecycleOwner) {
            it?.let { it1 -> adapter.setData(it1) }
        }
        viewModel?.bannerData?.observe(viewLifecycleOwner) {
            it?.let { it1 -> adapter.setBannerData(it1) }
        }
    }
}