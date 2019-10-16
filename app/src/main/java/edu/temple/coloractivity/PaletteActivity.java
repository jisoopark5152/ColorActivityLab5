package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {
    Resources res = [context.]getResources();
    String[] gridLabels = res.getStringArray(R.array.my_array);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("PaletteActivity");
        Spinner spinner =findViewById(R.id.spinner);

        TypedArray ta = getResources().obtainTypedArray(R.array.colors);
        final int[] colors = new int[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            colors[i] = ta.getColor(i, 0);
        }
        CustomAdapter customAdapter=new CustomAdapter(this,colors);
        spinner.setAdapter(customAdapter);

    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Intent myIntent = new Intent(getApplicationContext(), CanvasActivity.class);
            myIntent.putExtra("color",colors[position] );
            startActivity(myIntent);
        }

        @Override
        public void onNothingSelected(AdapterView<?>parent) {
        }
    });
}
}