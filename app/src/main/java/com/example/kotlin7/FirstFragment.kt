package com.example.kotlin7

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin7.databinding.ActivityMainBinding
import com.example.kotlin7.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var recyclerView: RecyclerView? = null
    private var recyclerAdapter: RecyclerAdapter? = null
    private var moviesList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        moviesList = ArrayList()
        moviesList?.add("Iron Man")
        moviesList?.add("The Incredible Hulk")
        moviesList?.add("Iron Man 2")
        moviesList?.add("Thor")
        moviesList?.add("Captain America: The First Avenger")
        moviesList?.add("The Avengers")
        moviesList?.add("Iron Man 3")
        moviesList?.add("Thor: The Dark World")
        moviesList?.add("Captain America: The Winter Soldier")
        moviesList?.add("Guardians of the Galaxy")
        moviesList?.add("Avengers: Age of Ultron")
        moviesList?.add("Ant-Man")
        moviesList?.add("Captain America: Civil War")
        moviesList?.add("Doctor Strange")
        moviesList?.add("Guardians of the Galaxy Vol. 2")
        moviesList?.add("Spider-Man: Homecoming")
        moviesList?.add("Thor: Ragnarok")
        moviesList?.add("Black Panther")
        moviesList?.add("Avengers: Infinity War")
        moviesList?.add("Ant-Man and the Wasp")
        moviesList?.add("Captain Marvel")
        moviesList?.add("Avengers: Endgame")
        moviesList?.add("Spider-Man: Far From Home")

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerAdapter = RecyclerAdapter(moviesList as ArrayList<String>)
//        recyclerView?.layoutManager = LinearLayoutManager(context);
        binding.recyclerView.adapter = recyclerAdapter
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerView?.addItemDecoration(dividerItemDecoration)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.search_menu, menu)
        val searchView =
            ((context as MainActivity).supportActionBar?.themedContext ?: context)?.let {
                SearchView(
                    it
                )
            }
        menu.findItem(R.id.action_search).apply {
            setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW or MenuItem.SHOW_AS_ACTION_IF_ROOM)
            actionView = searchView
        }

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        searchView?.setOnClickListener { _ -> }
    }
//    private lateinit var binding: ActivityMainBinding
//    private var recyclerView: RecyclerView? = null
//    private var recyclerAdapter: RecyclerAdapter? = null
//    private var moviesList: ArrayList<String>? = null
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//       binding = ActivityMainBinding.inflate(inflater,container,false)
//        return binding.root
//
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
//        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
//        recyclerView?.addItemDecoration(dividerItemDecoration)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        val menuItem = menu.findItem(R.id.action_search)
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
//        return super.onCreateOptionsMenu(menu, inflater)
//    }
}