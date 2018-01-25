package ua.nure.tkachenko.Final.services.api;


import ua.nure.tkachenko.Final.db.MySQLController;
import ua.nure.tkachenko.Final.db.entity.Route;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;
import ua.nure.tkachenko.Final.db.mysql.MySQLDAOFactory;
import ua.nure.tkachenko.Final.services.RouteService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RouteServiceImpl implements RouteService {
    @Override
    public Time getTime(int idRoute) throws DataBaseException {
        Time t = null;
        try (Connection connection = new MySQLController().getConnection()) {
            t = MySQLDAOFactory.getDAOFactory(1).getRouteDAO(connection).getTime(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public List<Route> getAllRoutes() throws DataBaseException {
        return null;
    }

    @Override
    public boolean addRoute(Route route) throws DataBaseException {
        return false;
    }

    @Override
    public List<Route> getRoutesWithStations(int stationIdFirst, int stationIdSecond) throws DataBaseException {
        return null;
    }

    @Override
    public Route getRoute(int idRoute) throws DataBaseException {
        return null;
    }

    @Override
    public Route getRouteByNumber(int numberOfRoute) throws DataBaseException {
        return null;
    }

    @Override
    public List<Route> getRoutesOnDates(Date from, Date to) throws DataBaseException {
        return null;
    }

    @Override
    public Map<String, String> getStartAndFinishStations(int idRoute) throws DataBaseException {
        return null;
    }

    @Override
    public boolean deleteRoute(int idRoute) throws DataBaseException {
        return false;
    }
}
