package com.vinay.resourcesc_19;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.util.ArrayList;

public class CovidResourceActivity extends AppCompatActivity {
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "CovidResourceActivity OnCreate");
        super.onCreate(savedInstanceState);

        // Step1: Show the content view
        setContentView(R.layout.activity_news);
        // Step2: Get links array list from intent
        ArrayList<UsefulLink> links = getLinkData();
        Log.d(TAG, "links" + links);

        // Step3: Put these links in content view
        showLinksOnUI(links);
    }

    void showLinksOnUI(ArrayList<UsefulLink> linkArrayList) {
        // step1.: get list view
        ListView mListView = findViewById(R.id.useful_links);
        UsefulLinksListAddapter linkAdapter = new UsefulLinksListAddapter(this, R.layout.adapter_view_links_layout, linkArrayList);
        mListView.setAdapter(linkAdapter);
    }

    ArrayList<UsefulLink> getLinkData() {
        /*
            Step1 : First get bundle from intent.
            Step 2: Get array list from bundle
        * */
       // Log.d(TAG, "getLinkData");
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("LinksBundle");
      //  Log.d(TAG, "Bundle received");
        ArrayList<UsefulLink> links = (ArrayList<UsefulLink>) args.getSerializable("usefulLinksArrayList");
     //   Log.d(TAG, "links: " + links);
        return links;
    }
}