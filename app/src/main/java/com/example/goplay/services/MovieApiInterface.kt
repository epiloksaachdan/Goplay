package com.example.goplay.services
import com.example.goplay.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/top_rated?api_key=fa8c19bddbc82cd44f43a1e10a4126a6")
    fun getMovieTopRated(): Call<MovieResponse>

    @GET("/3/movie/popular?api_key=fa8c19bddbc82cd44f43a1e10a4126a6")
    fun getMoviePopular(): Call<MovieResponse>

    @GET("/3/movie/now_playing?api_key=fa8c19bddbc82cd44f43a1e10a4126a6&language=en-US&page=1")
    fun getMovieNowPlaying(): Call<MovieResponse>

    @GET("/3/movie/upcoming?api_key=fa8c19bddbc82cd44f43a1e10a4126a6")
    fun getMovieUpcoming(): Call<MovieResponse>

}