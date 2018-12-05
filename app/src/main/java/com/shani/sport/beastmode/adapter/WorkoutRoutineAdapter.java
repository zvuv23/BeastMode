package com.shani.sport.beastmode.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.shani.sport.beastmode.R;
import com.shani.sport.beastmode.model.WgerExercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanil on 01/12/2018.
 */

public class WorkoutRoutineAdapter extends RecyclerView.Adapter<WorkoutRoutineAdapter.MyViewHolder> {
    private List<WgerExercise> _exerciseList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView _exerciseName;
        public TableLayout _setTable;

        public MyViewHolder(View v) {
            super(v);
            _exerciseName = v.findViewById(R.id.exerciseName);
            _setTable = v.findViewById(R.id.setTable);
            addSetRow(_setTable);

            ImageButton addSetBtn = v.findViewById(R.id.addSetBtn);
            addSetBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addSetRow(_setTable);
                }
            });
        }

        private void addSetRow(TableLayout table){
            TableRow setRow = (TableRow) LayoutInflater.from(table.getContext())
                    .inflate(R.layout.workout_set_table_row, _setTable, false);
            int index = table.getChildCount() - 1;
            ((TextView)setRow.findViewById(R.id.setNumberTextView)).setText(String.valueOf(index));
            table.addView(setRow, index);

        }
    }

    public WorkoutRoutineAdapter(List<WgerExercise> exerciseList) {
        setData(exerciseList);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WorkoutRoutineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workout_exercise_card, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder._exerciseName.setText(_exerciseList.get(position).getName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return _exerciseList.size();
    }

    public void setData(List<WgerExercise> exerciseList) {
        if (exerciseList == null){
            exerciseList = new ArrayList<>(0);
        }
        _exerciseList = exerciseList;
        notifyDataSetChanged();
    }
}