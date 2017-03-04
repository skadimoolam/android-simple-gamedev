package dev.and.gamedev.simplegames.justjump;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import dev.and.gamedev.simplegames.selecttilesgame.Game;

public class JustJumpGame extends Activity {

    Game gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point displaySize = new Point();
        display.getSize(displaySize);

        gameView = new Game(this, displaySize);
        setContentView(gameView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}
