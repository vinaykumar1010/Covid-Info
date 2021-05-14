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


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupFirestore();
    }

    void setupFirestore() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //
        db.collection("useful_links")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
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