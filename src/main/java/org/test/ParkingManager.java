package org.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    private final Map<Integer,ParkingFloor> parkingFloors;
    private final int numOfFloors;
    private final Map<Vehicle,ParkingSpot> parkingSpotDetails;
    private final List<Receipt> receiptList;

    public ParkingManager(int numOfFloors) {
        this.numOfFloors = numOfFloors;
        this.parkingFloors = new HashMap<>();
        this.receiptList = new ArrayList<>();
        this.parkingSpotDetails = new HashMap<>();

        for(int i=0;i<numOfFloors;i++){
            ParkingFloor parkingFloor = new ParkingFloor(i+1);
            parkingFloors.put(i+1,parkingFloor);
        }
    }

    public void addSpot(int num,int floor, VehicleType type){
        ParkingFloor parkingFloor = parkingFloors.get(floor);
        for(int i=0;i<num;i++) {
            parkingFloor.getParkingSpots().add(new ParkingSpot(parkingFloor.getParkingSpots().size() + 1, type));
        }
    }

    public void addParking(Vehicle vehicle){
        VehicleType type = vehicle.getVehicleType();
        for(int i=1;i<=numOfFloors;i++){
            List<ParkingSpot> parkingSpots = parkingFloors.get(i).getParkingSpots();
            for(ParkingSpot spot:parkingSpots){
                if(!spot.isOccupied() && spot.getVehicleType()==type){
                    spot.add(vehicle);
                    parkingSpotDetails.put(vehicle,spot);
                    System.out.println("Your vehicle is parked on: " + i + " floor with spot id: " + spot.getSpotId());
                    return;
                }
            }
        }
        System.out.println("Sorry, Parking is full!");
    }

    public void removeParking(Vehicle vehicle){
        ParkingSpot spot = parkingSpotDetails.get(vehicle);
        if(spot == null){
            System.out.println("Vehicle not found!");
        }
        Receipt receipt = spot.remove();
        if(receipt==null){
            System.out.println("This spot is not occupied, please check your spot again");
            return;
        }
        receiptList.add(receipt);
    }

    public void queryAllDetails(){
        for (Receipt r:receiptList){
            System.out.println("Vehicle number: " + r.getVehicleNum());
        }
    }
}
