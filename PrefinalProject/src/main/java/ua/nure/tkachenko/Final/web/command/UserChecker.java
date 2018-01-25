package ua.nure.tkachenko.Final.web.command;

import ua.nure.tkachenko.Final.db.exception.DataBaseException;
import ua.nure.tkachenko.Final.services.UserService;
import ua.nure.tkachenko.Final.services.api.UserServiceImpl;
import ua.nure.tkachenko.Final.web.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserChecker extends Command {
    @Override
    public String execute(HttpServletRequest request) {

        HttpServletResponse response = null ;
        UserServiceImpl userService = new UserServiceImpl();
        String userName = request.getParameter("login");
        try {
            if (userService.checkIfExists(userName)) {
                userName = "User name cannot be " + userName;
            } else {
                userName = "Hello " + userName;
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("answer", userName);

        response.setContentType("text/plain");
        try {
            response.getWriter().write(userName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
