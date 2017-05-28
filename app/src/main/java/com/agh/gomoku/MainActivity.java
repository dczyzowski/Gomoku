package com.agh.gomoku;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;


public class MainActivity extends AppCompatActivity {

    static TextView textInfo;
    static int dimension = 15;

    static boolean wygrana = false;
    boolean ruch = true;

    Plane plansza;
    PointsAdapter pointsAdapter;
    GridView gridview;
    static Button button;

    static ImageView switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.show();

        textInfo = (TextView) findViewById(R.id.title_text);
        button = (Button) findViewById(R.id.od_nowa);

        gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setNumColumns(dimension);
        gridview.setAdapter(new PlaneAdapter(this));

        plansza = new Plane();
        pointsAdapter = new PointsAdapter(this);

        final GridView pointsView = (GridView) findViewById(R.id.dots_view);
        pointsView.setNumColumns(dimension);
        pointsView.setAdapter(pointsAdapter);

        //ruch gracza jesli prawda, gra czarny
        ruch = true;

        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);

        switcher = (ImageView) findViewById(R.id.image_switcher);

        switcher.setImageResource(R.drawable.czarny);

        pointsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                if (!wygrana) {
                    if (ruch) {
                        Point mPoint = new Point(position, R.drawable.czarny);
                        if (plansza.putPoint(mPoint)) {
                            pointsAdapter.setmThumbIds(plansza.getPoint_pos());
                            ruch = false;
                            switcher.setImageResource(R.drawable.bialy);
                        }
                    } else {
                        Point mPoint = new Point(position, R.drawable.bialy);
                        if (plansza.putPoint(mPoint)) {
                            pointsAdapter.setmThumbIds(plansza.getPoint_pos());
                            ruch = true;
                            switcher.setImageResource(R.drawable.czarny);
                        }
                    }
                    pointsView.setAdapter(pointsAdapter);
                }
            }
        });
    }

    public static void setText(Integer color){
        if (color == R.drawable.bialy) {
            textInfo.setText("Wygrał biały");
            switcher.setImageResource(R.drawable.bialy);
        }
        else if (color == R.drawable.czarny) {
            textInfo.setText("Wygrał czarny");
        }
        switcher.setVisibility(View.GONE);
        button.setVisibility(View.VISIBLE);
        wygrana = true;
    }

    public void odNowa(View view) {
        pointsAdapter = new PointsAdapter(this);
        gridview.setAdapter(new PlaneAdapter(this));
        plansza = new Plane();

        wygrana = false;

        switcher.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
        textInfo.setText("");
    }
}
