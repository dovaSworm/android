package com.example.danij.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity {

    YouTubePlayerView playerMy;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener myOnInitListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerMy = (YouTubePlayerView) findViewById(R.id.viewPlayer);
        btnPlay = (Button) findViewById(R.id.playButton);

        myOnInitListner = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                ArrayList<String> videoList = new ArrayList<>();
                videoList.add("W4hTJybfU7s");
                videoList.add("Wcgd1oCbW4g");
                videoList.add("8Lq3HyBCuAA");
                youTubePlayer.loadVideos(videoList);
//                youTubePlayer.loadPlaylist("teojy6WjlKA&list=RDteojy6WjlKA&start_radio=1&t=15");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMy.initialize(YouTubeConfig.getApiKey(), myOnInitListner);
            }
        });
    }
}
