package test.task.java.controller.command;


import test.task.java.dao.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class CommandFind extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> findUsers = null;

        String enterField = request.getParameter(ENTER_FIELD);
        String findType = request.getParameter(FIND_TYPE);
        String sexType = request.getParameter(SEX);

        if (findType.equals(FIND_USER_BY_SURNAME) && enterField != null) {
            findUsers = DAO_FACTORY.createUserDao().findUserBySurname(enterField);
        }
        else if (findType.equals(FIND_USER_BY_NAME) && enterField != null) {
            findUsers = DAO_FACTORY.createUserDao().findUserByName(enterField);
        }
        else if (findType.equals(FIND_USER_BY_AGE) && enterField != null) {
            try {
                findUsers = DAO_FACTORY.createUserDao().findUserByAge(Integer.parseInt(enterField));
            }catch (NumberFormatException ex){
                return USERS_PAGE;
            }
        }
        else if (findType.equals(FIND_USER_BY_SEX)) {
            findUsers = DAO_FACTORY.createUserDao().findUserBySex(sexType.charAt(0));
        }
        else if (findType.equals(FIND_USER_BY_MOBILE_NUMBER) && enterField != null) {
            findUsers = DAO_FACTORY.createUserDao().findUserByMobileNumber(enterField);
        }
        else if (findType.equals(SHOW_ALL)) {
            findUsers = DAO_FACTORY.createUserDao().getAllUser();
        }

        request.setAttribute(USERS, findUsers);

        return USERS_PAGE;
    }
}
