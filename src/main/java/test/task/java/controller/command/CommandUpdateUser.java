package test.task.java.controller.command;


import test.task.java.dao.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandUpdateUser extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long id = 0l;
        try {
            id = Long.parseLong(request.getParameter(ID));
        }catch (NumberFormatException ex){
            return UPDATE_USER_PAGE;
        }
        String surname = request.getParameter(SURNAME);
        String name = request.getParameter(NAME);
        String age = request.getParameter(AGE);
        String sex = request.getParameter(SEX);
        String mobileNumber = request.getParameter(MOBILE_NUMBER);

        if(checkAllFields(surname, name, age, sex, mobileNumber)){
            User user = DAO_FACTORY.createUserDao().findUserById(id);
            user.setSurname(surname);
            user.setName(name);
            user.setAge(Integer.parseInt(age));
            user.setSex(sex.charAt(0));
            user.setMobileNumber(mobileNumber);

            DAO_FACTORY.createUserDao().updateUser(user);
            return CommandFactory.getInstance().getCommands(USERS).execute(request, response);
        }
        return UPDATE_USER_PAGE;
    }
}
