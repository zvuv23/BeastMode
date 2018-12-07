package com.shani.sport.beastmode.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.shani.sport.beastmode.R;
import com.shani.sport.beastmode.adapter.ExerciseListAdapter;
import com.shani.sport.beastmode.adapter.WorkoutRoutineAdapter;
import com.shani.sport.beastmode.model.WgerExercise;
import com.shani.sport.beastmode.viewmodel.ExerciseListViewModel;
import com.shani.sport.beastmode.viewmodel.WorkoutRoutineViewModel;

import java.util.List;

public class ExerciseListFragment extends Fragment {

    private RecyclerView _RecyclerView;
    private GenericRecyclerViewAdapter _adapter;
    private ExerciseListViewModel _viewModel;

    public static ExerciseListFragment newInstance() {
        return new ExerciseListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise_list, container, false);
        _RecyclerView = (RecyclerView) rootView.findViewById(R.id.exerciseListRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        _RecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        _RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // specify an adapter (see also next example)
        _adapter = new ExerciseListAdapter(getContext(), null);
        _RecyclerView.setAdapter(_adapter);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _viewModel = ViewModelProviders.of(this).get(ExerciseListViewModel.class);

        LiveData<List<WgerExercise>> exerciseListLiveData = _viewModel.getExercises();
        //update the list of the adapter once data changes
        exerciseListLiveData.observe(this, exerciseList -> {
            Log.d("TAG", "Observing live data: live data changed");
            _adapter.setItems(exerciseList);
        });

        _adapter.setItems(exerciseListLiveData.getValue());

    }

}
