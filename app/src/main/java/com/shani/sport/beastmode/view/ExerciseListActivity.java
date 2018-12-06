package com.shani.sport.beastmode.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.shani.sport.beastmode.R;
import com.shani.sport.beastmode.adapter.ExerciseListAdapter;
import com.shani.sport.beastmode.model.WgerExercise;
import com.shani.sport.beastmode.viewmodel.ExerciseListViewModel;

import java.util.List;

public class ExerciseListActivity extends AppCompatActivity {

    private RecyclerView _RecyclerView;
    private GenericRecyclerViewAdapter _adapter;
    private ExerciseListViewModel _viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        _viewModel = ViewModelProviders.of(this).get(ExerciseListViewModel.class);

        _RecyclerView = (RecyclerView) findViewById(R.id.exerciseListRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        _RecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        _RecyclerView.setLayoutManager(new LinearLayoutManager(this));

        LiveData<List<WgerExercise>> exerciseListLiveData = _viewModel.getExercises();

        // specify an adapter (see also next example)
        _adapter = new ExerciseListAdapter(this, null);

        //update the list of the adapter once data changes
        exerciseListLiveData.observe(this, exerciseList -> {
            _adapter.setItems(exerciseList);
        });
        _RecyclerView.setAdapter(_adapter);
    }

}
