package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newsGrid(View view) {
        Intent intent = new Intent(this, NewsActivity.class);
        //   EditText editText = (EditText) findViewById(R.id.editText);
        // String message = editText.getText().toString();
        //  intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void healthGrid(View view) {
        Intent intent = new Intent(this, HealthActivity.class);
        startActivity(intent);

    }

    public void protectionGrid(View view) {
        Intent intent = new Intent(this, ProtectionActivity.class);
        startActivity(intent);
    }

    public void deathGrid(View view) {
        Intent intent = new Intent(this, DeathActivity.class);
        startActivity(intent);
    }

}