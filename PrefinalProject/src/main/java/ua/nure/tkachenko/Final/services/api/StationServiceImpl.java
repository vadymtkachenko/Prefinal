package ua.nure.tkachenko.Final.services.api;


import ua.nure.tkachenko.Final.db.MySQLController;
import ua.nure.tkachenko.Final.db.entity.Schedule;
import ua.nure.tkachenko.Final.db.entity.Station;
import ua.nure.tkachenko.Final.db.entity.StationsOfroute;
import ua.nure.tkachenko.Final.db.entity.User;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;
import ua.nure.tkachenko.Final.db.mysql.MySQLDAOFactory;
import ua.nure.tkachenko.Final.services.StationService;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StationServiceImpl implements StationService {

    @Override
    public boolean addStation(Station station) throws DataBaseException {
        return false;
    }

    @Override
    public Station getStation(int idStation) throws DataBaseException {
        return null;
    }

    @Override
    public boolean deleteStation(int idStation) throws DataBaseException {
        return false;
    }

    @Override
    public Map<String, String> getStationsOfRoute(int idRoute) throws DataBaseException {
        Map<String, String> stringMap = new LinkedHashMap<>();
        try (Connection connection = new MySQLController().getConnection()) {
            stringMap = MySQLDAOFactory.getDAOFactory(1).getStationDAO(connection).getStationsOfRoute(idRoute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringMap;
    }

    @Override
    public Map<String, String> getStartAndFinish(String date, int idRoute) throws DataBaseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Map<String, String> stations_TimeWhenArrive = new LinkedHashMap<>();
        Map<String, String> startAndFinishStation = new LinkedHashMap<>();
        try (Connection connection = new MySQLController().getConnection()) {
            stations_TimeWhenArrive = MySQLDAOFactory.getDAOFactory(1).getStationDAO(connection).getStationsOfRoute(idRoute);
            try {

                List<Schedule> scheduleslist = new ArrayList<>();
                ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
                scheduleslist = scheduleService.getSchedulesByDateAndRoute(date, idRoute);
                System.out.println(scheduleslist);
                if (!scheduleslist.isEmpty()) {
                    List<String> startfinish = new ArrayList<>(stations_TimeWhenArrive.keySet());

                    startAndFinishStation.put(startfinish.get(0), format.format(scheduleslist.get(0).getDateStart()));
                    startAndFinishStation.put(startfinish.get(startfinish.size() - 1), format.format(scheduleslist.get(0).getDateFinish()));
                }
            } catch (DataBaseException e) {
                e.printStackTrace();
            }
        } catch (DataBaseException | SQLException e) {
            e.printStackTrace();
        }
        return startAndFinishStation;
    }


    @Override
    public List<String> getStayTimeOfStation(int idRoute) throws DataBaseException {
        List<String> timeList = new ArrayList<>();
        try (Connection connection = new MySQLController().getConnection()) {
            timeList = MySQLDAOFactory.getDAOFactory(1).getStationDAO(connection).getStayTimeOfStation(idRoute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeList;
    }

    @Override
    public List<StationsOfroute> getStationsBetweenStartAndFinish(String date, int idRoute) throws DataBaseException {
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Map<String, String> stations_TimeWhenArrive = new LinkedHashMap<>();
        Map<String, String> startAndFinishStation = new LinkedHashMap<>();
        List<String> startfinish = new ArrayList<>();
        List<String> timeStationsArriveing = new ArrayList<>();
        List<StationsOfroute> stationsBetween = new ArrayList<>();
        try (Connection connection = new MySQLController().getConnection()) {
            stations_TimeWhenArrive = MySQLDAOFactory.getDAOFactory(1).getStationDAO(connection).getStationsOfRoute(idRoute);

            List<String> timesOfStay = new ArrayList<>();
            try {
                timesOfStay = MySQLDAOFactory.getDAOFactory(1).getStationDAO(connection).getStayTimeOfStation(idRoute);
                List<Schedule> scheduleslist = new ArrayList<>();
                ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
                scheduleslist = scheduleService.getSchedulesByDateAndRoute(date, idRoute);
                if (!scheduleslist.isEmpty()) {
                    startfinish = new ArrayList<>(stations_TimeWhenArrive.keySet());
                    timeStationsArriveing = new ArrayList<>(stations_TimeWhenArrive.values());
                    startAndFinishStation.put(startfinish.get(0), format1.format(scheduleslist.get(0).getDateStart()));
                    startAndFinishStation.put(startfinish.get(startfinish.size() - 1), format1.format(scheduleslist.get(0).getDateFinish()));
                }
                for (int i = 1; i < startfinish.size() - 1; i++) {
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    String dateInNormFormat = format1.format(scheduleslist.get(0).getDateStart());
                    Date date1 = null;
                    Date to;
                    Date to2;
                    try {
                        date1 = format1.parse(dateInNormFormat);
//                        whenTrainMustBe = format1.parse(dateOfStationsThatBetween);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Calendar cal = Calendar.getInstance();
                    Calendar cal2 = Calendar.getInstance();// creates calendar
                    if (date1 != null) {
                        cal.setTime(date1);
                    }
                    cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStationsArriveing.get(i)));
                    to = cal.getTime();
                    cal2.setTime(to);
                    cal2.add(Calendar.MINUTE, Integer.parseInt(timesOfStay.get(i)));
                    to2 = cal2.getTime();
                    StationsOfroute stationsOfroute = new StationsOfroute();
                    stationsOfroute.setName(startfinish.get(i));
                    stationsOfroute.setMinutesOfstay(Integer.valueOf(timesOfStay.get(i)));
                    stationsOfroute.setDateIn(format1.format(to));
                    stationsOfroute.setDateOut(format.format(to2));
                    stationsBetween.add(stationsOfroute);
                }
            } catch (DataBaseException e) {
                e.printStackTrace();
            }
        } catch (DataBaseException | SQLException e) {
            e.printStackTrace();
        }
        return stationsBetween;
    }
}
