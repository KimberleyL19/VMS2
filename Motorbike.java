
public class Motorbike extends Vehicle {

    private boolean LuggageBox;

    public Motorbike (String make, String model, int year,
                     GearboxType gearbox, String colour, int mileage, String VIN) {
        super(make, model, year, gearbox, colour, mileage, VIN);
    }
    @Override
    public String toString() {
        return "Motorbike{Model='" + getModel() + "', Make='" + getMake() + "', Vin='" + getVIN() + "'}";
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
