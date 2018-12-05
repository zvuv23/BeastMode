package com.shani.sport.beastmode.repository;

import android.arch.lifecycle.LiveData;

import com.shani.sport.beastmode.model.WgerExercise;
import com.shani.sport.beastmode.repository.IExerciseRepository;

import java.util.List;

/**
 * Created by shanil on 05/12/2018.
 */

public class MockExerciseRepository implements IExerciseRepository {

    @Override
    public LiveData<List<WgerExercise>> getExercises(){
//        return Arrays.asList(new Exercise("lunge"), new Exercise("squat"), new Exercise("deadlift"));
        return null;
    }
}
