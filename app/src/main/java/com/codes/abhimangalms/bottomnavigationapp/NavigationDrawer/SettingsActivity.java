package com.codes.abhimangalms.bottomnavigationapp.NavigationDrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codes.abhimangalms.bottomnavigationapp.R;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
