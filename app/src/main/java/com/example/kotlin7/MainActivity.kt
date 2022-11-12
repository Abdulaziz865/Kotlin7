package com.example.kotlin7

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private var recyclerView: RecyclerView? = null
//    private var recyclerAdapter: RecyclerAdapter? = null
//    private var moviesList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.recycler_container , FirstFragment())
            .commit()
    }
    }
//        moviesList = ArrayList()
//        moviesList?.add("Iron Man")
//        moviesList?.add("The Incredible Hulk")
//        moviesList?.add("Iron Man 2")
//        moviesList?.add("Thor")
//        moviesList?.add("Captain America: The First Avenger")
//        moviesList?.add("The Avengers")
//        moviesList?.add("Iron Man 3")
//        moviesList?.add("Thor: The Dark World")
//        moviesList?.add("Captain America: The Winter Soldier")
//        moviesList?.add("Guardians of the Galaxy")
//        moviesList?.add("Avengers: Age of Ultron")
//        moviesList?.add("Ant-Man")
//        moviesList?.add("Captain America: Civil War")
//        moviesList?.add("Doctor Strange")
//        moviesList?.add("Guardians of the Galaxy Vol. 2")
//        moviesList?.add("Spider-Man: Homecoming")
//        moviesList?.add("Thor: Ragnarok")
//        moviesList?.add("Black Panther")
//        moviesList?.add("Avengers: Infinity War")
//        moviesList?.add("Ant-Man and the Wasp")
//        moviesList?.add("Captain Marvel")
//        moviesList?.add("Avengers: Endgame")
//        moviesList?.add("Spider-Man: Far From Home")
////        recyclerView = findViewById(R.id.recyclerView)
//        recyclerAdapter = RecyclerAdapter(moviesList as ArrayList<String>)
//        //        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        binding.recyclerView.adapter = recyclerAdapter
//        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
//        recyclerView?.addItemDecoration(dividerItemDecoration)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.search_menu, menu)
//        val menuItem = menu.findItem(R.id.actionSearch)
//        val searchView = menuItem.actionView as SearchView
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                recyclerAdapter!!.filter.filter(newText)
//                return false
//            }
//        })
//        return super.onCreateOptionsMenu(menu)
//    }
//}
