package ua.nure.tkachenko.Final.web;


import ua.nure.tkachenko.Final.web.utils.PropertyHolder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/controller", "/register/", "/loginUser", "/change"})
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
// определение команды, пришедшей из JSP
        String commandName = request.getParameter("command");
        String cc = PropertyHolder.getInstance().getCommandClass(commandName);
        Command command = null;
        try {
            command = (Command) Class.forName(cc).newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
/*
* вызов реализованного метода execute() и передача параметров
* классу-обработчику конкретной команды
 */
        if (command != null) {
            page = command.execute(request);
        }
// метод возвращает страницу ответа
// page = null; // поэксперементировать!
        if (page != null) {
// вызов страницы ответа на запрос
            response.sendRedirect(page);
        } else {
// установка страницы c cообщением об ошибке

            response.sendRedirect(request.getContextPath());
        }
    }
}
