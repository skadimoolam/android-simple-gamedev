package dev.and.gamedev.simplegames.selecttilesgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class Game extends SurfaceView implements Runnable {

    volatile boolean isPlaying = true;
    Thread gameThread = null;

    protected Paint paint;
    protected Canvas canvas;
    protected SurfaceHolder surfaceHolder;
    protected Point displaySize;
    protected Context context;

    private Player player;
    private Ground ground;

    public Game(Context context, Point displaySize) {
        super(context);
        this.context = context;
        this.displaySize = displaySize;
        surfaceHolder = getHolder();
        paint = new Paint();

        startGame();
    }

    private void startGame() {
        player = new Player(displaySize);
        ground = new Ground(displaySize);
    }

    protected void update() {
        player.update();

        if (player.box.intersect(ground.size)) {
            player.isJumping = false;
            player.upWordJump = 0;
            player.box.top = ground.size.top - player.size;
        }
    }

    protected void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.argb(255, 0, 0, 0));

            paint.setColor(Color.WHITE);
            canvas.drawRect(player.box.left, player.box.top, player.box.right, player.box.bottom, paint);

            canvas.drawRect(ground.size.left, ground.size.top, ground.size.right, ground.size.bottom, paint);

            surfaceHolder.unlockCanvasAndPost(canvas);
        } else {
            Toast.makeText(context, "No canvas", Toast.LENGTH_SHORT).show();
        }
    }

    protected void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                player.jump();
                break;

//            case MotionEvent.ACTION_DOWN:
//                player.startBoosting();
//                break;
        }

        return true;
    }

    @Override
    public void run() {
        while(isPlaying) {
            update();
            draw();
            control();
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
