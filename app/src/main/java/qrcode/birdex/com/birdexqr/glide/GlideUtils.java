package qrcode.birdex.com.birdexqr.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import qrcode.birdex.com.birdexqr.MyApplication;
import qrcode.birdex.com.birdexqr.R;


public class GlideUtils {
	// 图片加载
	public static void setImageToUrl(ImageView aa, String url) {
		// Glide的使用
		Glide.with(MyApplication.getInstans())
				// 设置加载路径
				.load(url)
				.diskCacheStrategy(DiskCacheStrategy.ALL)
				// 图像大小调整
				// .override(600, 500)
				// 裁剪中心
				// .centerCrop()
				// 设置占位图或者加载错误图：
//				.placeholder(R.drawable.head)
//				.error(R.drawable.head)
				// 交叉淡入淡出
				.crossFade(100)
				// 初始化
				.into(aa);
	}


	// 图片加载
	public static void Barnner(ImageView aa, String url) {
		// Glide的使用
		Glide.with(MyApplication.getInstans())
				// 设置加载路径
				.load(url)
				.diskCacheStrategy(DiskCacheStrategy.ALL)
						// 图像大小调整
						// .override(600, 500)
						// 裁剪中心
//						 .centerCrop()
						// 设置占位图或者加载错误图：
//				.placeholder(R.drawable.chrome)
//				.error(R.drawable.chrome)
						// 交叉淡入淡出
//				.crossFade(100)
						// 初始化
				.into(aa);
	}
	// 图片加载
	public static void setImageToLocalPath(ImageView aa, String url) {
		// Glide的使用
		Glide.with(MyApplication.getInstans())
				// 设置加载路径
				.load(url)
//				.diskCacheStrategy(DiskCacheStrategy.ALL)
						// 图像大小调整
						// .override(600, 500)
						// 裁剪中心
//						 .centerCrop()
						// 设置占位图或者加载错误图：
//				.placeholder(R.drawable.chrome)
				.fitCenter()
				.error(R.drawable.chrome)
						// 交叉淡入淡出
//				.crossFade(100)
						// 初始化
				.into(aa);
	}

	// 图片加载
	public static void setImageToLocalPath1(ImageView aa, String url) {
		// Glide的使用
		Glide.with(MyApplication.getInstans())
				// 设置加载路径
				.load(url)
//				.diskCacheStrategy(DiskCacheStrategy.ALL)
						// 图像大小调整
						// .override(600, 500)
						// 裁剪中心
//						 .centerCrop()
						// 设置占位图或者加载错误图：
//				.placeholder(R.drawable.chrome)
				.centerCrop()
				.error(R.drawable.chrome)
						// 交叉淡入淡出
//				.crossFade(100)
						// 初始化
				.into(aa);
	}
}
