package tanayot.sujipinyo.mypokedex.adapter

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import tanayot.sujipinyo.mypokedex.view.ImageRatioView

object ImageBindingAdapter{
    @JvmStatic
    @BindingAdapter("pokeImage", "progressBar", requireAll = false)
    fun loadImage(imageView: ImageRatioView, imageURL: String?, progressBar: ProgressBar?) {
        progressBar?.visibility = View.VISIBLE
        if(!imageURL.isNullOrEmpty()){
            Glide.with(imageView.context)
                .load(imageURL)
                .addListener(object :RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                       progressBar?.visibility = View.GONE
                        return false
                    }

                })
                .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("pokeName")
    fun setText(view: TextView, text: CharSequence?){
        if(!text.isNullOrEmpty()){
            view.text = text.toString().capitalize()
        }
    }
}