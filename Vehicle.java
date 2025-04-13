import java.io.Serializable;
import devtools.io.Data;

class Vehicle implements Serializable, Comparable <Vehicle> {

    /**
     * Vehicles class
     */
    private String make;
    private String model;
    private int year;
    private GearboxType gearbox;
    private String colour;
    private int mileage;
    private String VIN;

    public Vehicle(String make, String model, int year, GearboxType gearbox, String colour, int mileage, String VIN) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.gearbox = gearbox;
        this.colour = colour;
        this.mileage = mileage;
        this.VIN = VIN;
    }
    // Setters and Getters for Vehicle Details
    public String getMake() {return make;}
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public GearboxType getGearbox() {
        return gearbox;
    }
    public void setGearbox(GearboxType gearbox) {
        this.gearbox = gearbox;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public String getVIN() {
        return VIN;
    }
    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
    @Override
    public int compareTo(Vehicle other) {
        int compare = this.make.compareTo(other.make);
        if (compare !=0) {
            return compare;
        }
        compare = this.model.compareTo(other.model);
        if (compare !=0) {
            return compare;
        }
        compare = this.VIN.compareTo(other.VIN);
        if (compare !=0) {
            return compare;
        }
        return this.VIN.compareTo(other.VIN);
    }
}






