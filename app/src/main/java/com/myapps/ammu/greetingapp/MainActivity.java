package com.myapps.ammu.greetingapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner list=(Spinner) findViewById(R.id.spinner);
        String item=list.getSelectedItem().toString();
        List<String> categories = new ArrayList<String>();
        categories.add("Select a greeting");
        categories.add("Best Wishes");
        categories.add("Happy Birthday");
        ArrayAdapter<String> adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,categories);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

              // adapter.add("Select a greeting..");
        list.setAdapter(adapter);
        list.setOnItemSelectedListener(this);

        img=(ImageView)findViewById(R.id.imageView);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s=parent.getItemAtPosition(position).toString();
        Bitmap bmp;
        if(s.equals("Best Wishes")){
            bmp= BitmapFactory.decodeResource(getResources(),R.drawable.bestwishes);
            Bitmap bMapScaled = Bitmap.createScaledBitmap(bmp, 150, 100, true);
            img.setImageBitmap(bMapScaled);
        }
        else if(s.equals("Happy Birthday")){
            bmp= BitmapFactory.decodeResource(getResources(),R.drawable.happybirthday);
            Bitmap bMapScaled = Bitmap.createScaledBitmap(bmp, 150, 100, true);
            img.setImageBitmap(bMapScaled);
        }
        else if(s.equals("Select a greeting"))
        {

        }
        else
        {

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this," Select a greeting ",Toast.LENGTH_LONG).show();
    }
}
