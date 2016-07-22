package qrcode.birdex.com.birdexqr.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

/**
 * Created by hyj on 2016/3/14.
 */
public class SafeProgressDialog extends Dialog {

    Activity mParentActivity;

    public SafeProgressDialog(Context context,int theme) {
        super(context,theme);
        mParentActivity = (Activity) context;
    }

    @Override
    public void dismiss()
    {
        if (mParentActivity != null && !mParentActivity.isFinishing())
        {
            super.dismiss();    //调用超类对应方法
        }
    }
}
