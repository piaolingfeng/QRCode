package qrcode.birdex.com.birdexqr.Utils;

import android.os.Environment;

/**
 * Created by hyj on 2016/3/15.
 */
public class Constant {

    public static final String NAME = "/BirdexQr";

    public static final String BASEPATH = Environment
            .getExternalStorageDirectory().getAbsolutePath() + NAME;

}
