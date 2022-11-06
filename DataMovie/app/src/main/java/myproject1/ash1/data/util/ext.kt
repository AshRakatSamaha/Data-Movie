package myproject1.ash1.data.util

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(message:String) {
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}