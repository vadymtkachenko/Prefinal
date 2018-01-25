package ua.nure.tkachenko.Final.db;

/**
 * Class contains DB field names
 *
 * @author Vadym Tkachenko
 */
public class Fields {

    // User
    public final static String USER_TABLE = "user";
    public final static String USER_ID = "id_user";
    public final static String USER_NAME = "name";
    public final static String USER_SURNAME = "surname";
    public final static String LOGIN = "login";
    public final static String E_MAIL = "email";
    public static final String USER_DOCUMENT = "document";
    public static final String PASSWORD = "password";
    public static final String USER_ID_ROLE = "role_id";

    // Car
    public final static String CAR_TABLE = "car";
    public final static String CAR_ID = "id_car";
    public final static String CAR_NUMBER = "number";
    public final static String CAR_TYPE = "type";
    public final static String CAR_TRAIN_ID = "train_id";

    // Seat
    public final static String SEAT_TABLE = "seat";
    public final static String SEAT_ID = "id_seat";
    public final static String SEAT_TYPE = "type";
    public final static String SEAT_PRICE = "price";
    public final static String SEAT_TRAIN_ID = "car_id";
    public final static String SEAT_NUMBER = "number";

    // Train
    public final static String TRAIN_TABLE = "train";
    public final static String TRAIN_ID = "id_train";
    public final static String TRAIN_NUMBER = "number";
    public final static String TRAIN_NAME = "name";
    public final static String TRAIN_TYPE = "type";

    //Route
    public final static String ROUTE_TABLE = "route";
    public final static String ROUTE_ID = "id_route";
    public final static String ROUTE_NUMBER = "number";
    public final static String ROUTE_TIME = "time";

    //Schedule
    public final static String SCHEDULE_TABLE = "schedule";
    public final static String SCHEDULE_ID = "id_schedule";
    public final static String SCHEDULE_STARTDATE = "startDate";
    public final static String SCHEDULE_FINISHDATE = "finishDate";
    public final static String SCHEDULE_ROUTE_ID = "route_id";
    public final static String SCHEDULE_TRAIN_ID = "train_id";

    //Station
    public final static String STATION_TABLE = "station";
    public final static String STATION_ID = "id_station";
    public final static String STATION_NAME = "name";
    public final static String STATION_STAY_TIME = "stateTime";

}
