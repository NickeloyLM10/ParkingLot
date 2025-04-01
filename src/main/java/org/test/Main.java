package org.test;

public class Main {
    public static void main(String[] args) {
        // Initialize ParkingManager with 2 floors
        ParkingManager parkingManager = new ParkingManager(2);

        // Add parking spots: Floor 1 (2 CAR spots, 2 BIKE spots), Floor 2 (2 TRUCK spots)
        parkingManager.addSpot(2, 1, VehicleType.CAR);
        parkingManager.addSpot(2, 1, VehicleType.BIKE);
        parkingManager.addSpot(2, 2, VehicleType.TRUCK);

        // Create vehicles
        Vehicle car1 = new Vehicle("CAR123", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("BIKE123", VehicleType.BIKE);
        Vehicle truck1 = new Vehicle("TRUCK123", VehicleType.TRUCK);
        Vehicle truck2 = new Vehicle("TRUCK456", VehicleType.TRUCK);
        Vehicle bike2 = new Vehicle("BIKE456", VehicleType.BIKE); // Should fail (no available spot)

        // Park vehicles
        System.out.println("\n--- Parking Vehicles ---");
        parkingManager.addParking(car1);
        parkingManager.addParking(bike1);
        parkingManager.addParking(truck1);
        parkingManager.addParking(truck2);
        parkingManager.addParking(bike2); // Expect "Sorry, Parking is full!"

        // Remove a parked vehicle
        System.out.println("\n--- Removing a Vehicle ---");
        parkingManager.removeParking(car1);

        // Query all removed vehicle receipts
        System.out.println("\n--- Querying Parking History ---");
        parkingManager.queryAllDetails();
    }
}
