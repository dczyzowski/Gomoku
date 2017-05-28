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

public class PointsAdapter extends BaseAdapter {

    int dimension= MainActivity.dimension;;
    private Context mContext;
    private Point[][] mThumbIds = setmThumbIds();


    // generuje plansze pionkow, wypelniona jest pustymi polami na poczatku
    public Point[][] setmThumbIds() {

        Point[][] temp = new Point[dimension][dimension];
        for(int y = 0; y < dimension; y++){
            for (int x = 0 ; x < dimension; x++)
                temp[y][x] = new Point(x, y, R.drawable.blank);
        }
        return temp;
    }

    public PointsAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return dimension*dimension;
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
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView = (ImageView) convertView;
        }

        int x = 0,y = 0;

        if (position < dimension) {
            x = position;
            y = 0;
        } else if (position < 2*dimension) {
            x = position - dimension;
            y = 1;
        } else if (position < 3*dimension) {
            x = position - 2*dimension;
            y = 2;
        } else if (position < 4*dimension) {
            x = position - 3*dimension;
            y = 3;
        } else if (position < 5*dimension) {
            x = position - 4*dimension;
            y = 4;
        } else if (position < 6*dimension) {
            x = position - 5*dimension;
            y = 5;
        } else if (position < 7*dimension) {
            x = position - 6*dimension;
            y = 6;
        } else if (position < 8*dimension) {
            x = position - 7*dimension;
            y = 7;
        } else if (position < 9*dimension) {
            x = position - 8*dimension;
            y = 8;
        } else if (position < 10*dimension) {
            x = position - 9*dimension;
            y = 9;
        } else if (position < 11*dimension) {
            x = position - 10*dimension;
            y = 10;
        } else if (position < 12*dimension) {
            x = position - 11*dimension;
            y = 11;
        } else if (position < 13*dimension) {
            x = position - 12*dimension;
            y = 12;
        }else if (position < 14*dimension) {
            x = position - 13*dimension;
            y = 13;
        } else if (position < 15*dimension) {
            x = position - 14*dimension;
            y = 14;
        } else if (position < 16*dimension) {
            x = position - 15*dimension;
            y = 15;
        } else if (position < 17*dimension) {
            x = position - 16*dimension;
            y = 16;
        } else if (position < 18*dimension) {
            x = position - 17*dimension;
            y = 17;
        } else if (position < 19*dimension) {
            x = position - 18*dimension;
            y = 18;
        }

        //w razie wyjątku pole zastepuje polem pustym
        try {
            imageView.setImageResource(mThumbIds[y][x].getColor());
        }catch (NullPointerException e){
            imageView.setImageResource(R.drawable.blank);
        }
        return imageView;
    }

    void setmThumbIds(Point[][] points){
        mThumbIds = points;
    }
}
