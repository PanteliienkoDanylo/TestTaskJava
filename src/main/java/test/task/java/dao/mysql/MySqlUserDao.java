package test.task.java.dao.mysql;


import test.task.java.dao.UserDao;
import test.task.java.dao.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao implements UserDao{

    public static final String SQL_CRETE_USER = "INSERT INTO users(surname, name, age, sex, mobile_number) VALUES (?,?,?,?,?)";
    public static final String SQL_UPDATE_USER = "UPDATE users SET surname = ?, name = ?, age = ?, sex = ?, mobile_number = ? WHERE id = ?";
    public static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";


    @Override
    public void addUser(User user) {
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_CRETE_USER);
            ps.setString(1, user.getSurname());
            ps.setString(2, user.getName());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getSex().toString());
            ps.setString(5, user.getMobileNumber());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    @Override
    public void updateUser(User user) {
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_USER);
            ps.setString(1, user.getSurname());
            ps.setString(2, user.getName());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getSex().toString());
            ps.setString(5, user.getMobileNumber());
            ps.setLong(6, user.getId());
            ps.executeUpdate();
        }catch (SQLException ex){
        }
    }

    @Override
    public User findUserById(Long id) {
        List<User> users = getAllUser();
        for(User user : users){
            if(id == user.getId()){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findUserBySurname(String surname) {
        List<User> result = new ArrayList<User>();
        List<User> users = getAllUser();
        for(User user : users){
            if(users.size() > 0 && user.getSurname().toLowerCase().contains(surname.toLowerCase())){
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public List<User> findUserByName(String name) {
        List<User> result = new ArrayList<User>();
        List<User> users = getAllUser();
        for(User user : users){
            if(users.size() > 0 && user.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public List<User> findUserByAge(Integer age) {
        List<User> result = new ArrayList<User>();
        List<User> users = getAllUser();
        for(User user : users){
            if(users.size() > 0 && user.getAge() == age){
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public List<User> findUserBySex(Character sex) {
        List<User> result = new ArrayList<User>();
        List<User> users = getAllUser();
        for(User user : users){
            if(users.size() > 0 && user.getSex() == sex){
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public List<User> findUserByMobileNumber(String mobileNumber) {
        List<User> result = new ArrayList<User>();
        List<User> users = getAllUser();
        for(User user : users){
            if(users.size() > 0 && user.getMobileNumber().toLowerCase().contains(mobileNumber.toLowerCase())){
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public List<User> getAllUser() {
        List<User> result = new ArrayList<User>();
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_USERS);
            while(rs.next()){
                result.add(new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5).charAt(0), rs.getString(6)));
            }
        }catch(SQLException ex){
        }
        return result;
    }
}
