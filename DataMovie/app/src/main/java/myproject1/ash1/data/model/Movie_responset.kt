package myproject1.ash1.data.model

import android.database.CursorJoiner
import android.provider.MediaStore
import okhttp3.Response
import org.intellij.lang.annotations.Language
import javax.xml.transform.Result

data class Movie_responset ( val page:Int,
                             val results:List<Results>,
                              val total_pages:Int,
                               val total_results: Int)


data class Results(val id :Int,
                   val backdrop_path:String,
                   val overview :String,
                   val poster_path: String,
                    val vote_average :Double,
                    val release_date: String,
                   val original_title:String)
