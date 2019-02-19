package songpatechnicalhighschool.motivation.facedetection

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Bitmap
import android.util.SparseArray
import android.widget.Toast
import com.google.android.gms.vision.Frame
import com.google.android.gms.vision.face.Face
import com.google.android.gms.vision.face.FaceDetector
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import com.google.android.gms.vision.face.Landmark
import java.io.InputStream
import java.lang.Exception


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
                    Toast.makeText(this, uri.toString(), Toast.LENGTH_LONG).show()
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

    fun faceDetect() {
        val option = BitmapFactory.Options()
        option.inMutable = true

        val myBitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(uri), null, option)

        val myRectPaint = Paint()
//        myRectPaint.strokeWidth = 3F
//        myRectPaint.color = Color.RED
//        myRectPaint.style = Paint.Style.STROKE
        val blur = BlurMaskFilter(30F, BlurMaskFilter.Blur.NORMAL)
        myRectPaint.maskFilter = blur


        val pnt = Paint()
        pnt.color = Color.GREEN
        pnt.strokeWidth = 5F
        pnt.style = Paint.Style.STROKE

        val tempBitmap = Bitmap.createBitmap(myBitmap.width, myBitmap.height, Bitmap.Config.RGB_565)
        val tempCanvas = Canvas(tempBitmap)
        tempCanvas.drawBitmap(myBitmap, 0F, 0F, null)

        val faceDetector = FaceDetector.Builder(applicationContext).setTrackingEnabled(false).setLandmarkType(FaceDetector.ALL_LANDMARKS).build()

        if (!faceDetector.isOperational) {
            Toast.makeText(applicationContext, "Could not set up the face detector!", Toast.LENGTH_LONG).show()
        }

        val frame = Frame.Builder().setBitmap(myBitmap).build()
        val faces: SparseArray<Face> = faceDetector.detect(frame)

        Toast.makeText(this, faces.size().toString(), Toast.LENGTH_LONG).show()
        for (i in 0 until faces.size()) {
            val thisFace = faces.valueAt(i)
            val x1 = thisFace.position.x
            val y1 = thisFace.position.y
            val x2 = x1 + thisFace.width
            val y2 = y1 + thisFace.height
            tempCanvas.drawCircle(x2, y2, 10F, myRectPaint)

            val landmarks: List<Landmark> = thisFace.landmarks
            //for make landmark circle
            for (j in 0 until landmarks.size) {
                val thisLand = landmarks[j]
                val landx = thisLand.position.x
                val landy = thisLand.position.y
                tempCanvas.drawCircle(landx, landy, 10F, pnt)
            }
        }
        faceImage.setImageDrawable(BitmapDrawable(resources, tempBitmap))
        faceDetector.release()
    }

}
