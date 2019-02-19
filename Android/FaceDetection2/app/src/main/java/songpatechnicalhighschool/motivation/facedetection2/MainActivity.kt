package songpatechnicalhighschool.motivation.facedetection2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.FaceDetector
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    lateinit var uri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        faceButton.setOnClickListener {
            faceDetect()
        }

        selectImage.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                try {
                    uri = data!!.data
                    val input: InputStream = contentResolver.openInputStream(data!!.data)
                    val img: Bitmap = BitmapFactory.decodeStream(input)
                    faceImage.setImageBitmap(img)
                    input.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun faceDetect(){

    }
}
