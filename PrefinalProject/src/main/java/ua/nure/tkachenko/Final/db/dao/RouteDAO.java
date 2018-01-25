package ua.nure.tkachenko.Final.db.dao;

import ua.nure.tkachenko.Final.db.entity.Role;
import ua.nure.tkachenko.Final.db.entity.Route;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Class to work with DB. With entity {@link Route}. Provides methods to:
 * create,read,update,delete items
 *
 * @author Vadym Tkachenko
 */
public interface RouteDAO {

    /**
     * @return list of {@link Route} from 'route' table.
     * @throws DataBaseException
     */
    public List<Route> getAllRoutes() throws DataBaseException;

    /**
     * Adds route into database, sets fields from Route bean to DB.
     *
     * @param route
     * @return boolean
     * @throws DataBaseException
     */
    public boolean addRoute(Route route) throws DataBaseException;

    /**
     * @param stationIdFirst
     * @param stationIdSecond
     * @return {@link Route}
     * @throws DataBaseException
     */
    public List<Route> getRoutesWithStations(int stationIdFirst, int stationIdSecond) throws DataBaseException;

    /**
     * Method returns route entity where identifier equals idRoute.
     *
     * @param idRoute
     * @return {@link Route}
     * @throws DataBaseException
     */
    public Route getRoute(int idRoute) throws DataBaseException;

    /**
     * Method returns route entity where number equals numberOfRoute.
     *
     * @param numberOfRoute
     * @return {@link Route}
     * @throws DataBaseException
     */
    public Route getRouteByNumber(int numberOfRoute) throws DataBaseException;

    /**
     * @param from
     * @param to
     * @return {@link Route}
     * @throws DataBaseException
     */
    public List<Route> getRoutesOnDates(Date from, Date to) throws DataBaseException;

    /**
     * Method deletes route with identifier equals idRoute.
     *
     * @param idRoute
     * @return boolean
     * @throws DataBaseException
     */
    public boolean deleteRoute(int idRoute) throws DataBaseException;

    /**
     *  Method returns time eof route where id equals idRoute.
     *
     * @param idRoute
     * @return Date
     * @throws DataBaseException
     */
    public Time getTime(int idRoute) throws DataBaseException;


}
