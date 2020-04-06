package io.github.yuriypikachu.gray.white.skin.app.ui

import android.content.Intent
import android.os.Bundle
import io.github.yuriypikachu.gray.white.skin.app.base.BaseActivity
import io.github.yuriypikachu.gray.white.skin.app.databinding.ActivityMainBinding


/**
 * @author YuLiang
 * update  2020/4/6
 * <a href="YuriyPikachu@163.com">Contact Yuriy</a>
 */
class ColorSkinActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        binding.tvToNext.setOnClickListener {
            startActivity(Intent(this,
                GrayWhiteSkinActivity::class.java))
        }
    }
}
