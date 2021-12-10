package com.example.transportationandmanagementsystem;

public class Buses {

    private String name,schedule,seat,route;


    public Buses() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Buses(String name, String schedule, String seat, String route) {
        this.name = name;
        this.schedule = schedule;
        this.seat = seat;
        this.route = route;
    }
}
