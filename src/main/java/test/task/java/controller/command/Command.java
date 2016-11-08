package test.task.java.controller.command;


import test.task.java.dao.DaoFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Command {

    public static final String ID = "id";
    public static final String USER_ID = "user_id";
    public static final String SURNAME = "surname";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String SEX = "sex";
    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String USERS = "users";
    public static final String USER = "user";

    public static final String USERS_PAGE = "users.jsp";
    public static final String ADD_USER_PAGE = "add_user.jsp";
    public static final String UPDATE_USER_PAGE = "update_user.jsp";

    public static final String ENTER_FIELD = "enter_field";
    public static final String FIND_TYPE = "find_type";

    public static final String FIND_USER_BY_SURNAME = "find_user_by_surname";
    public static final String FIND_USER_BY_NAME = "find_user_by_name";
    public static final String FIND_USER_BY_AGE = "find_user_by_age";
    public static final String FIND_USER_BY_SEX = "find_user_by_sex";
    public static final String FIND_USER_BY_MOBILE_NUMBER = "find_user_by_mobile_number";
    public static final String SHOW_ALL = "show_all";

    public static final String REGEX_FOR_SURNAME_AND_NAME = "^[A-Za-z]{5,20}$";
    public static final String REGEX_FOR_AGE = "^[0-9]{1,3}$";
    public static final String REGEx_FOR_SEX = "^[wm]$";
    public static final String REGEX_FOR_MOBILE_NUMBER = "^[(]([0-9]{3})[)][0-9]{3}[-][0-9]{2}[-][0-9]{2}$";

    public static final DaoFactory DAO_FACTORY;

    static {
        DAO_FACTORY = DaoFactory.getInstance();
    }

    protected boolean checkAllFields(String surname, String name, String age, String sex, String mobileNumber) {

        Pattern patternForSurnameAndName = Pattern.compile(REGEX_FOR_SURNAME_AND_NAME);
        Matcher matcherForSurname = patternForSurnameAndName.matcher(surname);
        Matcher matcherForName = patternForSurnameAndName.matcher(name);

        Pattern patternForAge = Pattern.compile(REGEX_FOR_AGE);
        Matcher matcherForAge = patternForAge.matcher(age);

        Pattern patternForSex = Pattern.compile(REGEx_FOR_SEX);
        Matcher matcherForSex = patternForSex.matcher(sex);

        Pattern patternForMobileNumber = Pattern.compile(REGEX_FOR_MOBILE_NUMBER);
        Matcher matcherForMobileNumber = patternForMobileNumber.matcher(mobileNumber);

        return (matcherForSurname.matches() && matcherForName.matches() && matcherForAge.matches()
                && matcherForSex.matches() && matcherForMobileNumber.matches());
    }

    public abstract String execute(HttpServletRequest request, HttpServletResponse response);
}
