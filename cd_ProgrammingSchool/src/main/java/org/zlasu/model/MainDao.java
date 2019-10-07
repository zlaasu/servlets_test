package org.zlasu.model;

import org.zlasu.libs.dbUtils.DBConnector;

import java.sql.*;

public abstract class MainDao {

    protected String getDeleteQuery() {
        return null;
    }

    public void delete(int userId) {
        try (Connection conn = DBConnector.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(getDeleteQuery());
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
