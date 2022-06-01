package space.damir.roadquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Level1 extends AppCompatActivity {


    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                try {
                    Intent intent = new Intent(Level1.this, Animation.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {

                }
            }
        });
        Button btn_second = (Button)findViewById(R.id.btn_second);
        btn_second.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                showInfo("Правильно!!!");
                try {
                    Intent intent = new Intent(Level1.this, Animation1.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {

                }
            }
        });
                Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


    }

    public void btnClick(View v) {
        showInfo("Подумай еще раз!!!");
    }

    private void showInfo(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

}