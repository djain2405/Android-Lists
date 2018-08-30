package com.example.divya.simplelistview.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.content.pm.PackageInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;

import com.example.divya.simplelistview.R;
import com.example.divya.simplelistview.model.AppObj;

import java.util.Arrays;
import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private ListView listView;
//    private List<AppObj> appObjList;
    private List<String> appNamesList;


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
        //appObjList = mViewModel.getAppObjList();
        appNamesList = mViewModel.getAppObjList();
        String []arr = new String[appNamesList.size()];
        int i = 0;
        for(String s : appNamesList)
        {
            arr[i++] = s;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(listView.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, arr );
        listView.setAdapter(adapter);
    }

}
