package org.zlasu.model.userGroup;

import org.zlasu.model.MainDao;
import org.zlasu.libs.dbUtils.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDao extends MainDao {

    private static final String CREATE_QUERY = "INSERT INTO users_group(name) VALUES (?)";
    private static final String READ_QUERY = "SELECT * FROM users_group where id = ?";
    private static final String UPDATE_QUERY = "UPDATE users_group SET name = ? where id = ?";
    private static final String DELETE_QUERY = "DELETE FROM users_group WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users_group";

    public UserGroup create(UserGroup userGroup) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userGroup.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                userGroup.setId(resultSet.getInt(1));
            }
            return userGroup;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserGroup read(int userId) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                UserGroup userGroup = new UserGroup();
                userGroup.setId(resultSet.getInt("id"));
                userGroup.setName(resultSet.getString("name"));
                return userGroup;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(UserGroup userGroup) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setString(1, userGroup.getName());
            statement.setInt(2, userGroup.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserGroup> findAll() {
        try (Connection conn = DBConnector.getConnection()) {
            List<UserGroup> userGroups = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserGroup userGroup = new UserGroup();
                userGroup.setId(resultSet.getInt("id"));
                userGroup.setName(resultSet.getString("name"));
                userGroups.add(userGroup);
            }
            return userGroups;
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