package com.example.kotlin7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin7.databinding.ItemRecyclerBinding
import java.util.*

class RecyclerAdapter(moviesList: MutableList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(), Filterable {

    private lateinit var binding: ItemRecyclerBinding
    var moviesList: List<String>? = null
    private var moviesListAll: MutableList<String>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rowCountTextView.text = position.toString()
        holder.textView.text = moviesList!![position]
    }

    override fun getItemCount(): Int {
        return moviesList!!.size
    }

   override fun getFilter(): Filter {
        return myFilter
    }

    private var myFilter: Filter = object : Filter() {
        //Automatic on background thread
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filteredList: MutableList<String> = ArrayList()
            if (charSequence.isEmpty()) {
                filteredList.addAll(moviesListAll!!)
            } else {
                for (movie in moviesListAll!!) {
                    if (movie.lowercase(Locale.getDefault()).contains(
                            charSequence.toString().lowercase(
                                Locale.getDefault()
                            )
                        )
                    ) {
                        filteredList.add(movie)
                    }
                }
            }
            val filterResults = FilterResults()
            filterResults.values = filteredList
            return filterResults
        }

        override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
            moviesList.clear()
            moviesList.addAll((filterResults.values as Collection<String>))
            notifyDataSetChanged()
        }
    }

    init {
        this.moviesList = moviesList
        moviesListAll = ArrayList()
        moviesListAll!!.addAll(moviesList)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private var imageView: ImageView
        var textView: TextView
        var rowCountTextView: TextView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textView)
            rowCountTextView = itemView.findViewById(R.id.rowCountTextView)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            Toast.makeText(view.context, moviesList!![adapterPosition], Toast.LENGTH_SHORT).show()
        }
    }

}