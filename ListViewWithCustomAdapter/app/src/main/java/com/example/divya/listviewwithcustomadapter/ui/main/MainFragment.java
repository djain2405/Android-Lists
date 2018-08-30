package com.example.divya.listviewwithcustomadapter.ui.main;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.divya.listviewwithcustomadapter.R;
import com.example.divya.listviewwithcustomadapter.adapter.AppAdapter;
import com.example.divya.listviewwithcustomadapter.model.AppObj;

import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private ListView listView;
    private List<AppObj> appObjList;
    private AppAdapter appAdapter;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.main_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.appList);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        appObjList = mViewModel.getAppObjList();
        AppObj []arr = new AppObj[appObjList.size()];
        int i = 0;
        for(AppObj s : appObjList)
        {
            arr[i++] = s;
        }
        appAdapter = new AppAdapter(getContext(), arr);
        listView.setAdapter(appAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "App selected is " + appObjList.get(position).getName(), Toast.LENGTH_SHORT).show();

            }
        });


    }

}
