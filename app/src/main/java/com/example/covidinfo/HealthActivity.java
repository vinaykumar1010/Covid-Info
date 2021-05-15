package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class HealthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        ArrayList<HelthTips> tips = getHealthTipsData();
        showLinksOnUI(tips);
    }

    void showLinksOnUI(ArrayList<HelthTips> linkArrayList) {
        // step1.: get list view
        ListView mListView = findViewById(R.id.health_link);
        HelthTipsAdapter healthAdapter = new HelthTipsAdapter(this, R.layout.health_adapter_link_layout, linkArrayList);
        mListView.setAdapter(healthAdapter);

    }

    ArrayList<HelthTips> getHealthTipsData() {
        /*
            Step1 : First get bundle from intent.
            Step 2: Get array list from bundle
        * */
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("HealthBundle");
        ArrayList<HelthTips> links = (ArrayList<HelthTips>) args.getSerializable("HealthTipsArrayList");
        return links;
    }
}