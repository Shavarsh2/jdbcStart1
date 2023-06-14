package am.hitech.jdbc.repo;

import am.hitech.jdbc.interfaces.UserRepository;
import am.hitech.jdbc.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepoSpringJdbc implements UserRepository {
    JdbcTemplate jdbcTemplate;
    public UserRepoSpringJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public User getById(int id) {
        String query = "select * from user where id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(query,id);
        User user = null;
        while (sqlRowSet.next()){
            user = new User();
            user.setId(sqlRowSet.getInt("id"));
            user.setFirstName(sqlRowSet.getString("first_name"));
            user.setLastName(sqlRowSet.getString("last_name"));
            user.setAge(sqlRowSet.getInt("age"));
            user.setEmail(sqlRowSet.getString("email"));
            user.setPassword(sqlRowSet.getString("password"));
            return user;
        }
        return user;
    }

    @Override
    public User getByUsername(String username) {
        String query = "select * from user where email = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(query,username);
        User user = null;
        while (sqlRowSet.next()){
            user = new User();
            user.setId(sqlRowSet.getInt("id"));
            user.setFirstName(sqlRowSet.getString("first_name"));
            user.setLastName(sqlRowSet.getString("last_name"));
            user.setAge(sqlRowSet.getInt("age"));
            user.setEmail(sqlRowSet.getString("email"));
            user.setPassword(sqlRowSet.getString("password"));
            return user;
        }
        return null;
    }

    @Override
    public int creatUserV2(User user) {
        String query = "insert into `user` values(0,?,?,?,?,?,NULL,NULL)";

        String fName = user.getFirstName();
        String lName = user.getLastName();
        String email = user.getEmail();
        int age = user.getAge();
        String pass = user.getPassword();

        int row = jdbcTemplate.update(query,fName,lName,email,age,pass);

        return row;
    }

    @Override
    public int updateUser(User user) {
        String query = "UPDATE `user` SET first_name = ?,last_name = ? WHERE id = ?";
        int row = jdbcTemplate.update(query,user.getFirstName(),user.getLastName(),user.getId());
        return row;
    }

    @Override
    public int deleteUser(User user) {
        String query = "delete from `user` where email = ?";

        return jdbcTemplate.update(query,user.getEmail());
    }

    @Override
    public User getbyPassToken(String pass) {
        String query = "select * from `user` where password_token = ?";
        User user = null;
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(query,pass);
        while (sqlRowSet.next()){
            user = new User();
            user.setId(sqlRowSet.getInt("id"));
            user.setFirstName(sqlRowSet.getString("first_name"));
            user.setLastName(sqlRowSet.getString("last_name"));
            user.setAge(sqlRowSet.getInt("age"));
            user.setEmail(sqlRowSet.getString("email"));
            user.setPassword(sqlRowSet.getString("password"));
            return user;
        }
        return user;
    }

    @Override
    public int updateUserPass(User user) {
        String query = "UPDATE `user` SET password = ? WHERE id = ?";

        return jdbcTemplate.update(query,user.getPassword(),user.getId());
    }

    @Override
    public List<User> getByName(String name) {
        String query = "select * from user where first_name = ?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(query,name);
        List<User> list1 = new ArrayList<>();

        for (Map<String, Object> map: list) {
            User user = new User();
            user.setId((Integer) map.get("id"));
            user.setFirstName((String) map.get("first_name"));
            user.setLastName((String) map.get("last_name"));
            user.setAge((Integer) map.get("age"));
            user.setEmail((String) map.get("email"));
            user.setPassword((String) map.get("password"));

            list1.add(user);
        }
        return list1;
    }

    @Override
    public List<User> getByNameSearch(String name, String userName) {
        return null;
    }

    @Override
    public List<User> getAll() {
        String query = "select * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
        List<User> list1 = new ArrayList<>();

        for (Map<String, Object> map: list) {
            User user = new User();
            user.setId((Integer) map.get("id"));
            user.setFirstName((String) map.get("first_name"));
            user.setLastName((String) map.get("last_name"));
            user.setAge((Integer) map.get("age"));
            user.setEmail((String) map.get("email"));
            user.setPassword((String) map.get("password"));

            list1.add(user);
        }
        return list1;
        //List<User> listuser = jdbcTemplate.queryForList(query,User.class);
        //return listuser;
        // SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(query);
    }
}
