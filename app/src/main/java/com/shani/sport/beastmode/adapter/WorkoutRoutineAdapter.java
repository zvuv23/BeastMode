package com.shani.sport.beastmode.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.leodroidcoder.genericadapter.BaseViewHolder;
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;
import com.shani.sport.beastmode.R;
import com.shani.sport.beastmode.model.WgerExercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanil on 01/12/2018.
 */

public class WorkoutRoutineAdapter extends GenericRecyclerViewAdapter<WgerExercise, OnRecyclerItemClickListener, WorkoutRoutineAdapter.MyViewHolder> {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends BaseViewHolder<WgerExercise, OnRecyclerItemClickListener> {
        // each data item is just a string in this case
        private TextView _exerciseName;
        private TableLayout _setTable;

        public MyViewHolder(View itemView, OnRecyclerItemClickListener listener) {
            super(itemView, listener);
            _exerciseName = itemView.findViewById(R.id.exerciseName);
            _setTable = itemView.findViewById(R.id.setTable);
            addSetRow(_setTable);

            ImageButton addSetBtn = itemView.findViewById(R.id.addSetBtn);
            addSetBtn.setOnClickListener((view) -> {
                    addSetRow(_setTable);
            });

            if (listener != null) {
                itemView.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
            }
        }

        @Override
        public void onBind(WgerExercise exercise) {
            _exerciseName.setText(exercise.getName());
        }

        private void addSetRow(TableLayout table){
            TableRow setRow = (TableRow) LayoutInflater.from(table.getContext())
                    .inflate(R.layout.workout_set_table_row, _setTable, false);
            int index = table.getChildCount() - 1;
            ((TextView)setRow.findViewById(R.id.setNumberTextView)).setText(String.valueOf(index));
            table.addView(setRow, index);

        }

    }

    public WorkoutRoutineAdapter(Context context, OnRecyclerItemClickListener listener) {
        super(context, listener);
    }

    @Override
    public WorkoutRoutineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflate(R.layout.workout_exercise_card, parent), getListener());
    }

    @Override
    public void setItems(List<WgerExercise> items) {
        if (items == null){
            return;
        }
        super.setItems(items);
    }
}