// Cars Only class

public class Car extends Vehicle {
    private boolean satNav;
    private boolean parkingSensor;
    private boolean towbar;
    private boolean roofrack;

    public Car(String make, String model, int year, GearboxType gearbox, String colour, int mileage, String VIN) {
        super(make, model, year, gearbox, colour, mileage, VIN);
    }

    @Override
    public String toString() {
        return "Car{Model='" + getModel() + "', Make='" + getMake() + "', Vin='" + getVIN() + "'}";
    }

    // Method for adding optional details

    public void addSatNav() {
        this.satNav = true;
    }

    public void addParkingSensors() {
        this.parkingSensor = true;
    }

    public void addTowBar() {
        this.towbar = true;
    }

    public void addRoofRack() {
        this.roofrack = true;
    }

    public boolean hasSatNav() {
        return satNav;
    }

    public boolean hasParkingSensors() {
        return parkingSensor;
    }

    public boolean hasTowBar() {
        return towbar;
    }

    public boolean hasRoofRack() {
        return roofrack;
    }


}


