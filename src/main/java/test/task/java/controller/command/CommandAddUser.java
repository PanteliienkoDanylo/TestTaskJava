package test.task.java.controller.command;



import test.task.java.dao.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandAddUser extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String surname = request.getParameter(SURNAME);
        String name = request.getParameter(NAME);
        String age = request.getParameter(AGE);
        String sex = request.getParameter(SEX);
        String mobileNumber = request.getParameter(MOBILE_NUMBER);

        if(checkAllFields(surname, name, age, sex, mobileNumber)){
            DAO_FACTORY.createUserDao().addUser(new User(surname, name, Integer.parseInt(age), sex.charAt(0), mobileNumber));
            return CommandFactory.getInstance().getCommands(USERS).execute(request, response);
        }

        return ADD_USER_PAGE;

    }


}
