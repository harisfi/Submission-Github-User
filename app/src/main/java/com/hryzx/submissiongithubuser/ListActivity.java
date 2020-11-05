package com.hryzx.submissiongithubuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    String[] sUsername, sName, sLocation, sCompany, sRepository, sFollowers, sFollowing;
    RecyclerView recyclerView;
    RvAdapter adapter;
    TypedArray sPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        prepare();

        adapter = new RvAdapter(this, getMyList());
        recyclerView.setAdapter(adapter);
    }

    private void prepare() {
        sUsername = getResources().getStringArray(R.array.username);
        sName = getResources().getStringArray(R.array.name);
        sLocation = getResources().getStringArray(R.array.location);
        sCompany = getResources().getStringArray(R.array.company);
        sRepository = getResources().getStringArray(R.array.repository);
        sFollowers = getResources().getStringArray(R.array.followers);
        sFollowing = getResources().getStringArray(R.array.following);
        sPhoto = getResources().obtainTypedArray(R.array.avatar);
    }

    private ArrayList<RvModels> getMyList(){
        ArrayList<RvModels> models = new ArrayList<>();

        for (int i=0; i<sName.length; i++){
            RvModels model = new RvModels();
            model.setUsername(sUsername[i]);
            model.setName(sName[i]);
            model.setLocation(sLocation[i]);
            model.setCompany(sCompany[i]);
            model.setRepository(Integer.parseInt(sRepository[i]));
            model.setFollowers(Integer.parseInt(sFollowers[i]));
            model.setFollowing(Integer.parseInt((sFollowing[i])));
            model.setAvatar(sPhoto.getResourceId(i, -1));
            models.add(model);
        }

        return models;
    }
}