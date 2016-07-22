package qrcode.birdex.com.birdexqr.api;

import android.content.Context;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import qrcode.birdex.com.birdexqr.MyApplication;

/**
 * Created by hyj on 2016/3/14.
 */
public class QrCodeAPI {

//    public static String SERVER_ADDRESS = "epp.gtafe.com";http://upload2.birdex.cn/app_upload.php
//    public static String SERVER_ADDRESS = "192.168.1.206";
    public static String SERVER_ADDRESS = "upload2.birdex.cn";

    public static String PORT = "8012";//8002
    public static String BASE_URL = "http://" + SERVER_ADDRESS;  // ":" + PORT ;


    /**
     * @param context
     * @param url
     * @param params
     * @param jsonHttpResponseHandler
     */
    public static void post(Context context, String url, RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
        MyApplication.ahc.post(context, BASE_URL + "/" + url, params, jsonHttpResponseHandler);
    }

    public static void post(Context context, String url, RequestParams params, TextHttpResponseHandler textHttpResponseHandler) {
        MyApplication.ahc.post(context, BASE_URL + "/" + url, params, textHttpResponseHandler);
    }

    /**
     * @param context
     * @param url
     * @param params
     * @param jsonHttpResponseHandler
     */
    private static void get(Context context, String url, RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
        MyApplication.ahc.get(context, BASE_URL + "/" + url, params, jsonHttpResponseHandler);
    }

    private static void get(Context context, String url, RequestParams params, TextHttpResponseHandler textHttpResponseHandler) {
        MyApplication.ahc.get(context, BASE_URL + "/" + url, params, textHttpResponseHandler);
    }

    // 上传图片
    public static void upLoadPic(Context context, RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
        post(context, "app_upload.php", params, jsonHttpResponseHandler);
    }

    // 上传 upc 图片 url
    public static void upLoadUpc(Context context, RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
//        MyApplication.ahc.post(context, "http://192.168.1.215:8012/bs-product/productUpc/newByApp", params, jsonHttpResponseHandler);
//        MyApplication.ahc.post(context, "http://bs-product.apiv2.a.com/productUpc/newByApp", params, jsonHttpResponseHandler);
        MyApplication.ahc.post(context, "http://bs-product.apiv2.birdex.cn/productUpc/newByApp", params, jsonHttpResponseHandler);
    }

    // 获取更新信息
    public static void upDateMessage(Context context, RequestParams params, JsonHttpResponseHandler jsonHttpResponseHandler) {
//        MyApplication.ahc.post(context, "http://192.168.1.215:8012/bs-product/productUpc/newByApp", params, jsonHttpResponseHandler);
        MyApplication.ahc.get(context, "http://app.birdex.cn/app.html", params, jsonHttpResponseHandler);
    }
}
