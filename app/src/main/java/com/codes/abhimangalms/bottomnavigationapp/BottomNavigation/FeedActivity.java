package com.codes.abhimangalms.bottomnavigationapp.BottomNavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.codes.abhimangalms.bottomnavigationapp.R;

public class FeedActivity extends AppCompatActivity {

    TextView mdescriptionTextView;
    ImageButton mLikeImageButton, mCommentImageButton, mShareImageButton;


    String descriptionContentFromRecycler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        mdescriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        mLikeImageButton = (ImageButton) findViewById(R.id.likeImageButton);
        mCommentImageButton = (ImageButton) findViewById(R.id.commentImageButton);
        mShareImageButton = (ImageButton) findViewById(R.id.shareImageButton);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//back button in Toolbar

        Intent intent = getIntent(); // getting data from HomeFragment
        descriptionContentFromRecycler = intent.getStringExtra("descriptionFromRecyclerView");
//        Toast.makeText(this, "real data is " + descriptionContentFromRecycler, Toast.LENGTH_SHORT).show();

        mdescriptionTextView.setText(descriptionContentFromRecycler);




        mShareImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //sharing data option

                Intent i=new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject test");
                i.putExtra(android.content.Intent.EXTRA_TEXT, descriptionContentFromRecycler);
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
