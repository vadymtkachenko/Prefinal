package ua.nure.tkachenko.Final.db.dao;

import ua.nure.tkachenko.Final.db.entity.Ticket;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.util.List;

/**
 * Class to work with DB. With entity {@link Ticket}. Provides methods to:
 * create,read,update,delete items
 *
 * @author Vadym Tkachenko
 */
public interface TicketDAO {

    /**
     *
     * @return list of {@link Ticket} from 'ticket' table.
     * @throws DataBaseException
     */
    public List<Ticket> getAllStations() throws DataBaseException;

    /**
     *
     * Adds ticket into database, sets fields from ticket bean to DB.
     *
     * @param ticket
     * @return boolean
     * @throws DataBaseException
     */
    public boolean addTicket(Ticket ticket) throws DataBaseException;

    /**
     * Method returns ticket entity where identifier equals idTicket.
     *
     * @param idTicket
     * @return {@link Ticket}
     * @throws DataBaseException
     */
    public Ticket getTicket(int idTicket) throws DataBaseException;

    /**
     * Method deletes ticket with identifier equals idTicket
     *
     * @param idTicket
     * @return boolean
     * @throws DataBaseException
     */
    public boolean deleteTicket(int idTicket) throws DataBaseException;
}
