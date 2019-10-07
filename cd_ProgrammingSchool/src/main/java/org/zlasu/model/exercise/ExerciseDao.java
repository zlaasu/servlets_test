package org.zlasu.model.exercise;

import org.zlasu.libs.dbUtils.DBConnector;
import org.zlasu.model.MainDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao extends MainDao {

    private final String CREATE_QUERY = "INSERT INTO exercise(title, description) VALUES (?, ?)";
    private final String READ_QUERY = "SELECT * FROM exercise where id = ?";
    private final String UPDATE_QUERY = "UPDATE exercise SET title = ?, description = ? where id = ?";
    private final String DELETE_QUERY = "DELETE FROM exercise WHERE id = ?";
    private final String FIND_ALL_QUERY = "SELECT * FROM exercise";

    public Exercise create(Exercise exercise) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, exercise.getTitle());
            statement.setString(2, exercise.getDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                exercise.setId(resultSet.getInt(1));
            }
            return exercise;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Exercise read(int userId) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Exercise exercise = new Exercise();
                exercise.setId(resultSet.getInt("id"));
                exercise.setTitle(resultSet.getString("title"));
                exercise.setDescription(resultSet.getString("description"));
                return exercise;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Exercise exercise) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setString(1, exercise.getTitle());
            statement.setString(2, exercise.getDescription());
            statement.setInt(3, exercise.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Exercise> findAll() {
        try (Connection conn = DBConnector.getConnection()) {
            List<Exercise> exercises = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Exercise exercise = new Exercise();
                exercise.setId(resultSet.getInt("id"));
                exercise.setTitle(resultSet.getString("title"));
                exercise.setDescription(resultSet.getString("description"));
                exercises.add(exercise);
            }
            return exercises;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_QUERY;
    }
}
