package com.shani.sport.beastmode.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.shani.sport.beastmode.R;
import com.shani.sport.beastmode.adapter.WorkoutRoutineAdapter;
import com.shani.sport.beastmode.viewmodel.WorkoutRoutineViewModel;
import com.shani.sport.beastmode.model.WgerExercise;

import java.util.List;

public class WorkoutRoutineActivity extends AppCompatActivity {

    private RecyclerView _RecyclerView;
    private GenericRecyclerViewAdapter _adapter;
    private WorkoutRoutineViewModel _viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_routine);

        _viewModel = ViewModelProviders.of(this).get(WorkoutRoutineViewModel.class);

        _RecyclerView = (RecyclerView) findViewById(R.id.routineExercisesRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        _RecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        _RecyclerView.setLayoutManager(new LinearLayoutManager(this));

        LiveData<List<WgerExercise>> exerciseListLiveData = _viewModel.getExercises();

        // specify an adapter (see also next example)
        _adapter = new WorkoutRoutineAdapter(this, (item) -> {
            startActivity(new Intent(this, ExerciseListActivity.class));
        });

        //update the list of the adapter once data changes
        exerciseListLiveData.observe(this, exerciseList -> {
            _adapter.setItems(exerciseList);
        });
        _RecyclerView.setAdapter(_adapter);

        FloatingActionButton addExerciseBtn = findViewById(R.id.addExerciseFloatingAction);
        addExerciseBtn.setOnClickListener((view -> {
            startActivity(new Intent(this, ExerciseListActivity.class));
        }));
    }
}
