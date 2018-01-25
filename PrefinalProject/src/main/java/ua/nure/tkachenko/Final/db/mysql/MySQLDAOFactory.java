package ua.nure.tkachenko.Final.db.mysql;


import ua.nure.tkachenko.Final.db.dao.AbstractDAOFactory;
import ua.nure.tkachenko.Final.db.dao.*;

import java.sql.Connection;

public class MySQLDAOFactory extends AbstractDAOFactory {
    @Override
    public CarDAO getCarDAO(Connection connection) {
        return new MySQLCarDAO(connection);
    }

    @Override
    public RouteDAO getRouteDAO(Connection connection) {
        return new MySQLRouteDAO(connection);
    }

    @Override
    public SeatDAO getSeatDAO(Connection connection) {
        return new MySQLSeatDAO(connection);
    }

    @Override
    public StationDAO getStationDAO(Connection connection) {
        return new MySQLStationDAO(connection);
    }

    @Override
    public TicketDAO getTicketDAO(Connection connection) {
        return new MySQLTicketDAO(connection);
    }

    @Override
    public TrainDAO getTrainDAO(Connection connection) {
        return new MySQLTrainDAO(connection);
    }

    @Override
    public UserDAO getUserDAO(Connection connection) {
        return new MySQLUserDAO(connection);
    }

    @Override
    public ScheduleDAO getScheduleDAO(Connection connection) {
        return new MySQLScheduleDAO(connection);
    }
}
