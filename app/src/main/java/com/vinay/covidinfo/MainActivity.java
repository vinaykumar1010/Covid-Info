package com.vinay.covidinfo;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.io.Serializable;
import java.util.ArrayList;

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
        // new give object of  firebase manager class whom function is called
    }

    public void newsGrid(View view) {
        Intent intent = new Intent(this, CovidResourceActivity.class);
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
        Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, ProtectionActivity.class);
//        startActivity(intent);
        return;
    }



}