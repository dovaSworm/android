package com.example.danij.retrofitjson;

import com.example.danij.retrofitjson.model.Feed;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedditApi {

    String BASE_URL = "https://www.reddit.com/";

    @Headers("Content-Type: application/json")
    @GET(".json")
    Call<Feed> getData();

    @POST("{user}")
    Call<ResponseBody> login(
      @HeaderMap Map<String, String> headers,
      @Path("user") String userName,
      @Query("user") String user,
      @Query("passwd") String password,
      @Query("api-type") String type
    );
}
