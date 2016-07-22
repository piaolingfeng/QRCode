package qrcode.birdex.com.birdexqr.adapter;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import qrcode.birdex.com.birdexqr.R;
import qrcode.birdex.com.birdexqr.glide.GlideUtils;

/**
 * Created by hyj on 2016/3/11.
 */
public class PhotoGVAdapter extends BaseAdapter{

    // 传过来的 list bitmap
    private List<String> bitmapList;

    // 传过来的 context
    private Context context;

    public PhotoGVAdapter(Context context,List<String> bitmapList){
        this.context = context;
        this.bitmapList = bitmapList;
    }

    @Override
    public int getCount() {
        if(bitmapList.size()<4){
            return 4;
        }else
        return bitmapList.size();
    }

    @Override
    public Object getItem(int position) {
        if(position + 1 > bitmapList.size())
            return bitmapList.get(position);
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.photo_gv_adapter,null);
            vh = new ViewHolder();
            vh.iv = (ImageView) convertView.findViewById(R.id.gv_iv);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

//        Bitmap bitmap = bitmapList.get(position);
//        vh.iv.setImageBitmap(bitmap);
        ViewGroup.LayoutParams params = vh.iv.getLayoutParams();
        params.height = params.width;
        vh.iv.setLayoutParams(params);
        if(position < bitmapList.size()) {
            GlideUtils.setImageToLocalPath1(vh.iv, bitmapList.get(position));
        } else {
            vh.iv.setImageResource(R.drawable.group6copy4);
        }

        return convertView;
    }

    class ViewHolder {
        ImageView iv;
    }
}
