package qrcode.birdex.com.birdexqr;

import android.app.Application;

import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by hyj on 2016/3/14.
 */
public class MyApplication extends Application {

    private static MyApplication instants;
    public static AsyncHttpClient ahc;

    public static String appName = "birdexQrCode";

    // 标记是否是第一次请求更新
    private boolean isFirst = true;

    public boolean isFirst() {
        return isFirst;
    }

    public void setIsFirst(boolean isFirst) {
        this.isFirst = isFirst;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instants = this;

        initAsyncHttpClient();
    }

    //线程同步网络请求
    private synchronized void initAsyncHttpClient() {
        ahc = new AsyncHttpClient();//获取网络连接超时
        ahc.setTimeout(8 * 1000);//设置30秒超时
        ahc.setConnectTimeout(4 * 1000);//设置30秒超时
        ahc.setMaxConnections(5);
    }

    public static MyApplication getInstans() {
        if (instants == null) {
            instants = new MyApplication();
        }
        return instants;
    }
}
