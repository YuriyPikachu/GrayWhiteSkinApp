package io.github.yuriypikachu.gray.white.skin.app.ui

import android.os.Bundle
import io.github.yuriypikachu.gray.white.skin.app.R
import io.github.yuriypikachu.gray.white.skin.app.base.BaseActivity
import io.github.yuriypikachu.gray.white.skin.app.databinding.ActivityMainBinding

/**
 * @author YuLiang
 * update  2020/4/6
 * <a href="YuriyPikachu@163.com">Contact Yuriy</a>
 */
class GrayWhiteSkinActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        binding.tvToNext.apply  {
            text = getString(R.string.back)
            setOnClickListener { finish() }
        }
    }

    override fun isGrayWhiteSkin():Boolean{
        return true
    }

}
