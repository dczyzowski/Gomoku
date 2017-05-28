package com.agh.gomoku;

/**
 * Created by Tomasz on 2017-04-09.
 */

class Point {

    int dimension = MainActivity.dimension;
    int pos, color, x, y;


    Point(int x, int y, int myColor) {
        this.x = x;
        this.y = y;
        color = myColor;
    }

    Point(int position, int myColor) {
        pos = position;
        color = myColor;

        //zapisuje pozycje punktu do tablicy dwu wymiarowej ze wzgledu na uproszczenia
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

    }

    int getX(){
        return x;
    }

    int getY() {
        return y;
    }

    int getColor() {
        return color;
    }

    void setColor(int color) {
        this.color = color;
    }
}
