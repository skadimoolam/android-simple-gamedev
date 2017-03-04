package dev.and.gamedev.simplegames;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    volatile boolean isPlaying = true;
    Thread gameThread = null;

    protected Paint paint;
    protected Canvas canvas;
    protected SurfaceHolder surfaceHolder;
    protected Point displaySize;
    protected Context context;

    public GameView(Context context, Point displaySize) {
        super(context);
        this.context = context;
        this.displaySize = displaySize;
        surfaceHolder = getHolder();
        paint = new Paint();
    }

    @Override
    public void run() {
        while(isPlaying) {
            update();
            draw();
            control();
        }
    }

    protected void update() {}

    protected void draw() {}

    protected void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {

        }
    }

    public void pause() {
        isPlaying = false;

        try {
            gameThread.join();
        } catch (InterruptedException e) {

        }
    }

    public void resume() {
        isPlaying = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
}
