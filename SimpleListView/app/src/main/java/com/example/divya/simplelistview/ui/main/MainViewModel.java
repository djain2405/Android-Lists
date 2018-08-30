package com.example.divya.simplelistview.ui.main;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;

import com.example.divya.simplelistview.model.AppObj;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel

    List<AppObj> appObjList;
    List<String> appNamesList;
    Application application;

    public MainViewModel(Application app)
    {
        super(app);
        application = app;
        appObjList = new ArrayList<>();
        appNamesList = new ArrayList<>();
    }

    List<String> getAppObjList()
    {
        List<PackageInfo> packages = application.getApplicationContext().getPackageManager().getInstalledPackages(0);
        for(PackageInfo info : packages)
        {
            AppObj obj = new AppObj();
            obj.setName(info.applicationInfo.loadLabel(application.getApplicationContext().getPackageManager()).toString());
            obj.setIcon(info.applicationInfo.loadIcon(application.getApplicationContext().getPackageManager()));
            appObjList.add(obj);
            appNamesList.add(obj.getName());
        }

        return appNamesList;
    }
}
