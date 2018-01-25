package ua.nure.tkachenko.Final.services;

import ua.nure.tkachenko.Final.db.entity.Seat;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.util.List;

public interface SeatService {

    /**
     * @param type
     * @param idTrain
     * @param dateStart
     * @param idCar
     * @param idRoute
     * @return return list of {@link Seat} from 'seat' table where type equals type.
     * @throws DataBaseException
     */
    public List<Seat> getAllFreeSeatsOfSpecType(String type, int idTrain, String dateStart, int idCar, int idRoute) throws DataBaseException;
}
