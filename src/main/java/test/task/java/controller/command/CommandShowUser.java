package test.task.java.controller.command;


import test.task.java.dao.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandShowUser extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        Long id = Long.parseLong(request.getParameter(USER_ID));

        User user = DAO_FACTORY.createUserDao().findUserById(id);

        request.setAttribute(USER, user);

        return UPDATE_USER_PAGE;
    }
}
