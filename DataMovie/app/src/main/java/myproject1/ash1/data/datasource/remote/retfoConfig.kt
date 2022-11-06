package myproject1.ash1.data.datasource.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object retfoConfig {
  private  fun getRetInstance():Retrofit {
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/").
        addConverterFactory(GsonConverterFactory.create()).build()
    }
    fun getServiceInstance():ApiServes{
       return getRetInstance().create<ApiServes>()
    }
}