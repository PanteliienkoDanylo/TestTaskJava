package test.task.java.dao.mysql;

import test.task.java.dao.DaoFactory;
import test.task.java.dao.UserDao;


public class MySqlDaoFactory extends DaoFactory{

    @Override
    public UserDao createUserDao() {
        return new MySqlUserDao();
    }
}
