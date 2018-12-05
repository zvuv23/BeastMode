package com.shani.sport.beastmode.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shani.sport.beastmode.model.WgerExercise;

public class ExerciseList {

    @SerializedName("count")
    @Expose
    private Integer count;

    @SerializedName("next")
    @Expose
    private String next;

    @SerializedName("previous")
    @Expose
    private Object previous;

    @SerializedName("results")
    @Expose
    private List<WgerExercise> results = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<WgerExercise> getResults() {
        return results;
    }

    public void setResults(List<WgerExercise> results) {
        this.results = results;
    }

}
