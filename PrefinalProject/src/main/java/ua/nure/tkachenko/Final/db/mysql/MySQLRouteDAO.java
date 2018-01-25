package ua.nure.tkachenko.Final.db.mysql;

import ua.nure.tkachenko.Final.db.Fields;
import ua.nure.tkachenko.Final.db.MySQLController;
import ua.nure.tkachenko.Final.db.Queries;
import ua.nure.tkachenko.Final.db.dao.RouteDAO;
import ua.nure.tkachenko.Final.db.entity.Role;
import ua.nure.tkachenko.Final.db.entity.Route;
import ua.nure.tkachenko.Final.db.entity.Station;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import javax.naming.NamingException;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class MySQLRouteDAO implements RouteDAO {


    Connection connection;

    public MySQLRouteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Route> getAllRoutes() throws DataBaseException {
        List<Route> routes = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(Queries.FIND_ALL_ROUTES);
            while (rs.next()) {
                Route route = extractRoute(rs);
                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataBaseException("Cannot get Routes", e);
        }
        return routes;
    }

    @Override
    public boolean addRoute(Route route) throws DataBaseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.ADD_ROUTE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, route.getNumber());
            preparedStatement.setString(2, String.valueOf(route.getTimeOfRoute()));
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    route.setIdRoute(rs.getInt(1));
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot create route ", e);
        }
        return false;
    }

    @Override
    public Route getRoute(int idRoute) throws DataBaseException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_ROUTE_BY_ID)) {
            ResultSet resultSet = null;
            statement.setInt(1, idRoute);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractRoute(resultSet);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get route ", e);
        }
        return null;
    }

    @Override
    public Route getRouteByNumber(int numberOfRoute) throws DataBaseException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_ROUTE_BY_NUMBER)) {
            ResultSet resultSet = null;
            statement.setInt(1, numberOfRoute);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractRoute(resultSet);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get route ", e);
        }
        return null;
    }

    @Override
    public List<Route> getRoutesWithStations(int stationIdFirst, int stationIdSecond) throws DataBaseException {
        List<Route> routes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.ROUTES_BETWEEN_STATIONS)) {
            ResultSet resultSet = statement.executeQuery();
            statement.setInt(1, stationIdFirst);
            statement.setInt(2, stationIdSecond);
            while (resultSet.next()) {
                Route route = extractRoute(resultSet);
                routes.add(route);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get routes ", e);
        }
        return routes;
    }

    @Override
    public List<Route> getRoutesOnDates(Date from, Date to) throws DataBaseException {
        List<Route> routes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.ROUTES_ON_DATES)) {
            ResultSet resultSet = statement.executeQuery();
            statement.setString(1, String.valueOf(from));
            statement.setString(2, String.valueOf(to));
            while (resultSet.next()) {
                Route route = extractRoute(resultSet);
                routes.add(route);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get routes ", e);
        }
        return routes;
    }

    @Override
    public boolean deleteRoute(int idRoute) throws DataBaseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETE_ROUTE);) {
            preparedStatement.setInt(1, idRoute);
            int res = preparedStatement.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot delete user", e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DataBaseException("Cannot close connection ", e);
            }
        }
        return false;
    }

    @Override
    public Time getTime(int idRoute) throws DataBaseException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_TIME_OF_ROUTE)) {
            ResultSet resultSet = null;
            statement.setInt(1, idRoute);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getTime(Fields.ROUTE_TIME);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get time ", e);
        }
        return null;
    }


    private Route extractRoute(ResultSet rs) throws SQLException {
        Route route = new Route();
        route.setIdRoute(rs.getInt(Fields.ROUTE_ID));
        route.setNumber(rs.getInt(Fields.ROUTE_NUMBER));
        route.setTimeOfRoute(Time.valueOf(rs.getString(Fields.ROUTE_TIME)));
        return route;
    }


}
