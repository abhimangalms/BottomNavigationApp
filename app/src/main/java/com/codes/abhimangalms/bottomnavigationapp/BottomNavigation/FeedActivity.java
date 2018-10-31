package com.codes.abhimangalms.bottomnavigationapp.BottomNavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codes.abhimangalms.bottomnavigationapp.R;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//back button in Toolbar
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
