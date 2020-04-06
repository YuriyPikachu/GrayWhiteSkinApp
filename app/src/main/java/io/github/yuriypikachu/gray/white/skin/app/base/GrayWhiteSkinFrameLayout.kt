package io.github.yuriypikachu.gray.white.skin.app.base

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.FrameLayout


/**
 * @author YuLiang
 * update  2020/4/6
 * <a href="YuriyPikachu@163.com">Contact Yuriy</a>
 */
class GrayWhiteSkinFrameLayout(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    private val paint = Paint().apply {
       ColorMatrix().apply {
            setSaturation(0f)
        }.let {
           colorFilter = ColorMatrixColorFilter(it)
       }
    }

    override fun dispatchDraw(canvas: Canvas) {
        canvas.saveLayer(null, paint)
        super.dispatchDraw(canvas)
        canvas.restore()
    }

    override fun draw(canvas: Canvas) {
        canvas.saveLayer(null, paint)
        super.draw(canvas)
        canvas.restore()
    }
}