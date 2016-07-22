package qrcode.birdex.com.birdexqr.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import qrcode.birdex.com.birdexqr.R;
import qrcode.birdex.com.birdexqr.Utils.T;
import qrcode.birdex.com.birdexqr.adapter.MyPagerAdapter;
import qrcode.birdex.com.birdexqr.glide.GlideUtils;

/**
 * Created by hyj on 2016/3/14.
 */
public class PhotoShowActivity extends BaseActivity implements View.OnClickListener{

//    private ImageView iv;


    // 图片 path
    private String filePath;

    private int position;

    private final static int PHOTO_GREQUEST_CODE = 2;


    @Bind(R.id.show_photo_iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        iv = (ImageView) findViewById(R.id.show_photo_iv);

//        Bitmap bitmap = (Bitmap) getIntent().getExtras().get("bitmap");
//        String path = (String) getIntent().getExtras().get("path");
//        Bitmap bitmap1 = getLoacalBitmap(path);
//        iv.setImageBitmap(bitmap1);
    }

    @Override
    public int getContentLayoutResId() {
        return R.layout.show_photo;
    }

    private List<View> views = new ArrayList<>();

    private Bitmap bitmap;

    @Override
    public void initializeContentViews() {
//        int position = (int) getIntent().getExtras().get("position");
//        List list = (List) getIntent().getExtras().get("list");
//        for(int i=0;i<list.size();i++){
//            String path = (String) list.get(i);
//            View view = LayoutInflater.from(this).inflate(R.layout.photo_viewpager,null);
//            ImageView iv = (ImageView) view.findViewById(R.id.viewpager_iv);
//            TextView tv = (TextView) view.findViewById(R.id.page_no);
//            tv.setText((i+1) + "/" + list.size());
////            bitmap = getLoacalBitmap(path);
//            GlideUtils.setImageToLocalPath(iv,path);
////            iv.setImageBitmap(bitmap);
//            views.add(view);
//        }
//        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(views);
//        viewpager.setAdapter(myPagerAdapter);
//        viewpager.setCurrentItem(position);
        String path = (String) getIntent().getExtras().get("path");
        position = getIntent().getExtras().getInt("position");
        GlideUtils.setImageToLocalPath(iv,path);
    }


    /**
     * 加载本地图片
     * @param url
     * @return
     */
    public static Bitmap getLoacalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            return BitmapFactory.decodeStream(fis);  ///把流转化为Bitmap图片

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PHOTO_GREQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    Intent resultIntent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("newpath", filePath);
                    bundle.putInt("position", position);
                    resultIntent.putExtras(bundle);
                    this.setResult(RESULT_OK, resultIntent);
                }
                finish();
                break;
        }
    }

    @OnClick({R.id.photo_back,R.id.rephotograph})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.photo_back:
                finish();
                break;

            case R.id.rephotograph:

                Intent photoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                filePath = getFileName();
                photoIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(filePath)));

                startActivityForResult(photoIntent, PHOTO_GREQUEST_CODE);
                break;
        }
    }

    /**
     * 生成文件路径和文件名
     *
     * @return
     */
    private String getFileName() {
        String saveDir = Environment.getExternalStorageDirectory() + "/myPic";
        File dir = new File(saveDir);
        if (!dir.exists()) {
            dir.mkdir(); // 创建文件夹
        }
        //用日期作为文件名，确保唯一性
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String fileName = saveDir + "/" + formatter.format(date) + ".jpg";

        return fileName;
    }
}
