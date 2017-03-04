package dev.and.gamedev.simplegames.selecttilesgame;

import android.graphics.Point;
import android.graphics.Rect;

public class Player {

    boolean isJumping = false;
    int size = 50, gravity = 1, speed = 7, upWordJump = 0;
    Rect box;
    Point displaySize;

    public Player(Point displaySize) {
        this.displaySize = displaySize;
        box = new Rect(0, displaySize.y - 200, size, displaySize.y - 150);
    }

    public void update() {
        if (box.left > displaySize.x) box.left = 0;
        upWordJump -= gravity;

        box.left += speed;
        box.top -= upWordJump;
        box.right = box.left + size;
        box.bottom = box.top + size;
    }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            upWordJump = 17;
//            box.top -= 100;
        }
    }
}
