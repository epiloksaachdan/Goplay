package com.example.goplay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.goplay.MainActivity
import com.example.goplay.adapter.MovieAdapter
import com.example.goplay.R
import com.example.goplay.databinding.PopularFragmentBinding
import com.example.goplay.models.Movie
import com.example.goplay.models.MovieResponse
import com.example.goplay.services.MovieApiInterface
import com.example.goplay.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularFragment : Fragment(R.layout.popular_fragment) {

    private lateinit var binding: PopularFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PopularFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMoviesList.layoutManager = LinearLayoutManager(MainActivity())
        getMovieData { movies : List<Movie> ->
            binding.rvMoviesList.adapter = MovieAdapter(movies)

        }

    }

    private fun getMovieData(callback : (List<Movie>) -> Unit) {

        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMoviePopular().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })

    }
}