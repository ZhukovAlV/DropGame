package com.company.game;

import java.awt.*;
import java.util.Random;

public class Bomb {
    private static final Random RANDOM = new Random();

    private Image bomb;
    private int bomb_left;
    private int bomb_top;
    private int bomb_right;
    private int bomb_bottom;
    private boolean isExplosion;

    public Bomb(Image bomb) {
        this.bomb = bomb;
        bomb_left = 20 + RANDOM.nextInt(900);
        bomb_right = bomb_left + bomb.getWidth(null);
        bomb_bottom = bomb_top + bomb.getHeight(null);
    }

    public int getBomb_left() {
        return bomb_left;
    }

    public void setBomb_left(int bomb_left) {
        this.bomb_left = bomb_left;
    }

    public int getBomb_top() {
        return bomb_top;
    }

    public void setBomb_top(int bomb_top) {
        this.bomb_top = bomb_top;
    }

    public int getBomb_right() {
        return bomb_right;
    }

    public void setBomb_right(int bomb_right) {
        this.bomb_right = bomb_right;
    }

    public int getBomb_bottom() {
        return bomb_bottom;
    }

    public void setBomb_bottom(int bomb_bottom) {
        this.bomb_bottom = bomb_bottom;
    }

    public boolean isExplosion() {
        return isExplosion;
    }

    public void setExplosion(boolean explosion) {
        isExplosion = explosion;
    }

    public Image getBomb() {
        return bomb;
    }
}
