package ua.nure.tkachenko.Final.db.dao;

import ua.nure.tkachenko.Final.db.entity.Station;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.util.List;
import java.util.Map;

/**
 * Class to work with DB. With entity {@link Station}. Provides methods to:
 * create,read,update,delete items
 *
 * @author Vadym Tkachenko
 */
public interface StationDAO {

    /**
     * @return list of {@link Station} from 'station' table.
     * @throws DataBaseException
     */
    public List<Station> getAllStations() throws DataBaseException;

    /**
     * @return list of names of {@link Station} of routes.
     * @throws DataBaseException
     */
    public Map<String, String> getStationsOfRoute(int idRoute) throws DataBaseException;


    /**
     *
     * @param idRoute
     * @return list of names of {@link Station} of routes.
     * @throws DataBaseException
     */

    public List<String> getStayTimeOfStation(int idRoute) throws DataBaseException;

    /**
     * Adds station into database, sets fields from station bean to DB.
     *
     * @param station
     * @return boolean
     * @throws DataBaseException
     */
    public boolean addStation(Station station) throws DataBaseException;

    /**
     * Method returns station entity where identifier equals idStation.
     *
     * @param idStation
     * @return {@link Station}
     * @throws DataBaseException
     */
    public Station getStation(int idStation) throws DataBaseException;

    /**
     * Method deletes station with identifier equals idStation.
     *
     * @param idStation
     * @return boolean
     * @throws DataBaseException
     */
    public boolean deleteStation(int idStation) throws DataBaseException;
}
