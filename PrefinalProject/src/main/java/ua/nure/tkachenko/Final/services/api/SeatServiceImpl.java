package ua.nure.tkachenko.Final.services.api;


import ua.nure.tkachenko.Final.db.MySQLController;
import ua.nure.tkachenko.Final.db.entity.Schedule;
import ua.nure.tkachenko.Final.db.entity.Seat;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;
import ua.nure.tkachenko.Final.db.mysql.MySQLDAOFactory;
import ua.nure.tkachenko.Final.services.SeatService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatServiceImpl implements SeatService {
    @Override
    public List<Seat> getAllFreeSeatsOfSpecType(String type, int idTrain, String dateStart, int idCar, int idRoute) throws DataBaseException {
        List<Seat> seats = new ArrayList<>();
        try (Connection connection = new MySQLController().getConnection()) {
            seats = MySQLDAOFactory.getDAOFactory(1).getSeatDAO(connection).getAllFreeSeatsOfSpecType(type, idTrain, dateStart, idCar, idRoute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seats;
    }
}
