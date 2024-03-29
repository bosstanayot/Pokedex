package tanayot.sujipinyo.mypokedex.view

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatImageView
import tanayot.sujipinyo.mypokedex.R

class ImageRatioView : AppCompatImageView {

    var imageOrientation: Int? = 0
    var imageRatio: Int? = 0
    val LANDSCAPE  = 0
    val PORTRAIT = 1
    val SQUARE = 0
    val RATIO_2_1 = 1
    val RATIO_2_1_DIVISION = 0.5
    val PIXEL_PERFECT = 1

    constructor(context: Context) : super(context)

    constructor(context: Context, @Nullable attrs: AttributeSet) : this(context, attrs, 0)

    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        val typedArray = context.obtainStyledAttributes(attrs,
            R.styleable.ImageRatioView
        )
        imageOrientation = typedArray.getInt(R.styleable.ImageRatioView_imageOrientation, 0)
        imageRatio = typedArray.getInt(R.styleable.ImageRatioView_imageRatio, 0)

        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var width =  MeasureSpec.getSize(widthMeasureSpec)
        var height = MeasureSpec.getSize(heightMeasureSpec)

        when(imageOrientation) {
            LANDSCAPE -> {
                height = calculateRatio(width)
            }
            PORTRAIT -> {
                width = calculateRatio(height)
            }
        }

        width += PIXEL_PERFECT
        height += PIXEL_PERFECT

        this.setMeasuredDimension(width , height)
        this.layoutParams.width = width
        this.layoutParams.height = height
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


    private fun calculateRatio(measureSpec: Int) : Int {
        return when (imageRatio) {
            SQUARE -> measureSpec
            RATIO_2_1 -> (measureSpec * RATIO_2_1_DIVISION).toInt()
            else -> {
                0
            }
        }
    }
}