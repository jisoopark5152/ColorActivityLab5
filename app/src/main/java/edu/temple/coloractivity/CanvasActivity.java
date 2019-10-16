package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.RelativeLayout;


public class CanvasActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        setTitle("CanvasActivity");
        int selectedColor= getIntent().getExtras().getInt("color");

        RelativeLayout layout = findViewById(R.id.canvas_act);
        layout.setBackgroundColor(selectedColor);


    }
}


