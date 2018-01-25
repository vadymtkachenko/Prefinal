package ua.nure.tkachenko.Final.db.mysql;

import ua.nure.tkachenko.Final.db.Fields;
import ua.nure.tkachenko.Final.db.Queries;
import ua.nure.tkachenko.Final.db.dao.StationDAO;
import ua.nure.tkachenko.Final.db.entity.Station;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.sql.*;
import java.util.*;


public class MySQLStationDAO implements StationDAO {

    Connection connection;

    public MySQLStationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Station> getAllStations() throws DataBaseException {
        List<Station> stations = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(Queries.FIND_ALL_STATIONS);
            while (rs.next()) {
                Station station = extractStation(rs);
                stations.add(station);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataBaseException("Cannot get Stations", e);
        }
        return stations;
    }

    @Override
    public Map<String, String> getStationsOfRoute(int idRoute) throws DataBaseException {
        Map<String, String> stationsAndTime = new LinkedHashMap<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.STATIONS_OF_ROUTE)) {
            statement.setInt(1, idRoute);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String station = (resultSet.getString("name"));
                String time = (resultSet.getString("timeArrive"));
                stationsAndTime.put(station, time);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get stations ", e);
        }
        return stationsAndTime;
    }

    @Override
    public List<String> getStayTimeOfStation(int idRoute) throws DataBaseException {
        List<String> stayTimes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_STAYTIME_OF_STATION)) {
            statement.setInt(1, idRoute);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stayTimes.add((resultSet.getString("stateTime")));
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get stations ", e);
        }
        return stayTimes;
    }


    @Override
    public boolean addStation(Station station) throws DataBaseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.ADD_STATION, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, station.getName());
            preparedStatement.setInt(2, station.getTime());
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    station.setIdStation(rs.getInt(1));
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot create station ", e);
        }
        return false;
    }

    @Override
    public Station getStation(int idStation) throws DataBaseException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_STATION_BY_ID)) {
            ResultSet resultSet;
            statement.setInt(1, idStation);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractStation(resultSet);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get station ", e);
        }
        return null;
    }

    @Override
    public boolean deleteStation(int idStation) throws DataBaseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETE_STATION)) {
            preparedStatement.setInt(1, idStation);
            int res = preparedStatement.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot delete station", e);
        }
        return false;
    }

    private Station extractStation(ResultSet rs) throws SQLException {
        Station station = new Station();
        station.setIdStation(rs.getInt(Fields.STATION_ID));
        station.setName(rs.getString(Fields.STATION_NAME));
        station.setTime(rs.getInt(Fields.STATION_STAY_TIME));
        return station;
    }
}
