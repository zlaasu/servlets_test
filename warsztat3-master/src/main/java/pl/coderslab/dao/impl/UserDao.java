package pl.coderslab.dao.impl;

import pl.coderslab.dao.DaoInterface;
import pl.coderslab.domain.User;
import pl.coderslab.util.DbService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements DaoInterface<User> {

    @Override
    public List<User> findAll() {
        try {
           DbService.Result result = DbService.getInstance()
                   .execute("SELECT id, username, password, email, user_group_id FROM users");
           List<User> users =new ArrayList<>();
            result.getRows().forEach(row->users.add(new User().setValues(row)));
           return users;
        }catch (SQLException e){e.printStackTrace();}

        return null;
    }

    @Override
    public User findById(Long id) {
        try {
            DbService.Result result = DbService.getInstance()
                    .execute("SELECT id, username, password, email, user_group_id FROM users WHERE id=?",
                    String.valueOf(id));
            if(result.getRows().size()>0){
                return new User().setValues(result.getRows().get(0));
            }
        }catch (SQLException e){e.printStackTrace();}

        return null;
    }

    @Override
    public User update(User user) {
        try {
            DbService.Result result = DbService.getInstance()
                    .execute(
                            "UPDATE user SET username=?,password=?,email=?,user_group_id=? WHERE id=?",
                            user.getUsername(),
                            user.getPassword(),
                            user.getEmail(),
                            String.valueOf(user.getUser_group_id()),
                            String.valueOf(user.getId()));
            if(result.getAffectedRowsCount()>0){
                return user;
            }
        }catch (SQLException e){e.printStackTrace();}
        return null;
    }

    @Override
    public User create(User user) {
        try {
            Integer id = DbService.getInstance()
                    .insertInto(
                            "INSERT INTO users(username, password,email,user_group_id) VALUES (?,?,?,?)",
                            String.valueOf(user.getUsername()),
                            user.getPassword(),
                            user.getEmail(),
                            String.valueOf(user.getUser_group_id()));
            if(id!=null){
                user.setId(id.longValue());
                return user;
            }
        }catch (SQLException e){e.printStackTrace();}
        return null;
    }

    @Override
    public boolean remove(User user) {
        try {
            DbService.Result result = DbService.getInstance()
                    .execute(
                            "DELETE FROM users WHERE id=?",
                            String.valueOf(user.getId()));
            if(result.getAffectedRowsCount()>0){
                return true;
            }
        }catch (SQLException e){e.printStackTrace();}
        return false;
    }
}
