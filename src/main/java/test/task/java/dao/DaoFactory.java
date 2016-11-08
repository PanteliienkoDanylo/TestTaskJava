package test.task.java.dao;


public abstract class DaoFactory {

    public static final String JDBC_DRIVER_MYSQL = "test.task.java.dao.mysql.MySqlDaoFactory";

    public abstract UserDao createUserDao();

    public static DaoFactory getInstance() {
        Class clazz;
        try {
            clazz = Class.forName(JDBC_DRIVER_MYSQL);
            return (DaoFactory) clazz.newInstance();
        } catch (Exception e) {
            return null;
        }
    }

}