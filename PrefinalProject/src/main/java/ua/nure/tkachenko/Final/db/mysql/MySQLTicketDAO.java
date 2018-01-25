package ua.nure.tkachenko.Final.db.mysql;

import ua.nure.tkachenko.Final.db.dao.TicketDAO;
import ua.nure.tkachenko.Final.db.entity.Ticket;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.sql.Connection;
import java.util.List;


public class MySQLTicketDAO implements TicketDAO {


    Connection connection;

    public MySQLTicketDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Ticket> getAllStations() throws DataBaseException {
        return null;
    }

    @Override
    public boolean addTicket(Ticket ticket) throws DataBaseException {
        return false;
    }

    @Override
    public Ticket getTicket(int idTicket) throws DataBaseException {
        return null;
    }

    @Override
    public boolean deleteTicket(int idTicket) throws DataBaseException {
        return false;
    }
}
