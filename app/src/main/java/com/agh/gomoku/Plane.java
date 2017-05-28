package com.agh.gomoku;

/**
 * Created by Tomasz on 2017-04-10.
 */

public class Plane {

    int dimension;
    Point[][] point_pos;

    //konstrutor domyslny
    Plane(){
        dimension = MainActivity.dimension;
        point_pos = new Point[dimension][dimension];
    }

    // metoda zwracajaca prawde jesli mozna w danym punkcie postawic pionek, jesli nie to falsz
    public boolean putPoint(Point newPoint) {

        if (point_pos[newPoint.getY()][newPoint.getX()] == null) {
            point_pos[newPoint.getY()][newPoint.getX()] = newPoint;
            checkConnection();
            return true;
        }
        return false;
    }

    public void checkConnection() {

        //sprawdzamy polączenia na całej planszy, czy nie zostal okrazony ktorys z punktow
        for (int y = 0; y < dimension; y++) {
            for (int x = 0; x < dimension; x++) {
                if (point_pos[y][x] != null) {
                    int win = 0;
                    loop1:
                    for (int i = 1; i < 5; i++) {
                        try {
                            if (point_pos[y][x].getColor() == point_pos[y + i][x].getColor()) {
                                win++;
                            }
                        } catch (Exception e) {
                            break loop1;
                        }
                    }

                    if (win == 4) {
                        MainActivity.setText(point_pos[y][x].getColor());
                        return;
                    }

                    win = 0;
                    loop2:
                    for (int i = 1; i < 5; i++) {
                        try {
                            if (point_pos[y][x].getColor() == point_pos[y][x + i].getColor()) {
                                win++;
                            }
                        } catch (Exception e) {
                            break loop2;
                        }
                    }
                    if (win == 4) {
                        MainActivity.setText(point_pos[y][x].getColor());
                        break;
                    }

                    win = 0;
                    loop3:
                    for (int i = 1; i < 5; i++) {
                        try {
                            if (point_pos[y][x].getColor() == point_pos[y + i][x + i].getColor()) {
                                win++;
                            }
                        } catch (Exception e) {
                            break loop3;
                        }
                    }

                    if (win == 4) {
                        MainActivity.setText(point_pos[y][x].getColor());
                        break;
                    }

                    win = 0;
                    loop3:
                    for (int i = 1; i < 5; i++) {
                        try {
                            if (point_pos[y][x].getColor() == point_pos[y - i][x + i].getColor()) {
                                win++;
                            }
                        } catch (Exception e) {
                            break loop3;
                        }
                    }

                    if (win == 4) {
                        MainActivity.setText(point_pos[y][x].getColor());
                        break;
                    }
                }
            }
        }
    }

    public Point[][]getPoint_pos(){
        return point_pos;
    }
}


