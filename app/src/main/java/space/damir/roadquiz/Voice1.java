package space.damir.roadquiz;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;
public class Voice1 extends AppCompatActivity {
    private TextView textTest;
    private ImageView imMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice1);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                try {
                    Intent intent = new Intent(Voice1.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {

                }
            }
        });
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                try {
                    Intent intent = new Intent(Voice1.this, Baze.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {

                }
            }
        });
        init();
    }
    private void init(){
        textTest=findViewById(R.id.textTest);
        imMain=findViewById(R.id.imageView4);
    }
    public void onClickMic(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        startActivityForResult(intent, 10);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                case 10:
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textTest.setText(text.get(0));
                    textCommand(text.get(0));
                    break;
            }
        }
    }
    private  void textCommand(String text){
        switch (text) {
            case "знак Стоп":
                imMain.setImageResource(R.drawable.qw);
                break;
            case "знак стоянка запрещена":
                imMain.setImageResource(R.drawable.shop_items_catalog_image1301);
                break;
            case "знак главная дорога":
                imMain.setImageResource(R.drawable.a358656d67d186f5d2e3cd826dab7909);
                break;
            case "знак стоп":
                imMain.setImageResource(R.drawable.qw);
                break;
            case "знак уступи дорогу":
                imMain.setImageResource(R.drawable.zx);
                break;
            case "знак Стоянка запрещена":
                imMain.setImageResource(R.drawable.shop_items_catalog_image1301);
                break;
        }
    }
}

