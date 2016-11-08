package test.task.java.controller.command;


import test.task.java.dao.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommandGetUsers extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = DAO_FACTORY.createUserDao().getAllUser();
        request.setAttribute(USERS, users);
        return USERS_PAGE;
    }
}
