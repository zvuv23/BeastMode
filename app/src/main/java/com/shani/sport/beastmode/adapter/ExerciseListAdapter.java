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

public class ExerciseListAdapter extends GenericRecyclerViewAdapter<WgerExercise, OnRecyclerItemClickListener, ExerciseListAdapter.MyViewHolder> {

    public ExerciseListAdapter(Context context, OnRecyclerItemClickListener listener) {
        super(context, listener);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends BaseViewHolder<WgerExercise, OnRecyclerItemClickListener> {
        // each data item is just a string in this case
        public TextView _exerciseName;

        public MyViewHolder(View itemView, OnRecyclerItemClickListener listener) {
            super(itemView, listener);
            _exerciseName = itemView.findViewById(R.id.exerciseName);
            if (listener != null) {
                itemView.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
            }
        }

        @Override
        public void onBind(WgerExercise exercise) {
            _exerciseName.setText(exercise.getName());
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ExerciseListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        return new ExerciseListAdapter.MyViewHolder(inflate(R.layout.content_exercise_list, parent), getListener());
    }

}