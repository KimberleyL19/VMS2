//SUVs Only

public class SUV extends Car {
    private boolean AllWheelDrive;

    public SUV(String make, String model, int year, GearboxType gearbox, String colour, int mileage, String VIN) {
        super(make, model, year, gearbox, colour, mileage, VIN);
    }

    public void addAllWheelDrive() {
        this.AllWheelDrive = true;
    }

    public boolean hasAllWheelDrive() {
        return AllWheelDrive;
    }
}
