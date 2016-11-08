package test.task.java.dao;


import test.task.java.dao.entity.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    void updateUser(User user);
    User findUserById(Long id);
    List<User> findUserBySurname(String surname);
    List<User> findUserByName(String name);
    List<User> findUserByAge(Integer age);
    List<User> findUserBySex(Character sex);
    List<User> findUserByMobileNumber(String mobileNumber);
    List<User> getAllUser();
}
