package ua.nure.tkachenko.Final.db.mysql;

import ua.nure.tkachenko.Final.db.Fields;
import ua.nure.tkachenko.Final.db.Queries;
import ua.nure.tkachenko.Final.db.dao.SeatDAO;
import ua.nure.tkachenko.Final.db.entity.*;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLSeatDAO implements SeatDAO {

    Connection connection;

    public MySQLSeatDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Seat> getAllSeats() throws DataBaseException {

        return null;
    }

    @Override
    public List<Seat> getAllFreeSeatsOfSpecType(String type, int idTrain, String dateStart, int idCar, int idRoute) throws DataBaseException {
        List<Seat> seats = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_ALL_FREE_SEATS_OF_SPEC_TYPE)) {
            statement.setString(1, type);
            statement.setInt(2, idTrain);
            statement.setString(3, dateStart);
            statement.setInt(4, idTrain);
            statement.setInt(5, idCar);
            statement.setInt(6, idRoute);
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Seat seat = extractSeat(resultSet);
                Car car = new Car();
                car.setIdCar(resultSet.getInt(Fields.CAR_ID));
                car.setNumber(resultSet.getInt(Fields.CAR_NUMBER));
                car.setType(resultSet.getString(Fields.CAR_TYPE));
                Train train = new Train();
                train.setName(resultSet.getString(Fields.TRAIN_NAME));
                train.setNumber(resultSet.getInt(Fields.TRAIN_NUMBER));
                train.setType(resultSet.getString(Fields.TRAIN_TYPE));
                train.setIdTrain(resultSet.getInt(Fields.TRAIN_ID));
                car.setTrainId(train);
                seat.setCar(car);
                seats.add(seat);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get free seats ", e);
        }
        return seats;
    }

    @Override
    public boolean addSeat(Seat seat) throws DataBaseException {
        return false;
    }

    @Override
    public Seat getSeat(int idSeat) throws DataBaseException {
        return null;
    }


    @Override
    public boolean deleteSeat(int idSeat) throws DataBaseException {
        return false;
    }

    private Seat extractSeat(ResultSet rs) throws SQLException {
        Seat seat = new Seat();
        seat.setIdSeat(rs.getInt(Fields.SEAT_ID));
        seat.setNumber(rs.getInt(Fields.SEAT_NUMBER));
        seat.setType(rs.getString(Fields.SEAT_TYPE));
        seat.setPrice(rs.getDouble(Fields.SEAT_PRICE));
        return seat;
    }

}
