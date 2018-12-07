package com.shani.sport.beastmode.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.shani.sport.beastmode.webservice.WgerAPIClient;
import com.shani.sport.beastmode.webservice.WgerExerciseService;
import com.shani.sport.beastmode.db.ExerciseDao;
import com.shani.sport.beastmode.db.ExerciseDatabase;
import com.shani.sport.beastmode.model.WgerExercise;
import com.shani.sport.beastmode.pojo.ExerciseList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExerciseRepository implements IExerciseRepository {

    private WgerExerciseService _exerciseService;
    private final ExerciseDao _exerciseDao;


    public ExerciseRepository(Application application){
        _exerciseService = WgerAPIClient.getClient().create(WgerExerciseService.class);
        _exerciseDao = ExerciseDatabase.getInstance(application)._exerciseDao();

    }

    @Override
    public LiveData<List<WgerExercise>> getExercises() {

        _exerciseService.getExercises().enqueue(new getExercisesCallback());

        return _exerciseDao.load();
    }

    class getExercisesCallback implements Callback<ExerciseList>{

        @Override
        public void onResponse(Call<ExerciseList> call, Response<ExerciseList> response) {
            Log.d("TAG",response.code()+"");

            ExerciseList exerciseList = response.body();
            if (exerciseList.getNext() != null){
                String[] split = exerciseList.getNext().split("/");
                _exerciseService.getExercises(split[split.length -1]).enqueue(new getExercisesCallback());
            }

            if (exerciseList != null) {
                _exerciseDao.save(exerciseList.getResults());
            }
        }

        @Override
        public void onFailure(Call<ExerciseList> call, Throwable t) {
            call.cancel();
        }
    }
}
