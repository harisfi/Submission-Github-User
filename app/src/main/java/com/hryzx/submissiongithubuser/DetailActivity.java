package com.hryzx.submissiongithubuser;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView txName, txUname, txCompany, txRepo, txLoc, txFlwr, txFlwg;
    Button btGit, btShare;
    ImageView imAvatar;
    RvModels mdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        txName = findViewById(R.id.tvName);
        txUname = findViewById(R.id.tvUName);
        txCompany = findViewById(R.id.tvCompany);
        txRepo = findViewById(R.id.tvRepo);
        txLoc = findViewById(R.id.tvLoc);
        txFlwr = findViewById(R.id.tvFollowers);
        txFlwg = findViewById(R.id.tvFollowing);
        imAvatar = findViewById(R.id.imgAvatar);
        btGit = findViewById(R.id.btGit);
        btShare = findViewById(R.id.btShare);

        mdl = getIntent().getParcelableExtra("parcel");

        assert mdl != null;
        actionBar.setTitle(mdl.getName());
        txName.setText(mdl.getName());
        txUname.setText(mdl.getUsername());
        txCompany.setText(mdl.getCompany());
        txRepo.setText(String.valueOf(mdl.getRepository()));
        txLoc.setText(mdl.getLocation());
        txFlwr.setText(String.valueOf(mdl.getFollowers()));
        txFlwg.setText(String.valueOf(mdl.getFollowing()));
        imAvatar.setImageResource(mdl.getAvatar());

        btGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openGithub = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/" + mdl.getUsername()));
                startActivity(openGithub);
            }
        });

        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "https://www.github.com/" + mdl.getUsername());
                startActivity(Intent.createChooser(iShare, "Share"));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}