package ua.nure.tkachenko.Final.db.dao;


import ua.nure.tkachenko.Final.db.mysql.MySQLDAOFactory;

import java.sql.Connection;

public abstract class AbstractDAOFactory {

    // List of DAO types supported by the factory
    public static final int MySQL = 1;
//    public static final int ORACLE = 2;
//    public static final int SYBASE = 3;

    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract CarDAO getCarDAO(Connection connection);


    public abstract RouteDAO getRouteDAO(Connection connection);

    public abstract SeatDAO getSeatDAO(Connection connection);

    public abstract StationDAO getStationDAO(Connection connection);

    public abstract TicketDAO getTicketDAO(Connection connection);

    public abstract TrainDAO getTrainDAO(Connection connection);

    public abstract UserDAO getUserDAO(Connection connection);

    public abstract ScheduleDAO getScheduleDAO(Connection connection);


    public static AbstractDAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MySQL:
                return new MySQLDAOFactory();
            default:
                return null;
        }
    }
}
