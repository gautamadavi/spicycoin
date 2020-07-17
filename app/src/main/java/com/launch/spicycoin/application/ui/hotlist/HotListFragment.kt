package com.launch.spicycoin.application.ui.hotlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseExpandableListAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.launch.spicycoin.R
import com.launch.spicycoin.application.viewmodel.HotListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_hot_list.*
import javax.inject.Inject

@AndroidEntryPoint
class HotListFragment : Fragment() {

    private val hotListViewModel: HotListViewModel by viewModels()
    private lateinit var viewManager: RecyclerView.LayoutManager
    //private lateinit var listAdapter: Adapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hot_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        watchList.apply {
            layoutManager = viewManager
        }
        hotListViewModel.downloadCoinList().map {
            if(it.isSuccessful){
                it.body()
            }else{
                Toast.makeText(view.context, "There was an error. Trying again...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
