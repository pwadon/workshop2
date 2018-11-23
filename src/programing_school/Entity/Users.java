package programing_school.Entity;

import programing_school.service.*;

public class Users {
    private int id;
    private String username;
    private String email;
    private String password;
    private int user_group_id;



    @Override
    public String toString() {
        return  "id=" + id + ", username=" + username +", email=" + email + ", password=" + CodePassword(password)+", user_group_id=" +user_group_id;
    }
    public Users() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users(String name, String email, String password, int user_group_id ) {
        this.username = name;
        this.email = email;
        this.password = CodePassword(password);
        this.user_group_id = user_group_id;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUser_group_id(int user_group_id) {
        this.user_group_id = user_group_id;
    }

    public int getUser_group_id() {
        return user_group_id;
    }

    public static String  CodePassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = CodePassword(password);
    }
}