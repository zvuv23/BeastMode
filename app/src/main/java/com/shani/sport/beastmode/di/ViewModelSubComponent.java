package com.shani.sport.beastmode.di;

import com.shani.sport.beastmode.viewmodel.ExerciseListViewModel;
import com.shani.sport.beastmode.viewmodel.WorkoutRoutineViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    ExerciseListViewModel exerciseListViewModel();
    WorkoutRoutineViewModel workoutRoutineViewModel();
}