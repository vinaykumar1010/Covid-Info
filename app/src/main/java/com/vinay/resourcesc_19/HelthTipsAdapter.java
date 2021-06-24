package com.vinay.resourcesc_19;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
public class HelthTipsAdapter extends ArrayAdapter<HelthTips> {
    String TAG = "HealthTipsAdapter";
    private final Context mContext;
    private final int mResource;

    public HelthTipsAdapter(@NonNull Context hcontext, int hresource, @NonNull ArrayList<HelthTips> HealthTips) {
        super(hcontext, hresource, HealthTips);
        this.mContext = hcontext;
        this.mResource = hresource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the link data
        String name = getItem(position).getName1();
        String link = getItem(position).getLink1();
        Log.d(TAG  , "name:"+name+"  link:" + link);

        // Create UsefulLink object using this link data
//        UsefulLink linkObj = new UsefulLink(name, link);

        // Get table cell View
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView nametv = convertView.findViewById(R.id.name_health);
        TextView linktv = convertView.findViewById(R.id.link_health);

        // Set data to view
        nametv.setText(name);
        linktv.setText(link);

        return convertView;
    }
}
