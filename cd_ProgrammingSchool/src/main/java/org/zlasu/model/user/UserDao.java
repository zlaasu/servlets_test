package org.zlasu.model.user;

import org.zlasu.libs.dbUtils.DBConnector;
import org.zlasu.model.MainDao;
import org.zlasu.model.userGroup.UserGroup;
import org.zlasu.model.userGroup.UserGroupDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends MainDao {

    private final String CREATE_QUERY = "INSERT INTO users(user_group_id, username, email, password) VALUES (?, ?, ?, ?)";
    private final String READ_QUERY = "SELECT * FROM users where id = ?";
    private final String UPDATE_QUERY = "UPDATE users SET user_group_id = ?, username = ?, email = ?, password = ? where id = ?";
    private final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";
    private final String FIND_ALL_QUERY = "SELECT * FROM users";

    public User create(User user) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);

            if (user.getUserGroup() != null && user.getUserGroup().getId() > 0) {
                statement.setInt(1, user.getUserGroup().getId());
            } else {
                statement.setString(1, null);
            }
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User read(int userId) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

                Integer groupId = resultSet.getInt("user_group_id");
                if (groupId != null) {
                    UserGroupDao groupDao = new UserGroupDao();
                    UserGroup group = groupDao.read(groupId);
                    user.setUserGroup(group);
                }
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User user) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);

            if (user.getUserGroup() != null && user.getUserGroup().getId() > 0) {
                statement.setInt(1, user.getUserGroup().getId());
            } else {
                statement.setString(1, null);
            }

            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        try (Connection conn = DBConnector.getConnection()) {
            List<User> users = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                UserGroupDao userGroupDao = new UserGroupDao();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setUserGroup(userGroupDao.read(resultSet.getInt("user_group_id")));
                users.add(user);
            }
            return users;
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
