package com.codes.abhimangalms.bottomnavigationapp.BottomNavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.codes.abhimangalms.bottomnavigationapp.R;

public class FeedActivity extends AppCompatActivity {

    ImageButton mLikeImageButton, mCommentImageButton, mShareImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        mLikeImageButton = (ImageButton) findViewById(R.id.likeImageButton);
        mCommentImageButton = (ImageButton) findViewById(R.id.commentImageButton);
        mShareImageButton = (ImageButton) findViewById(R.id.shareImageButton);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//back button in Toolbar

        mShareImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject test");
                i.putExtra(android.content.Intent.EXTRA_TEXT, "extra text that you want to put");
                startActivity(Intent.createChooser(i,"Share via"));

            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
