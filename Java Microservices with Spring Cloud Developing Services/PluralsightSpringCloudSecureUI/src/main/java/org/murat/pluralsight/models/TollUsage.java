package org.murat.pluralsight.models;

public class TollUsage {
    public String id;
    public String stationId;
    public String licensePlate;
    public String timestamp;

    public TollUsage(){

    }

    public TollUsage(String id, String stationId, String licensePlate, String timestamp){
        this.id = id;
        this.stationId = stationId;
        this.licensePlate = licensePlate;
        this.timestamp = timestamp;
    }
}
