package ua.nure.tkachenko.Final.services;


import ua.nure.tkachenko.Final.db.entity.Schedule;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.util.Date;
import java.util.List;

public interface ScheduleService {
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
