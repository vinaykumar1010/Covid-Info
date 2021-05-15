package com.example.covidinfo;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class FirebaseManager {
    private String TAG = "FirebaseManager";

    /**
     * Function to fetch list of useful links from firebase firestore
     * @return
     */
    public ArrayList<UsefulLink> getUsefulLinks() {
        ArrayList<UsefulLink> usefulLinksList = new ArrayList<UsefulLink>();
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
        return usefulLinksList;
    }

    public ArrayList<HelthTips> fetchHealthTips(){
        ArrayList<HelthTips>  healthLinkList = new ArrayList<HelthTips>();
        FirebaseFirestore db  = FirebaseFirestore.getInstance();
        // Firebase getinstance is static method  that why we not use new keyword and make object
        db.collection("helth_tips")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                          QuerySnapshot querySnapshot  = task.getResult();
                          for (QueryDocumentSnapshot doc: querySnapshot) {
                              Map data = doc.getData();
                              String name = (String) data.get("name");
                              String link = (String) data.get("link");
                              HelthTips helthTips = new HelthTips(name,link);
                              healthLinkList.add(helthTips);

                          }
                        }else{
                            Log.e("tag" , "  health tip fetching failed");
                        }
                    }
                });
        return healthLinkList;

    }


}
