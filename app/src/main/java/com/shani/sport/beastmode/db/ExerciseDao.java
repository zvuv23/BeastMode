package com.shani.sport.beastmode.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.shani.sport.beastmode.model.WgerExercise;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ExerciseDao {

    @Insert(onConflict = REPLACE)
    void save(List<WgerExercise> exercises);

    @Query("SELECT * FROM exercises")
    LiveData<List<WgerExercise>> load();
}
