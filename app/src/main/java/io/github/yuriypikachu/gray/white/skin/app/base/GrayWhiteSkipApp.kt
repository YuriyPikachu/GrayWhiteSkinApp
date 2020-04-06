package io.github.yuriypikachu.gray.white.skin.app.base

import android.app.Activity
import android.app.Application
import android.os.Bundle


/**
 * @author YuLiang
 * update  2020/4/6
 * <a href="beiming@webuy.ai">Contact me</a>
 */
class GrayWhiteSkipApp : Application() {
    private fun initActivityLifecycleCallbacks() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            //添加监听
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle) {

            }

            override fun onActivityStarted(activity: Activity) {
                //activity启动生命周期
            }

            override fun onActivityResumed(activity: Activity) {
                //activity恢复生命周期
            }

            override fun onActivityPaused(activity: Activity) {
                //activity暂停生命周期
            }

            override fun onActivityStopped(activity: Activity) {
                //activity停止生命周期
            }

            override fun onActivitySaveInstanceState(
                activity: Activity,
                outState: Bundle
            ) {
                //保存activity实例状态
            }

            override fun onActivityDestroyed(activity: Activity) {
                //activity销毁生命周期
            }
        })
    }

}