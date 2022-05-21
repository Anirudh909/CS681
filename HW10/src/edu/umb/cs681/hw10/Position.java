package edu.umb.cs681.hw10;

import java.util.ArrayList;

public final class Position {
    private final double latitude,longitude,altitude;

    public Position(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public String toString() {
        return (latitude + "," + longitude + "," + altitude);
    }

    public boolean equals(Position anotherPosition ) {
        if (this.toString().equals(anotherPosition.toString()))
            return true;
        else
            return false;
    }
    public ArrayList<Double> getCoordinate(){
        ArrayList<Double> coordinates = new ArrayList<>();
        coordinates.add(latitude);
        coordinates.add(longitude);
        coordinates.add(altitude);
        return coordinates;
    }
    public Position changeLat(double newLat){
        return new Position(newLat, this.longitude, this.altitude);
    }

    public Position changeLon(double newLon){
        return new Position(this.latitude, newLon, this.altitude);
    }

    public Position changeAlt(double newAlt){
        return new Position(this.latitude, this.longitude, newAlt);
    }
}
