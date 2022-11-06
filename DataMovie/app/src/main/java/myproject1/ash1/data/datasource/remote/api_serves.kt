package myproject1.ash1.data.datasource.remote

import android.provider.MediaStore
import myproject1.ash1.data.model.Movie_responset
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServes {
    @GET("3/movie/popular")
    fun fetchMovie(@Query("api_key") key:String):Call<Movie_responset>
}