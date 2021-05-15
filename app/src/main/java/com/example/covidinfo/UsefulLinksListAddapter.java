package com.example.covidinfo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UsefulLinksListAddapter extends ArrayAdapter<UsefulLink> {
    String TAG = "UsefulLinksListAdapter";
    private Context mContext;
    private int mResource;

    public UsefulLinksListAddapter(@NonNull Context context, int resource, @NonNull ArrayList<UsefulLink> usefulLinks) {
        super(context, resource, usefulLinks);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the link data
        String name = getItem(position).getName();
        String link = getItem(position).getLink();
        Log.d(TAG  , "name:"+name+"  link:" + link);

        // Create UsefulLink object using this link data
//        UsefulLink linkObj = new UsefulLink(name, link);

        // Get table cell View
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView nametv = convertView.findViewById(R.id.name_tv);
        TextView linktv = convertView.findViewById(R.id.link_tv);

        // Set data to view
        nametv.setText(name);
        linktv.setText(link);

        return convertView;
    }

//    @Override
//    protected void onClick() {
//        onClick();
//    }
//
//    @Override
//    protected void onClick(View view) {
//        Toast.makeText(view.getContext(),"This is Maps",Toast.LENGTH_SHORT).show();
//
//    }

}

