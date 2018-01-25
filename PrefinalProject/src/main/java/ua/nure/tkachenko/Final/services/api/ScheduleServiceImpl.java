package ua.nure.tkachenko.Final.services.api;


import ua.nure.tkachenko.Final.db.MySQLController;
import ua.nure.tkachenko.Final.db.entity.Schedule;
import ua.nure.tkachenko.Final.db.entity.User;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;
import ua.nure.tkachenko.Final.db.mysql.MySQLDAOFactory;
import ua.nure.tkachenko.Final.services.ScheduleService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    @Override
    public List<Schedule> getSchedulesOnDates(Date from, Date to) throws DataBaseException {
        return null;
    }

    @Override
    public List<Schedule> getSchedulesOnDate(Date date) throws DataBaseException {
        return null;
    }

    @Override
    public List<Schedule> getSchedulesByDateAndRoute(String date, int idRoute) throws DataBaseException {
        List<Schedule> schedules = new ArrayList<>();
        try (Connection connection = new MySQLController().getConnection()) {
            schedules = MySQLDAOFactory.getDAOFactory(1).getScheduleDAO(connection).getSchedulesByDateAndRoute(date, idRoute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }
}
