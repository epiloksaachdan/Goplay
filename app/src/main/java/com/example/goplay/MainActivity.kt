package com.example.goplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.goplay.adapter.MovieAdapter
import com.example.goplay.databinding.ActivityMainBinding
import com.example.goplay.fragment.NowPlayingFragment
import com.example.goplay.fragment.PopularFragment
import com.example.goplay.fragment.TopRatedFragment
import com.example.goplay.fragment.UpcomingFragment
import com.example.goplay.models.Movie
import com.example.goplay.models.MovieResponse
import com.example.goplay.services.MovieApiInterface
import com.example.goplay.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(NowPlayingFragment())

        binding.btnFragment1.setOnClickListener{
            replaceFragment(NowPlayingFragment())
            binding.tvCategories.text = "Now Playing .."
            binding.rvMoviesList.visibility = android.view.View.GONE
        }

        binding.btnFragment2.setOnClickListener{
            replaceFragment(UpcomingFragment())
            binding.tvCategories.text = "Upcoming Movies"
            binding.rvMoviesList.visibility = android.view.View.GONE
        }

        binding.btnFragment3.setOnClickListener{
            replaceFragment(TopRatedFragment())
            binding.tvCategories.text = "Top Rated Movies"
            binding.rvMoviesList.visibility = android.view.View.GONE
        }

        binding.btnFragment4.setOnClickListener{
            replaceFragment(PopularFragment())
            binding.tvCategories.text = "Popular Movies"
            binding.rvMoviesList.visibility = android.view.View.GONE
        }

    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment,fragment)
        fragmentTransaction.commit()
    }

}