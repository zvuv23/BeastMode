package com.shani.sport.beastmode.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.shani.sport.beastmode.model.WgerExercise;
import com.shani.sport.beastmode.repository.ExerciseRepository;
import com.shani.sport.beastmode.repository.IExerciseRepository;

import java.util.List;

/**
 * Created by shanil on 05/12/2018.
 */

public class WorkoutRoutineViewModel extends AndroidViewModel {

    private IExerciseRepository _repository;

    public WorkoutRoutineViewModel(Application application){
        super(application);
        _repository = new ExerciseRepository(application);
    }

    public LiveData<List<WgerExercise>> getExercises() {
        return _repository.getExercises();
    }
}
