package com.ankit.storyviewsample.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ankit.storyviewsample.R
import com.ankit.storyviewsample.adapters.StoriesAdapter
import com.ankit.storyviewsample.models.StoryModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecycler()
    }

    private fun setUpRecycler() {
        val list = ArrayList<StoryModel>()
        val storyModel = StoryModel("https://homepages.cae.wisc.edu/~ece533/images/airplane.png")
        val storyModel2 = StoryModel("https://homepages.cae.wisc.edu/~ece533/images/girl.png")
        val storyModel3 = StoryModel("https://homepages.cae.wisc.edu/~ece533/images/monarch.png")
        val storyModel4 = StoryModel("https://homepages.cae.wisc.edu/~ece533/images/fruits.png")
        val storyModel5= StoryModel("https://homepages.cae.wisc.edu/~ece533/images/tulips.png")
        val storyModel6 = StoryModel("https://homepages.cae.wisc.edu/~ece533/images/pool.png")


        list.add(storyModel)
        list.add(storyModel2)
        list.add(storyModel3)
        list.add(storyModel4)
        list.add(storyModel5)
        list.add(storyModel6)


        val recyclerStories = findViewById<View>(R.id.recyclerStories) as RecyclerView





        // use this if you want the RecyclerView to look like a horizontal list view
        val linearLayoutManager= LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation=LinearLayoutManager.HORIZONTAL
        recyclerStories.layoutManager=linearLayoutManager




        val adapter = StoriesAdapter(list, this@MainActivity)
        recyclerStories.adapter = adapter
    }
}