package com.example.danij.listview;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "Secondscreen";
    private WebView mWebView;
    private Button openBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);



        TextView ime = (TextView) findViewById(R.id.textView1);
        TextView pol = (TextView) findViewById(R.id.textView2);
        TextView datumrodjenja = (TextView) findViewById(R.id.textView3);
        ImageView slika = (ImageView) findViewById(R.id.image);
        openBrowser = (Button) findViewById(R.id.brobutton);


        Person osoba = (Person) getIntent().getSerializableExtra("serialize");
        ime.setText(osoba.getName());
        pol.setText(osoba.getSex());
        datumrodjenja.setText(osoba.getBirthday());
        String uriString = osoba.getImageUrl();
        Intent intent = getIntent();
        int defaultImage = this.getResources().getIdentifier("@drawable/image_failed", null, this.getPackageName());
        ImageLoader imageLoader = ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();
        imageLoader.displayImage(uriString, slika, options);
//        String name = intent.getStringExtra("ime");
//        String sex = intent.getStringExtra("pol");
//        String bday = intent.getStringExtra("datumrodjenja");
//        ime.setText(name);
//        pol.setText(sex);
//        datumrodjenja.setText(bday);
        Log.d(TAG, "onCreate: usao u drugi activity: " + osoba.getName());

        openBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebView = (WebView) findViewById(R.id.webview);
                WebSettings settings = mWebView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setBlockNetworkImage(true);

                mWebView.loadUrl("https://www.youtube.com/");
            }
        });

    }
}
