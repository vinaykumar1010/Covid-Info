package com.example.covidinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ArrayList<UsefulLink> usefulLinksList = new ArrayList<UsefulLink>();
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupFirestoreAndGetLinks();
    }

    void setupFirestoreAndGetLinks() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("useful_links")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map data = document.getData();
                                String name = (String) data.get("name");
                                String link = (String) data.get("link");
//                               {link=http://google.com/twitter, name=covid twitter link}

                                // Creating useful link class object for one link coming from db.
                                UsefulLink linkObj = new UsefulLink(name, link);

                                // push this link in useful links array.
                                usefulLinksList.add(linkObj);
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void newsGrid(View view) {
        Log.d(TAG, "News clicked with data: " + usefulLinksList.size());
        Intent intent = new Intent(this, NewsActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("usefulLinksArrayList", (Serializable) usefulLinksList);
        intent.putExtra("LinksBundle", args);
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