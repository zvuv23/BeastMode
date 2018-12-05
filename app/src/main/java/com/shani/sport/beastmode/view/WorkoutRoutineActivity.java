package com.shani.sport.beastmode.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shani.sport.beastmode.R;
import com.shani.sport.beastmode.adapter.WorkoutRoutineAdapter;
import com.shani.sport.beastmode.viewmodel.WorkoutRoutineViewModel;
import com.shani.sport.beastmode.model.WgerExercise;

import java.util.List;

public class WorkoutRoutineActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WorkoutRoutineAdapter mAdapter;
    private WorkoutRoutineViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_routine);

        viewModel = ViewModelProviders.of(this).get(WorkoutRoutineViewModel.class);

        mRecyclerView = (RecyclerView) findViewById(R.id.routineExercisesRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        LiveData<List<WgerExercise>> exerciseListLiveData = viewModel.getExercises();

        // specify an adapter (see also next example)
        mAdapter = new WorkoutRoutineAdapter(exerciseListLiveData.getValue());

        //update the list of the adapter once data changes
        exerciseListLiveData.observe(this, exerciseList -> {
            mAdapter.setData(exerciseList);
        });
        mRecyclerView.setAdapter(mAdapter);
    }
}
