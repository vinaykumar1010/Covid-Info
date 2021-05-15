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
    ArrayList<HelthTips> healthLinkList = new ArrayList<HelthTips>();
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseManager firebaseObj = new FirebaseManager();
        usefulLinksList = firebaseObj.getUsefulLinks(); //new FirebaseManager().getUsefulLinks();

        healthLinkList = firebaseObj.fetchHealthTips();
        // new give object of  firebase manager class whom function is calld e

    }

    public void newsGrid(View view) {
        Intent intent = new Intent(this, NewsActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("usefulLinksArrayList", (Serializable) usefulLinksList);
        intent.putExtra("LinksBundle", args);
        startActivity(intent);
    }

    public void healthGrid(View view) {
        Intent intent = new Intent(this, HealthActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("HealthTipsArrayList" , (Serializable) healthLinkList );
        intent.putExtra("HealthBundle" , args);
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