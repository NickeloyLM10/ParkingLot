# Parking Management System

## Overview
This is a simple **Parking Management System** built in Java, supporting multiple floors, vehicle types, and dynamic parking allocation. It tracks parking history and generates receipts for parked vehicles.

## Features
- 🚗 **Multi-floor Parking:** Supports multiple floors with different parking spots.
- 🏍️ **Vehicle Types:** Supports **CAR, BIKE, and TRUCK**.
- 🎟️ **Receipt Generation:** Calculates bill based on parking duration.
- 🔄 **Add & Remove Vehicles:** Vehicles can be parked and removed dynamically.
- 📜 **Query Parking History:** Keeps a record of all parked vehicles.

## Technologies Used
- **Java 8+**
- **Collections Framework (HashMap, List)**

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/parking-system.git
   cd parking-system
   ```
2. Compile the Java files:
   ```sh
   javac -d bin src/org/test/*.java
   ```
3. Run the main class:
   ```sh
   java -cp bin org.test.Main
   ```

## Usage
### Adding Parking Spots
```java
ParkingManager manager = new ParkingManager(2); // 2 Floors
manager.addSpot(2, 1, VehicleType.CAR); // 2 CAR spots on Floor 1
manager.addSpot(2, 1, VehicleType.BIKE); // 2 BIKE spots on Floor 1
```

### Parking Vehicles
```java
Vehicle car1 = new Vehicle("CAR123", VehicleType.CAR);
manager.addParking(car1);
```

### Removing Vehicles
```java
manager.removeParking(car1);
```

### Querying Parking History
```java
manager.queryAllDetails();
```

## Expected Output
```
--- Parking Vehicles ---
Your vehicle is parked on: 1 floor with spot id: 1
Your vehicle is parked on: 1 floor with spot id: 3
Your vehicle is parked on: 2 floor with spot id: 1
Your vehicle is parked on: 2 floor with spot id: 2
Your vehicle is parked on: 1 floor with spot id: 4

--- Removing a Vehicle ---

--- Querying Parking History ---
Vehicle number: CAR123
```
