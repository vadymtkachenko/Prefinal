package ua.nure.tkachenko.Final.db.entity;


import java.util.List;
import java.util.Map;

public class RouteFormat {
    private Map<String, String> startAndFinishStations;
    private List<StationsOfroute> list;


    public Map<String, String> getStartAndFinishStations() {
        return startAndFinishStations;
    }

    public void setStartAndFinishStations(Map<String, String> startAndFinishStations) {
        this.startAndFinishStations = startAndFinishStations;
    }


    public List<StationsOfroute> getList() {
        return list;
    }

    public void setList(List<StationsOfroute> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "RouteFormat{" +
                "startAndFinishStations=" + startAndFinishStations +
                ", list=" + list +
                '}';
    }
}
