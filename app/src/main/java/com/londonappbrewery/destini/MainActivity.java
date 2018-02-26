package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mBtnTop, mBtnBottom;
    TextView mTvStory;
    int[] mStory = new int[]{
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story
    };
    int[] mChoiseTop = new int[]{
            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1
    };
    int[] mChoiseBottom = new int[]{
            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2
    };

    int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnTop = findViewById(R.id.buttonTop);
        mBtnBottom = findViewById(R.id.buttonBottom);
        mTvStory = findViewById(R.id.storyTextView);
        mTvStory.setText(mStory[0]);

        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("IndexKey");
            updateViews(mIndex);
        }

        mBtnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mIndex) {
                    case 0:
                        mIndex = 2;
                        updateViews(mIndex);
                        break;
                    case 1:
                        mIndex = 2;
                        updateViews(mIndex);
                        break;
                    case 2:
                        mTvStory.setText(R.string.T6_End);
                        invisibleBtns();
                        break;
                }
            }
        });

        mBtnBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mIndex) {
                    case 0:
                        mIndex = 1;
                        updateViews(mIndex);
                        break;
                    case 1:
                        mTvStory.setText(R.string.T4_End);
                        invisibleBtns();
                        break;
                    case 2:
                        mTvStory.setText(R.string.T5_End);
                        invisibleBtns();
                        break;
                }
            }
        });

    }

    private void invisibleBtns() {
        mBtnTop.setVisibility(View.GONE);
        mBtnBottom.setVisibility(View.GONE);
    }

    private void updateViews(int index) {
        mTvStory.setText(mStory[index]);
        mBtnTop.setText(mChoiseTop[index]);
        mBtnBottom.setText(mChoiseBottom[index]);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("IndexKey", mIndex);
    }
}
