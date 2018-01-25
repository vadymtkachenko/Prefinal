package ua.nure.tkachenko.Final.db;

/**
 * Class contains DB Queries
 *
 * @author Vadym Tkachenko
 */
public class Queries {
    // ==============Car queries=================
    public static final String FIND_ALL_CARS = "SELECT * FROM " + Fields.CAR_TABLE;
    public static final String GET_CAR_BY_ID = "SELECT * FROM " + Fields.CAR_TABLE + " WHERE " + Fields.CAR_ID + "=?";
    public static final String GET_CAR_BY_TRAIN_ID = "SELECT * FROM " + Fields.CAR_TABLE + " WHERE " + Fields.CAR_TRAIN_ID + "=?";
    public static final String ADD_CAR = "INSERT INTO " + Fields.CAR_TABLE + " (" + Fields.CAR_NUMBER + ", " + Fields.CAR_TYPE + ", " + Fields.CAR_TRAIN_ID + ")" +
            " VALUES (?, ?, ?)";
    public static final String DELETE_CAR = "DELETE from " + Fields.CAR_TABLE + " WHERE " + Fields.CAR_ID + "=?";
    // ==============User queries=================
    public static final String FIND_ALL_USERS = "SELECT * FROM " + Fields.USER_TABLE;
    public static final String ADD_USER = "INSERT INTO " + Fields.USER_TABLE + " (" + Fields.USER_NAME + "," + Fields.USER_SURNAME + "," +
            Fields.USER_DOCUMENT + "," + Fields.LOGIN + "," + Fields.PASSWORD + "," + Fields.E_MAIL + "," + Fields.USER_ID_ROLE + ")" +
            " VALUES ( ?, ?, ?, ?, ?, ?, 1)";
    public static final String GET_USER_BY_ID = "SELECT * FROM " + Fields.USER_TABLE + " WHERE " + Fields.USER_ID + "=?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM " + Fields.USER_TABLE + " WHERE " + Fields.LOGIN + "=?";
    public static final String DELETE_USER = "DELETE from " + Fields.USER_TABLE + " WHERE " + Fields.USER_ID + "=?";
    //===============Schedule queries==============
    public static final String GET_ALL_SCHEDULES = "SELECT * FROM " + Fields.SCHEDULE_TABLE + " o inner join " + Fields.TRAIN_TABLE + " a on a." + Fields.TRAIN_ID + " = o." + Fields.SCHEDULE_ROUTE_ID
            + "inner join " + Fields.ROUTE_TABLE + " r on r." + Fields.ROUTE_ID + "=o.route_id;";
    public static final String GET_SCHEDULES_BY_STARTDATE_AND_ROUTE_ID = " SELECT * FROM schedule s inner join train t on t.id_train = s.train_id inner join route r on r.id_route = s.route_id where s.startDate = ? and s.route_id = ? ";
    public static final String GET_SCHEDULES_BETWEEN_DATES = "SELECT * FROM " + Fields.SCHEDULE_TABLE + " where" +
            "startDate between ?" +
            "And ?";
    // ==============Seat queries==================
    public static final String GET_ALL_FREE_SEATS = "SELECT * FROM seat where type='VIP' AND id not in(select " +
            "seat_id from ticket where dateStart ='2018-01-18 19:38' and train_id = 1 and car_id = 1 and route_id = 3 )";
    public static final String GET_ALL_FREE_SEATS_OF_SPEC_TYPE = " SELECT * FROM "+Fields.SEAT_TABLE+" as s inner join "+Fields.CAR_TABLE+" as c on c.id_car = s.car_id inner join train t" +
            " on c.train_id = t.id_train where s.type= ? and c.train_id=? and" +
            " s.id_seat not in(SELECT seat_id from ticket where dateStart =? and train_id = ? and car_id = ? and route_id = ?)";
    // ==============Route queries=================
    public static final String FIND_ALL_ROUTES = "SELECT * FROM " + Fields.ROUTE_TABLE;
    public static final String GET_TIME_OF_ROUTE = "SELECT " + Fields.ROUTE_TIME + " FROM " + Fields.ROUTE_TABLE + " WHERE " + Fields.ROUTE_ID + " =?";
    public static final String GET_ROUTE_BY_ID = "SELECT * FROM " + Fields.ROUTE_TABLE + " WHERE " + Fields.ROUTE_ID + "=?";
    public static final String GET_ROUTE_BY_NUMBER = "SELECT * FROM " + Fields.ROUTE_TABLE + " WHERE " + Fields.ROUTE_NUMBER + "=?";
    public static final String ROUTES_ON_DATES = "SELECT route_id FROM schedule where" +
            "startDate between ?" +
            "And ?";
    public static final String ADD_ROUTE = "INSERT INTO " + Fields.ROUTE_TABLE + " (" + Fields.ROUTE_TIME + ", " + Fields.ROUTE_NUMBER + ")" +
            " VALUES ( ?, ?)";
    public static final String DELETE_ROUTE = "DELETE from " + Fields.ROUTE_TABLE + " WHERE " + Fields.ROUTE_ID + "=?";
    public static final String ROUTES_BETWEEN_STATIONS = "select " + Fields.ROUTE_ID + " from " + Fields.ROUTE_TABLE + " where " + Fields.ROUTE_ID + " in " +
            "(select route_id from routes_stations where station_id=?)" +
            " and id in (select route_id from routes_stations where station_id=?)";
    // ==============Station queries=================
    public static final String FIND_ALL_STATIONS = "SELECT * FROM " + Fields.STATION_TABLE;
    public static final String GET_STATION_BY_ID = "SELECT * FROM " + Fields.STATION_TABLE + " WHERE " + Fields.STATION_ID + "=?";
    public static final String GET_STAYTIME_OF_STATION = "select " + Fields.STATION_STAY_TIME +
            " from " + Fields.STATION_TABLE + " " +
            "join routes_stations on routes_stations.station_id = " + Fields.STATION_ID + " " +
            "where route_id = ? " +
            "order by routes_stations.ordering";
    public static final String ADD_STATION = "INSERT INTO " + Fields.STATION_TABLE + " (" + Fields.STATION_NAME + ", " + Fields.STATION_STAY_TIME + ")" +
            " VALUES ( ?, ?)";
    public static final String DELETE_STATION = "DELETE from " + Fields.STATION_TABLE + " WHERE " + Fields.STATION_ID + "=?";
    public static final String STATIONS_OF_ROUTE = "select " + Fields.STATION_NAME + ", routes_stations.timeArrive" +
            " from " + Fields.STATION_TABLE + " " +
            "join routes_stations on routes_stations.station_id = " + Fields.STATION_ID + " " +
            "where route_id = ? " +
            "order by routes_stations.ordering";
}

