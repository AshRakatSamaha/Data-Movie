package myproject1.ash1.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import myproject1.ash1.data.databinding.ActivityMainBinding
import myproject1.ash1.data.datasource.remote.retfoConfig
import myproject1.ash1.data.model.Movie_responset
import myproject1.ash1.data.util.Constants
import myproject1.ash1.data.util.showToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var newRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        newRecyclerView=binding.recycle
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
    }

    override fun onStart() {
        super.onStart()
        retfoConfig.getServiceInstance().fetchMovie(Constants.API_KEY).
        enqueue(object :Callback<Movie_responset>{

            override fun onResponse(
                call: Call<Movie_responset>,
                response: Response<Movie_responset>
            ) {
               // binding.pro
               if (response.isSuccessful){
                   response.body()?.let { 
                    //  binding.progressLoader.hide()
                       viewMovie(it)
                   }
               }
            }

            override fun onFailure(call: Call<Movie_responset>, t: Throwable) {
                t.message?.let {
                    showToast(it)
                }
            }
        })
    }

    private fun viewMovie(it: Movie_responset) {
        binding.txtdata.text=it.results[0].release_date
      //  binding.textover.text="${it.results}"
       binding.txtTitle.text=it.results[0].original_title
        binding.txtvote.text="${it.results[0].vote_average}"

        Picasso.get().load("${Constants.IMAGES_PATH}${ it.results[0].poster_path}").into(binding.imageView )

    }

}