// Car class
    public class Car extends Vehicle {
    private BodyType carType;
    private boolean satNav;
    private boolean parkingSensor;
    private boolean towbar;
    private boolean roofrack;
    private boolean thirdRowSeat;
    private boolean allWheelDrive;

    public Car(String make, String model, int year, GearboxType gearbox, String colour, int mileage, String VIN, BodyType carType,
               boolean satNav, boolean parkingSensor, boolean towbar, boolean roofrack, boolean thirdRowSeat, boolean allWheelDrive) {
        super(make, model, year, gearbox, colour, mileage, VIN);
        this.carType = carType;
        this.satNav = satNav;
        this.parkingSensor = parkingSensor;
        this.towbar = towbar;
        this.roofrack = roofrack;
        this.thirdRowSeat = thirdRowSeat;
        this.allWheelDrive = allWheelDrive;
    }

    @Override
    public String toString() {
        return "Car{Make=" + getMake() + ", Model=" + getModel() + ", Vin=" + getVIN() +
                ", Colour=" + getColour() + ", Mileage=" + getMileage() + ", Year= " + getYear() +
                ", Gearbox Type=" + getGearbox() + ", Bodytype=" + getCarType().toString() + "}"; }

    // Setters & Getters for optional details
    public void addSatNav() {this.satNav = true;}
    public void addParkingSensors() {this.parkingSensor = true;}
    public void addTowBar() {this.towbar = true;}
    public void addRoofRack() {this.roofrack = true;}
    public void addThirdRowSeat() {this.thirdRowSeat = true;}
    public void addAllWheelDrive() {this.allWheelDrive = true;}
    public void setCarType(BodyType carType) {this.carType = carType;}

    public boolean hasSatNav() {return satNav;}
    public boolean hasParkingSensors() {return parkingSensor;}
    public boolean hasRoofRack() {return roofrack;}
    public boolean hasTowBar() {return towbar;}
    public boolean hasThirdRowSeat() {return thirdRowSeat;}
    public boolean hasAllWheelDrive(){return allWheelDrive;}
    public BodyType getCarType() {return carType;}
}



