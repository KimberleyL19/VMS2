
public class Motorbike extends Vehicle {

    private boolean LuggageBox;

    public Motorbike (String make, String model, int year,
                     GearboxType gearbox, String colour, int mileage, String VIN, LugaggeBox lugaggeBox) {
        super(make, model, year, gearbox, colour, mileage, VIN);
    }
    @Override
    public String toString() {
        return "Motorbike{Make= " + getMake() + ", Model=" + getModel() + "', Vin= " + getVIN() + " " +
                ", Colour= " + getColour() + ", Mileage= " + getMileage() + ", Year= " + getYear() + ", Luggage Box= "
                + hasLuggageBox() + "}";
    }
    public void addLuggageBox() {
        this.LuggageBox = true;
    }
    public void removeLuggageBox() {
        this.LuggageBox = false;
    }
    public boolean hasLuggageBox() {
        return LuggageBox;
    }
}
