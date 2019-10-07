package org.zlasu.model.solution;

import org.zlasu.model.MainModel;
import org.zlasu.model.exercise.Exercise;
import org.zlasu.model.user.User;

import java.util.Date;

public class Solution extends MainModel {

    private Exercise exercise;
    private User user;
    private Date created;
    private Date updated;
    private String description;

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
