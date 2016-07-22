package qrcode.birdex.com.birdexqr.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity {
    private int mContentLayoutResId;
    ProgressDialog bar;
    Dialog loadingDialog;

    protected EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContentLayoutResId = getContentLayoutResId();
        if (0 == mContentLayoutResId) {
            throw new IllegalArgumentException(
                    "mContentLayoutResId is 0, "
                            + "you must thought the method getContentLayoutResId() set the mContentLayoutResId's value"
                            + "when you used a fragment which implements the gta.dtp.fragment.BaseFragment.");
        }
        setContentView(mContentLayoutResId);
        ButterKnife.bind(this);
        bar = new ProgressDialog(this);
        bar.setCanceledOnTouchOutside(false);
        initializeContentViews();

    }

    //设置布局
    public abstract int getContentLayoutResId();

    public abstract void initializeContentViews();

    public void showBar() {
        bar.setMessage("加载中...");
        bar.show();
    }

    public void hideBar() {
        bar.dismiss();
    }

    public void showBarCommit() {
        bar.setMessage("正在提交...");
        bar.show();
    }

    public void hideLoading() {
        loadingDialog.dismiss();
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {// 获取横屏
//            return; // 此处添加用户自己的操作
//        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {// 获取竖屏
//            return;
//        }
//    }
}
