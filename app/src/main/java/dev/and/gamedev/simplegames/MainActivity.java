package dev.and.gamedev.simplegames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import dev.and.gamedev.simplegames.justjump.JustJumpGame;
import dev.and.gamedev.simplegames.selecttilesgame.SelectTilesGame;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llButtonHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llButtonHost = (LinearLayout) findViewById(R.id.button_host);

        addNewButton("Just Jump", JustJumpGame.class);
        addNewButton("Select Tiles", SelectTilesGame.class);
    }

    public void addNewButton(String buttonText, final Object resultActivity) {
        Button button = new Button(this);
        button.setText(buttonText);
        button.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, (Class<?>) resultActivity));
            }
        });

        llButtonHost.addView(button);
    }
}


// http://www.emanueleferonato.com/2016/12/09/create-a-html5-game-like-space-is-key-using-phaser-tweens-and-arcade-physics/
// http://www.emanueleferonato.com/2016/11/17/html5-endless-samegame-engine-with-object-pooling-made-with-phaser/