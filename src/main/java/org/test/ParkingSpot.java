package org.test;

import java.util.Date;

public class ParkingSpot {
    private int spotId;
    private VehicleType vehicleType;
    private boolean isOccupied;
    private Vehicle parkedVehicle;
    private Receipt receipt;

    public ParkingSpot(int spotId, VehicleType vehicleType) {
        this.spotId = spotId;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public void add(Vehicle vehicle){
        parkedVehicle = vehicle;
        isOccupied = true;
        receipt = new Receipt(new Date(),vehicle.getVehicleNumber());
    }

    public Receipt remove(){
        if(isOccupied) {
            parkedVehicle = null;
            isOccupied = false;
            receipt.calculateBill(new Date());
            return receipt;
        }

        return null;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
