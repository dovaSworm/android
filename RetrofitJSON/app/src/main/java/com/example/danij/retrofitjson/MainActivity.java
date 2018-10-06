package com.example.danij.retrofitjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.danij.retrofitjson.model.Feed;
import com.example.danij.retrofitjson.model.children.Children;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "https://www.reddit.com/";
    private static final String LOGIN_URL = "https://www.reddit.com/api/login/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        retrieving data button
//        Button getData = (Button) findViewById(R.id.jsonButton);

        //posting data
        Button loginBtn = (Button) findViewById(R.id.btn_login);
        final EditText etName = (EditText) findViewById(R.id.input_username);
        final EditText etPass = (EditText) findViewById(R.id.input_password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etName.getText().toString();
                String pass = etPass.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(LOGIN_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RedditApi redditApi = retrofit.create(RedditApi.class);
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                Call<ResponseBody> call = redditApi.login(headers, username, username, pass, "json");
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.d(TAG, "onResponse: Server response" + response.toString());

                        try {
                            String json = response.body().string();
                            JSONObject data = null;
                            data = new JSONObject(json);
                            Log.d(TAG, "onResponse: json" + json.toString());
                            Log.d(TAG, "onResponse: DATA---------------------------------------------------" + data.toString());
                        }catch (JSONException e){
                            Log.e(TAG, "onResponse: JSONException" + e.getMessage());
                        }catch (IOException ex){
                            Log.e(TAG, "onResponse: JSONException" + ex.getMessage());
                        }
                    };

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e(TAG, "onFailure: Failure !!!" + t.getMessage());
                        Toast.makeText(MainActivity.this,"Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
//        retrieving data code
//        getData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(BASE_URL)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//
//                RedditApi redditApi = retrofit.create(RedditApi.class);
//                Call<Feed> call = redditApi.getData();
//                call.enqueue(new Callback<Feed>() {
//                    @Override
//                    public void onResponse(Call<Feed> call, Response<Feed> response) {
//                        Log.d(TAG, "onResponse: Server response" + response.toString());
//                        Log.d(TAG, "onResponse: received information" + response.body().toString());
//
//                        ArrayList<Children> childrenList = response.body().getData().getChildren();
//                        for(int i = 0; i < childrenList.size(); i++){
//                            Toast.makeText(MainActivity.this,"onResponse: \n" +
//                                    "kind: " + childrenList.get(i).getKind() + "\n" +
//                                    "contest_mode: " + childrenList.get(i).getData().getContest_mode() + "\n" +
//                                    "subreddit: " + childrenList.get(i).getData().getSubreddit() + "\n" +
//                                    "author: " + childrenList.get(i).getData().getAuthor() +
//                                    "-------------------------------------------------------------------" + "\n", Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, "onResponse: \n" +
//                                    "kind: " + childrenList.get(i).getKind() + "\n" +
//                                    "contest_mode: " + childrenList.get(i).getData().getContest_mode() + "\n" +
//                                    "subreddit: " + childrenList.get(i).getData().getSubreddit() + "\n" +
//                                    "author: " + childrenList.get(i).getData().getAuthor() +
//                                    "-------------------------------------------------------------------" + "\n");
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Feed> call, Throwable t) {
//                        Log.e(TAG, "onFailure: Failure !!!" + t.getMessage());
//                        Toast.makeText(MainActivity.this,"Something went wrong", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });

    }
}
