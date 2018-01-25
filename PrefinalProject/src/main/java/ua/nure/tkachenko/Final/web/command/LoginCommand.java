package ua.nure.tkachenko.Final.web.command;


import ua.nure.tkachenko.Final.db.entity.*;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;
import ua.nure.tkachenko.Final.services.ScheduleService;
import ua.nure.tkachenko.Final.services.api.*;
import ua.nure.tkachenko.Final.web.Command;
import ua.nure.tkachenko.Final.web.utils.Path;
import ua.nure.tkachenko.Final.web.utils.SecurityManager;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class LoginCommand extends Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        String login = request.getParameter("login");
        String password = request.getParameter("password");
// проверка логина и пароля
        UserServiceImpl userService = new UserServiceImpl();
        StationServiceImpl stationService = new StationServiceImpl();

        List<String> list1 = new ArrayList();
        try {
            Map<String, String> map = stationService.getStartAndFinish("2018-01-23 01:00:00", 3);
            System.out.println(map);

            List <StationsOfroute> list = stationService.getStationsBetweenStartAndFinish("2018-01-23 01:00:00", 3);
            System.out.println(list);

            RouteFormat routeFormat = new RouteFormat();
            routeFormat.setStartAndFinishStations(map);
            routeFormat.setList(list);

            System.out.println(routeFormat);


            ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
            Train train = scheduleService.getSchedulesByDateAndRoute("2018-01-23 01:00:00", 3).get(0).getIdTrain();

            RouteServiceImpl routeService = new RouteServiceImpl();

            Time t = routeService.getTime(3);

            List mapList = new ArrayList(map.entrySet());

            SeatServiceImpl seatService = new SeatServiceImpl();
            List<Seat> seats = seatService.getAllFreeSeatsOfSpecType("VIP", 1, "2018-01-18 19:38:00", 1, 3);
            List<Seat> seatsEco = seatService.getAllFreeSeatsOfSpecType("Eco", 1, "2018-01-18 19:38:00", 1, 3);

            System.out.println(train.getNumber());
            System.out.println(mapList.get(0));
            System.out.println(t);
            System.out.println(mapList.get(1));

            list1.add(String.valueOf(train.getNumber()) + " " + mapList.get(0) + " " + t + " " + mapList.get(1) + " VIP:" + seats.size() + " Eco:" + seatsEco.size());
            System.out.println(list1);
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        try {
            boolean userExists = userService.checkIfExists(login);
            if (userExists) {
                User user = userService.getUserBylogin(login);
                try {
                    if (user.getPassword().equals(SecurityManager.getSecurePassword(password))) {
                        request.getSession().setAttribute("user", user);
                        page = "/userOffice.jsp";
                    } else {
                        page = Path.ERROR_PAGE;
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else page = Path.ERROR_PAGE;
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        return page;
    }
}

