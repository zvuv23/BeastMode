package com.shani.sport.beastmode.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.shani.sport.beastmode.model.WgerExercise;

@Database(entities = {WgerExercise.class}, version = 1)
public abstract class ExerciseDatabase extends RoomDatabase {

    private static ExerciseDatabase INSTANCE;
    public abstract ExerciseDao _exerciseDao();

    private static final Object sLock = new Object();

    public static ExerciseDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        ExerciseDatabase.class, "Exercises.db")
                        .allowMainThreadQueries() //TODO Remove this
                        .fallbackToDestructiveMigration()
                        .build();
            }
            return INSTANCE;
        }
    }

}
