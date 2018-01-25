package ua.nure.tkachenko.Final.db.dao;

import ua.nure.tkachenko.Final.db.entity.Schedule;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Class to work with DB. With entity {@link Schedule}. Provides methods to:
 * create,read,update,delete items
 *
 * @author Vadym Tkachenko
 */
public interface ScheduleDAO {
    /**
     * Method returns list of {@link Schedule} from 'schedule' from one date to second.
     *
     * @param from
     * @param to
     * @return
     * @throws DataBaseException
     */
    public List<Schedule> getSchedulesOnDates(Date from, Date to) throws DataBaseException;


    /**
     * Method returns list of {@link Schedule} from 'schedule' for date.
     *
     * @param date
     * @return {@link Schedule}
     * @throws DataBaseException
     */
    public List<Schedule> getSchedulesOnDate(Date date) throws DataBaseException;

    /**
     * Method returns list of {@link Schedule} from 'schedule' for date and idRoute.
     *
     * @param date
     * @param idRoute
     * @return {@link Schedule}
     * @throws DataBaseException
     */
    public List<Schedule> getSchedulesByDateAndRoute(String date, int idRoute) throws DataBaseException;
}
