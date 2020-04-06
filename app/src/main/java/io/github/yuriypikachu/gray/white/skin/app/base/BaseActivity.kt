package io.github.yuriypikachu.gray.white.skin.app.base

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * @author YuLiang
 * update  2020/4/6
 * <a href="YuriyPikachu@163.com">Contact Yuriy</a>
 */
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        if (FRAME_LAYOUT == name && isGrayWhiteSkin()) {
            attrs.apply {
                for (i in 0 until attributeCount) {
                    getAttributeName(i).takeIf {
                        it == ID
                    }?.let {
                        getAttributeValue(i).substring(1).toInt()
                    }?.takeIf {
                        CONTENT == resources.getResourceName(it)
                    }.let {
                        return GrayWhiteSkinFrameLayout(context, attrs)
                    }
                }
            }
        }
        return super.onCreateView(name, context, attrs)
    }

    open fun isGrayWhiteSkin(): Boolean {
        return false
    }

    companion object {
        private const val FRAME_LAYOUT = "FrameLayout"
        private const val ID = "id"
        private const val CONTENT = "android:id/content"
    }
}
