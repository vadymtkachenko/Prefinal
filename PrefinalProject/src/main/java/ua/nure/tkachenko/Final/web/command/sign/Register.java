package ua.nure.tkachenko.Final.web.command.sign;

import ua.nure.tkachenko.Final.db.entity.Schedule;
import ua.nure.tkachenko.Final.db.entity.User;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;
import ua.nure.tkachenko.Final.services.StationService;
import ua.nure.tkachenko.Final.services.api.ScheduleServiceImpl;
import ua.nure.tkachenko.Final.services.api.StationServiceImpl;
import ua.nure.tkachenko.Final.services.api.UserServiceImpl;
import ua.nure.tkachenko.Final.web.Command;
import ua.nure.tkachenko.Final.web.utils.Path;
import ua.nure.tkachenko.Final.web.utils.SecurityManager;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Register extends Command {

    @Override
    public String execute(HttpServletRequest request) {
        UserServiceImpl userService = new UserServiceImpl();

        String page = null;

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String document = request.getParameter("document");

        User user = new User();
        user.setLogin(login);
        try {
            user.setPassword(SecurityManager.getSecurePassword(password));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setDocument(document);

        try {
            boolean userAdd = userService.addUser(user);
            if (!userAdd) {
                page = Path.ERROR_PAGE;
            } else page = Path.LOGIN_PAGE;
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        return page;
    }
}
