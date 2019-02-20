package motivation.opencv_facedetection

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.core.*
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc
import org.opencv.objdetect.CascadeClassifier
import org.opencv.objdetect.Objdetect
import java.io.InputStream
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OpenCVLoader.initDebug()

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
                    val input: InputStream = contentResolver.openInputStream(data!!.data)
                    val tempBitmap= BitmapFactory.decodeStream(input)
                    var bitmapImage =   tempBitmap.copy(Bitmap.Config.ARGB_8888,true)
                    var mat = Mat(bitmapImage.width, bitmapImage.height, CvType.CV_8UC1)
                    Utils.bitmapToMat(bitmapImage, mat)
                    Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2GRAY)
                    Utils.matToBitmap(mat, bitmapImage)
                    faceImage.setImageBitmap(bitmapImage)
                    faceDetect(mat)

                    input.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun faceDetect(mat: Mat){
        makeTaost("faceDetect fun")
        val faceFile= "src\\main\\res\\haarcascade_frontalface_default.xml"
        makeTaost("faceFile")
        val cascade = CascadeClassifier(faceFile)
        makeTaost("cascade")
        var faces = MatOfRect()
        makeTaost("faces")
        cascade.detectMultiScale(mat, faces)
        makeTaost("detect face")
        var faceArray = faces.toArray()
        makeTaost("face array")
    }

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    fun makeTaost(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}
