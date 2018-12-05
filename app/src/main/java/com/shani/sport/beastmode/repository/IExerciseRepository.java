package com.shani.sport.beastmode.repository;

import android.arch.lifecycle.LiveData;

import com.shani.sport.beastmode.model.WgerExercise;

import java.util.List;

/**
 * Created by shanil on 05/12/2018.
 */

public interface IExerciseRepository {
    LiveData<List<WgerExercise>> getExercises();
}
