package com.example.divya.listviewwithcustomadapter.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.divya.listviewwithcustomadapter.R;
import com.example.divya.listviewwithcustomadapter.model.AppObj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AppAdapter extends ArrayAdapter<AppObj> {

    private Context context;
    private AppObj[] appObjs;

    public AppAdapter(Context context, AppObj []apps)
    {
        super(context, -1, apps);
        this.context = context;
        appObjs = apps;
    }

    public View getView(int position, @Nullable View convertView,
                 @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        TextView title = (TextView)view.findViewById(R.id.appname);
        title.setText(appObjs[position].getName());
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        icon.setBackground(appObjs[position].getIcon());
        return view;
    }
}
