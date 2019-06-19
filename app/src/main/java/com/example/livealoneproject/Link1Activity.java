package com.example.livealoneproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Link1Activity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView1;
    YouTubePlayerView youTubePlayerView2;
    YouTubePlayerView youTubePlayerView3;
    YouTubePlayerView youTubePlayerView4;
    YouTubePlayerView youTubePlayerView5;

    YouTubePlayer.OnInitializedListener listener1;
    YouTubePlayer.OnInitializedListener listener2;
    YouTubePlayer.OnInitializedListener listener3;
    YouTubePlayer.OnInitializedListener listener4;
    YouTubePlayer.OnInitializedListener listener5;

    ImageButton play1;
    ImageButton play2;
    ImageButton play3;
    ImageButton play4;
    ImageButton play5;

    TextView tv1,tv2,tv3,tv4,tv5;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link1);

        i=getIntent();

        play1=(ImageButton) findViewById(R.id.play1);
        play2=(ImageButton) findViewById(R.id.play2);
        play3=(ImageButton) findViewById(R.id.play3);
        play4=(ImageButton) findViewById(R.id.play4);
        play5=(ImageButton) findViewById(R.id.play5);

        youTubePlayerView1=(YouTubePlayerView) findViewById(R.id.youtube1);
        youTubePlayerView2=(YouTubePlayerView) findViewById(R.id.youtube2);
        youTubePlayerView3=(YouTubePlayerView) findViewById(R.id.youtube3);
        youTubePlayerView4=(YouTubePlayerView) findViewById(R.id.youtube4);
        youTubePlayerView5=(YouTubePlayerView) findViewById(R.id.youtube5);

        tv1=(TextView) findViewById(R.id.tv1);
        tv2=(TextView) findViewById(R.id.tv2);
        tv3=(TextView) findViewById(R.id.tv3);
        tv4=(TextView) findViewById(R.id.tv4);
        tv5=(TextView) findViewById(R.id.tv5);

        //1
        listener1 = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("H_O3eoQD3TA");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setVisibility(View.INVISIBLE);
                play1.setVisibility(View.INVISIBLE);

                //그외에것들 보여주기
                tv5.setVisibility(View.VISIBLE);
                play5.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                play2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
                play3.setVisibility(View.VISIBLE);
                tv4.setVisibility(View.VISIBLE);
                play4.setVisibility(View.VISIBLE);
                youTubePlayerView1.initialize("AIzaSyDudGbOvKMgtQ1MkBbJGHT-8AnNei4RMyg", listener1);
            }
        });

        //2
        listener2 = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("j0FWUazfuSc");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setVisibility(View.INVISIBLE);
                play2.setVisibility(View.INVISIBLE);

                //그외에것들 보여주기
                tv1.setVisibility(View.VISIBLE);
                play1.setVisibility(View.VISIBLE);
                tv5.setVisibility(View.VISIBLE);
                play5.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
                play3.setVisibility(View.VISIBLE);
                tv4.setVisibility(View.VISIBLE);
                play4.setVisibility(View.VISIBLE);
                youTubePlayerView2.initialize("AIzaSyDudGbOvKMgtQ1MkBbJGHT-8AnNei4RMyg", listener2);
            }
        });

        //3
        listener3 = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("XrN-sbfoA7M");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv3.setVisibility(View.INVISIBLE);
                play3.setVisibility(View.INVISIBLE);

                //그외에것들 보여주기
                tv1.setVisibility(View.VISIBLE);
                play1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                play2.setVisibility(View.VISIBLE);
                tv5.setVisibility(View.VISIBLE);
                play5.setVisibility(View.VISIBLE);
                tv4.setVisibility(View.VISIBLE);
                play4.setVisibility(View.VISIBLE);
                youTubePlayerView3.initialize("AIzaSyDudGbOvKMgtQ1MkBbJGHT-8AnNei4RMyg", listener3);
            }
        });

        //4
        listener4 = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("WoEH6aXSUxs");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv4.setVisibility(View.INVISIBLE);
                play4.setVisibility(View.INVISIBLE);

                //그외에것들 보여주기
                tv1.setVisibility(View.VISIBLE);
                play1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                play2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
                play3.setVisibility(View.VISIBLE);
                tv5.setVisibility(View.VISIBLE);
                play5.setVisibility(View.VISIBLE);
                youTubePlayerView4.initialize("AIzaSyDudGbOvKMgtQ1MkBbJGHT-8AnNei4RMyg", listener4);
            }
        });

        //5
        listener5 = new YouTubePlayer.OnInitializedListener(){
            //초기화 성공시

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("pDovI8HIbWQ");//url의 맨 뒷부분 ID값만 넣으면 됨
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        play5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv5.setVisibility(View.INVISIBLE);
                play5.setVisibility(View.INVISIBLE);

                //그외에것들 보여주기
                tv1.setVisibility(View.VISIBLE);
                play1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                play2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
                play3.setVisibility(View.VISIBLE);
                tv4.setVisibility(View.VISIBLE);
                play4.setVisibility(View.VISIBLE);
                youTubePlayerView5.initialize("AIzaSyDudGbOvKMgtQ1MkBbJGHT-8AnNei4RMyg", listener5);
            }
        });


    }

}

