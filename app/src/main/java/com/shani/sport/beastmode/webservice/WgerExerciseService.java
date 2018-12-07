package com.shani.sport.beastmode.webservice;

import com.shani.sport.beastmode.pojo.ExerciseList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WgerExerciseService {

    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
//    @GET("/users/{user}")
//    Call<User> getUser(@Path("user") String userId);

    @GET("exercise/?status=2&language=2")
    Call<ExerciseList> getExercises();

    @GET("exercise/{query}")
    Call<ExerciseList> getExercises(@Path("query") String query);
}
