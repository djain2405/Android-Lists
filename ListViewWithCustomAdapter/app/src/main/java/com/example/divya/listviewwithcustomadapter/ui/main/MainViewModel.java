package com.example.divya.listviewwithcustomadapter.ui.main;

import android.app.Application;
import android.content.pm.PackageInfo;

import com.example.divya.listviewwithcustomadapter.model.AppObj;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends AndroidViewModel {

    List<AppObj> appObjList;
    Application application;
    public MainViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        appObjList = new ArrayList<>();
    }

    List<AppObj> getAppObjList()
    {
        List<PackageInfo> packages = application.getApplicationContext().getPackageManager().getInstalledPackages(0);
        for(PackageInfo info : packages)
        {
            AppObj obj = new AppObj();
            obj.setName(info.applicationInfo.loadLabel(application.getApplicationContext().getPackageManager()).toString());
            obj.setIcon(info.applicationInfo.loadIcon(application.getApplicationContext().getPackageManager()));
            appObjList.add(obj);

        }

        return appObjList;
    }
}
