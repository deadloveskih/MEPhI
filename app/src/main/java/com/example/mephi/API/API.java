package com.example.mephi.API;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  API {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";
    @GET("todos/1/")
    Call<model> getLesson();
}
