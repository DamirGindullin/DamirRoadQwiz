package space.damir.roadquiz;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Animation extends AppCompatActivity {

    private  ImageView imageView3;
    private android.view.animation.Animation logoAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qwertyui);
        init();
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                try {
                    Intent intent = new Intent(Animation.this, GameLevels.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {

                }
            }
        });
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                try {
                    Intent intent = new Intent(Animation.this, Level1.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {

                }
            }
        });

    }
    public void init() {
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.qwer);
        imageView3 = findViewById(R.id.imageView3);
        imageView3.startAnimation(logoAnim);
    }
}