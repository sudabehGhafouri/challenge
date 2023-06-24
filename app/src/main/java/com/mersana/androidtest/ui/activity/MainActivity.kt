package com.mersana.androidtest.ui.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mersana.androidtest.R
import com.mersana.androidtest.base.BaseActivity
import com.mersana.androidtest.database.DataBase
import com.mersana.androidtest.databinding.ActivityMainBinding
import com.mersana.androidtest.ui.adapter.MainAdapter
import com.mersana.androidtest.ui.adapter.MainLoadStateAdapter
import com.mersana.androidtest.viewModel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class MainActivity : BaseActivity<MainViewModel,ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        /**
         * for insert DB information only install app
         */

        val   prefs = getSharedPreferences(
            "my.app.packagename_preferences", Context.MODE_PRIVATE)
        if (!prefs.getBoolean("firstTime", false)) {

            viewModel.initDatabase()
            val editor = prefs.edit()
            editor.putBoolean("firstTime", true)
            editor.commit()
        }


        viewModel.click.observe(this, Observer {

                    val intent = Intent(this@MainActivity, CommentsActivity::class.java)
                    intent.putExtra("Post",it )
                    startActivity(intent)
        })

//        val adapter = MainAdapter(viewModel)
//        binding.recyclerViewPostMainActivity.adapter = adapter.withLoadStateFooter(
//            MainLoadStateAdapter()
//        )
//
//        lifecycleScope.launch {
//            viewModel.dataMyPager.collectLatest {
//                adapter.submitData(it)
//            }
//        }
    }

    override fun onResume() {
        super.onResume()

        val adapter = MainAdapter(viewModel)
        binding.recyclerViewPostMainActivity.adapter = adapter.withLoadStateFooter(
            MainLoadStateAdapter()
        )
        lifecycleScope.launch {
            viewModel.dataMyPager.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun getResourceLayoutId(): Int =R.layout.activity_main

    override fun getClassViewModel(): Class<MainViewModel> {

     return   MainViewModel::class.java
    }

    override fun getFactory(): ViewModelProvider.Factory {

        return MainViewModel.Factory(DataBase.getInstance(this).postDao())}
}