package ua.nure.tkachenko.Final.db.mysql;


import ua.nure.tkachenko.Final.db.Fields;
import ua.nure.tkachenko.Final.db.Queries;
import ua.nure.tkachenko.Final.db.dao.ScheduleDAO;
import ua.nure.tkachenko.Final.db.entity.Role;
import ua.nure.tkachenko.Final.db.entity.Route;
import ua.nure.tkachenko.Final.db.entity.Schedule;
import ua.nure.tkachenko.Final.db.entity.Train;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySQLScheduleDAO implements ScheduleDAO {

    Connection connection;

    public MySQLScheduleDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Schedule> getSchedulesOnDates(Date from, Date to) throws DataBaseException {
        List<Schedule> schedules = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_SCHEDULES_BETWEEN_DATES)) {
            ResultSet resultSet = statement.executeQuery();
            statement.setString(1, String.valueOf(from));
            statement.setString(2, String.valueOf(to));
            while (resultSet.next()) {
                Schedule schedule = extractSchedule(resultSet);
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get routes ", e);
        }
        return schedules;
    }

    @Override
    public List<Schedule> getSchedulesOnDate(Date date) throws DataBaseException {
        return null;
    }

    @Override
    public List<Schedule> getSchedulesByDateAndRoute(String date, int idRoute) throws DataBaseException {
        List<Schedule> schedules = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_SCHEDULES_BY_STARTDATE_AND_ROUTE_ID)) {
            statement.setString(1, date);
            statement.setInt(2, idRoute);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Schedule schedule = extractSchedule(rs);
                Route route = new Route();
                route.setIdRoute(rs.getInt(Fields.ROUTE_ID));
                route.setNumber(rs.getInt(Fields.ROUTE_NUMBER));
                route.setTimeOfRoute(Time.valueOf(rs.getString(Fields.ROUTE_TIME)));
                Train train = new Train();
                train.setName(rs.getString(Fields.TRAIN_NAME));
                train.setNumber(rs.getInt(Fields.TRAIN_NUMBER));
                train.setType(rs.getString(Fields.TRAIN_TYPE));
                train.setIdTrain(rs.getInt(Fields.TRAIN_ID));
                schedule.setIdRoute(route);
                schedule.setIdTrain(train);
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get routes ", e);
        }
        return schedules;
    }

    private Schedule extractSchedule(ResultSet rs) throws SQLException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Schedule schedule = new Schedule();
        schedule.setId(rs.getInt(Fields.SCHEDULE_ID));

        schedule.setDateStart(rs.getTimestamp(Fields.SCHEDULE_STARTDATE));
        schedule.setDateFinish(rs.getTimestamp(Fields.SCHEDULE_FINISHDATE));
        return schedule;
    }
}
