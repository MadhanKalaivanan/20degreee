package com.t.a20degree

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.t.a20degree.databinding.ActivityMainBinding
import com.t.a20degree.repository.TwitterRepository
import com.t.a20degree.viewmodel.TwitterViewModel
import com.t.a20degree.viewmodel.TwitterViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TwitterViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        viewModel = ViewModelProvider(this, TwitterViewModelFactory(TwitterRepository())).get(TwitterViewModel::class.java)

        viewModel.data.observe(this){
            //data can be updated in ui here
        }
    }

}