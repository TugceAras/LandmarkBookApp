package com.tugcearas.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // Data
        ArrayList<String>  landmarkNames = new ArrayList<>();
        landmarkNames.add("Pisa");
        landmarkNames.add("Eiffel");
        landmarkNames.add("Colosseum");
        landmarkNames.add("London Bridge");

        ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");


        //To transfer images to arrays;
        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap colosseum = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.collesium);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(colosseum);
        landmarkImages.add(londonBridge);



        // To transfer ArrayList values to ListView;
        // We indicate that you want to send simple_list_item_1 text.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter); // connection provided.


        // Clicks in ListView
        listView.setOnItemClickListener((parent, view, position, id) -> {

            //System.out.println(landmarkNames.get(position));
            //System.out.println(countryNames.get(position));


            // skip to the related page
            Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
            intent.putExtra("name",landmarkNames.get(position));
            intent.putExtra("country",countryNames.get(position));

            Singleton singleton = Singleton.getInstance();
            singleton.setChosenImage(landmarkImages.get(position));

            startActivity(intent);


        });


    }
}