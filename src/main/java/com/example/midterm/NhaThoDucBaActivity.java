package com.example.midterm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NhaThoDucBaActivity extends AppCompatActivity {
    Button Returnb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhathoducba_info);

        Returnb = findViewById(R.id.activity_2nd);
        Returnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void Clickinfo(View view){
        GoTo("https://en.wikipedia.org/wiki/Notre-Dame_Cathedral_Basilica_of_Saigon");
    }
    public void GoTo(String url) {
        Uri uri = Uri.parse(url);
        Intent launch = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launch);
    }
}
