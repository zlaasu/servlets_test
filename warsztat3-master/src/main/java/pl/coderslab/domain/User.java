package pl.coderslab.domain;

import org.mindrot.jbcrypt.BCrypt;

public class User extends ResultObject<User>{
    private Long id;
    private String username;
    private String password;
    private String email;
    private Long user_group_id;
    private Group group;

    public User() {
    }
    @Override
    public User setValues(String[] row){
        this.setId(Long.parseLong(row[0]));
        this.setUsername(row[1]);
        this.setPassword(row[2]);
        this.setEmail(row[3]);
        if(row[4]!=null) {
            this.setUser_group_id(Long.parseLong(row[4]));
        }
        return this;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setPasswordHash(String password) {
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUser_group_id() {
        return user_group_id;
    }

    public void setUser_group_id(Long user_group_id) {
        this.user_group_id = user_group_id;
    }
}
