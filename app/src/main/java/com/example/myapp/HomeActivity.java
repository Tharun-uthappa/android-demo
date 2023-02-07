package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
//     Button google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button checkbtn = (Button)  findViewById(R.id.check);
      Button b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               try {
                   Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=JyiYTYzxgis"));
                   startActivity(i);
               }catch(ActivityNotFoundException e){
                   Toast.makeText(HomeActivity.this, "No app is available to handle action", Toast.LENGTH_SHORT).show();

               }
//               Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=JyiYTYzxgis"));
//               startActivity(i);
           }
       });

        checkbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
            if(isConnected())
                Toast.makeText(getApplicationContext(), "Internet Available", Toast.LENGTH_SHORT).show();

            else
                Toast.makeText(getApplicationContext(), "Internet Not Available", Toast.LENGTH_SHORT).show();
            }

        });
//
   }
    boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            if (networkInfo.isConnected())
                return true;
            else
                return false;
        } else
            return false;

    }


}