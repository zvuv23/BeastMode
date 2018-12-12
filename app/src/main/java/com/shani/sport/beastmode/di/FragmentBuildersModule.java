package com.shani.sport.beastmode.di;

import com.shani.sport.beastmode.view.ExerciseListFragment;
import com.shani.sport.beastmode.view.WorkoutRoutineFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract ExerciseListFragment contributeExerciseListFragment();

    @ContributesAndroidInjector
    abstract WorkoutRoutineFragment contributeWorkoutRoutineFragment();
}
