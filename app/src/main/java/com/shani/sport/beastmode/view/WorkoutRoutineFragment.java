package com.shani.sport.beastmode.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.shani.sport.beastmode.R;
import com.shani.sport.beastmode.adapter.WorkoutRoutineAdapter;
import com.shani.sport.beastmode.viewmodel.WorkoutRoutineViewModel;
import com.shani.sport.beastmode.model.WgerExercise;

import java.util.List;

public class WorkoutRoutineFragment extends Fragment {

    private RecyclerView _RecyclerView;
    private GenericRecyclerViewAdapter _adapter;
    private WorkoutRoutineViewModel _viewModel;

    public static WorkoutRoutineFragment newInstance() {
        return new WorkoutRoutineFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_workout_routine, container, false);
        _RecyclerView = (RecyclerView) rootView.findViewById(R.id.routineExercisesRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        _RecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        _RecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // specify an adapter (see also next example)
//        _adapter = new WorkoutRoutineAdapter(this, (item) -> {
//            startActivity(new Intent(this, ExerciseListFragment.class));
//        });

        _adapter = new WorkoutRoutineAdapter(getContext(), null);

        _RecyclerView.setAdapter(_adapter);

        FloatingActionButton addExerciseBtn = rootView.findViewById(R.id.addExerciseFloatingAction);
//        addExerciseBtn.setOnClickListener((view -> {
//            startActivity(new Intent(this, ExerciseListFragment.class));
//        }));
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _viewModel = ViewModelProviders.of(this).get(WorkoutRoutineViewModel.class);

        LiveData<List<WgerExercise>> exerciseListLiveData = _viewModel.getExercises();
        //update the list of the adapter once data changes
        exerciseListLiveData.observe(this, exerciseList -> {
            Log.d("TAG", "Observing live data: live data changed");
            _adapter.setItems(exerciseList);
        });

        _adapter.setItems(exerciseListLiveData.getValue());

    }

}
