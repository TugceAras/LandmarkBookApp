package com.tugcearas.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView1 = findViewById(R.id.LandmarkNameText);
        TextView textView2 = findViewById(R.id.countryNameText);


        Intent intent = getIntent();
        String landmarkName = intent.getStringExtra("name");
        String countryNames = intent.getStringExtra("country");
        textView1.setText(landmarkName);
        textView2.setText(countryNames);


        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());


    }
}