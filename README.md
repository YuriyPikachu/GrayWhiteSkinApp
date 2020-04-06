# Android App 如何快速实现灰白化效果？
## 原因
清明期间不少客户端都上了灰白皮肤的效果，那我们客户端究竟如何实现黑白皮肤效果呢？本篇文章分享一种方式，让大家在客户端快速的进行黑白化换肤。
## 效果
彩色效果
![-w315](https://tva1.sinaimg.cn/large/00831rSTly1gdkd8ga8zrj30hi0v2tb6.jpg)
灰白化后效果
![-w315](https://tva1.sinaimg.cn/large/00831rSTly1gdkbhy6vfqj30hk0v60v0.jpg)
## 需要基础知识
有些知识不在文章当中阐述，不知道的同学可以自行Google，百度后再看。

如下：kotlin，Activity 的生命周期，viewBinding。

## View 如何变灰白化？
1、碰到这种情况，肯定我们要自定义View将他画出来了。然后我们操作Paint画就行了。

2、那我们如何自定义View画呢？有个类叫ColorMatrix，我们将他setSaturation(0f)，用获得的对象再给ColorMatrixColorFilter，对Paint当中的colorFilter进行赋值就可以了。最后用这个Paint画就可以了。实现代码如下：
```java
private val paint = Paint().apply {
       ColorMatrix().apply {
            setSaturation(0f)
        }.let {
           colorFilter = ColorMatrixColorFilter(it)
       }
}
```
## Activity 如何变为灰白皮肤的呢？
如上操作后，我们已经知道了自定义View进行灰白化？

那我们怎么对一个Acitivity 进行灰白化呢？

不可能每一个View都去自定义View？

其实一个Activity的产出是有层级的View Three。不知道的同学可以打开Android Studio -> Tools -> Layout Inspector。如下
![](https://tva1.sinaimg.cn/large/00831rSTly1gdkc9mh2k5j30pm0e6aai.jpg)

经过分析，我们写的布局是在ContentFrameLayout下面，因此只要我们替换了ContentFrameLayout，根据View的绘制原理，我们就可以对该布局下的所有View的Paint进行修改了。

那我们如何替换ContentFrameLayout，请回到 Activity 的生命周期，有个方法叫 onCreateView。代码如下，我们把ContentFrameLayout替换成我们的GrayWhiteSkinFrameLayout。
![](https://tva1.sinaimg.cn/large/00831rSTly1gdkcpdurm7j30ye0i2t9h.jpg)

那我们GrayWhiteSkinFrameLayout类里做了什么呢？代码如下
![](https://tva1.sinaimg.cn/large/00831rSTly1gdkcl8db76j31400puab4.jpg)

## app 如何全部变为灰白皮肤的呢？
实现父类的BaseActivity，子类继承就可以了，具体如下。
![](https://tva1.sinaimg.cn/large/00831rSTly1gdkcqb40qzj30u00uztab.jpg)

##Flutter 如何变灰白皮肤的呢？
道理都是一样的，Flutter也是有层级的。我们只需要在最外层的Widget的Build 复写如下代码就好了。

```java
@override
Widget build(BuildContext context) {
  return ColorFiltered(
      colorFilter: ColorFilter.mode(Colors.grey, BlendMode.color),
      child: Scaffold(
        appBar: _appBar,
        body: IndexedStack(
          index: _currIndex,
          children: <Widget>[HomeItemPage(), WidgetPage(), MyPage()],
        ),
        backgroundColor: Theme.of(context).backgroundColor,
        bottomNavigationBar: _buildBottomNavigationBar(context),
      ));
}
```

Demo 地址，欢迎点star：[https://github.com/YuriyPikachu/GrayWhiteSkinApp](https://github.com/YuriyPikachu/GrayWhiteSkinApp)

## 了解更多，欢迎关注：
* 博客：[https://YuriyPikachu.github.io](https://YuriyPikachu.github.io)
* github：[https://github.com/YuriyPikachu](https://github.com/YuriyPikachu)
* QQ技术交流群：389274438
* csdn：[https://blog.csdn.net/pjingying](https://blog.csdn.net/pjingying)
* 知乎：[YuriyPikachu](https://www.zhihu.com/people/YuriyPikachu)
* 简书：[YuriyPikachu](https://www.jianshu.com/u/1df4d713a12c)
* 邮箱：[YuriyPikachu@163.com](YuriyPikachu@163.com)
* 头条：[Android开发加油站](https://www.toutiao.com/c/user/1789857904/#mid=1581788092440589)
* 公众号：[Android开发加油站]() 
* 
![](https://tva1.sinaimg.cn/large/006tNbRwgy1gayiubsiuaj309k09kdfn.jpg)     

