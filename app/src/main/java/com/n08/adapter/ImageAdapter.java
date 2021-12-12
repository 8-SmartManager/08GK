package com.n08.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.n08.g701.R;
import com.n08.model.Image_Product;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    Context context;
    int item_product;
    List<Image_Product> imageProductList;

    public ImageAdapter(Context context, int item_product, List<Image_Product> imageProductList) {
        this.context = context;
        this.item_product = item_product;
        this.imageProductList = imageProductList;
    }

    @Override
    public int getCount() {
        return imageProductList.size();
    }

    @Override
    public Object getItem(int i) {
        return imageProductList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_product,null);
            holder.imvThumb= view.findViewById(R.id.imvThumb);




            view.setTag(holder);
        }
        else {holder= (ViewHolder) view.getTag();
        }
        Image_Product image = imageProductList.get(i);
        holder.imvThumb.setImageResource(image.getImageId());


        return view;
    }

    public static class ViewHolder{
        ImageView imvThumb;

    }
}
