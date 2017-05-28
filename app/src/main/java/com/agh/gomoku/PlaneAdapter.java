package com.agh.gomoku;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Tomasz on 2017-04-09.
 */

public class PlaneAdapter extends BaseAdapter {

    //generuje plansze zlozna z kratek w ilosci okreslonej na poczatku

    int dimension = MainActivity.dimension;
    private Context mContext;

    public PlaneAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(100-2*dimension, 100-2*dimension));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = setmThumbIds();


    // metoda generujaca plansze
    public Integer[] setmThumbIds() {
        Integer[] temp = new Integer[dimension * dimension];

        temp[0] = R.drawable.rog;

        for (int i = 1; i < dimension - 1; i++) {
            temp[i] = R.drawable.bok1;
        }

        temp[dimension-1] = R.drawable.rog2;

        for (int i = 1; i < dimension - 1; i++) {
            temp[i*dimension] = R.drawable.bok;
            for(int j = 1; j < dimension ; j++){
                temp[i*dimension + j] = R.drawable.srodek;
            }
            temp[i*dimension + dimension - 1] = R.drawable.bok2;
        }

        temp[dimension*(dimension - 1)] = R.drawable.rog3;

        for (int i = 1 ; i < dimension ; i++){
            temp[dimension*(dimension-1) + i] = R.drawable.bok3;
        }

        temp[dimension*dimension - 1] = R.drawable.rog4;

        return temp;
    }
}
