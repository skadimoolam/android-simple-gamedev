package dev.and.gamedev.simplegames.selecttilesgame;

import android.graphics.Point;
import android.graphics.Rect;

public class Ground {

    Rect size;
    Point displaySize;

    public Ground(Point displaySize) {
        this.displaySize = displaySize;
        size = new Rect(0, displaySize.y - 100, displaySize.x, displaySize.y - 50);
    }
}
