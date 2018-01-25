package ua.nure.tkachenko.Final.db.dao;

import ua.nure.tkachenko.Final.db.entity.Seat;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.util.List;

/**
 * Class to work with DB. With entity {@link Seat}. Provides methods to:
 * create,read,update,delete items
 *
 * @author Vadym Tkachenko
 */
public interface SeatDAO {

    /**
     * @return list of {@link Seat} from 'seat' table.
     * @throws DataBaseException
     */
    public List<Seat> getAllSeats() throws DataBaseException;

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

    /**
     * Adds seat into database, sets fields from Seat bean to DB.
     *
     * @param seat
     * @return boolean
     * @throws DataBaseException
     */
    public boolean addSeat(Seat seat) throws DataBaseException;

    /**
     * Method returns seat entity where identifier equals idSeat.
     *
     * @param idSeat
     * @return {@link Seat}
     * @throws DataBaseException
     */
    public Seat getSeat(int idSeat) throws DataBaseException;

    /**
     * Method deletes seat with identifier equals idSeat.
     *
     * @param idSeat
     * @return boolean
     * @throws DataBaseException
     */
    public boolean deleteSeat(int idSeat) throws DataBaseException;
}
