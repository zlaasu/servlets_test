package org.zlasu.model.solution;

import org.zlasu.libs.dbUtils.DBConnector;
import org.zlasu.model.MainDao;
import org.zlasu.model.exercise.Exercise;
import org.zlasu.model.exercise.ExerciseDao;
import org.zlasu.model.user.User;
import org.zlasu.model.user.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao extends MainDao {

    private final String CREATE_QUERY = "INSERT INTO solution(exercise_id, user_id, created, updated, description) " +
            "VALUES (?, ?, ?, ?, ?)";
    private final String READ_QUERY = "SELECT * FROM solution where id = ?";
    private final String UPDATE_QUERY = "UPDATE solution SET exercise_id = ?, user_id = ?, created = ?, updated = ?," +
            " description = ? where id = ?";
    private final String DELETE_QUERY = "DELETE FROM solution WHERE id = ?";
    private final String FIND_ALL_QUERY = "SELECT * FROM solution";

    public Solution create(Solution solution) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);

            if (solution.getExercise() != null && solution.getExercise().getId() > 0) {
                statement.setInt(1, solution.getExercise().getId());
            } else {
                statement.setString(1, null);
            }

            if (solution.getUser() != null && solution.getUser().getId() > 0) {
                statement.setInt(2, solution.getUser().getId());
            } else {
                statement.setString(2, null);
            }

            statement.setDate(3, new java.sql.Date(solution.getCreated().getTime()));
            statement.setDate(4, new java.sql.Date(solution.getUpdated().getTime()));
            statement.setString(5, solution.getDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                solution.setId(resultSet.getInt(1));
            }
            return solution;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Solution read(int userId) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getDate("created"));
                solution.setUpdated(resultSet.getDate("updated"));
                solution.setDescription(resultSet.getString("description"));

                Integer exerciseId = resultSet.getInt("exercise_id");
                if (exerciseId != null) {
                    ExerciseDao exerciseDao = new ExerciseDao();
                    Exercise exercise = exerciseDao.read(exerciseId);
                    solution.setExercise(exercise);
                }

                Integer usersId = resultSet.getInt("user_id");
                if (exerciseId != null) {
                    UserDao userDao = new UserDao();
                    User user = userDao.read(usersId);
                    solution.setUser(user);
                }

                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Solution solution) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);

            if (solution.getExercise() != null && solution.getExercise().getId() > 0) {
                statement.setInt(1, solution.getExercise().getId());
            } else {
                statement.setString(1, null);
            }

            if (solution.getUser() != null && solution.getUser().getId() > 0) {
                statement.setInt(2, solution.getUser().getId());
            } else {
                statement.setString(2, null);
            }

            statement.setDate(3, new java.sql.Date(solution.getCreated().getTime()));
            statement.setDate(4, new java.sql.Date(solution.getUpdated().getTime()));
            statement.setString(5, solution.getDescription());
            statement.setInt(6, solution.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Solution> findAll() {
        try (Connection conn = DBConnector.getConnection()) {
            List<Solution> solutions = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solution solution = new Solution();
                ExerciseDao exerciseDao = new ExerciseDao();

                UserDao userDao = new UserDao();

                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getDate("created"));
                solution.setUpdated(resultSet.getDate("updated"));
                solution.setDescription(resultSet.getString("description"));

                Integer exerciseID = resultSet.getInt("exercise_id");
                Integer userID = resultSet.getInt("user_id");
                solution.setExercise(exerciseDao.read(exerciseID));
                solution.setUser(userDao.read(userID));

                solutions.add(solution);
            }
            return solutions;
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
