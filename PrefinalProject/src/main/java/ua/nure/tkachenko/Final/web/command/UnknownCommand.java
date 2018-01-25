package ua.nure.tkachenko.Final.web.command;


import ua.nure.tkachenko.Final.web.Command;
import ua.nure.tkachenko.Final.web.utils.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnknownCommand extends Command {


    @Override
    public String execute(HttpServletRequest request) {
/* в случае ошибки или прямого обращения к контроллеру
* переадресация на страницу ввода логина */
        return "/errors/general-error.jsp";

    }
}
