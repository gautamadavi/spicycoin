package com.launch.spicycoin.application.ui.hotlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.launch.spicycoin.R
import com.launch.spicycoin.application.viewmodel.HotListViewModel

class HotListFragment : Fragment() {

    private lateinit var dashboardViewModel: HotListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hot_list, container, false)
    }
}
