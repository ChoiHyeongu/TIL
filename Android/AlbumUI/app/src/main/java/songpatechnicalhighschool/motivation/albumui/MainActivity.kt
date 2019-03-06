package songpatechnicalhighschool.motivation.albumui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var galleryAdapter: GalleryAdapter
    var imageList = ArrayList<Image>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(i in 1..100){
            imageList.add(Image(20190306, R.mipmap.sample, "place"))
        }
        galleryAdapter = GalleryAdapter(imageList, this)
        main_gallery.adapter = galleryAdapter
    }
}
